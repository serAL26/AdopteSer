package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOUtilisateur;
import enumeration.RoleUtilisateur;

public interface IBusinessUtilisateur {
	DTOUtilisateur connecterDtoUtilisateur(String mail,String mdp);
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
	List<DTODeveloppeur> recupTousLesDev();
	int typeUtilisateur(int idUtilisateur);
}
