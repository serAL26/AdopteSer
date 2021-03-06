package dto;

import java.io.Serializable;


/**
 * 
 */
/**
 * @author Jajar
 *
 */
public class DTOAssociationDevTechno implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOAssociationDevTechno() {
    }

    /**
     * 
     */
    private Integer idAssociationDevTechno;


    /**
     * 
     */
    public DTODeveloppeur developpeur;

    /**
     * 
     */
    public DTOTechnologie technologie;

	public Integer getIdAssociationDevTechno() {
		return idAssociationDevTechno;
	}

	public void setIdAssociationDevTechno(Integer idAssociationDevTechno) {
		this.idAssociationDevTechno = idAssociationDevTechno;
	}

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

	public DTOTechnologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(DTOTechnologie technologie) {
		this.technologie = technologie;
	}

    
}