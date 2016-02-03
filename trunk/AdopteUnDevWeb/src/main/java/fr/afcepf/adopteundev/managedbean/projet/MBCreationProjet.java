package fr.afcepf.adopteundev.managedbean.projet;

import dto.*;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur.TechnoConverter;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean(name = "mbCreationProjet")
@SessionScoped
public class MBCreationProjet {
	private Logger log = Logger.getLogger(MBCreationProjet.class);
	private Set<DTOTypeFonctionnalite> listTypeFonctionn;
	private DTOTypeFonctionnalite selectedTypeFonction = new DTOTypeFonctionnalite();
	private List<DTOFonctionnalite> listeFonctionnaliteCree = new ArrayList<>();
	private String commentaire;
	private String besoin;
	private String contexte;
	private String existant;
	private String dateFin;
	private Double tarif;
	private boolean panelCdc = false;
	private boolean panelFonctionnalite = false;
	private Set<DTOTypeAppli> listeAppli;
	private Set<DTOTypeService> listeServices;
	private DTOTypeAppli selectedAppli;
	private DTOTypeService selectedService;
	private DTOProjet projetcree;
	private UploadedFile file;
	private boolean actionAjout = true;
	private IUCProjet ucProjet;
	private DTOCdc cdc;
	private IUcUtilisateur gestionUtilisateur;
	private IUCGestionCdc gestionCdc;
	private Set<DTOTechnologie> listeTechnoParService;

	@ManagedProperty(value = "#{mBConnexion}")
	private MBConnexion mBConnexion;

	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}

	@PostConstruct
	public void init() {
		ucProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		gestionUtilisateur = (IUcUtilisateur) ContextFactory
				.createProxy(UcName.UCGESTIONUTILISATEUR);
		gestionCdc = (IUCGestionCdc) ContextFactory
				.createProxy(UcName.UCGESTIONCDC);
		listeAppli = ucProjet.rechercherTousApplication();
		listTypeFonctionn = gestionCdc.recupTousLesTypesFonctionnalites();
		selectedAppli = new DTOTypeAppli();
		selectedService = new DTOTypeService();
		projetcree = new DTOProjet();

		panelCdc = false;
		panelFonctionnalite = false;
	}

	public void remplirServices(AjaxBehaviorEvent event) {
		if (selectedAppli.getIdTypeAppli() > 0) {
			listeServices = ucProjet.recupTypeAppliById(
					selectedAppli.getIdTypeAppli()).getLesServices();
		} else {
			if (listeServices != null)
				listeServices.clear();
		}

	}

	public void ajouterFonctionnaliteSaisi() {
		DTOFonctionnalite fonctionnaliteCree = new DTOFonctionnalite();
		fonctionnaliteCree.setCommentaire(commentaire);
		System.out.println("type fonctionnalite "
				+ selectedTypeFonction.getIdTypeFonctionnalite());
		selectedTypeFonction = gestionCdc
				.recupTypeFonctionnaliteParID(selectedTypeFonction
						.getIdTypeFonctionnalite());
		fonctionnaliteCree.setTypeFonctionnalite(selectedTypeFonction);
		System.out.println("fonctionnalite id : "
				+ fonctionnaliteCree.getIdFonctionnalite());
		listeFonctionnaliteCree.add(fonctionnaliteCree);
		for (DTOFonctionnalite fonctionna : listeFonctionnaliteCree) {
			System.out.println("fonctionnalite : "
					+ fonctionna.getCommentaire());
		}
		commentaire = "";
		setActionAjout(false);
	}

	public void remplirChamps() {
		besoin = "Notre site internet veut répondre à cette problématique en centralisant, d’une part, une majorité des développeurs freelances sur un même espace mais également en accompagnant le particulier au maximum.";
		contexte = "Les solutions de mise en relation de professionnels de l’informatique avec des clients à la recherche de développeurs ne sont pas prévues aux particuliers ou aux micro-entreprises. ";
		existant = "La majorité des sites proposent un système d’abonnement en plus de se rémunérer en récupérant un pourcentage des transactions.";
		tarif = 1500.0;
		dateFin = "04/02/2015";

	}

	private DTOCdc ajouterCDC(DTOProjet projet) {
		cdc = new DTOCdc();
		cdc.setBesoin(besoin);
		cdc.setContexte(contexte);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFinEstimee = null;
		try {
			dateFinEstimee = sdf.parse(dateFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdc.setDateFinEstimee(dateFinEstimee);
		cdc.setExistant(existant);
		cdc.setLu(true);
		cdc.setProjet(projet);
		System.out.println("id projet " + projet.getIdProjet());
		cdc.setTarif(tarif);
		return gestionCdc.ajouterCdcDto(cdc);
	}

	public String creeProjet() {

		System.out.println(gestionUtilisateur.recupClientById(16).getNom());
		projetcree.setClient(gestionUtilisateur.recupClientById(mBConnexion
				.getUtilisateur().getIdUtilisateur()));
		projetcree.setService(selectedService);
		if (file != null)
			projetcree.setPhoto(file.getFileName());
		projetcree = ucProjet.creerProjet(projetcree);
		if (projetcree.getIdProjet() != 0) {
			cdc = ajouterCDC(projetcree);
			if (cdc.getIdCdc() != 0)
				gestionCdc.ajouterAssociationFonctCdcComplet(cdc,
						listeFonctionnaliteCree);
		}

		listeTechnoParService = ucProjet.recupTechnoParService(selectedService
				.getIdTypeService());
		for (DTOTechnologie techno : listeTechnoParService) {
			System.out.println("techno : " + techno.getTechnologieLibelle());
		}
		return "/CatalogueDeveloppeurTestRech.xhtml?faces-redirect=true";

	}

	public String upload() {
		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		List<DiskFileItem> params = (List<DiskFileItem>) httpServletRequest
				.getAttribute("fichierUpload");
		for (DiskFileItem diskFileItem : params) {
			String path = this.getClass().getResource("").getPath();
			path = path.split("/WEB-INF")[0];
			File file1 = new File(path + "/Livrables");
			if (!file1.exists())
				file1.mkdirs();
			file1 = new File(path + "/Photos/" + diskFileItem.getName());
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file1);
				fileOutputStream.write(diskFileItem.get());
				fileOutputStream.close();
				log.info("photo : " + path + "/Photos/"
						+ diskFileItem.getName());
				projetcree.setPhoto(path + "/Photos/" + diskFileItem.getName());
				log.info("projet.photo : " + projetcree.getPhoto());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public boolean isPanelCdc() {
		return panelCdc;
	}

	public void setPanelCdc(boolean panelCdc) {
		this.panelCdc = panelCdc;
	}

	public boolean isPanelFonctionnalite() {
		return panelFonctionnalite;
	}

	public void setPanelFonctionnalite(boolean panelFonctionnalite) {
		this.panelFonctionnalite = panelFonctionnalite;
	}

	public Set<DTOTypeAppli> getListeAppli() {
		return listeAppli;
	}

	public void setListeAppli(Set<DTOTypeAppli> listeAppli) {
		this.listeAppli = listeAppli;
	}

	public Set<DTOTypeService> getListeServices() {
		return listeServices;
	}

	public void setListeServices(Set<DTOTypeService> listeServices) {
		this.listeServices = listeServices;
	}

	public DTOTypeAppli getSelectedAppli() {
		return selectedAppli;
	}

	public void setSelectedAppli(DTOTypeAppli selectedAppli) {
		this.selectedAppli = selectedAppli;
	}

	public DTOTypeService getSelectedService() {
		return selectedService;
	}

	public void setSelectedService(DTOTypeService selectedService) {
		this.selectedService = selectedService;
	}

	public DTOProjet getProjetcree() {
		return projetcree;
	}

	public void setProjetcree(DTOProjet projetcree) {
		this.projetcree = projetcree;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getBesoin() {
		return besoin;
	}

	public void setBesoin(String besoin) {
		this.besoin = besoin;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getExistant() {
		return existant;
	}

	public void setExistant(String existant) {
		this.existant = existant;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public Set<DTOTypeFonctionnalite> getListTypeFonctionn() {
		return listTypeFonctionn;
	}

	public void setListTypeFonctionn(
			Set<DTOTypeFonctionnalite> listTypeFonctionn) {
		this.listTypeFonctionn = listTypeFonctionn;
	}

	public DTOTypeFonctionnalite getSelectedTypeFonction() {
		return selectedTypeFonction;
	}

	public void setSelectedTypeFonction(
			DTOTypeFonctionnalite selectedTypeFonction) {
		this.selectedTypeFonction = selectedTypeFonction;
	}

	public List<DTOFonctionnalite> getListeFonctionnaliteCree() {
		return listeFonctionnaliteCree;
	}

	public void setListeFonctionnaliteCree(
			List<DTOFonctionnalite> listeFonctionnaliteCree) {
		this.listeFonctionnaliteCree = listeFonctionnaliteCree;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	public boolean isActionAjout() {
		return actionAjout;
	}

	public void setActionAjout(boolean actionAjout) {
		this.actionAjout = actionAjout;
	}

	public void afficherPanelCdc() {

		panelCdc = true;
	}

	public void afficherPanelFonctionnalite() {
		panelFonctionnalite = true;
	}

	public Set<DTOTechnologie> getListeTechnoParService() {
		return listeTechnoParService;
	}

	public void setListeTechnoParService(
			Set<DTOTechnologie> listeTechnoParService) {
		this.listeTechnoParService = listeTechnoParService;
	}

}
