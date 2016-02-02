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

    @ManagedProperty(value="#{mBProjetParUtilisateur}")
    private MBProjetParUtilisateur mBProjetParUtilisateur;


    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        initCdc();
        livrableList = ucProjet.recupListLivrableParProjet(mBProjetParUtilisateur.getProjet());
    }

    public void upload() {
        if (file != null) {
            log.info("Succesful"+file.getFileName()+" is uploaded.");
        }
    }
    public int noteDeProjetParUtilisateur(int idUtilisateur){
        int note = getNoteParUtilisateur(idUtilisateur).getNote().intValue();
        log.info("valeur de la  note : "+note);
        return note;
    }

    public String commentaireDeProjetParUtilisateur(int idUtilisateur) {
        return getNoteParUtilisateur(idUtilisateur).getCommentaire();
    }

    private DTONote getNoteParUtilisateur(int idUtilisateur) {
        DTONote note = new DTONote();
        Set<DTONote> noteSet = mBProjetParUtilisateur.getProjet().getLesNotes();
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

    public DTOCdc initCdc() {
        cdc = gestionCdc.recupCdcFinalParidProjet(mBProjetParUtilisateur.getProjet().getIdProjet());
        return cdc;
    }

    public MBProjetParUtilisateur getmBProjetParUtilisateur() {
		return mBProjetParUtilisateur;
	}

	public void setmBProjetParUtilisateur(
			MBProjetParUtilisateur mBProjetParUtilisateur) {
		this.mBProjetParUtilisateur = mBProjetParUtilisateur;
	}

	public Double getTarifRestant() {
        Double tarif = cdc.getTarif();
        List<DTOOperation> operationList = ucProjet.recupListOperationParProjetEtType(mBProjetParUtilisateur.getProjet().getIdProjet(), 3);
        if (operationList != null) {
            log.info("taille de la liste des operations : "+operationList.size());
            for (DTOOperation anOperationList : operationList) {
                tarif -= anOperationList.getMontant();
            }
        }
        return tarif;
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
