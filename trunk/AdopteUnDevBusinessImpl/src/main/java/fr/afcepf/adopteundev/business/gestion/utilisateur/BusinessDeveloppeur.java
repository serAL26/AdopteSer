package fr.afcepf.adopteundev.business.gestion.utilisateur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOTechnologie;
import entity.Developpeur;
import entity.Note;
import entity.Technologie;
import enumeration.TypeNotes;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoNotes;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoNote;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoTechnologie;

@Remote(IBusinessDeveloppeur.class)
@Stateless
public class BusinessDeveloppeur implements IBusinessDeveloppeur {
	static Logger log = Logger.getLogger(BusinessDeveloppeur.class);
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
		return EntityToDTO.listDevtoDTODeveloppeur(daoDeveloppeur
				.recupererTousLesDeveloppeurs());
	}

	@Override
	public NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
		NoDeveloppeur noDev = new NoDeveloppeur(dtoDeveloppeur);
		noDev.setListeCommentaire(obtenirNote(dtoDeveloppeur));
		if (noDev.getListeCommentaire().size() > 0) {
			noDev.setNote(moyenneNote(noDev.getListeCommentaire()));
		}
		noDev.setTechnologie(obtenirTechnologie(dtoDeveloppeur));
		noDev.setPetiteListeDeTechnoPasPiqueeDesVers(obtenirStringTechno(noDev
				.getTechnologie()));
		return noDev;
	}

	private String obtenirStringTechno(List<DTOTechnologie> technologie) {
		String listeTechno = "";
		for (int i = 0; i < technologie.size() && i < 3; i++) {
			if (i == 0) {
				listeTechno += technologie.get(i).getTechnologieLibelle();
			} else {
				listeTechno += " | "
						+ technologie.get(i).getTechnologieLibelle();
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
		if (nbProjet > 0) {
			somme = somme / nbProjet;
		}
		return somme;
	}

	private List<DTOTechnologie> obtenirTechnologie(
			DTODeveloppeur dtoDeveloppeur) {
		List<Technologie> listeTechnologie = daoTechnologie
				.recupTechnoParDev(dtoDeveloppeur.getIdUtilisateur());
		return EntityToDTO.listeTechnologieToDTOTechnologie(listeTechnologie);
	}

	private List<DTONote> obtenirNote(DTODeveloppeur dtoDeveloppeur) {
		List<Note> listeNote = daoNote
				.recupNoteParPropositionValidee(dtoDeveloppeur
						.getIdUtilisateur());
		return EntityToDTO.listeNoteToDTONote(listeNote);
	}

	private Double calculLaNote(Set<Note> listeNote, int idDev) {
		Double sommeNote = new Double(0);
		double nbProjet = 0;
		Double retour = new Double(0);
		for (Note note : listeNote) {
			if (note.getIdEstNote() == idDev) {
				sommeNote += note.getNote();
				nbProjet++;
			}
		}
		if (nbProjet > 0) {
			retour = sommeNote / nbProjet;
		}
		return retour;
	}

	@Override
	public List<DTODeveloppeur> recupDevWeb() {
		List<Developpeur> listeDev = daoDeveloppeur.recupDeveloppeurWeb();
		List<DTODeveloppeur> listeDto = new ArrayList<DTODeveloppeur>();

		for (Developpeur developpeur : listeDev) {

			DTODeveloppeur dtoDev = EntityToDTO
					.developpeurToDTODeveloppeur(developpeur);
			listeDto.add(dtoDev);
		}
		return listeDto;
	}

	@Override
	public List<DTODeveloppeur> recupDevParTechno(Integer id) {
		List<Developpeur> listeDev = daoDeveloppeur.recupDeveloppeurWeb();
		List<DTODeveloppeur> listeDto = new ArrayList<DTODeveloppeur>();

		for (Developpeur developpeur : listeDev) {

			DTODeveloppeur dtoDev = EntityToDTO
					.developpeurToDTODeveloppeur(developpeur);
			listeDto.add(dtoDev);
		}
		return listeDto;
	}

	@Override
	public Set<DTODeveloppeur> recupDeveloppeurParNoteEtTechno(double note,
			DTOTechnologie techno) {
		log.info("id techno " + techno.getIdTechnologie());
		log.info("note " + note);
		Set<Developpeur> liste = null;
		if (note <= 0) {
			liste = daoDeveloppeur.recupDeveloppeursParTechnoSet(techno
					.getIdTechnologie());
			log.info("taille liste dev " + liste.size());
			return EntityToDTO.listDevtoDTODeveloppeur(liste);
		}
		liste = daoDeveloppeur.recupDeveloppeurParNoteEtTechno(note,
				techno.getIdTechnologie());
		return EntityToDTO.listDevtoDTODeveloppeur(liste);

	}

	@Override
	public Set<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies) {
		Set<DTODeveloppeur> listeDev = new HashSet<>();
		if (technologies != null&& technologies.size()>=1) {
			for (DTOTechnologie techno : technologies) {
				listeDev.addAll(recupDeveloppeurParNoteEtTechno(note, techno));
			}
			return listeDev;
		}
		if (note > 0) {
			listeDev = recupDevParNote(note);
			return listeDev;
		}
		if (technologies != null && note <= 0 && technologies.size()>1) {
			listeDev.addAll(recupererTousLesDeveloppeurs());
			return listeDev;
		}
		listeDev.addAll(recupererTousLesDeveloppeurs());
		return listeDev;
	}

	@Override
	public List<DTOTechnologie> recupToutesTechnos() {
		List<Technologie> liste = daoTechnologie.recupToutesTechnos();
		return EntityToDTO.listeTechnologieToDTOTechnologie(liste);
	}

	@Override
	public DTOTechnologie recupTechnoById(int id) {
		return EntityToDTO.technologieToDTOTechnologie(daoTechnologie
				.recupTechnoById(id));
	}

	@Override
	public List<NoNotes> recupListNotes() {
		List<NoNotes> liste = new ArrayList<>();
		int i = 1;
		for (TypeNotes typeNotes : TypeNotes.values()) {
			NoNotes note = new NoNotes(i, typeNotes.toString());
			liste.add(note);
			i++;
		}
		return liste;
	}

	@Override
	public Set<DTODeveloppeur> recupDevParNote(double note) {
		return EntityToDTO.listDevtoDTODeveloppeur(daoDeveloppeur
				.recupDevParNote(note));
	}

	@Override
	public Set<NoDeveloppeur> recupNoDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies) {
		Set<NoDeveloppeur> liste = new HashSet<>();
		Set<DTODeveloppeur> listeDev = recupDevParListeTechnoEtNote(note,
				technologies);
		for (DTODeveloppeur dtoDeveloppeur : listeDev) {
			NoDeveloppeur nodev = creerNoDeveloppeur(dtoDeveloppeur);
			liste.add(nodev);
		}
		return liste;
	}

	@Override
	public NoDeveloppeur obtenirNoDevById(int id) {
		return creerNoDeveloppeur(EntityToDTO
				.developpeurToDTODeveloppeur(daoDeveloppeur
						.obtenirDeveloppeurParId(id)));
	}

}
