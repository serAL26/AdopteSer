package fr.afcepf.adopteundev.managedbean.connexion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dto.DTOProposition;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBConnexion {
	private String mail;
	private String mdp;
	private String message;
	private  IUcConnexion connexion;
	private List<DTOProposition> listePropositionNonLue = new ArrayList<>();
	private IUcUtilisateur ucUtilisateur;
	private IUcProposition ucProposition;
	private DTOUtilisateur utilisateur;
	private int typeUtilisateur = 3;

	public MBConnexion() {
		super();
	}

	@PostConstruct
	public void obtenirLesInterfaces(){
		ucProposition = (IUcProposition) ContextFactory.createProxy(UcName.UCGESTIONPROPOSITION);
		connexion = (IUcConnexion) ContextFactory.createProxy(UcName.UCCONNEXION);
		ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
	}

	public void initListePropositionNonLue() {
		if(typeUtilisateur == 1) {
			listePropositionNonLue = ucProposition.recupPropositionNonLue(utilisateur.getIdUtilisateur());
		}
	}

	public String deconnexion() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		return "/Accueil.xhtml?faces-redirect=true";
	}

	public String seConnecter() {
		utilisateur = connexion.seConnecter(mail, mdp);
		String retour = "";
		if (utilisateur == null){
			message = "Login/Mdp errone";
		}
		else {
			retour = "/Messagerie.xhtml?faces-redirect=true";
			typeUtilisateur = ucUtilisateur.typeUtilisateur(utilisateur.getIdUtilisateur());
		}
		return retour;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMail() {
		return mail;
	}

	public String getMdp() {
		return mdp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DTOUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(DTOUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(int typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public List<DTOProposition> getListePropositionNonLue() {
		return listePropositionNonLue;
	}

	public void setListePropositionNonLue(List<DTOProposition> listePropositionNonLue) {
		this.listePropositionNonLue = listePropositionNonLue;
	}
}
