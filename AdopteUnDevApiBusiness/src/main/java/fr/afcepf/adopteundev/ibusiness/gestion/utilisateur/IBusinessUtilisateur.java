package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import dto.DTOUtilisateur;

public interface IBusinessUtilisateur {
	DTOUtilisateur connecterDtoUtilisateur(String mail,String mdp);
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
}
