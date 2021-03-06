package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor
     */
    public Departement() {
    }

    /**
     * 
     */
    @Column(nullable=false)
    private String nom;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_departement",nullable=false)
    private Integer idDepartement;

    @Column(nullable=false)
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