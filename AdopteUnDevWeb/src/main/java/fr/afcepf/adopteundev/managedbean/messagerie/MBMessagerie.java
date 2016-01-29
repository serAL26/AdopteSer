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
	private String titre;
	private DTOMessage messageAjoute = new DTOMessage();
	private List<DTOMessage> filConversation = new ArrayList<>();
	private List<NoMessage> listeNoMessage = new ArrayList<>();
	private DTOUtilisateur mecEnFace = new DTOUtilisateur();
	private IUCMessage ucMessage;
	private DTOMessage dernierMessFilConversation = new DTOMessage();
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

	public String ajoutCompletMessAUnFil() {
		ajouterMessAUnFil();
		majDuMessMere();
		return "";
	}
	
	public void majDuMessMere() {
		dernierMessFilConversation.setMessFille(messageAjoute);
		ucMessage.majDuMessMere(dernierMessFilConversation);
	}
	
	public String ajouterMessAUnFil(){
		DTOMessage messageCree = new DTOMessage();
		dernierMessFilConversation = filConversation.get(filConversation.size()-1);
		messageCree.setMessMere(dernierMessFilConversation);
		messageCree.setDateEnvoi(new Date());
		messageCree.setMessage(message);
		messageCree.setTitre(dernierMessFilConversation.getTitre());
		messageCree.setUtilisateur1(mBConnexion.getUtilisateur());
		messageCree.setUtilisateur2(mecEnFace);
		messageAjoute = ucMessage.ecrireUnNouveauMesssage(messageCree);
		return "";
	}
	
	public String obtenirFilConversation(DTOMessage messMere, NoMessage noMess) {
		mecEnFace = noMess.getMecEnFace();
		filConversation = ucMessage.recupererFilConversation(messMere);
		return "";
	}
	
	public String creerNouveauFil() {
		DTOMessage nouveauMessage = new DTOMessage();
		nouveauMessage.setMessage(message);
		nouveauMessage.setDateEnvoi(new Date());
		nouveauMessage.setTitre(titre);
		nouveauMessage.setUtilisateur1(mBConnexion.getUtilisateur());
		//TODO changer le new en mec en face
		nouveauMessage.setUtilisateur2(ucUtilisateur.obtenirUtilisateurById(3));
		ucMessage.creerNouveauFil(nouveauMessage);
		return "";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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

	public List<DTOMessage> getFilConversation() {
		return filConversation;
	}

	public void setFilConversation(List<DTOMessage> filConversation) {
		this.filConversation = filConversation;
	}

	public DTOMessage getDernierMessFilConversation() {
		return dernierMessFilConversation;
	}

	public void setDernierMessFilConversation(DTOMessage dernierMessFilConversation) {
		this.dernierMessFilConversation = dernierMessFilConversation;
	}
	
}
