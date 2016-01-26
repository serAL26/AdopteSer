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
@Table(name="adresse")
public class Adresse {

    /**
     * Default constructor
     */
    public Adresse() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_adresse", nullable=false)
    private Integer idAdresse;

    /**
     * 
     */
    @Column(nullable=false)
    private String numero;

    /**
     * 
     */
    @Column(nullable=false)
    private String rue;


    @ManyToOne
    @JoinColumn(name="idVille")
    @Column(nullable=false)
    private Ville ville;


	public Integer getIdAdresse() {
		return idAdresse;
	}


	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
}