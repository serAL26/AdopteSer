package dto;

import java.util.Set;

/**
 * 
 */
public class DTOReponsesPreDefinies {

    /**
     * Default constructor
     */
    public DTOReponsesPreDefinies() {
    }

    /**
     * 
     */
    private Integer idReponsesPreDefinies;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    public DTOQuestions question;

    /**
     * 
     */
    public Set<DTOAssociationTechnoRep> lesAssociationTechnoRep;

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

	public DTOQuestions getQuestion() {
		return question;
	}

	public void setQuestion(DTOQuestions question) {
		this.question = question;
	}

	public Set<DTOAssociationTechnoRep> getLesAssociationTechnoRep() {
		return lesAssociationTechnoRep;
	}

	public void setLesAssociationTechnoRep(
			Set<DTOAssociationTechnoRep> lesAssociationTechnoRep) {
		this.lesAssociationTechnoRep = lesAssociationTechnoRep;
	}

    
}