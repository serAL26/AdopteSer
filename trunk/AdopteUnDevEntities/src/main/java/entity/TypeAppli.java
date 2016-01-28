package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(nullable=false)
    private String libelle;
    
    @OneToMany(mappedBy="typeAppli")
	private Set<TypeService> lesServices;
    
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

	public Set<TypeService> getLesServices() {
		return lesServices;
	}

	public void setLesServices(Set<TypeService> lesServices) {
		this.lesServices = lesServices;
	}


    
}