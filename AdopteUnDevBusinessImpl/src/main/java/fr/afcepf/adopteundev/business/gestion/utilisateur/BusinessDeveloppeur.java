package fr.afcepf.adopteundev.business.gestion.utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOProposition;
import dto.DTOTechnologie;
import dto.DTOTypeFonctionnalite;
import entity.Developpeur;
import entity.Technologie;
import entity.TypeFonctionnalite;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoTechnologie;

@Remote(IBusinessDeveloppeur.class)
@Stateless
public class BusinessDeveloppeur implements IBusinessDeveloppeur{

	@EJB
	private IDaoUtilisateur daoUtilisateur;

	@EJB
	private IDaoProposition daoProposition;

	@EJB
	private IDaoTechnologie daoTechnologie;

	@EJB
	private IDaoDeveloppeur daoDeveloppeur;

	@Override
	public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
		return null;
	}

	@Override
	public NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
		NoDeveloppeur noDev = new NoDeveloppeur(dtoDeveloppeur);
		noDev.setNote(obtenirNote(dtoDeveloppeur));
		noDev.setTechnologie(obtenirTechnologie(dtoDeveloppeur));
		return noDev;
	}

	private List<DTOTechnologie> obtenirTechnologie(DTODeveloppeur dtoDeveloppeur) {
		List<Technologie> listeTechnologie = daoTechnologie.recupTechnoParDev(dtoDeveloppeur.getIdUtilisateur());
		return EntityToDTO.listeTechnologieToDTOTechnologie(listeTechnologie);
	}

	private Double obtenirNote(DTODeveloppeur dtoDeveloppeur) {
		List<DTOProposition> listeDTOProposition = EntityToDTO.listePropositionToDtoProposition(daoProposition.recupPropositionValideeParDev(dtoDeveloppeur.getIdUtilisateur()));
		Double retour = new Double(0);
		for (DTOProposition dtoProposition : listeDTOProposition) {
			Set<DTONote> listeNote = dtoProposition.getProjet().getLesNotes();
			if(listeNote != null) {
				retour = calculLaNote(listeNote, dtoDeveloppeur.getIdUtilisateur());
			}
		}
		return retour;
	}

	private Double calculLaNote(Set<DTONote> listeNote, int idDev) {
		Double sommeNote = new Double(0);
		double nbProjet = 0;
		Double retour = new Double(0);
		for (DTONote dtoNote : listeNote) {
			if(dtoNote.getIdEstNote()== idDev){
				sommeNote += dtoNote.getNote();
				nbProjet++;
			}
		}
		if (nbProjet > 0) {
			retour = sommeNote/nbProjet;
		}
		return retour;
	}

	@Override
	public List<DTODeveloppeur> recupDevWeb() {
		List<Developpeur> listeDev = daoDeveloppeur.recupDeveloppeurWeb();
		List<DTODeveloppeur> listeDto = new ArrayList<DTODeveloppeur>();

		for (Developpeur  developpeur : listeDev) {

			DTODeveloppeur dtoDev = EntityToDTO.developpeurToDTODeveloppeur(developpeur);
			listeDto.add(dtoDev);
		}
		return listeDto;
	}

	@Override
	public List<DTODeveloppeur> recupDevParTechno(Integer id) {
		List<Developpeur> listeDev = daoDeveloppeur.recupDeveloppeurWeb();
		List<DTODeveloppeur> listeDto = new ArrayList<DTODeveloppeur>();

		for (Developpeur  developpeur : listeDev) {

			DTODeveloppeur dtoDev = EntityToDTO.developpeurToDTODeveloppeur(developpeur);
			listeDto.add(dtoDev);
		}
		return listeDto;
	}

	@Override
	public List<DTODeveloppeur> recupDeveloppeurParNoteEtTechno(double note,
			DTOTechnologie techno) {
		List<Developpeur> liste = daoDeveloppeur.recupDeveloppeurParNoteEtTechno(note, DTOToEntity.dtoTechnologieToTechnologie(techno));
		//TODO A faire le retour chez moi car je dois partir 
		return null;
	}

	@Override
	public List<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies) {
		// TODO Auto-generated method stub
		return null;
	}
}
