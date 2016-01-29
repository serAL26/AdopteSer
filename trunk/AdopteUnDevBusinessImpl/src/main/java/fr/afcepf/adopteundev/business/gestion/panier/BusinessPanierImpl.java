package fr.afcepf.adopteundev.business.gestion.panier;

import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOProposition;
import entity.Developpeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Remote(IBusinessPanier.class)
@Stateless
public class BusinessPanierImpl implements IBusinessPanier {
    @EJB
    private IDaoDeveloppeur daoDeveloppeur;

    @Override
    public List<DTOProposition> recupererPanier() {
        return null;
    }

    @Override
    public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
        List<Developpeur> liste = daoDeveloppeur.recupererTousLesDeveloppeurs();
        List<DTODeveloppeur> listDto = new ArrayList<>();
        for (Developpeur dev :
                liste) {
            listDto.add(EntityToDTO.developpeurToDTODeveloppeur(dev));
        }
        return listDto;
    }

    @Override
    public List<NoDeveloppeur> recupererFicheResumeDeveloppeur() {
        List<NoDeveloppeur> result = new ArrayList<>();
        List<DTODeveloppeur> list = recupererTousLesDeveloppeurs();
        for (DTODeveloppeur dev :
                list) {
            NoDeveloppeur noDeveloppeur = new NoDeveloppeur(dev);
            noDeveloppeur.setNote(calculNote(dev));
            result.add(noDeveloppeur);
        }
        return result;
    }

    @Override
    public void ajouterProposition(DTODeveloppeur developpeur) {
        DTOProposition proposition = new DTOProposition();
    }

    @Override
    public void retirerProposition(DTOProposition proposition) {

    }


    public Integer calculNote(DTODeveloppeur dev) {
        return getNoteDeProjetFini(dev);
    }

    private Integer getNoteDeProjetFini(DTODeveloppeur developpeur) {
        Integer valeur = 0;
        Set<DTOProposition> listePropositionsTotales = developpeur.getListeProposition();
        if (listePropositionsTotales != null) {
            for (DTOProposition proposition :
                    listePropositionsTotales) {
                Set<DTONote> listNote = proposition.getProjet().getLesNotes();
                if (proposition.getProjet().getEtatProjet().getIdEtatProjet() == 2) {
                    for (DTONote note :
                            listNote) {
                        if (note.getIdEstNote() == developpeur.getIdUtilisateur() && note.getNote() != null)
                            valeur += note.getNote().intValue();
                    }
                }
            }
        }
        return valeur;
    }
}
