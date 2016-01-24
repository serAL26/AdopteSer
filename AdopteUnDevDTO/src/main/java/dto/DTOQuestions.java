package dto;

import java.util.Set;

/**
 * 
 */
public class DTOQuestions {

    /**
     * Default constructor
     */
    public DTOQuestions() {
    }

    /**
     * 
     */
    private Integer idQuestion;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    public Set<DTOReponsesPreDefinies> lesReponses;

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

	public Set<DTOReponsesPreDefinies> getLesReponses() {
		return lesReponses;
	}

	public void setLesReponses(Set<DTOReponsesPreDefinies> lesReponses) {
		this.lesReponses = lesReponses;
	}

    
	
}