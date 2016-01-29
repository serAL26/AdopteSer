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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "typeService")
public class TypeService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public TypeService() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_service")
	private Integer idTypeService;

	/**
	 * 
	 */
	@Column(nullable = false)
	private String libelle;

	/**
     * 
     */
	@ManyToOne
	@JoinColumn(name = "idTypeAppli")
	private TypeAppli typeAppli;

	/**
     * 
     */
	@OneToMany(mappedBy = "typeService")
	private Set<AssociationTypeServiceTechno> lesAssociationTypeServiceTechno;
	
	@ManyToOne
	@JoinColumn(name = "idProjet")
	private Projet projet;

	public TypeAppli getTypeAppli() {
		return typeAppli;
	}

	public void setTypeAppli(TypeAppli typeAppli) {
		this.typeAppli = typeAppli;
	}

	public Set<AssociationTypeServiceTechno> getLesAssociationTypeServiceTechno() {
		return lesAssociationTypeServiceTechno;
	}

	public void setLesAssociationTypeServiceTechno(
			Set<AssociationTypeServiceTechno> lesAssociationTypeServiceTechno) {
		this.lesAssociationTypeServiceTechno = lesAssociationTypeServiceTechno;
	}

	public Integer getIdTypeService() {
		return idTypeService;
	}

	public void setIdTypeService(Integer idTypeService) {
		this.idTypeService = idTypeService;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}