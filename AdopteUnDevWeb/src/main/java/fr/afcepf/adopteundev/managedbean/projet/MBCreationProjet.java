package fr.afcepf.adopteundev.managedbean.projet;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	@EJB
	private IUCProjet ucProjet;
	
	public String init(){
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
		listeAppli = ucProjet.rechercherTousApplication();
		for (DTOTypeAppli app : listeAppli) {
			System.out.println(app);
		}
		
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
	
	
	

}
