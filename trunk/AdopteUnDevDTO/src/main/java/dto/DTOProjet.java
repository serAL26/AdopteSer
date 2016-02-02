package dto;

import java.io.Serializable;
import java.util.Set;

/**
 *
 */
public class DTOProjet implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public DTOProjet() {
    }

    public DTOProjet(Integer idProjet, String libelle) {
        this.idProjet = idProjet;
        this.libelle = libelle;
    }

    public DTOProjet(Integer idProjet, String libelle, DTOClient client) {
        this.idProjet = idProjet;
        this.libelle = libelle;
        this.client = client;
    }

    private String photo;
    
    /**
     *
     */
    private Integer idProjet;

    /**
     *
     */
    private String libelle;

    /**
     *
     */
    public DTOClient client;

    /**
     *
     */
    public Set<DTONote> lesNotes;

    /**
     *
     */
    public DTOEtatProjet etatProjet;

    /**
     *
     */
    public Set<DTOCdc> lesCdc;

    /**
     *
     */
    private DTOTypeService service;
    /**
     *
     */
    public Set<DTOLitige> lesLitige;

    /**
     *
     */
    public Set<DTOLivrable> lesLivrable;

    /**
     *
     */
    public Set<DTOProposition> lesProposition;

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public DTOClient getClient() {
        return client;
    }

    public void setClient(DTOClient client) {
        this.client = client;
    }

    public Set<DTONote> getLesNotes() {
        return lesNotes;
    }

    public void setLesNotes(Set<DTONote> lesNotes) {
        this.lesNotes = lesNotes;
    }

    public DTOEtatProjet getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(DTOEtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    public Set<DTOCdc> getLesCdc() {
        return lesCdc;
    }

    public void setLesCdc(Set<DTOCdc> lesCdc) {
        this.lesCdc = lesCdc;
    }


    public Set<DTOLitige> getLesLitige() {
        return lesLitige;
    }

    public void setLesLitige(Set<DTOLitige> lesLitige) {
        this.lesLitige = lesLitige;
    }

    public Set<DTOLivrable> getLesLivrable() {
        return lesLivrable;
    }

    public void setLesLivrable(Set<DTOLivrable> lesLivrable) {
        this.lesLivrable = lesLivrable;
    }

    public Set<DTOProposition> getLesProposition() {
        return lesProposition;
    }

    public void setLesProposition(Set<DTOProposition> lesProposition) {
        this.lesProposition = lesProposition;
    }


	public DTOTypeService getService() {
		return service;
	}

	public void setService(DTOTypeService service) {
		this.service = service;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

    @Override
    public String toString() {
        return "DTOProjet{" +
                "idProjet=" + idProjet +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}