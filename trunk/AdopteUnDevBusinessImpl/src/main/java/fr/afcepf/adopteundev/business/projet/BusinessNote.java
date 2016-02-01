package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTONote;
import entity.Note;
import fr.afcepf.adopteundev.idao.projet.IDaoNote;

@Remote(IBusinessNote.class)
@Stateless
public class BusinessNote implements IBusinessNote{

	@EJB
	private IDaoNote daoNote;
	@Override
	public List<DTONote> recupNoteParProjet(int idProjet) {
		List<Note> listeNote = daoNote.recupNoteParProjet(idProjet); 
		return EntityToDTO.listeNoteToDTONote(listeNote);
	}
	@Override
	public DTONote ajouterUnCommentaire(DTONote dtoNote) {
		return EntityToDTO.noteToDTONote(daoNote.ajouterUnCommentaire(DTOToEntity.dtoNoteToNote(dtoNote)));
	}

}
