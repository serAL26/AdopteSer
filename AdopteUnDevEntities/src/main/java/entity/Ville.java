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
@Table(name="ville")
public class Ville {

    /**
     * Default constructor
     */
    public Ville() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ville")
    private Integer idVille;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String cp;

    @ManyToOne
    @JoinColumn(name="idDepartemen")
    private Departement departement;

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

    
}