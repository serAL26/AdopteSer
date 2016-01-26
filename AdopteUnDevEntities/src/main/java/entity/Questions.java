package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Questions {

	/**
	 * Default constructor
	 */
	public Questions() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_question",nullable=false)
	private Integer idQuestion;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	@OneToMany(mappedBy="question")
	private Set<ReponsesPreDefinies> lesReponses;

	public Integer getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<ReponsesPreDefinies> getLesReponses() {
		return lesReponses;
	}

	public void setLesReponses(Set<ReponsesPreDefinies> lesReponses) {
		this.lesReponses = lesReponses;
	}

	
	
}