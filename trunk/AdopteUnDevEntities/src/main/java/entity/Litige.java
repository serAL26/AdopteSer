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
@Table(name="litige")
public class Litige {

    /**
     * Default constructor
     */
    public Litige() {
    }

    /**
     * 
     */
    @Column(nullable=false)
    private String motif;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_litige",nullable=false)
    private Integer idLitige;

    /**
     * 
     */
    @Column(nullable=false)
    private String libelle;

    @ManyToOne
    @JoinColumn(name="idProjet")
    @Column(nullable=false)
    private Projet projet;

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Integer getIdLitige() {
		return idLitige;
	}

	public void setIdLitige(Integer idLitige) {
		this.idLitige = idLitige;
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