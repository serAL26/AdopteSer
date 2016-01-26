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
@Table(name="association_cdc_fonctionnalite")
public class AssociationCdcFonctionnalite {

	/**
	 * Default constructor
	 */
	public AssociationCdcFonctionnalite() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_assoc_cdc_fonctionnalite", nullable=false)
	private Integer idAssocCdcFonctionnalite;

	@ManyToOne
	@JoinColumn(name="idCdc")
	private Cdc cdc;

	@ManyToOne
	@JoinColumn(name="idFonctionnalite")
	private Fonctionnalite fonctionnalite;

	public Integer getIdAssocCdcFonctionnalite() {
		return idAssocCdcFonctionnalite;
	}

	public void setIdAssocCdcFonctionnalite(Integer idAssocCdcFonctionnalite) {
		this.idAssocCdcFonctionnalite = idAssocCdcFonctionnalite;
	}

	public Cdc getCdc() {
		return cdc;
	}

	public void setCdc(Cdc cdc) {
		this.cdc = cdc;
	}

	public Fonctionnalite getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(Fonctionnalite fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	
}