package dto;

import java.io.Serializable;


/**
 * 
 */
/**
 * @author Jajar
 *
 */
public class DTOTypeFonctionnalite implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOTypeFonctionnalite() {
    }

    /**
     * 
     */
    private Integer idTypeFonctionnalite;

    /**
     * 
     */
    private String libelle;

	public Integer getIdTypeFonctionnalite() {
		return idTypeFonctionnalite;
	}

	public void setIdTypeFonctionnalite(Integer idTypeFonctionnalite) {
		this.idTypeFonctionnalite = idTypeFonctionnalite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}