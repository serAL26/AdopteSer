package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTODepartement implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTODepartement() {
    }

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private Integer idDepartement;

    /**
     * 
     */
    private String numero;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Integer idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


    
}