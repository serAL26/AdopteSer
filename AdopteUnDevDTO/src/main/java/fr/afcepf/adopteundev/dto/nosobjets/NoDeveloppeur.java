package fr.afcepf.adopteundev.dto.nosobjets;

import java.io.Serializable;
import java.util.List;

import dto.DTODeveloppeur;
import dto.DTOTechnologie;

public class NoDeveloppeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private DTODeveloppeur developpeur;
    private Double note;
    private List<DTOTechnologie> technologie;

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
	}

	public List<DTOTechnologie> getTechnologie() {
		return technologie;
	}

	public void setTechnologie(List<DTOTechnologie> technologie) {
		this.technologie = technologie;
	}
}
