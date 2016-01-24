package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeFonctionnalite")
public class TypeFonctionnalite {

	/**
	 * Default constructor
	 */
	public TypeFonctionnalite() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_fonctionnalite")
	private Integer idTypeFonctionnalite;

	/**
	 * 
	 */
	private String libelle;

	public Integer getIdTypeFonctionnalite() {
		return idTypeFonctionnalite;
	}

	public void setIdTypeFonctionnalite(Integer idTypeFonctionnalite) {
		this.idTypeFonctionnalite = idTypeFonctionnalite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}