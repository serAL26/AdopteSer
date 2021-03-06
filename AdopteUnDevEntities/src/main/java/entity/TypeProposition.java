package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeProposition")
public class TypeProposition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public TypeProposition() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_proposition")
	private Integer idTypeProposition;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	public Integer getIdTypeProposition() {
		return idTypeProposition;
	}

	public void setIdTypeProposition(Integer idTypeProposition) {
		this.idTypeProposition = idTypeProposition;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}