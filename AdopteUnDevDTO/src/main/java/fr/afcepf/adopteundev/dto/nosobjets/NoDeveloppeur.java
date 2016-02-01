package fr.afcepf.adopteundev.dto.nosobjets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOTechnologie;

public class NoDeveloppeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private DTODeveloppeur developpeur;
    private Double note;
    private Integer noteEnInteger;
    private String petiteListeDeTechnoPasPiqueeDesVers;
    private List<DTONote> listeCommentaire;
    private List<DTOTechnologie> technologie = new ArrayList<>();

	public NoDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
    }

    public DTODeveloppeur getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
    }

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
		noteEnInteger = note.intValue();
	}

	public List<DTOTechnologie> getTechnologie() {
		return technologie;
	}

	public void setTechnologie(List<DTOTechnologie> technologie) {
		this.technologie = technologie;
	}

	public Integer getNoteEnInteger() {
		return noteEnInteger;
	}

	public void setNoteEnInteger(Integer noteEnInteger) {
		this.noteEnInteger = noteEnInteger;
	}

	public List<DTONote> getListeCommentaire() {
		return listeCommentaire;
	}

	public void setListeCommentaire(List<DTONote> listeCommentaire) {
		this.listeCommentaire = listeCommentaire;
	}

	public String getPetiteListeDeTechnoPasPiqueeDesVers() {
		return petiteListeDeTechnoPasPiqueeDesVers;
	}

	public void setPetiteListeDeTechnoPasPiqueeDesVers(String petiteListeDeTechnoPasPiqueeDesVers) {
		this.petiteListeDeTechnoPasPiqueeDesVers = petiteListeDeTechnoPasPiqueeDesVers;
	}
}
