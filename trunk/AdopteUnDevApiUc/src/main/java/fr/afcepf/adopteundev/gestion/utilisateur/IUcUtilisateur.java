package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOUtilisateur;

public interface IUcUtilisateur {
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
	List<DTODeveloppeur> recupTousLesDeveloppeurs();
}
