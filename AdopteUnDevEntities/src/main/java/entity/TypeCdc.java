package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeCdc")
public class TypeCdc {

	/**
	 * Default constructor
	 */
	public TypeCdc() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_cdc")
	private Integer idTypeCdc;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	public Integer getIdTypeCdc() {
		return idTypeCdc;
	}

	public void setIdTypeCdc(Integer idTypeCdc) {
		this.idTypeCdc = idTypeCdc;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}