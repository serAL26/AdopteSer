package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class DTOMessage implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOMessage() {
    }

    /**
     * 
     */
    private Integer idMessage;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private Date dateEnvoi;

    /**
     * 
     */
    private String titre;

    /**
     * 
     */
    public DTOMessage messFille;

    /**
     * 
     */
    public DTOMessage messMere;

    /**
     * 
     */
    public DTOUtilisateur utilisateur1;

    /**
     * 
     */
    public DTOUtilisateur utilisateur2;

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public DTOMessage getMessFille() {
		return messFille;
	}

	public void setMessFille(DTOMessage messFille) {
		this.messFille = messFille;
	}

	public DTOMessage getMessMere() {
		return messMere;
	}

	public void setMessMere(DTOMessage messMere) {
		this.messMere = messMere;
	}

	public DTOUtilisateur getUtilisateur1() {
		return utilisateur1;
	}

	public void setUtilisateur1(DTOUtilisateur utilisateur1) {
		this.utilisateur1 = utilisateur1;
	}

	public DTOUtilisateur getUtilisateur2() {
		return utilisateur2;
	}

	public void setUtilisateur2(DTOUtilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}

    
	
}