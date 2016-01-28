package fr.afcepf.adopteundev.ucimpl.connexion;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;
import fr.afcepf.adopteundev.gestion.connexion.IUcConnexion;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IUcConnexion.class)
@Stateless
public class UcConnexion implements IUcConnexion {
    private IBusinessUtilisateur businessUtilisateur;

    @Override
    public DTOUtilisateur seConnecter(String mail, String mdp) {
        return businessUtilisateur.connecterDtoUtilisateur(mail, mdp);
    }
}
