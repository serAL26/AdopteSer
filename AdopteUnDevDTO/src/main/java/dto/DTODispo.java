package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class DTODispo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTODispo() {
    }

    /**
     * 
     */
    private Integer idDispo;

    /**
     * 
     */
    private Date debutDispo;

    /**
     * 
     */
    private Date finDispo;

    /**
     * 
     */
    public DTODeveloppeur developpeur;

    /**
     * 
     */
    public DTOTypeDispo typeDispo;

	public Integer getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(Integer idDispo) {
		this.idDispo = idDispo;
	}

	public Date getDebutDispo() {
		return debutDispo;
	}

	public void setDebutDispo(Date debutDispo) {
		this.debutDispo = debutDispo;
	}

	public Date getFinDispo() {
		return finDispo;
	}

	public void setFinDispo(Date finDispo) {
		this.finDispo = finDispo;
	}

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

	public DTOTypeDispo getTypeDispo() {
		return typeDispo;
	}

	public void setTypeDispo(DTOTypeDispo typeDispo) {
		this.typeDispo = typeDispo;
	}

    
	
}