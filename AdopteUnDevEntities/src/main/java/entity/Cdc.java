package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cdc")
public class Cdc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Cdc() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cdc", nullable = false)
	private Integer idCdc;

	/**
     * 
     */
	@Column(nullable = false)
	private String Contexte;

	@Column(nullable = false)
	private Boolean lu;

	/**
     * 
     */
	@Column(nullable = false)
	private String Besoin;

	/**
     * 
     */
	@Column(nullable = false, name="EXISTANT")
	private String Existant;

	/**
     * 
     */
	@Column(nullable = false)
	private Double tarif;

	/**
     * 
     */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_fin_estimee")
	private Date dateFinEstimee;

	@ManyToOne
	@JoinColumn(name = "idProjet")
	private Projet projet;

	
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="id_remarque")
	private Cdc remarque;

	@OneToMany(mappedBy="remarque")
    private List<Cdc> lesCdc ;
	
	@ManyToOne
	@JoinColumn(name = "idTypeCdc", nullable = false)
	private TypeCdc typeCdc;
	
	@ManyToOne
	@JoinColumn(name = "id_developpeur")
	private Developpeur developpeurCdc;

	@OneToMany(mappedBy = "cdc")
	private Set<AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;

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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	

	public TypeCdc getTypeCdc() {
		return typeCdc;
	}

	public void setTypeCdc(TypeCdc typeCdc) {
		this.typeCdc = typeCdc;
	}

	public Set<AssociationCdcFonctionnalite> getLesAssociationCdcFonctionnalite() {
		return lesAssociationCdcFonctionnalite;
	}

	public void setLesAssociationCdcFonctionnalite(
			Set<AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite) {
		this.lesAssociationCdcFonctionnalite = lesAssociationCdcFonctionnalite;
	}

	public Boolean getLu() {
		return lu;
	}

	public void setLu(Boolean lu) {
		this.lu = lu;
	}

	public Cdc getRemarque() {
		return remarque;
	}

	public void setRemarque(Cdc remarque) {
		this.remarque = remarque;
	}

	public List<Cdc> getLesCdc() {
		return lesCdc;
	}

	public void setLesCdc(List<Cdc> lesCdc) {
		this.lesCdc = lesCdc;
	}

	public Developpeur getDeveloppeurCdc() {
		return developpeurCdc;
	}

	public void setDeveloppeurCdc(Developpeur developpeurCdc) {
		this.developpeurCdc = developpeurCdc;
	}
}