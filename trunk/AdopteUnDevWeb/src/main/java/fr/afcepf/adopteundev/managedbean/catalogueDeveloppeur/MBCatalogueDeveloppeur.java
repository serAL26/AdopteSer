package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Access;

import org.apache.log4j.Logger;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
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
    
    @ManagedProperty(value="#{mBConnexion}")
    private MBConnexion mBConnexion;

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
    
    public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

    public Map<Integer, Set<DTODeveloppeur>> getPanier() {
        return panier;
    }

    public List<DTOProjet> getProjetList() {
        return projetList;
    }

    public DTOProjet getProjetSelectionne() {
        return projetSelectionne;
    }

    private List<NoDeveloppeur> initFichesDeveloppeur() {
        return panierUc.recupererFicheResumeDeveloppeur();
    }
    
    private List<DTOProjet> initListeProjet() {
        return panierUc.recupererListProjetParUtilisateur(mBConnexion.getUtilisateur().getIdUtilisateur());
    }

    @PostConstruct
    public void obtenirLesInterfaces() {
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        listFiche = initFichesDeveloppeur();
        log.info(listFiche);
        projetList = initListeProjet();
    }

    public String renvoieVersPanier() {
    	return "/Panier.xhtml?faces-redirect=true";
    }

    public void setListFiche(List<NoDeveloppeur> listFiche) {
        this.listFiche = listFiche;
    }

    public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}

    public void setPanier(Map<Integer, Set<DTODeveloppeur>> panier) {
        this.panier = panier;
    }

	public void setProjetList(List<DTOProjet> projetList) {
        this.projetList = projetList;
    }

	public void setProjetSelectionne(DTOProjet projetSelectionne) {
        this.projetSelectionne = projetSelectionne;
    }
}