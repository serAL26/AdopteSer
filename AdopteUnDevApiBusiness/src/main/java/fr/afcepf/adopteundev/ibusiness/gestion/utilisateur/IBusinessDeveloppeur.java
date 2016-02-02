package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dto.DTODeveloppeur;
import dto.DTOTechnologie;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoNotes;

public interface IBusinessDeveloppeur {
	List<DTODeveloppeur> recupererTousLesDeveloppeurs();

	NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);

	List<DTODeveloppeur> recupDevWeb();

	List<DTODeveloppeur> recupDevParTechno(Integer id);

	Set<DTODeveloppeur> recupDeveloppeurParNoteEtTechno(double note,
			DTOTechnologie techno);

	Set<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies);

	List<DTOTechnologie> recupToutesTechnos();

	DTOTechnologie recupTechnoById(int id);

	List<NoNotes> recupListNotes();

	NoDeveloppeur obtenirNoDevById(int id);

	Set<DTODeveloppeur> recupDevParNote(double note);

	public Set<NoDeveloppeur> recupNoDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies);
}
