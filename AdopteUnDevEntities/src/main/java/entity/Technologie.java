package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="technologie")
public class Technologie {

	/**
	 * Default constructor
	 */
	public Technologie() {
	}

	/**
	 * 
	 */
	private String Technologie;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_technologie",nullable=false)
	private Integer idTechnologie;

	@OneToMany(mappedBy="technologie")
	private Set<AssociationTechnoRep> lesAssociationTechnoRep;

	@OneToMany(mappedBy="technologie")
	private Set<AssociationCdcTechnologie> lesAssociationCdcTechnologie;

	@OneToMany(mappedBy="technologie")
	private Set<AssociationDevTechno> lesAssociationDevTechno;

	public String getTechnologie() {
		return Technologie;
	}

	public void setTechnologie(String technologie) {
		Technologie = technologie;
	}

	public Integer getIdTechnologie() {
		return idTechnologie;
	}

	public void setIdTechnologie(Integer idTechnologie) {
		this.idTechnologie = idTechnologie;
	}

	public Set<AssociationTechnoRep> getLesAssociationTechnoRep() {
		return lesAssociationTechnoRep;
	}

	public void setLesAssociationTechnoRep(
			Set<AssociationTechnoRep> lesAssociationTechnoRep) {
		this.lesAssociationTechnoRep = lesAssociationTechnoRep;
	}

	public Set<AssociationCdcTechnologie> getLesAssociationCdcTechnologie() {
		return lesAssociationCdcTechnologie;
	}

	public void setLesAssociationCdcTechnologie(
			Set<AssociationCdcTechnologie> lesAssociationCdcTechnologie) {
		this.lesAssociationCdcTechnologie = lesAssociationCdcTechnologie;
	}

	public Set<AssociationDevTechno> getLesAssociationDevTechno() {
		return lesAssociationDevTechno;
	}

	public void setLesAssociationDevTechno(
			Set<AssociationDevTechno> lesAssociationDevTechno) {
		this.lesAssociationDevTechno = lesAssociationDevTechno;
	}

}