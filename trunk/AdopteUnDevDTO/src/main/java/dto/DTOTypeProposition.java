package dto;

import java.io.Serializable;


/**
 *
 */
public class DTOTypeProposition implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOTypeProposition() {
    }

    public DTOTypeProposition(Integer idTypeProposition) {
        this.idTypeProposition = idTypeProposition;
    }

    /**
     *
     */
    private Integer idTypeProposition;

    /**
     *
     */
    private String libelle;

    public Integer getIdTypeProposition() {
        return idTypeProposition;
    }

    public void setIdTypeProposition(Integer idTypeProposition) {
        this.idTypeProposition = idTypeProposition;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}