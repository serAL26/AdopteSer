package dto;

import java.util.Set;


/**
 * 
 */
public class DTOTypeAppli {

    /**
     * Default constructor
     */
    public DTOTypeAppli() {
    }

    /**
     * 
     */
    private Integer idTypeAppli;

    /**
     * 
     */
    private String libelle;

	private Set<DTOTypeService> lesServices;
	
	public Integer getIdTypeAppli() {
		return idTypeAppli;
	}

	public void setIdTypeAppli(Integer idTypeAppli) {
		this.idTypeAppli = idTypeAppli;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<DTOTypeService> getLesServices() {
		return lesServices;
	}

	public void setLesServices(Set<DTOTypeService> lesServices) {
		this.lesServices = lesServices;
	}


    
	
}