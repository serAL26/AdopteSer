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
@Table(name="association_techno_rep")
public class AssociationTechnoRep {

    /**
     * Default constructor
     */
    public AssociationTechnoRep() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_association_techno_rep",nullable=false)
    private Integer idAssociationTechnoRep;

     @ManyToOne
     @JoinColumn(name="idTechnologie",nullable=false)
    private Technologie technologie;

     @ManyToOne
     @JoinColumn(name="idReponse",nullable=false)
    private ReponsesPreDefinies reponse;

	public Integer getIdAssociationTechnoRep() {
		return idAssociationTechnoRep;
	}

	public void setIdAssociationTechnoRep(Integer idAssociationTechnoRep) {
		this.idAssociationTechnoRep = idAssociationTechnoRep;
	}

	public Technologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

	public ReponsesPreDefinies getReponse() {
		return reponse;
	}

	public void setReponse(ReponsesPreDefinies reponse) {
		this.reponse = reponse;
	}

     
}