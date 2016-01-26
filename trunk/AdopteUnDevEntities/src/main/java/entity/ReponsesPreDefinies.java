package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
 @Table(name="reponses_pre_definies")
public class ReponsesPreDefinies {

    /**
     * Default constructor
     */
    public ReponsesPreDefinies() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_reponses_pre_definies",nullable=false)
    private Integer idReponsesPreDefinies;

    /**
     * 
     */
    @Column(nullable=false)
    private String libelle;

    @ManyToOne
    @JoinColumn(name="idQuestion")
    private Questions question;

    @OneToMany(mappedBy="reponse")
    private Set<AssociationTechnoRep> lesAssociationTechnoRep;

	public Integer getIdReponsesPreDefinies() {
		return idReponsesPreDefinies;
	}

	public void setIdReponsesPreDefinies(Integer idReponsesPreDefinies) {
		this.idReponsesPreDefinies = idReponsesPreDefinies;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public Set<AssociationTechnoRep> getLesAssociationTechnoRep() {
		return lesAssociationTechnoRep;
	}

	public void setLesAssociationTechnoRep(
			Set<AssociationTechnoRep> lesAssociationTechnoRep) {
		this.lesAssociationTechnoRep = lesAssociationTechnoRep;
	}

    
}