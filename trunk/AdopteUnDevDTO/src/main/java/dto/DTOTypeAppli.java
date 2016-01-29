package dto;

import java.io.Serializable;
import java.util.Set;


/**
 * 
 */
public class DTOTypeAppli implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "DTOTypeAppli [idTypeAppli=" + idTypeAppli + ", libelle="
				+ libelle + ", lesServices=" + lesServices + "]";
	}


    
	
}