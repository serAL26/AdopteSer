package fr.afcepf.adopteundev.managedbean.projet;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import dto.DTOProjet;
import dto.DTOTypeAppli;
import dto.DTOTypeService;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name = "mbCreationProjet")
@Remote(MBCreationProjet.class)
@SessionScoped
public class MBCreationProjet {

	private Set<DTOTypeAppli> listeAppli;
	private Set<DTOTypeService> listeServices;
	private DTOTypeAppli selectedAppli;
	private DTOTypeService selectedService;
	private DTOProjet projetcree;
	@EJB
	private IUCProjet ucProjet;

	@PostConstruct
	public void init() {
		ucProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		listeAppli = ucProjet.rechercherTousApplication();
		// listeServices =ucProjet.rechercherTousServices();
	}

	public void changeAppli(AjaxBehaviorEvent event) {
		System.out.println("je suis dans ajax");
		if (selectedAppli != null)
			listeServices = selectedAppli.getLesServices();
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

}
