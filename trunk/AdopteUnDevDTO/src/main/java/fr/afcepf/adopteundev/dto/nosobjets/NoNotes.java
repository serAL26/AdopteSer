package fr.afcepf.adopteundev.dto.nosobjets;

import java.io.Serializable;

public class NoNotes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double note;
	private String libelle;

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public NoNotes(double note, String libelle) {
		super();
		this.note = note;
		this.libelle = libelle;
	}

}
