package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeOperation")
public class TypeOperation {

	/**
	 * Default constructor
	 */
	public TypeOperation() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_operation")
	private Integer idTypeOperation;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	public Integer getIdTypeOperation() {
		return idTypeOperation;
	}

	public void setIdTypeOperation(Integer idTypeOperation) {
		this.idTypeOperation = idTypeOperation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}