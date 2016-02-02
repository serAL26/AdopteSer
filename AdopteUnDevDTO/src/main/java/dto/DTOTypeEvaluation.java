package dto;

import java.io.Serializable;


/**
 *
 */
public class DTOTypeEvaluation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public DTOTypeEvaluation() {
    }

    /**
     *
     */
    private Integer idTypeEvaluation;

    /**
     *
     */
    private String libelle;

    public Integer getIdTypeEvaluation() {
        return idTypeEvaluation;
    }

    public void setIdTypeEvaluation(Integer idTypeEvaluation) {
        this.idTypeEvaluation = idTypeEvaluation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}