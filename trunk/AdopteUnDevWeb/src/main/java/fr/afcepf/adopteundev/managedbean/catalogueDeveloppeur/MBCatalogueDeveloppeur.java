package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name="mBCatalogueDeveloppeur")
@SessionScoped
public class MBCatalogueDeveloppeur {
	private Logger log = Logger.getLogger(MBCatalogueDeveloppeur.class);
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
        log.info(listFiche);
        projetList = initListeProjet(16);
    }

    public String renvoieVersPanier() {
    	return "/Panier.xhtml?faces-redirect=true";
    }
    
    public String ajouterDeveloppeurAuPanier(Integer idProjet, DTODeveloppeur developpeur) {
    	Set<DTODeveloppeur> setDeveloppeur = panier.get(idProjet);
    	if(setDeveloppeur == null) {
    		setDeveloppeur = new HashSet<>();
    	}
    	setDeveloppeur.add(developpeur);
    	panier.put(idProjet, setDeveloppeur);
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

    private List<DTOProjet> initListeProjet(Integer idUtilisateur) {
        return panierUc.recupererListProjetParUtilisateur(idUtilisateur);
    }

}
