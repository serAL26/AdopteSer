package fr.afcepf.adopteundev.managedbean.projet;

import dto.*;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private DTOProjet projet;
    private IUCProjet ucProjet;
    private IUcProposition ucProposition;
    private IUCGestionCdc gestionCdc;
    private DTOCdc cdc;
    private String tarifCdc;


    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        ucProposition = (IUcProposition) ContextFactory.createProxy(UcName.UCGESTIONPROPOSITION);
        projet = ucProjet.recupProjetById(2);
        cdc = getFinalCdc();
        tarifCdc = transformTarif(cdc);
    }

    public String commentaireDeProjetParUtilisateur(int idUtilisateur){
        return getNoteParUtilisateur(idUtilisateur).getCommentaire();
    }

    private DTONote getNoteParUtilisateur(int idUtilisateur) {
        DTONote note = new DTONote();
        Set<DTONote> noteSet = projet.getLesNotes();
        if (noteSet!= null){
            for (DTONote note2 :
                    noteSet) {
                if (note2.getIdEstNote() != idUtilisateur)
                    note = note2;
            }
        }else{
            //pour le test
            note.setNote(5.0);
            note.setCommentaire("test test test");
            note.setDate(new Date());
            note.setIdEstNote(1);
            note.setIdNoteur(17);
        }
        return note;
    }
    public List<DTOLivrable> getLesLivrableDuProjet(int idProjet){
        List<DTOLivrable>liste = new ArrayList<>();

        return liste;
    }

    public DTOCdc getFinalCdc(){
        return gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
    }

    public String transformTarif(DTOCdc cdc){
       return String.valueOf(cdc);
    }

    public DTOProjet getProjet() {
        return projet;
    }

    public void setProjet(DTOProjet projet) {
        this.projet = projet;
    }

    public DTOCdc getCdc() {
        return cdc;
    }

    public void setCdc(DTOCdc cdc) {
        this.cdc = cdc;
    }

    public String getTarifCdc() {
        return tarifCdc;
    }

    public void setTarifCdc(String tarifCdc) {
        this.tarifCdc = tarifCdc;
    }
}
