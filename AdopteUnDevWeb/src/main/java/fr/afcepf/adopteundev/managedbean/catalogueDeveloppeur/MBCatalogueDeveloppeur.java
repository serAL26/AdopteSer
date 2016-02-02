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

import dto.DTODeveloppeur;
import dto.DTOProjet;
import dto.DTOTechnologie;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name="mBCatalogueDeveloppeur")
@SessionScoped
public class MBCatalogueDeveloppeur {
    private List<NoDeveloppeur> listFiche = new ArrayList<>();
	private List<NoDeveloppeur> listeDevWeb = new ArrayList<>();
    private List<DTOProjet> projetList = new ArrayList<>();
    private Map<Integer, Set<NoDeveloppeur>> panier = new HashMap<>();
    private DTOProjet projetSelectionne = new DTOProjet();
    private IUCPanier panierUc;
    private IUcUtilisateur ucUtilisateur;
    private NoDeveloppeur dev;
    private List<DTOTechnologie> listeTouteTechno = new ArrayList<>();
    private List<DTOTechnologie> listeSelectedTechno = new ArrayList<>();
    @ManagedProperty(value="#{mBConnexion}")
    private MBConnexion mBConnexion;

    public String ajouterDeveloppeurAuPanier(Integer idProjet, DTODeveloppeur dev) {
    	Set<NoDeveloppeur> setDeveloppeur = panier.get(idProjet);
        NoDeveloppeur developpeur = ucUtilisateur.creerNoDeveloppeur(dev);
    	if(setDeveloppeur == null) {
    		setDeveloppeur = new HashSet<>();
    	}
    	setDeveloppeur.add(developpeur);
    	panier.put(idProjet, setDeveloppeur);
        return "";
    }
    
 
	public List<NoDeveloppeur> getListeDevWeb() {
		return listeDevWeb;
	}
	public void setListeDevWeb(List<NoDeveloppeur> listeDevWeb) {
		this.listeDevWeb = listeDevWeb;
	}

	//getter,setter et init methodes
    public List<NoDeveloppeur> getListFiche() {
        return listFiche;
    }
    
    public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

    public Map<Integer, Set<NoDeveloppeur>> getPanier() {
        return panier;
    }

    public List<DTOProjet> getProjetList() {
        return projetList;
    }

    public DTOProjet getProjetSelectionne() {
        return projetSelectionne;
    }

    private List<NoDeveloppeur> initFichesDeveloppeur() {
    	List<DTODeveloppeur> listeTousLesDevs = ucUtilisateur.recupTousLesDeveloppeurs();
    	List<DTODeveloppeur> listeDtoDevWeb= ucUtilisateur.recupDevWeb();
    	for (DTODeveloppeur dtoDeveloppeur : listeDtoDevWeb) {
    		NoDeveloppeur developpeur = ucUtilisateur.creerNoDeveloppeur(dtoDeveloppeur);
    		listeDevWeb.add(developpeur);
		}
    	List<NoDeveloppeur> listeNoDeveloppeur = new ArrayList<>();
    	for (DTODeveloppeur dtoDeveloppeur : listeTousLesDevs) {
    		listeNoDeveloppeur.add(panierUc.recupererFicheResumeDeveloppeur(dtoDeveloppeur));
		}
        return listeNoDeveloppeur;
    }
    
    private List<NoDeveloppeur> initFichesDeveloppeurTest() {
    	List<DTOTechnologie> listeTechno = new ArrayList<>();
    	DTOTechnologie techno = new DTOTechnologie();
    	techno.setIdTechnologie(8);
    	listeTechno.add(techno);
    	List<DTODeveloppeur> listeTousLesDevs = ucUtilisateur.recupDevParListeTechnoEtNote(4, listeTechno);
    	List<DTODeveloppeur> listeDtoDevWeb= ucUtilisateur.recupDevWeb();
    	for (DTODeveloppeur dtoDeveloppeur : listeDtoDevWeb) {
    		NoDeveloppeur developpeur = ucUtilisateur.creerNoDeveloppeur(dtoDeveloppeur);
    		listeDevWeb.add(developpeur);
		}
    	List<NoDeveloppeur> listeNoDeveloppeur = new ArrayList<>();
    	for (DTODeveloppeur dtoDeveloppeur : listeTousLesDevs) {
    		listeNoDeveloppeur.add(panierUc.recupererFicheResumeDeveloppeur(dtoDeveloppeur));
		}
        return listeNoDeveloppeur;
    }
    
    public List<DTOProjet> initListeProjet() {
    	if (mBConnexion.getTypeUtilisateur() == 2)
        {
        projetList = panierUc.recupererListProjetEnAttenteParUtilisateur(mBConnexion.getUtilisateur().getIdUtilisateur());
        }
    	return projetList;
    }
	public NoDeveloppeur getDev() {
		return dev;
	}

	public void setDev(NoDeveloppeur dev) {
		this.dev = dev;
	}

	@PostConstruct
    public void obtenirLesInterfaces() {
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
        listeTouteTechno = ucUtilisateur.recupToutesTechnos();
       //TODO A decommenter après le test
        listFiche = initFichesDeveloppeur();
        //listFiche = initFichesDeveloppeurTest();
        initListeProjet();
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

    public void setPanier(Map<Integer, Set<NoDeveloppeur>> panier) {
        this.panier = panier;
    }

	public void setProjetList(List<DTOProjet> projetList) {
        this.projetList = projetList;
    }

	public void setProjetSelectionne(DTOProjet projetSelectionne) {
        this.projetSelectionne = projetSelectionne;
    }
	public String recupDeveloppeur(NoDeveloppeur developpeur)
	{
		dev = developpeur;
		return "/DetailDeveloppeur.xhtml?faces-redirect=true";
	}


	public List<DTOTechnologie> getListeTouteTechno() {
		return listeTouteTechno;
	}


	public void setListeTouteTechno(List<DTOTechnologie> listeTouteTechno) {
		this.listeTouteTechno = listeTouteTechno;
	}


	public List<DTOTechnologie> getListeSelectedTechno() {
		return listeSelectedTechno;
	}


	public void setListeSelectedTechno(List<DTOTechnologie> listeSelectedTechno) {
		this.listeSelectedTechno = listeSelectedTechno;
	}
	
}
