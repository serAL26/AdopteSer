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
@Table(name="association_cdc_technologie")
public class AssociationCdcTechnologie {

    /**
     * Default constructor
     */
    public AssociationCdcTechnologie() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_association_cdc_technologie",nullable=false)
    private Integer idAssociationCdcTechnologie;

    @ManyToOne
    @JoinColumn(name="idCdc")
    @Column(nullable=false)
    private Cdc cdc;

    @ManyToOne
    @JoinColumn(name="idTechnologie")
    @Column(nullable=false)
    private Technologie technologie;

	public Integer getIdAssociationCdcTechnologie() {
		return idAssociationCdcTechnologie;
	}

	public void setIdAssociationCdcTechnologie(Integer idAssociationCdcTechnologie) {
		this.idAssociationCdcTechnologie = idAssociationCdcTechnologie;
	}

	public Cdc getCdc() {
		return cdc;
	}

	public void setCdc(Cdc cdc) {
		this.cdc = cdc;
	}

	public Technologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

    
}