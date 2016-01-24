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
    private String Technologie;

    /**
     * 
     */
    private Integer idTechnologie;

    /**
     * 
     */
    public Set<DTOAssociationTechnoRep> lesAssociationTechnoRep;

    /**
     * 
     */
    public Set<DTOAssociationCdcTechnologie> lesAssociationCdcTechnologie;

    /**
     * 
     */
    public Set<DTOAssociationDevTechno> lesAssociationDevTechno;

	public String getTechnologie() {
		return Technologie;
	}

	public void setTechnologie(String technologie) {
		Technologie = technologie;
	}

	public Integer getIdTechnologie() {
		return idTechnologie;
	}

	public void setIdTechnologie(Integer idTechnologie) {
		this.idTechnologie = idTechnologie;
	}

	public Set<DTOAssociationTechnoRep> getLesAssociationTechnoRep() {
		return lesAssociationTechnoRep;
	}

	public void setLesAssociationTechnoRep(
			Set<DTOAssociationTechnoRep> lesAssociationTechnoRep) {
		this.lesAssociationTechnoRep = lesAssociationTechnoRep;
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

    
	
}