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
import entity.Note;
import entity.Technologie;
import entity.TypeFonctionnalite;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoNote;
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
	@EJB
	private IDaoNote daoNote;

	@Override
	public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
		return null;
	}

	@Override
	public NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
		NoDeveloppeur noDev = new NoDeveloppeur(dtoDeveloppeur);
		noDev.setListeCommentaire(obtenirNote(dtoDeveloppeur));
		if(noDev.getListeCommentaire().size() > 0) {
		noDev.setNote(moyenneNote(noDev.getListeCommentaire()));
		}
		noDev.setTechnologie(obtenirTechnologie(dtoDeveloppeur));
		noDev.setPetiteListeDeTechnoPasPiqueeDesVers(obtenirStringTechno(noDev.getTechnologie()));
		return noDev;
	}

	private String obtenirStringTechno(List<DTOTechnologie> technologie) {
		String listeTechno ="";
		for(int i=0; i<technologie.size() && i<3;i++) {
			if (i==0) {
				listeTechno += technologie.get(i).getTechnologieLibelle(); 
			}
			else {
				listeTechno += " | "+technologie.get(i).getTechnologieLibelle();
			}
		}
		return listeTechno;
	}

	private Double moyenneNote(List<DTONote> listeCommentaire) {
		Double nbProjet = new Double(0);
		Double somme = new Double(0);
		for (DTONote dtoNote : listeCommentaire) {
			somme += dtoNote.getNote();
			nbProjet++;
		}
		if(nbProjet > 0){
			somme = somme / nbProjet;
		}
		return somme;
	}

	private List<DTOTechnologie> obtenirTechnologie(DTODeveloppeur dtoDeveloppeur) {
		List<Technologie> listeTechnologie = daoTechnologie.recupTechnoParDev(dtoDeveloppeur.getIdUtilisateur());
		return EntityToDTO.listeTechnologieToDTOTechnologie(listeTechnologie);
	}

	private List<DTONote> obtenirNote(DTODeveloppeur dtoDeveloppeur) {
		List<Note> listeNote = daoNote.recupNoteParPropositionValidee(dtoDeveloppeur.getIdUtilisateur());
		return EntityToDTO.listeNoteToDTONote(listeNote);
	}

	private Double calculLaNote(Set<Note> listeNote, int idDev) {
		Double sommeNote = new Double(0);
		double nbProjet = 0;
		Double retour = new Double(0);
		for (Note note : listeNote) {
			if(note.getIdEstNote()== idDev){
				sommeNote += note.getNote();
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
