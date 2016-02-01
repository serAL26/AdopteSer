package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTONote;

public interface IBusinessNote {
	List<DTONote> recupNoteParProjet(int idProjet);
	DTONote ajouterUnCommentaire(DTONote dtoNote);
}
