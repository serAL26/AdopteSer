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
@Table(name="association_dev_techno")
public class AssociationDevTechno {

    /**
     * Default constructor
     */
    public AssociationDevTechno() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_association_dev_techno")
    private Integer idAssociationDevTechno;

    @ManyToOne
    @JoinColumn(name="idDeveloppeur")
    private Developpeur developpeur;

    @ManyToOne
    @JoinColumn(name="idTechnologie")
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