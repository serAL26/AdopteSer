package dto;


/**
 * 
 */
public class DTOAssociationTechnoRep {

    /**
     * Default constructor
     */
    public DTOAssociationTechnoRep() {
    }

    /**
     * 
     */
    private Integer idAssociationTechnoRep;

    /**
     * 
     */
    public DTOTechnologie technologie;

    /**
     * 
     */
    public DTOReponsesPreDefinies reponse;

	public Integer getIdAssociationTechnoRep() {
		return idAssociationTechnoRep;
	}

	public void setIdAssociationTechnoRep(Integer idAssociationTechnoRep) {
		this.idAssociationTechnoRep = idAssociationTechnoRep;
	}

	public DTOTechnologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(DTOTechnologie technologie) {
		this.technologie = technologie;
	}

	public DTOReponsesPreDefinies getReponse() {
		return reponse;
	}

	public void setReponse(DTOReponsesPreDefinies reponse) {
		this.reponse = reponse;
	}

    
}