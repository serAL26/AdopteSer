package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOTypeOperation implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOTypeOperation() {
    }

    /**
     * 
     */
    private Integer idTypeOperation;

    /**
     * 
     */
    private String libelle;

	public Integer getIdTypeOperation() {
		return idTypeOperation;
	}

	public void setIdTypeOperation(Integer idTypeOperation) {
		this.idTypeOperation = idTypeOperation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


    
	
}