package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTOLitige implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOLitige() {
    }

    /**
     * 
     */
    private String motif;

    /**
     * 
     */
    private Integer idLitige;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    public DTOProjet projet;

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Integer getIdLitige() {
		return idLitige;
	}

	public void setIdLitige(Integer idLitige) {
		this.idLitige = idLitige;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}

    
	
}