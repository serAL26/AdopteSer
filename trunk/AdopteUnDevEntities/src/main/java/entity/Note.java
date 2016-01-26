package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="note")
public class Note {

    /**
     * Default constructor
     */
    public Note() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_note",nullable=false)
    private Integer idNote;

    /**
     * 
     */
    @Column(name="id_noteur",nullable=false)
    private int idNoteur;

    /**
     * 
     */
      @Column(name="id_est_note",nullable=false)
    private int idEstNote;

    /**
     * 
     */
    private String Commentaire;

    /**
     * 
     */
    @Column(nullable=false)
    private Double Note;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date Date;

    @ManyToOne
    @JoinColumn(name="idProjet")
    @Column(nullable=false)
    private Projet projet;

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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

    
}