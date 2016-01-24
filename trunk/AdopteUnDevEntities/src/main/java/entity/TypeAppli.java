package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeAppli")
public class TypeAppli {

    /**
     * Default constructor
     */
    public TypeAppli() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_type_appli")
    private Integer idTypeAppli;

    /**
     * 
     */
    private String libelle;

	public Integer getIdTypeAppli() {
		return idTypeAppli;
	}

	public void setIdTypeAppli(Integer idTypeAppli) {
		this.idTypeAppli = idTypeAppli;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


    
}