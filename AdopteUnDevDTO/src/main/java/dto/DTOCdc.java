package dto;

import java.util.Date;
import java.util.Set;

/**
 * 
 */
public class DTOCdc {

    /**
     * Default constructor
     */
    public DTOCdc() {
    }

    /**
     * 
     */
    private Integer idCdc;

    
    private Boolean lu;
    
    /**
     * 
     */
    private String Contexte;

    /**
     * 
     */
    private String Besoin;

    /**
     * 
     */
    private String Existant;

    /**
     * 
     */
    private Double tarif;

    /**
     * 
     */
    private Date dateFinEstimee;

    /**
     * 
     */
    public DTOProjet projet;

    /**
     * 
     */

    /**
     * 
     */
    public DTOTypeCdc typeCdc;

    /**
     * 
     */
    public Set<DTOAssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;

	public Integer getIdCdc() {
		return idCdc;
	}

	public void setIdCdc(Integer idCdc) {
		this.idCdc = idCdc;
	}

	public String getContexte() {
		return Contexte;
	}

	public void setContexte(String contexte) {
		Contexte = contexte;
	}

	public String getBesoin() {
		return Besoin;
	}

	public void setBesoin(String besoin) {
		Besoin = besoin;
	}

	public String getExistant() {
		return Existant;
	}

	public void setExistant(String existant) {
		Existant = existant;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public Date getDateFinEstimee() {
		return dateFinEstimee;
	}

	public void setDateFinEstimee(Date dateFinEstimee) {
		this.dateFinEstimee = dateFinEstimee;
	}

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}


	public DTOTypeCdc getTypeCdc() {
		return typeCdc;
	}

	public void setTypeCdc(DTOTypeCdc typeCdc) {
		this.typeCdc = typeCdc;
	}

	public Set<DTOAssociationCdcFonctionnalite> getLesAssociationCdcFonctionnalite() {
		return lesAssociationCdcFonctionnalite;
	}

	public void setLesAssociationCdcFonctionnalite(
			Set<DTOAssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite) {
		this.lesAssociationCdcFonctionnalite = lesAssociationCdcFonctionnalite;
	}

	public Boolean getLu() {
		return lu;
	}

	public void setLu(Boolean lu) {
		this.lu = lu;
	}

	public DTOCdc(String contexte, String besoin, String existant,
			Double tarif, Date dateFinEstimee, DTOProjet projet,
			DTOTypeCdc typeCdc) {
		super();
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.typeCdc = typeCdc;
	}
	
	
}