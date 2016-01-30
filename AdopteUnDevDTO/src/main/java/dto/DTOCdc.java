package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 
 */
public class DTOCdc implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
    
    public DTODeveloppeur developpeur;
    
    public DTOCdc remarque;

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
	

	public DTOCdc getRemarque() {
		return remarque;
	}

	public void setRemarque(DTOCdc remarque) {
		this.remarque = remarque;
	}

	public Boolean getLu() {
		return lu;
	}

	public void setLu(Boolean lu) {
		this.lu = lu;
	}

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

	public DTOCdc(String contexte, String besoin, String existant,
			Double tarif, Date dateFinEstimee, DTOProjet projet,
			DTOTypeCdc typeCdc, DTODeveloppeur developpeur) {
		super();
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.typeCdc = typeCdc;
		this.developpeur = developpeur;
	}

	public DTOCdc(Boolean lu, String contexte, String besoin,
			String existant, Double tarif, Date dateFinEstimee) {
		super();
		this.lu = lu;
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
	}

	public DTOCdc(Boolean lu, String contexte, String besoin, String existant,
			Double tarif, Date dateFinEstimee, DTOProjet projet,
			DTOTypeCdc typeCdc) {
		super();
		this.lu = lu;
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.typeCdc = typeCdc;
	}

	public DTOCdc(Integer idCdc, Boolean lu, String contexte, String besoin,
			String existant, Double tarif, Date dateFinEstimee,
			DTOProjet projet, DTOTypeCdc typeCdc) {
		super();
		this.idCdc = idCdc;
		this.lu = lu;
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.typeCdc = typeCdc;
	}

	public DTOCdc(Boolean lu, String contexte, String besoin, String existant,
			Double tarif, Date dateFinEstimee, DTOProjet projet,
			DTODeveloppeur developpeur, DTOTypeCdc typeCdc) {
		super();
		this.lu = lu;
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.developpeur = developpeur;
		this.typeCdc = typeCdc;
	}

	public DTOCdc(Boolean lu, String contexte, String besoin, String existant,
			Double tarif, Date dateFinEstimee, DTOProjet projet,
			DTODeveloppeur developpeur, DTOCdc remarque, DTOTypeCdc typeCdc) {
		super();
		this.lu = lu;
		Contexte = contexte;
		Besoin = besoin;
		Existant = existant;
		this.tarif = tarif;
		this.dateFinEstimee = dateFinEstimee;
		this.projet = projet;
		this.developpeur = developpeur;
		this.remarque = remarque;
		this.typeCdc = typeCdc;
	}
}