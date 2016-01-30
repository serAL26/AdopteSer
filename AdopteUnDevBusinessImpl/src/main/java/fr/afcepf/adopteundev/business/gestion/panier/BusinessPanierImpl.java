package fr.afcepf.adopteundev.business.gestion.panier;

import assembleur.EntityToDTO;
import dto.*;
import entity.Client;
import entity.Developpeur;
import entity.Projet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.panier.IBusinessPanier;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.*;

@Remote(IBusinessPanier.class)
@Stateless
public class BusinessPanierImpl implements IBusinessPanier {
    @EJB
    private IDaoDeveloppeur daoDeveloppeur;
    @EJB
    private IDaoUtilisateur daoUtilisateur;
    @EJB
    private IDaoGestionProjet daoGestionProjet;

    Logger log = Logger.getLogger(BusinessPanierImpl.class);
    private Map<Integer, Set<DTODeveloppeur>> panierDeveloppeur = new HashMap<>();
    private Set<DTODeveloppeur> dtoDeveloppeurList = new HashSet<>();

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
    public Map<Integer, Set<DTODeveloppeur>> recupererPanier() {
        return panierDeveloppeur;
    }

    @Override
    public void ajouterDeveloppeur(int idProjet, int idDeveloppeur) {
        log.info("Business ajouter Developpeur au panier : In");
        Developpeur developpeur = (Developpeur) daoUtilisateur.obtenirUtilisateurParId(idDeveloppeur);
        DTODeveloppeur dtoDeveloppeur = EntityToDTO.developpeurToDTODeveloppeur(developpeur);
        dtoDeveloppeurList.add(dtoDeveloppeur);
        panierDeveloppeur.put(idProjet, dtoDeveloppeurList);
        log.info("developpeur ajouter : " + dtoDeveloppeur.getNom());
        log.info("taille du panier : " + panierDeveloppeur.size());
        log.info("taille de la liste : " + dtoDeveloppeurList.size());
    }

    @Override
    public void retirerDeveloppeur(DTODeveloppeur developpeur) {
        log.info("Business Retirer developpeur au panier : In");
        log.info("taille de la liste avant: " + dtoDeveloppeurList.size());
        dtoDeveloppeurList.remove(developpeur);
        log.info("taille de la liste apres: " + dtoDeveloppeurList.size());
        log.info("taille du panier : " + panierDeveloppeur.size());
        log.info("Business Retirer developpeur au panier : OUT");
    }

    @Override
    public List<DTOProjet> recupererListProjetParUtilisateur(int idUtilisateur) {
        log.info("Business recup projets par utilisateur : In");
        //Pour le test
        Client patrick = (Client) daoUtilisateur.obtenirUtilisateurParId(16);
        DTOClient dtoPatrick = EntityToDTO.clientToDTOClient(patrick);
        //Fin de test
        List<Projet> projetList = daoGestionProjet.recupProjetParIdClient(idUtilisateur);
        List<DTOProjet> dtoProjetList = new ArrayList<>();
        if (projetList != null && projetList.size() != 0) {
            for (Projet projet :
                    projetList) {
                dtoProjetList.add(EntityToDTO.projetToDTOProjet(projet));
                log.info("projet : " + projet.getLibelle());
            }
        } else
            dtoProjetList.add(new DTOProjet(90, "ProjetTest", dtoPatrick));
        log.info("Business recup projets par utilisateur : Out");
        log.info("taille liste projet : " + dtoProjetList.size());
        return dtoProjetList;
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
                if (proposition.getTypeProposition().getIdTypeProposition() == 3) {
                    Set<DTONote> listNote = proposition.getProjet().getLesNotes();
                    if (proposition.getProjet().getEtatProjet().getIdEtatProjet() == 2) {
                        int nbProjetTermine = 0;
                        for (DTONote note :
                                listNote) {
                            if (note.getIdEstNote() == developpeur.getIdUtilisateur() && note.getNote() != null)
                                valeur += note.getNote().intValue();
                            nbProjetTermine++;
                        }
                        valeur = valeur / nbProjetTermine;
                    }
                }
            }
        }

        return valeur;
    }
}
