package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="livrable")
public class Livrable implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public Livrable() {
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date echeance;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_livrable",nullable=false)
    private Integer idLivrable;

    /**
     * 
     */
    private String fichier;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_livraison",nullable=false)
    private Date dateLivraison;

    @ManyToOne
    @JoinColumn(name="idProjet")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name="idTypeEvaluation")
    private TypeEvaluation typeEvaluation;
    
    @OneToMany(mappedBy="livrable")
    private Set<Operation> lesOperation;

	public Set<Operation> getLesOperation() {
		return lesOperation;
	}

	public void setLesOperation(Set<Operation> lesOperation) {
		this.lesOperation = lesOperation;
	}

	public Date getEcheance() {
		return echeance;
	}

	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}

	public Integer getIdLivrable() {
		return idLivrable;
	}

	public void setIdLivrable(Integer idLivrable) {
		this.idLivrable = idLivrable;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public TypeEvaluation getTypeEvaluation() {
		return typeEvaluation;
	}

	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}

    
}