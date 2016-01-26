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
@Table(name="operation")
public class Operation {

    /**
     * Default constructor
     */
    public Operation() {
    }

    /**
     * 
     */
    @Column(nullable=false)
    private Double montant;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date date;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_operation",nullable=false)
    private Integer idOperation;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    @Column(nullable=false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idTypeOperation")
    @Column(nullable=false)
    private TypeOperation typeOperation;

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

    
}