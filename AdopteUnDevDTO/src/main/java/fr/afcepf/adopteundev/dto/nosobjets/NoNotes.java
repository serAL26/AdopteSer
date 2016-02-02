package fr.afcepf.adopteundev.dto.nosobjets;

public class NoNotes {
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
