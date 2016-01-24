package dto;

import java.util.Set;

/**
 * 
 */
public class DTOAppli {

    /**
     * Default constructor
     */
    public DTOAppli() {
    }

    /**
     * 
     */
    private Integer idAppli;

    /**
     * 
     */
    public DTOProjet projet;

    /**
     * 
     */
    public Set<DTOService> lesService;

    /**
     * 
     */
    public DTOTypeAppli typeAppli;

	public Integer getIdAppli() {
		return idAppli;
	}

	public void setIdAppli(Integer idAppli) {
		this.idAppli = idAppli;
	}

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}

	public Set<DTOService> getLesService() {
		return lesService;
	}

	public void setLesService(Set<DTOService> lesService) {
		this.lesService = lesService;
	}

	public DTOTypeAppli getTypeAppli() {
		return typeAppli;
	}

	public void setTypeAppli(DTOTypeAppli typeAppli) {
		this.typeAppli = typeAppli;
	}

    
}