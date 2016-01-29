package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="projet")
public class Projet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Projet() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_projet",nullable=false)
	private Integer idProjet;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

	@OneToMany(mappedBy="projet")
	private Set<Note> lesNotes;

	@ManyToOne
	@JoinColumn(name="idEtatProjet")
	private EtatProjet etatProjet;

	@OneToMany(mappedBy="projet")
	private Set<Cdc> lesCdc;

	
	@OneToMany(mappedBy="projet")
	private Set<TypeService> lesServices;
	
	@OneToMany(mappedBy="projet")
	private Set<Litige> lesLitige;

	@OneToMany(mappedBy="projet")
	private Set<Livrable> lesLivrable;

	@OneToMany(mappedBy="projet")
	private Set<Proposition> lesProposition;

	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Note> getLesNotes() {
		return lesNotes;
	}

	public void setLesNotes(Set<Note> lesNotes) {
		this.lesNotes = lesNotes;
	}

	public EtatProjet getEtatProjet() {
		return etatProjet;
	}

	public void setEtatProjet(EtatProjet etatProjet) {
		this.etatProjet = etatProjet;
	}

	public Set<Cdc> getLesCdc() {
		return lesCdc;
	}

	public void setLesCdc(Set<Cdc> lesCdc) {
		this.lesCdc = lesCdc;
	}

	public Set<Litige> getLesLitige() {
		return lesLitige;
	}

	public void setLesLitige(Set<Litige> lesLitige) {
		this.lesLitige = lesLitige;
	}

	public Set<Livrable> getLesLivrable() {
		return lesLivrable;
	}

	public void setLesLivrable(Set<Livrable> lesLivrable) {
		this.lesLivrable = lesLivrable;
	}

	public Set<Proposition> getLesProposition() {
		return lesProposition;
	}

	public void setLesProposition(Set<Proposition> lesProposition) {
		this.lesProposition = lesProposition;
	}

	public Set<TypeService> getLesServices() {
		return lesServices;
	}

	public void setLesServices(Set<TypeService> lesServices) {
		this.lesServices = lesServices;
	}

	
}