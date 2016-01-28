package dto;

import java.util.Set;

/**
 * 
 */
public class DTOTechnologie {

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
    public Set<DTOAssociationCdcTechnologie> lesAssociationCdcTechnologie;

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


	public Set<DTOAssociationCdcTechnologie> getLesAssociationCdcTechnologie() {
		return lesAssociationCdcTechnologie;
	}

	public void setLesAssociationCdcTechnologie(
			Set<DTOAssociationCdcTechnologie> lesAssociationCdcTechnologie) {
		this.lesAssociationCdcTechnologie = lesAssociationCdcTechnologie;
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