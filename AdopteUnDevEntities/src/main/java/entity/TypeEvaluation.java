package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeEvaluation")
public class TypeEvaluation {

	/**
	 * Default constructor
	 */
	public TypeEvaluation() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_evaluation")
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