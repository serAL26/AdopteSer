package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement {

    /**
     * Default constructor
     */
    public Departement() {
    }

    /**
     * 
     */
    private String nom;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_departement")
    private Integer idDepartement;

    
    private String numero;


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getIdDepartement() {
		return idDepartement;
	}


	public void setIdDepartement(Integer idDepartement) {
		this.idDepartement = idDepartement;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


    
}