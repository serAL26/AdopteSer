package entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="association_typeservice_techno")
public class AssociationTypeServiceTechno implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public AssociationTypeServiceTechno() {
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_association_typeservice_techno",nullable=false)
    private Integer idAssociationTypeServiceTechno;

    @ManyToOne
    @JoinColumn(name="idTypeService")
    private TypeService typeService;

    @ManyToOne
    @JoinColumn(name="idTechnologie")
    private Technologie technologie;
    
	public Integer getIdAssociationTypeServiceTechno() {
		return idAssociationTypeServiceTechno;
	}

	public void setIdAssociationTypeServiceTechno(
			Integer idAssociationTypeServiceTechno) {
		this.idAssociationTypeServiceTechno = idAssociationTypeServiceTechno;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Technologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}



}