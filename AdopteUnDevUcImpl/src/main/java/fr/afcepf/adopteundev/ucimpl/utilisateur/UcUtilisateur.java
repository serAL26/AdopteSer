package fr.afcepf.adopteundev.ucimpl.utilisateur;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;

@Remote(IUcUtilisateur.class)
@Stateless
public class UcUtilisateur implements IUcUtilisateur{

	@EJB
	private IBusinessUtilisateur businessUtilisateur;
	
	@Override
	public DTOUtilisateur obtenirUtilisateurById(int idUtilisateur) {
		return businessUtilisateur.obtenirUtilisateurById(idUtilisateur);
	}

}
