package fr.afcepf.adopteundev.managedbean.connexion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBConnexion {
    private String mail;
    private String mdp;
    private String message;
    private  IUcConnexion connexion;
    private DTOUtilisateur utilisateur;

    public MBConnexion() {
		super();
	}

	@PostConstruct
    public void obtenirLesInterfaces(){
        connexion = (IUcConnexion) ContextFactory.createProxy(UcName.UCCONNEXION);
    }

    public String seConnecter() {
        utilisateur = connexion.seConnecter(mail, mdp);
        String retour = "";
        if (utilisateur == null){
            message = "Login/Mdp errone";
        }
        else {
        	retour = "/Messagerie.xhtml?faces-redirect=true";
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
}
