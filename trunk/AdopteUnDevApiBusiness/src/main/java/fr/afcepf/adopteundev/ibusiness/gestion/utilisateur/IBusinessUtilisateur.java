package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOUtilisateur;

public interface IBusinessUtilisateur {
	DTOUtilisateur connecterDtoUtilisateur(String mail,String mdp);
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
	List<DTODeveloppeur> recupTousLesDev();
}
