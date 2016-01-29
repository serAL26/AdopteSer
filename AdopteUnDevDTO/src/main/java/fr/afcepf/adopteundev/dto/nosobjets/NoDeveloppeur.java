package fr.afcepf.adopteundev.dto.nosobjets;

import dto.DTODeveloppeur;
import dto.DTONote;

import java.io.Serializable;

public class NoDeveloppeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private DTODeveloppeur developpeur;
    private Integer note;

    public NoDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
    }

    public DTODeveloppeur getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
