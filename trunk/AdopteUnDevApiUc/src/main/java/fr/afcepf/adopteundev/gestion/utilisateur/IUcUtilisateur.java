package fr.afcepf.adopteundev.gestion.utilisateur;

import dto.DTOUtilisateur;

public interface IUcUtilisateur {
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
}
