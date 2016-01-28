package fr.afcepf.adopteundev.ucimpl.connexion;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;

@Remote(IUcConnexion.class)
@Stateless
public class UcConnexion implements IUcConnexion {
	@EJB
    private IBusinessUtilisateur businessUtilisateur;

    @Override
    public DTOUtilisateur seConnecter(String mail, String mdp) {
        return businessUtilisateur.connecterDtoUtilisateur(mail, mdp);
    }
}
