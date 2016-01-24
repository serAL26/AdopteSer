package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="etat_projet")
public class EtatProjet {

    /**
     * Default constructor
     */
    public EtatProjet() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id_etat_projet")
    private Integer idEtatProjet;

    /**
     * 
     */
    private String libelle;

	public Integer getIdEtatProjet() {
		return idEtatProjet;
	}

	public void setIdEtatProjet(Integer idEtatProjet) {
		this.idEtatProjet = idEtatProjet;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    
}