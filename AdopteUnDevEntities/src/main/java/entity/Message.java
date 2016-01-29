package entity;

import java.io.Serializable;
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
@Table(name="message")
public class Message implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public Message() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_message",nullable=false)
    private Integer idMessage;

    /**
     * 
     */
    @Column(nullable=false, name="MESSAGE")
    private String message;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_envoi",nullable=false)
    private Date dateEnvoi;

    /**
     * 
     */
    @Column(nullable=false, name="TITRE")
    private String titre;

    @ManyToOne
    @JoinColumn(name="idMessFille")
private Message messFille;

    @ManyToOne
    @JoinColumn(name="idMessMere")
    private Message messMere;

    @ManyToOne
    @JoinColumn(name="idUtilisateur1")
    private Utilisateur utilisateur1;

    @ManyToOne
    @JoinColumn(name="idUtilisateur2")
    private Utilisateur utilisateur2;

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Message getMessFille() {
		return messFille;
	}

	public void setMessFille(Message messFille) {
		this.messFille = messFille;
	}

	public Message getMessMere() {
		return messMere;
	}

	public void setMessMere(Message messMere) {
		this.messMere = messMere;
	}

	public Utilisateur getUtilisateur1() {
		return utilisateur1;
	}

	public void setUtilisateur1(Utilisateur utilisateur1) {
		this.utilisateur1 = utilisateur1;
	}

	public Utilisateur getUtilisateur2() {
		return utilisateur2;
	}

	public void setUtilisateur2(Utilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}

    
}