package dto;

import java.util.Date;

/**
 * 
 */
public class DTOProposition {

    /**
     * Default constructor
     */
    public DTOProposition() {
    }

    /**
     * 
     */
    private Boolean Lu;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer idProposition;

    /**
     * 
     */
    private String titre;

    /**
     * 
     */
    public DTOProjet projet;

    /**
     * 
     */
    public DTODeveloppeur developpeur;

    /**
     * 
     */
    public DTOTypeProposition typeProposition;

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

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

	public DTOTypeProposition getTypeProposition() {
		return typeProposition;
	}

	public void setTypeProposition(DTOTypeProposition typeProposition) {
		this.typeProposition = typeProposition;
	}

    
	
}