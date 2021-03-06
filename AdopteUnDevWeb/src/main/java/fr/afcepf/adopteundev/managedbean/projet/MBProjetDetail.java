package fr.afcepf.adopteundev.managedbean.projet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;

import dto.DTOCdc;
import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOLivrable;
import dto.DTONote;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOProposition;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private static final int DEFAULT_BUFFER_SIZE = 10240;
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private IUCGestionCdc gestionCdc;
    private DTOCdc cdc;
    private boolean livrablePaye;
    private String descriptionPaiement;
    private String descriptionLivrable;
    private IUCProjet ucProjet;
    private List<DTOLivrable> livrableList = new ArrayList<>();
    private Integer note = 0;
    private String commentaire="";

    @ManagedProperty(value = "#{mBProjetParUtilisateur}")
    private MBProjetParUtilisateur mBProjetParUtilisateur;

	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;

    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        initCdc();
    }

    public void initIsPaye(DTOLivrable livrable) {
        livrablePaye = ucProjet.initIsPaye(livrable);
        if (livrablePaye) {
            descriptionPaiement = "Payé";
        } else {
            descriptionPaiement = "En attente de paiement";
        }
    }
    
    public int obtenirMontantLivrable(DTOLivrable dtoLivrable) {
    	return ucProjet.obtenirMontantLivrable(dtoLivrable);
    }
    
    public void payerLivrable(DTOLivrable livrable) {
        List<DTOOperation> liste = new ArrayList<>();
        if (livrable.getLesOperation() != null) {
            liste.addAll(livrable.getLesOperation());
            ucProjet.payerLivrable(liste.get(0));
            livrablePaye = ucProjet.initIsPaye(livrable);
        }
    }

    public String upload(DTOLivrable livrable) {
        log.info("Debut de l'upload...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        List<DiskFileItem> params = (List<DiskFileItem>) httpServletRequest.getAttribute("fichierUpload");
        for (DiskFileItem diskFileItem :
                params) {
            //String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
            //la methode en dessous est moins fiable car tout depend du serveur
            String path = this.getClass().getResource("").getPath();
            log.info(path);
            path = path.split("/WEB-INF")[0];
            log.info(path);
            File file1 = new File(path + "/Livrables");
            if (!file1.exists())
                file1.mkdirs();
            log.info(diskFileItem.getName());
            StringBuffer test = new StringBuffer("");
            test.append(path);
            test.append("/Livrables/");
            test.append(diskFileItem.getName());
            log.info("stringbuffer = " + test);
            file1 = new File(test.toString());

            try {
                if (!file1.exists())
                    file1.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                fileOutputStream.write(diskFileItem.get());
                fileOutputStream.close();
                log.info("livrable : " + livrable.getFichier());
                log.info("livrable : " + livrable.getIdLivrable());
                livrable.setFichier(diskFileItem.getName());
                log.info("livrable : " + livrable.getFichier());
                ucProjet.ajouterLeFichierDansLeLivrable(livrable);
            } catch (IOException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return "";
    }

    public int noteDeProjetParUtilisateur(int idUtilisateur) {
        int note = getNoteParUtilisateur(idUtilisateur).getNote().intValue();
        log.info("valeur de la  note : " + note);
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
		if(mBProjetParUtilisateur.getProjet().getEtatProjet().getIdEtatProjet() != 4) {
			DTOProposition propositionValidee = new DTOProposition();
 					if((propositionValidee = ucProjet.recupPropositionValidePourProjet(mBProjetParUtilisateur.getProjet())) != null){
			livrableList = ucProjet.recupListLivrableParProjetEtParDev(mBProjetParUtilisateur.getProjet(), propositionValidee.getDeveloppeur().getIdUtilisateur());
 					}
		}
		else if (mBConnexion.getTypeUtilisateur() == 1){
			livrableList = ucProjet.recupListLivrableParProjetEtParDev(mBProjetParUtilisateur.getProjet(), mBConnexion.getUtilisateur().getIdUtilisateur());
		}
		else {
			livrableList = new ArrayList<>();
		}
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
        log.info(tarif);
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

    public boolean isLivrablePaye() {
        return livrablePaye;
    }

    public void setLivrablePaye(boolean livrablePaye) {
        this.livrablePaye = livrablePaye;
    }

    public String getDescriptionPaiement() {
        return descriptionPaiement;
    }

	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}
	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}
    public void setDescriptionPaiement(String descriptionPaiement) {
        this.descriptionPaiement = descriptionPaiement;
    }

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
    
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String noter(DTOProjet projet, DTODeveloppeur dev, DTOClient client)
	{
		DTONote noteDto = new DTONote();
		noteDto.setCommentaire(commentaire);
		noteDto.setDate(new Date());
		noteDto.setIdEstNote(dev.getIdUtilisateur());
		noteDto.setIdNoteur(client.getIdUtilisateur());
		noteDto.setProjet(projet);
		noteDto.setNote(note.doubleValue());
		ucProjet.ajouterUnCommentaire(noteDto);
		return "/ListeProjets.xhtml?faces-redirect=true";
	}
	
	public List<DTONote> recupNote(Integer idProjet)
	{
		List<DTONote> listeNote = ucProjet.recupNoteParProjet(idProjet);
		return listeNote;
	}
	
}
