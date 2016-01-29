package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOTypeCdc implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOTypeCdc() {
    }

    /**
     * 
     */
    private Integer idTypeCdc;

    /**
     * 
     */
    private String libelle;

	public Integer getIdTypeCdc() {
		return idTypeCdc;
	}

	public void setIdTypeCdc(Integer idTypeCdc) {
		this.idTypeCdc = idTypeCdc;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


    
	
}