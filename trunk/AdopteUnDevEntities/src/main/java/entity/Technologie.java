package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "technologie")
public class Technologie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Default constructor
	 */
	public Technologie() {
	}

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_technologie", nullable = false)
	private Integer idTechnologie;

	@Column(name = "libelle", nullable = false)
	private String technologieLibelle;

	@OneToMany(mappedBy = "technologie")
	private Set<AssociationTypeServiceTechno> lesAssociationTypeServiceTechno;


	@OneToMany(mappedBy = "technologie")
	private Set<AssociationDevTechno> lesAssociationDevTechno;



	public Integer getIdTechnologie() {
		return idTechnologie;
	}

	public void setIdTechnologie(Integer idTechnologie) {
		this.idTechnologie = idTechnologie;
	}


	public Set<AssociationDevTechno> getLesAssociationDevTechno() {
		return lesAssociationDevTechno;
	}

	public void setLesAssociationDevTechno(
			Set<AssociationDevTechno> lesAssociationDevTechno) {
		this.lesAssociationDevTechno = lesAssociationDevTechno;
	}

	public Set<AssociationTypeServiceTechno> getLesAssociationTypeServiceTechno() {
		return lesAssociationTypeServiceTechno;
	}

	public void setLesAssociationTypeServiceTechno(
			Set<AssociationTypeServiceTechno> lesAssociationTypeServiceTechno) {
		this.lesAssociationTypeServiceTechno = lesAssociationTypeServiceTechno;
	}

	public String getTechnologieLibelle() {
		return technologieLibelle;
	}

	public void setTechnologieLibelle(String technologieLibelle) {
		this.technologieLibelle = technologieLibelle;
	}

}