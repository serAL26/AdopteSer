package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.List;
import java.util.Set;

import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOTechnologie;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoNotes;

public interface IUcUtilisateur {
	DTOUtilisateur obtenirUtilisateurById(int idUtilisateur);

	List<DTODeveloppeur> recupTousLesDeveloppeurs();

	NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);

	int typeUtilisateur(int idUtilisateur);

	List<DTODeveloppeur> recupDevWeb();

	List<DTODeveloppeur> recupDevParTechno(Integer id);

	public DTOClient recupClientById(int id);

	public Set<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies);
	public Set<NoDeveloppeur> recupNoDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies);

	public List<DTOTechnologie> recupToutesTechnos();

	public DTOTechnologie recupTechnoById(int id);

	public List<NoNotes> recupListNotes();
	public NoDeveloppeur obtenirNoDevById(int id);
}
