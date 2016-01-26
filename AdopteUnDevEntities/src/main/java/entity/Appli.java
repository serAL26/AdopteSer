package entity;

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
@Table(name="appli")
public class Appli {

	/**
	 * Default constructor
	 */
	public Appli() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_appli", nullable=false)
	private Integer idAppli;

	@OneToOne
	@Column(nullable=false)
	private Projet projet;

	@OneToMany(mappedBy="appli")
	@Column(nullable=false)
	private Set<Service> lesService;

	@ManyToOne
	@JoinColumn(name="idTypeAppli")
	@Column(nullable=false)
	private TypeAppli typeAppli;

	public Integer getIdAppli() {
		return idAppli;
	}

	public void setIdAppli(Integer idAppli) {
		this.idAppli = idAppli;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Service> getLesService() {
		return lesService;
	}

	public void setLesService(Set<Service> lesService) {
		this.lesService = lesService;
	}

	public TypeAppli getTypeAppli() {
		return typeAppli;
	}

	public void setTypeAppli(TypeAppli typeAppli) {
		this.typeAppli = typeAppli;
	}

	
}