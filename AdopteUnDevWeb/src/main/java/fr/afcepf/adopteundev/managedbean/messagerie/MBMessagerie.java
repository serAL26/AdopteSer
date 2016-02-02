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
	private String leMessage;
	private String titre;
	private boolean premierChargement = true;
	private DTOMessage messMereDeLaConverse = new DTOMessage();
	private DTOMessage messageAjoute = new DTOMessage();
	private List<DTOMessage> filConversation = new ArrayList<>();
	private boolean tousLesMessLu = true;
	private List<NoMessage> listeNoMessage = new ArrayList<>();
	private DTOUtilisateur mecEnFace = new DTOUtilisateur();
	private DTOUtilisateur correspondantPourNouveauFil = new DTOUtilisateur();
	private NoMessage noMessage = new NoMessage();
	private IUCMessage ucMessage;
	private DTOMessage dernierMessFilConversation = new DTOMessage();
	private IUcUtilisateur ucUtilisateur;
	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;

	public void initListeNoMessage() {
		if(mBConnexion.getUtilisateur() != null) {
			listeNoMessage = ucMessage.recupereNoMessage(mBConnexion.getUtilisateur().getIdUtilisateur());
			for (NoMessage noMessage : listeNoMessage) {
				if(!noMessage.isLu()) {
					tousLesMessLu = false;
				}
			}
		}
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
		obtenirFilConversation(messMereDeLaConverse, noMessage);
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
		messageCree.setMessage(leMessage);
		messageCree.setLu(false);
		messageCree.setTitre(dernierMessFilConversation.getTitre());
		messageCree.setUtilisateur1(mBConnexion.getUtilisateur());
		messageCree.setUtilisateur2(mecEnFace);
		messageAjoute = ucMessage.ecrireUnNouveauMesssage(messageCree);
		return "";
	}

	public String obtenirFilConversation(DTOMessage messMere, NoMessage noMessParam) {
		mecEnFace = noMessParam.getMecEnFace();
		messMereDeLaConverse = messMere;
		noMessage = noMessParam;
		filConversation = ucMessage.recupererFilConversation(messMereDeLaConverse, mBConnexion.getUtilisateur().getIdUtilisateur());
		return "";
	}

	public String creerNouveauFil(DTOUtilisateur recepteur) {
		DTOMessage nouveauMessage = new DTOMessage();
		nouveauMessage.setMessage(leMessage);
		nouveauMessage.setDateEnvoi(new Date());
		nouveauMessage.setTitre(titre);
		nouveauMessage.setLu(false);
		nouveauMessage.setUtilisateur1(mBConnexion.getUtilisateur());
		nouveauMessage.setUtilisateur2(recepteur);
		ucMessage.creerNouveauFil(nouveauMessage);
		return "";
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

	public DTOMessage getMessMereDeLaConverse() {
		return messMereDeLaConverse;
	}

	public void setMessMereDeLaConverse(DTOMessage messMereDeLaConverse) {
		this.messMereDeLaConverse = messMereDeLaConverse;
	}

	public DTOMessage getMessageAjoute() {
		return messageAjoute;
	}

	public void setMessageAjoute(DTOMessage messageAjoute) {
		this.messageAjoute = messageAjoute;
	}

	public NoMessage getNoMessage() {
		return noMessage;
	}

	public void setNoMessage(NoMessage noMessage) {
		this.noMessage = noMessage;
	}

	public String getLeMessage() {
		return leMessage;
	}

	public void setLeMessage(String leMessage) {
		this.leMessage = leMessage;
	}

	public boolean isPremierChargement() {
		if(premierChargement) {
			premierChargement = false;
			return true;
		}
		return premierChargement;
	}

	public void setPremierChargement(boolean premierChargement) {
		this.premierChargement = premierChargement;
	}

	public DTOUtilisateur getCorrespondantPourNouveauFil() {
		return correspondantPourNouveauFil;
	}

	public void setCorrespondantPourNouveauFil(DTOUtilisateur correspondantPourNouveauFil) {
		this.correspondantPourNouveauFil = correspondantPourNouveauFil;
	}

	public boolean isTousLesMessLu() {
		return tousLesMessLu;
	}

	public void setTousLesMessLu(boolean tousLesMessLu) {
		this.tousLesMessLu = tousLesMessLu;
	}
}
