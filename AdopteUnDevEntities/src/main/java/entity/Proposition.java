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
@Table(name="propostion")
public class Proposition {

    /**
     * Default constructor
     */
    public Proposition() {
    }

    /**
     * 
     */
    @Column(nullable=false)
    private Boolean Lu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date date;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_proposition",nullable=false)
    private Integer idProposition;

    /**
     * 
     */
    @Column(nullable=false)
    private String titre;

    @ManyToOne
    @JoinColumn(name="idProjet")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name="idDeveloppeur")
    private Developpeur developpeur;

    @ManyToOne
    @JoinColumn(name="idTypeProposition")
    private TypeProposition typeProposition;

	public Boolean getLu() {
		return Lu;
	}

	public void setLu(Boolean lu) {
		Lu = lu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(Integer idProposition) {
		this.idProposition = idProposition;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public TypeProposition getTypeProposition() {
		return typeProposition;
	}

	public void setTypeProposition(TypeProposition typeProposition) {
		this.typeProposition = typeProposition;
	}

    
}