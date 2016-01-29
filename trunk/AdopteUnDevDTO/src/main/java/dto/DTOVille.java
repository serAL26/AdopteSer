package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOVille implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor
     */
    public DTOVille() {
    }

    /**
     * 
     */
    private Integer idVille;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String cp;


    /**
     * 
     */
    public DTODepartement departement;


	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public DTODepartement getDepartement() {
		return departement;
	}


	public void setDepartement(DTODepartement departement) {
		this.departement = departement;
	}

}