package fr.afcepf.adopteundev.managedbean.messagerie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOMessage;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoMessage;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import fr.afcepf.adopteundev.message.IUCMessage;

@ManagedBean
@SessionScoped
public class MBMessagerie {
	private String message;
	private DTOMessage messageCree;
	private String titre;
	private List<NoMessage> listeNoMessage = new ArrayList<>();
	private DTOUtilisateur mecEnFace = new DTOUtilisateur();
	private IUCMessage ucMessage;
	private IUcUtilisateur ucUtilisateur;
	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;

	
	private void initListeNoMessage() {
		listeNoMessage = ucMessage.recupereNoMessage(mBConnexion.getUtilisateur().getIdUtilisateur());
	}

	private void obtenirLesInterfaces(){
		ucMessage = (IUCMessage) ContextFactory.createProxy(UcName.UCGESTIONMESSAGERIE);
		ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
	}

	@PostConstruct
	private void init() {
		obtenirLesInterfaces();
		initListeNoMessage();
	}

	public String creerNouveauFil() {
		DTOMessage nouveauMessage = new DTOMessage();
		nouveauMessage.setMessage(message);
		nouveauMessage.setDateEnvoi(new Date());
		nouveauMessage.setTitre(titre);
		nouveauMessage.setUtilisateur1(mBConnexion.getUtilisateur());
		//TODO changer le new en mec en face
		nouveauMessage.setUtilisateur2(ucUtilisateur.obtenirUtilisateurById(2));
		ucMessage.creerNouveauFil(nouveauMessage);
		return "";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DTOMessage getMessageCree() {
		return messageCree;
	}
	public void setMessageCree(DTOMessage messageCree) {
		this.messageCree = messageCree;
	}
	public List<NoMessage> getListeNoMessage() {
		return listeNoMessage;
	}
	public void setListeNoMessage(List<NoMessage> listeNoMessage) {
		this.listeNoMessage = listeNoMessage;
	}
	public DTOUtilisateur getMecEnFace() {
		return mecEnFace;
	}
	public void setMecEnFace(DTOUtilisateur mecEnFace) {
		this.mecEnFace = mecEnFace;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}
	
}
