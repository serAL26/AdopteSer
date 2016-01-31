package fr.afcepf.adopteundev.managedbean.connexion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTODeveloppeur;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;



@ManagedBean
@SessionScoped
public class MBAccueil {
	
	private List<DTODeveloppeur> listeDev = new ArrayList<>();
	
	private IUcUtilisateur gestionDeveloppeur;
	
	
	
	public List<DTODeveloppeur> getListeDev() {
		return listeDev;
	}
	public void setListeDev(List<DTODeveloppeur> listeDev) {
		this.listeDev = listeDev;
	}


	@PostConstruct
    public void obtenirDevWeb(){
		gestionDeveloppeur = (IUcUtilisateur)ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
		
		listeDev = gestionDeveloppeur.recupDevWeb();
    }
}
