package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeDispo")
public class TypeDispo {

	/**
	 * Default constructor
	 */
	public TypeDispo() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_dispo")
	private Integer idTypeDispo;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String libelle;

	public Integer getIdTypeDispo() {
		return idTypeDispo;
	}

	public void setIdTypeDispo(Integer idTypeDispo) {
		this.idTypeDispo = idTypeDispo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	
}