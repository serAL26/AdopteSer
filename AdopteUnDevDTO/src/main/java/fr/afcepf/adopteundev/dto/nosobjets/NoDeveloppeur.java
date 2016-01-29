package fr.afcepf.adopteundev.dto.nosobjets;

import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOProposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NoDeveloppeur {
    private DTODeveloppeur developpeur;
    private DTONote note;

    public NoDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
        this.note = calculNote(developpeur);
    }

    public DTODeveloppeur getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(DTODeveloppeur developpeur) {
        this.developpeur = developpeur;
    }

    public DTONote getNote() {
        return note;
    }

    public void setNote(DTONote note) {
        this.note = note;
    }

    public DTONote calculNote(DTODeveloppeur dev){
        return operation(getNoteDeProjetFini(dev));
    }

    private List<DTONote> getNoteDeProjetFini(DTODeveloppeur developpeur){
        List<DTONote> listeNoteProjetTermine = new ArrayList<>();
        Set<DTOProposition> listePropositionsTotales = developpeur.getListeProposition();
        for (DTOProposition proposition :
                listePropositionsTotales) {
            Set<DTONote> listNote = proposition.getProjet().getLesNotes();
            if (proposition.getProjet().getEtatProjet().getIdEtatProjet()==2){
                for (DTONote note :
                        listNote) {
                    if (note.getIdEstNote() == developpeur.getIdUtilisateur()) {
                        listeNoteProjetTermine.add(note);
                    }
                }
            }
        }
        return listeNoteProjetTermine;
    }

    private DTONote operation(List<DTONote> noteACalculer){
        DTONote note = new DTONote();
        Double resultat=0d;
        for (int i = 0; i < noteACalculer.size(); i++) {
            resultat += noteACalculer.get(i).getNote();
        }
        resultat = resultat/noteACalculer.size();
        note.setNote(resultat);
        return note;
    }
}
