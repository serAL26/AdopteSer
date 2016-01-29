package dto;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 */
public class DTOTechnologie implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
     * Default constructor
     */
    public DTOTechnologie() {
    }

    /**
     * 
     */
    private String technologieLibelle;

    /**
     * 
     */
    private Integer idTechnologie;

    /**
     * 
     */
    private Set<DTOAssociationTypeServiceTechno> lesAssociationTypeServiceTechno;
    /**
     * 
     */

    /**
     * 
     */
    public Set<DTOAssociationDevTechno> lesAssociationDevTechno;



	public Integer getIdTechnologie() {
		return idTechnologie;
	}

	public void setIdTechnologie(Integer idTechnologie) {
		this.idTechnologie = idTechnologie;
	}



	public Set<DTOAssociationDevTechno> getLesAssociationDevTechno() {
		return lesAssociationDevTechno;
	}

	public void setLesAssociationDevTechno(
			Set<DTOAssociationDevTechno> lesAssociationDevTechno) {
		this.lesAssociationDevTechno = lesAssociationDevTechno;
	}

	public Set<DTOAssociationTypeServiceTechno> getLesAssociationTypeServiceTechno() {
		return lesAssociationTypeServiceTechno;
	}

	public void setLesAssociationTypeServiceTechno(
			Set<DTOAssociationTypeServiceTechno> lesAssociationTypeServiceTechno) {
		this.lesAssociationTypeServiceTechno = lesAssociationTypeServiceTechno;
	}

	public String getTechnologieLibelle() {
		return technologieLibelle;
	}

	public void setTechnologieLibelle(String technologieLibelle) {
		this.technologieLibelle = technologieLibelle;
	}

    
	
}