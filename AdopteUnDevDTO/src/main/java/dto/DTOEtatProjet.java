package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOEtatProjet implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOEtatProjet() {
    }

    /**
     * 
     */
    private Integer idEtatProjet;

    /**
     * 
     */
    private String libelle;

	public Integer getIdEtatProjet() {
		return idEtatProjet;
	}

	public void setIdEtatProjet(Integer idEtatProjet) {
		this.idEtatProjet = idEtatProjet;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}