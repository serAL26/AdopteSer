package fr.afcepf.adopteundev.ucimpl.gestionpanier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Remote(IUCPanier.class)
@Stateless
public class UcPanierImpl implements IUCPanier {
    Logger log = Logger.getLogger(UcPanierImpl.class);
    @EJB
    private IBusinessPanier businessPanier;

    @Override
    public Map<Integer, Set<DTODeveloppeur>> recupererPanier() {
        return businessPanier.recupererPanier();
    }

    @Override
    public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
        return businessPanier.recupererTousLesDeveloppeurs();
    }

    @Override
    public List<NoDeveloppeur> recupererFicheResumeDeveloppeur() {
        return businessPanier.recupererFicheResumeDeveloppeur();
    }

    @Override
    public void ajouterDeveloppeur(int idProjet, int developpeur) {
        log.info("AjoutDeveloppeur UC : In");
        businessPanier.ajouterDeveloppeur(idProjet, developpeur);
        log.info("AjoutDeveloppeur UC : Out");
    }

    @Override
    public void retirerDeveloppeur(DTODeveloppeur developpeur) {
        businessPanier.retirerDeveloppeur(developpeur);
    }

    @Override
    public List<DTOProjet> recupererListProjetParUtilisateur(int idUtilisateur) {
        log.info("UcRecupListProjetParUtilisateur");
        return businessPanier.recupererListProjetParUtilisateur(idUtilisateur);

    }
}