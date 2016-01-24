package dto;


/**
 * 
 */
public class DTOAssociationCdcTechnologie {

    /**
     * Default constructor
     */
    public DTOAssociationCdcTechnologie() {
    }

    /**
     * 
     */
    private Integer idAssociationCdcTechnologie;

    /**
     * 
     */
    public DTOCdc cdc;

    /**
     * 
     */
    public DTOTechnologie technologie;

	

	public Integer getIdAssociationCdcTechnologie() {
		return idAssociationCdcTechnologie;
	}

	public void setIdAssociationCdcTechnologie(Integer idAssociationCdcTechnologie) {
		this.idAssociationCdcTechnologie = idAssociationCdcTechnologie;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	public DTOTechnologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(DTOTechnologie technologie) {
		this.technologie = technologie;
	}

    
	
}