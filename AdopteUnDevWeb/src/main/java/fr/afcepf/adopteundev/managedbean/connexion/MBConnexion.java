package fr.afcepf.adopteundev.managedbean.connexion;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MBConnexion {
    private String mail;
    private String mdp;
    private  IUcConnexion connexion;
    @PostConstruct
    private void obtenirLesInterfaces(){
        connexion = (IUcConnexion) ContextFactory.createProxy(UcName.UCCONNEXION);
    }

    public String seConnecter() {
        DTOUtilisateur utilisateur = connexion.seConnecter(mail, mdp);
        if (utilisateur == null)
            return "";
        else return "";
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
}
