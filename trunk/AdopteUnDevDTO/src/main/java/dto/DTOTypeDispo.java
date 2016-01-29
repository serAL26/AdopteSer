package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOTypeDispo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOTypeDispo() {
    }

    /**
     * 
     */
    private Integer idTypeDispo;

    /**
     * 
     */
    private String libelle;

	public Integer getIdTypeDispo() {
		return idTypeDispo;
	}

	public void setIdTypeDispo(Integer idTypeDispo) {
		this.idTypeDispo = idTypeDispo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


   
	
}