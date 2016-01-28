package dto;

import java.util.Date;

/**
 * 
 */
public class DTOOperation {

    /**
     * Default constructor
     */
    public DTOOperation() {
    }

    /**
     * 
     */
    private Double montant;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer idOperation;

    /**
     * 
     */
    public DTOUtilisateur utilisateur;

    /**
     * 
     */
    public DTOTypeOperation typeOperation;
    
	 private DTOLivrable livrable;

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	public DTOUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(DTOUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public DTOTypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(DTOTypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public DTOLivrable getLivrable() {
		return livrable;
	}

	public void setLivrable(DTOLivrable livrable) {
		this.livrable = livrable;
	}

    
	
}