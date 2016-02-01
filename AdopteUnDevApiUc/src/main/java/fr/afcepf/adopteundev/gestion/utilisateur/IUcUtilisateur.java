package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.List;

import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOTechnologie;
import dto.DTOUtilisateur;
import enumeration.RoleUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IUcUtilisateur {
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);
	List<DTODeveloppeur> recupTousLesDeveloppeurs();
	NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);
	int typeUtilisateur(int idUtilisateur);
    List<DTODeveloppeur> recupDevWeb();
    List<DTODeveloppeur> recupDevParTechno(Integer id);
    public DTOClient recupClientById(int id);
    public List<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies);
}
