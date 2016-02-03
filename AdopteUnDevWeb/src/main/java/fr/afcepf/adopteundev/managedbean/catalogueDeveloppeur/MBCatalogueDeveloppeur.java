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
import fr.afcepf.adopteundev.dto.nosobjets.NoNotes;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.projet.MBCreationProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name = "mBCatalogueDeveloppeur")
@SessionScoped
public class MBCatalogueDeveloppeur {
	private DTOTechnologie techn = new DTOTechnologie();
	private List<NoDeveloppeur> listFiche = new ArrayList<>();
	private List<NoDeveloppeur> listeFicheFiltre = new ArrayList<>();
	private List<NoDeveloppeur> listeDevWeb = new ArrayList<>();
	private List<DTOProjet> projetList = new ArrayList<>();
	private Map<Integer, Set<NoDeveloppeur>> panier = new HashMap<>();
	private DTOProjet projetSelectionne = new DTOProjet();
	private IUCPanier panierUc;
	private IUcUtilisateur ucUtilisateur;
	private NoDeveloppeur dev;
	private List<DTOTechnologie> listeTouteTechno;
	private List<DTOTechnologie> listeSelectedTechno;
	private Set<NoDeveloppeur> listDevRafraichi = new HashSet<>();
	private List<String> listeSelectedTechnoId;

	private List<NoNotes> listeNote = new ArrayList<>();
	private Double selectedNote;
	@ManagedProperty(value = "#{mBConnexion}")
	private MBConnexion mBConnexion;

	@ManagedProperty(value = "#{mbCreationProjet}")
	private MBCreationProjet mbCreationProjet;

	public List<NoNotes> getListeNote() {
		return listeNote;
	}

	public void setListeNote(List<NoNotes> listeNote) {
		this.listeNote = listeNote;
	}

	public String ajouterDeveloppeurAuPanier(Integer idProjet,
			DTODeveloppeur dev) {
		Set<NoDeveloppeur> setDeveloppeur = panier.get(idProjet);
		NoDeveloppeur developpeur = ucUtilisateur.creerNoDeveloppeur(dev);
		if (setDeveloppeur == null) {
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

	// getter,setter et init methodes
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

	public List<String> getListeSelectedTechnoId() {
		return listeSelectedTechnoId;
	}

	public void setListeSelectedTechnoId(List<String> listeSelectedTechnoId) {
		this.listeSelectedTechnoId = listeSelectedTechnoId;
	}

	private List<NoDeveloppeur> initFichesDeveloppeur() {
		List<DTODeveloppeur> listeTousLesDevs = null;
		Set<DTOTechnologie> listTechnoParProjet = mbCreationProjet
				.getListeTechnoParService();

		if (listTechnoParProjet != null && listTechnoParProjet.size() > 0) {
			listeTousLesDevs = new ArrayList<>(
					ucUtilisateur.recupDevParListeTechnoEtNote(-1,
							new ArrayList<>(listTechnoParProjet)));
			if (listeTousLesDevs.size() < 1)
				listeTousLesDevs = ucUtilisateur.recupTousLesDeveloppeurs();
		} else {
			listeTousLesDevs = ucUtilisateur.recupTousLesDeveloppeurs();
		}
		List<DTODeveloppeur> listeDtoDevWeb = ucUtilisateur.recupDevWeb();
		for (DTODeveloppeur dtoDeveloppeur : listeDtoDevWeb) {
			NoDeveloppeur developpeur = ucUtilisateur
					.creerNoDeveloppeur(dtoDeveloppeur);
			listeDevWeb.add(developpeur);
		}
		List<NoDeveloppeur> listeNoDeveloppeur = new ArrayList<>();
		for (DTODeveloppeur dtoDeveloppeur : listeTousLesDevs) {
			listeNoDeveloppeur.add(panierUc
					.recupererFicheResumeDeveloppeur(dtoDeveloppeur));
		}
		return listeNoDeveloppeur;
	}

	private List<NoDeveloppeur> initFichesDeveloppeurTest() {
		List<DTOTechnologie> listeTechno = new ArrayList<>();
		DTOTechnologie techno = new DTOTechnologie();
		techno.setIdTechnologie(8);
		listeTechno.add(techno);
		List<DTODeveloppeur> listeTousLesDevs = (List<DTODeveloppeur>) ucUtilisateur
				.recupDevParListeTechnoEtNote(4, listeTechno);
		List<DTODeveloppeur> listeDtoDevWeb = ucUtilisateur.recupDevWeb();
		for (DTODeveloppeur dtoDeveloppeur : listeDtoDevWeb) {
			NoDeveloppeur developpeur = ucUtilisateur
					.creerNoDeveloppeur(dtoDeveloppeur);
			listeDevWeb.add(developpeur);
		}
		List<NoDeveloppeur> listeNoDeveloppeur = new ArrayList<>();
		for (DTODeveloppeur dtoDeveloppeur : listeTousLesDevs) {
			listeNoDeveloppeur.add(panierUc
					.recupererFicheResumeDeveloppeur(dtoDeveloppeur));
		}
		return listeNoDeveloppeur;
	}

	public List<DTOProjet> initListeProjet() {
		if (mBConnexion.getTypeUtilisateur() == 2) {
			projetList = panierUc
					.recupererListProjetEnAttenteParUtilisateur(mBConnexion
							.getUtilisateur().getIdUtilisateur());
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
		panierUc = (IUCPanier) ContextFactory
				.createProxy(UcName.UCGESTIONPANIER);
		ucUtilisateur = (IUcUtilisateur) ContextFactory
				.createProxy(UcName.UCGESTIONUTILISATEUR);
		listeNote = ucUtilisateur.recupListNotes();
		listeTouteTechno = new ArrayList<>();
		listeTouteTechno = ucUtilisateur.recupToutesTechnos();
		listeSelectedTechno = new ArrayList<>();
		listFiche = initFichesDeveloppeur();
		listeFicheFiltre = initFichesDeveloppeur();
		if (mBConnexion.getTypeUtilisateur() == 2) {
			projetList = initListeProjet();
		}
	}

	public String rechercherDev() {
		//
		listeFicheFiltre.clear();
		double noteValue = selectedNote.doubleValue();
		System.out.println("selectedNote : " + selectedNote.doubleValue());
		for (String technoId : listeSelectedTechnoId) {
			DTOTechnologie techno = new DTOTechnologie();
			techno.setIdTechnologie(Integer.parseInt(technoId));
			System.out.println(techno.getIdTechnologie());
			listeSelectedTechno.add(techno);
		}
		for (DTOTechnologie tech : listeSelectedTechno) {
			System.out.println(tech.getIdTechnologie());
		}
		Set<NoDeveloppeur> setDev = ucUtilisateur
				.recupNoDevParListeTechnoEtNote(selectedNote,
						listeSelectedTechno);
		Set<Integer> setIdDev = new HashSet<>();
		for (NoDeveloppeur dev : setDev) {
			setIdDev.add(dev.getDeveloppeur().getIdUtilisateur());
		}
		Set<NoDeveloppeur> listDev = new HashSet<>();
		for (Integer integer : setIdDev) {
			NoDeveloppeur dev = ucUtilisateur.obtenirNoDevById(integer);
			listDev.add(dev);
		}
		listeFicheFiltre = new ArrayList<>(listDev);
		for (NoDeveloppeur fich : listDev) {
			System.out.println("dev" + fich.getDeveloppeur().getNom());
		}
		listeSelectedTechno.clear();
		return "";
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

	public String recupDeveloppeur(NoDeveloppeur developpeur) {
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

	public List<NoDeveloppeur> getListeFicheFiltre() {
		return listeFicheFiltre;
	}

	public void setListeFicheFiltre(List<NoDeveloppeur> listeFicheFiltre) {
		this.listeFicheFiltre = listeFicheFiltre;
	}

	public DTOTechnologie getTechn() {
		return techn;
	}

	public void setTechn(DTOTechnologie techn) {
		this.techn = techn;
	}

	public Double getSelectedNote() {
		return selectedNote;
	}

	public void setSelectedNote(Double selectedNote) {
		this.selectedNote = selectedNote;
	}

	public Set<NoDeveloppeur> getListDevRafraichi() {
		return listDevRafraichi;
	}

	public void setListDevRafraichi(Set<NoDeveloppeur> listDevRafraichi) {
		this.listDevRafraichi = listDevRafraichi;
	}

	public MBCreationProjet getMbCreationProjet() {
		return mbCreationProjet;
	}

	public void setMbCreationProjet(MBCreationProjet mbCreationProjet) {
		this.mbCreationProjet = mbCreationProjet;
	}

}
