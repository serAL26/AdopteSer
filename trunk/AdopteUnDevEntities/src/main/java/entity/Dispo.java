package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dispo")
public class Dispo {

    /**
     * Default constructor
     */
    public Dispo() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_dispo",nullable=false)
    private Integer idDispo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date debutDispo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date finDispo;

    @ManyToOne
    @JoinColumn(name="idDeveloppeur")
    @Column(nullable=false)
    private Developpeur developpeur;

    @ManyToOne
    @JoinColumn(name="idTypeDispo")
    @Column(nullable=false)
    private TypeDispo typeDispo;


	public Integer getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(Integer idDispo) {
		this.idDispo = idDispo;
	}

	public Date getDebutDispo() {
		return debutDispo;
	}

	public void setDebutDispo(Date debutDispo) {
		this.debutDispo = debutDispo;
	}

	public Date getFinDispo() {
		return finDispo;
	}

	public void setFinDispo(Date finDispo) {
		this.finDispo = finDispo;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public TypeDispo getTypeDispo() {
		return typeDispo;
	}

	public void setTypeDispo(TypeDispo typeDispo) {
		this.typeDispo = typeDispo;
	}

    
}