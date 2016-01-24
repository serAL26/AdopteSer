package dto;


/**
 * 
 */
public class DTOService {

    /**
     * Default constructor
     */
    public DTOService() {
    }

    /**
     * 
     */
    private Integer idService;

    /**
     * 
     */
    public DTOAppli appli;

    /**
     * 
     */
    public DTOTypeService typeService;

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public DTOAppli getAppli() {
		return appli;
	}

	public void setAppli(DTOAppli appli) {
		this.appli = appli;
	}

	public DTOTypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(DTOTypeService typeService) {
		this.typeService = typeService;
	}

    
	
}