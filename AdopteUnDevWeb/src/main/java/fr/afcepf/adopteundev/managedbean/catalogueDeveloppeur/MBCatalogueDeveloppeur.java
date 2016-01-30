package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class MBCatalogueDeveloppeur {
    private List<DTODeveloppeur> ListeDeveloppeur = new ArrayList<>();
    private List<NoDeveloppeur> listFiche = new ArrayList<>();
    private List<DTOProjet> projetList = new ArrayList<>();
    private DTOProjet projetSelectionne = new DTOProjet();
    private IUCPanier panier;

    @PostConstruct
    public void obtenirLesInterfaces() {
        panier = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ListeDeveloppeur = initListeDeveloppeur();
        listFiche = initFichesDeveloppeur();
        projetList = initListeProjet(16);
    }

    private List<DTOProjet> initListeProjet(Integer idUtilisateur) {
        return panier.recupererListProjetParUtilisateur(idUtilisateur);
    }

    public String ajouterDeveloppeurAuPanier(Integer idProjet,Integer idDeveloppeur) {
        panier.ajouterDeveloppeur(idProjet,idDeveloppeur);
        return "";
    }

    public List<NoDeveloppeur> getListFiche() {
        return listFiche;
    }

    public void setListFiche(List<NoDeveloppeur> listFiche) {
        this.listFiche = listFiche;
    }

    public List<DTODeveloppeur> getListeDeveloppeur() {
        return ListeDeveloppeur;
    }

    public void setListeDeveloppeur(List<DTODeveloppeur> listeDeveloppeur) {
        ListeDeveloppeur = listeDeveloppeur;
    }

    private List<DTODeveloppeur> initListeDeveloppeur() {
        return panier.recupererTousLesDeveloppeurs();
    }

    private List<NoDeveloppeur> initFichesDeveloppeur() {
        return panier.recupererFicheResumeDeveloppeur();
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
}
