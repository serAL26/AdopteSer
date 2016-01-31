package fr.afcepf.adopteundev.managedbean.connexion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOClient;
import dto.DTOUtilisateur;
import enumeration.RoleUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;
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
    private IUcUtilisateur ucUtilisateur;
    private DTOUtilisateur utilisateur;
    private String typeUtilisateur;

    public MBConnexion() {
		super();
	}

	@PostConstruct
    public void obtenirLesInterfaces(){
        connexion = (IUcConnexion) ContextFactory.createProxy(UcName.UCCONNEXION);
        ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
    }

    private void initTypeUtilisateur() {
    	if(utilisateur != null) {
    	typeUtilisateur = ucUtilisateur.typeUtilisateur(utilisateur.getIdUtilisateur()).toString();
    	}
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
        initTypeUtilisateur();
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

	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}
}
