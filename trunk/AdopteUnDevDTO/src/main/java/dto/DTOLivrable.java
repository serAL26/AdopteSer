package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 */
public class DTOLivrable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public DTOLivrable() {
    }

    /**
     *
     */
    private Date echeance;

    private String description;

    /**
     *
     */
    private Integer idLivrable;

    /**
     *
     */
    private String fichier;

    /**
     *
     */
    private Date dateLivraison;

    /**
     *
     */
    public DTOProjet projet;

    private DTODeveloppeur developpeur;
    
    /**
     *
     */
    public DTOTypeEvaluation typeEvaluation;

    private Set<DTOOperation> lesOperation;

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public Integer getIdLivrable() {
        return idLivrable;
    }

    public void setIdLivrable(Integer idLivrable) {
        this.idLivrable = idLivrable;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public DTOProjet getProjet() {
        return projet;
    }

    public void setProjet(DTOProjet projet) {
        this.projet = projet;
    }

    public DTOTypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(DTOTypeEvaluation typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public Set<DTOOperation> getLesOperation() {
        return lesOperation;
    }

    public void setLesOperation(Set<DTOOperation> lesOperation) {
        this.lesOperation = lesOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DTOLivrable{" +
                "echeance=" + echeance +
                ", description='" + description + '\'' +
                ", idLivrable=" + idLivrable +
                ", fichier='" + fichier + '\'' +
                ", dateLivraison=" + dateLivraison +
                '}';
    }

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

}