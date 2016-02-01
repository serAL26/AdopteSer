package fr.afcepf.adopteundev.managedbean.projet;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.model.UploadedFile;

import dto.DTOProjet;
import dto.DTOTypeAppli;
import dto.DTOTypeService;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name = "mbCreationProjet")
@SessionScoped
public class MBCreationProjet {

	private Set<DTOTypeAppli> listeAppli;
	private Set<DTOTypeService> listeServices;
	private DTOTypeAppli selectedAppli;
	private DTOTypeService selectedService;
	private DTOProjet projetcree;
	private UploadedFile file;
	private IUCProjet ucProjet;

	private IUcUtilisateur gestionUtilisateur;

	@PostConstruct
	public void init() {
		ucProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		gestionUtilisateur = (IUcUtilisateur) ContextFactory
				.createProxy(UcName.UCGESTIONUTILISATEUR);
		listeAppli = ucProjet.rechercherTousApplication();
		selectedAppli = new DTOTypeAppli();
		selectedService = new DTOTypeService();
		projetcree = new DTOProjet();
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

	public void upload() {
		System.out.println("upload");
		if (file != null) {
			System.out.println("file");
			FacesMessage message = new FacesMessage("Succesful",
					file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String creeProjet() {
		
		System.out.println(gestionUtilisateur.recupClientById(16).getNom());
		projetcree.setClient(gestionUtilisateur.recupClientById(16));
		if (file != null)
			projetcree.setPhoto(file.getFileName());
		projetcree=ucProjet.creerProjet(projetcree);
		if (projetcree.getIdProjet() != 0)
			return "CreationCDC.xhtml" + "?faces-redirect=true";
		
		return "";

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

}
