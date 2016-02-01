package fr.afcepf.adopteundev.managedbean.projet;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOClient;
import dto.DTOProjet;
import dto.DTOTypeAppli;
import dto.DTOTypeService;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBProjetParClient {
	
	private List<DTOProjet> listeProjetsValide;
	private List<DTOProjet> listeProjetsEnCours;
	private List<DTOProjet> listeProjetsArrete;
	
	private IUCProjet gestionProjet;
	
	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;
	
	

	public List<DTOProjet> getListeProjetsValide() {
		return listeProjetsValide;
	}



	public void setListeProjetsValide(List<DTOProjet> listeProjetsValide) {
		this.listeProjetsValide = listeProjetsValide;
	}



	public List<DTOProjet> getListeProjetsEnCours() {
		return listeProjetsEnCours;
	}



	public void setListeProjetsEnCours(List<DTOProjet> listeProjetsEnCours) {
		this.listeProjetsEnCours = listeProjetsEnCours;
	}



	public List<DTOProjet> getListeProjetsArrete() {
		return listeProjetsArrete;
	}



	public void setListeProjetsArrete(List<DTOProjet> listeProjetsArrete) {
		this.listeProjetsArrete = listeProjetsArrete;
	}



	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}



	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}



	@PostConstruct
	public void init() {
		gestionProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		listeProjetsValide = gestionProjet.recupProjerParEtatParClient("Valide", (DTOClient)mBConnexion.getUtilisateur());
		selectedAppli = new DTOTypeAppli();
		selectedService = new DTOTypeService();
		projetcree = new DTOProjet();
	}

}
