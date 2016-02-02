package fr.afcepf.adopteundev.managedbean.projet;

import dto.*;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private IUCGestionCdc gestionCdc;
    private DTOCdc cdc;
    private String descriptionLivrable;
    private IUCProjet ucProjet;
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

    public String upload() {

        log.info("Debut de l'upload...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        List<DiskFileItem>params = (List<DiskFileItem>) httpServletRequest.getAttribute("fichierUpload");
        for (DiskFileItem diskFileItem :
                params) {
            String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
            //la methode en dessous est moins fiable car tout depend du serveur
            //String path = this.getClass().getResource(".").getPath();
            path = path.split("/WEB-INF")[0];
            File instal = new File(path+"/Livrables");
            instal.mkdirs();
            File file1 = new File(path+"/Livrables/"+diskFileItem.getName());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                fileOutputStream.write(diskFileItem.get());
                fileOutputStream.close();
                DTOLivrable livrable = new DTOLivrable();
                livrable.setDateLivraison(new Date());
                livrable.setDescription(descriptionLivrable);
                livrable.setProjet(cdc.projet);
                livrable.setEcheance(new Date());
                livrable.setFichier(path+"/"+diskFileItem.getName());
                ucProjet.creerLivrable(livrable);
            } catch (IOException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return "";
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

    public String getDescriptionLivrable() {
        return descriptionLivrable;
    }

    public void setDescriptionLivrable(String descriptionLivrable) {
        this.descriptionLivrable = descriptionLivrable;
    }
}
