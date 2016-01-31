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
	String typeUtilisateur(int idUtilisateur);
    List<DTODeveloppeur> recupDevWeb();
    List<DTODeveloppeur> recupDevParTechno(Integer id);
}
