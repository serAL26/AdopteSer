package dto;


/**
 * 
 */
public class DTOAssociationCdcFonctionnalite {

    /**
     * Default constructor
     */
    public DTOAssociationCdcFonctionnalite() {
    }

    /**
     * 
     */
    private Integer idAssocCdcFonctionnalite;

    /**
     * 
     */
    public DTOCdc cdc;

    /**
     * 
     */
    public DTOFonctionnalite fonctionnalite;

	public Integer getIdAssocCdcFonctionnalite() {
		return idAssocCdcFonctionnalite;
	}

	public void setIdAssocCdcFonctionnalite(Integer idAssocCdcFonctionnalite) {
		this.idAssocCdcFonctionnalite = idAssocCdcFonctionnalite;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	public DTOFonctionnalite getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(DTOFonctionnalite fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

    
}