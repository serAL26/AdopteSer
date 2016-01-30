package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class MBCatalogueDeveloppeur {
    private List<NoDeveloppeur> listFiche = new ArrayList<>();
    private List<DTOProjet> projetList = new ArrayList<>();
    private Map<Integer, Set<DTODeveloppeur>> panier = new HashMap<>();
    private DTOProjet projetSelectionne = new DTOProjet();
    private IUCPanier panierUc;

    @PostConstruct
    public void obtenirLesInterfaces() {
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        List<DTODeveloppeur> listeDeveloppeur = initListeDeveloppeur();
        listFiche = initFichesDeveloppeur();
        projetList = initListeProjet(16);
        panier = initPanier();
    }

    public String ajouterDeveloppeurAuPanier(Integer idProjet, Integer idDeveloppeur) {
        panierUc.ajouterDeveloppeur(idProjet, idDeveloppeur);
        return "";
    }

    //getter,setter et init methodes
    public List<NoDeveloppeur> getListFiche() {
        return listFiche;
    }

    public void setListFiche(List<NoDeveloppeur> listFiche) {
        this.listFiche = listFiche;
    }

    private List<DTODeveloppeur> initListeDeveloppeur() {
        return panierUc.recupererTousLesDeveloppeurs();
    }

    private List<NoDeveloppeur> initFichesDeveloppeur() {
        return panierUc.recupererFicheResumeDeveloppeur();
    }

    public List<DTOProjet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<DTOProjet> projetList) {
        this.projetList = projetList;
    }

    public DTOProjet getProjetSelectionne() {
        return projetSelectionne;
    }

    public void setProjetSelectionne(DTOProjet projetSelectionne) {
        this.projetSelectionne = projetSelectionne;
    }

    public Map<Integer, Set<DTODeveloppeur>> getPanier() {
        return panier;
    }

    public void setPanier(Map<Integer, Set<DTODeveloppeur>> panier) {
        this.panier = panier;
    }

    private Map<Integer, Set<DTODeveloppeur>> initPanier() {
        return panierUc.recupererPanier();
    }

    private List<DTOProjet> initListeProjet(Integer idUtilisateur) {
        return panierUc.recupererListProjetParUtilisateur(idUtilisateur);
    }

}
