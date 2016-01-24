package dto;

import java.util.Date;

/**
 * 
 */
public class DTONote {

    /**
     * Default constructor
     */
    public DTONote() {
    }

    /**
     * 
     */
    private Integer idNote;

    /**
     * 
     */
    private int idNoteur;

    /**
     * 
     */
    private int idEstNote;

    /**
     * 
     */
    private String Commentaire;

    /**
     * 
     */
    private Double Note;

    /**
     * 
     */
    private Date Date;

    /**
     * 
     */
    public DTOProjet projet;

	public Integer getIdNote() {
		return idNote;
	}

	public void setIdNote(Integer idNote) {
		this.idNote = idNote;
	}

	public int getIdNoteur() {
		return idNoteur;
	}

	public void setIdNoteur(int idNoteur) {
		this.idNoteur = idNoteur;
	}

	public int getIdEstNote() {
		return idEstNote;
	}

	public void setIdEstNote(int idEstNote) {
		this.idEstNote = idEstNote;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	public Double getNote() {
		return Note;
	}

	public void setNote(Double note) {
		Note = note;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}

    
}