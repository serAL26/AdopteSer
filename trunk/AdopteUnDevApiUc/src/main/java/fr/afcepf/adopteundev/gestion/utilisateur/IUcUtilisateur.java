package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOUtilisateur;
import enumeration.RoleUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IUcUtilisateur {
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
	List<DTODeveloppeur> recupTousLesDeveloppeurs();
	NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);
	RoleUtilisateur typeUtilisateur(int idUtilisateur);
}