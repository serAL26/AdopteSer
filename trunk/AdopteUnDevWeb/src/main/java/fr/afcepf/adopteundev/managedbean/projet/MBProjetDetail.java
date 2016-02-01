package fr.afcepf.adopteundev.managedbean.projet;

import dto.*;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private IUCGestionCdc gestionCdc;
    private DTOCdc cdc;
    private IUCProjet ucProjet;
    private UploadedFile file;
    private List<DTOLivrable> livrableList;

    @ManagedProperty("mbProjetParUtilisateur")
    private DTOProjet projet;


    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        //projet = ucProjet.recupProjetById(2);
        cdc = getFinalCdc();
        livrableList = ucProjet.recupListLivrableParProjet(projet);
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String commentaireDeProjetParUtilisateur(int idUtilisateur) {
        return getNoteParUtilisateur(idUtilisateur).getCommentaire();
    }

    private DTONote getNoteParUtilisateur(int idUtilisateur) {
        DTONote note = new DTONote();
        Set<DTONote> noteSet = projet.getLesNotes();
        if (noteSet != null) {
            for (DTONote note2 :
                    noteSet) {
                if (note2.getIdEstNote() != idUtilisateur)
                    note = note2;
            }
        } else {
            //pour le test
            note.setNote(5.0);
            note.setCommentaire("test test test");
            note.setDate(new Date());
            note.setIdEstNote(1);
            note.setIdNoteur(17);
        }
        return note;
    }

    public DTOCdc getFinalCdc() {
        return gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
    }

    public DTOProjet getProjet() {
        return projet;
    }

    public Double getTarifRestant() {
        Double tarif = cdc.getTarif();
        List<DTOOperation> operationList = ucProjet.recupListOperationParProjetEtType(projet.getIdProjet(), 3);
        log.info("taille de la liste des operations : "+operationList.size());
        if (operationList != null) {
            for (DTOOperation anOperationList : operationList) {
                tarif -= anOperationList.getMontant();
            }
        }
        return tarif;
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

    public List<DTOLivrable> getLivrableList() {
        return livrableList;
    }

    public void setLivrableList(List<DTOLivrable> livrableList) {
        this.livrableList = livrableList;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
