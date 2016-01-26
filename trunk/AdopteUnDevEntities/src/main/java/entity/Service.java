package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	/**
	 * Default constructor
	 */
	public Service() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_service",nullable=false)
	private Integer idService;

	@ManyToOne
	@JoinColumn(name="idAppli")
	private Appli appli;

	@ManyToOne
	@JoinColumn(name="idTypeService")
	private TypeService typeService;

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public Appli getAppli() {
		return appli;
	}

	public void setAppli(Appli appli) {
		this.appli = appli;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	
}