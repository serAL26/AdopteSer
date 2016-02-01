package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Note;
import entity.Proposition;

public interface IDaoNote {
	 List<Note> recupNoteParPropositionValidee(int idUtilisateur);
	 List<Note> recupNoteParProjet(int idProjet);
	 Note ajouterUnCommentaire(Note note);
}
