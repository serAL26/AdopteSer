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

@Entity
@Table(name="association_dev_techno")
public class AssociationDevTechno implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public AssociationDevTechno() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_association_dev_techno",nullable=false)
    private Integer idAssociationDevTechno;

    @ManyToOne
    @JoinColumn(name="idDeveloppeur",nullable=false)
    private Developpeur developpeur;

    @ManyToOne
    @JoinColumn(name="idTechnologie",nullable=false)
    private Technologie technologie;

	public Integer getIdAssociationDevTechno() {
		return idAssociationDevTechno;
	}

	public void setIdAssociationDevTechno(Integer idAssociationDevTechno) {
		this.idAssociationDevTechno = idAssociationDevTechno;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public Technologie getTechnologie() {
		return technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

}