package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 
 */
public class DTOUtilisateur implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public DTOUtilisateur() {
    }

    /**
     * 
     */
    private String mail;

    /**
     * 
     */
    private String mdp;

    /**
     * 
     */
    private String Nom;

    /**
     * 
     */
    private String Prenom;

    /**
     * 
     */
    private String Portable;

    /**
     * 
     */
    private String Fixe;

    /**
     * 
     */
    private String Photo;

    /**
     * 
     */
    private Integer idUtilisateur;

    /**
     * 
     */
    private Date DateInscription;

    /**
     * 
     */
    public Set<DTOMessage> lesMessages1;

    /**
     * 
     */
    public DTOAdresse adresse;

    /**
     * 
     */

    /**
     * 
     */
    public Set<DTOMessage> lesMessages2;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getPortable() {
		return Portable;
	}

	public void setPortable(String portable) {
		Portable = portable;
	}

	public String getFixe() {
		return Fixe;
	}

	public void setFixe(String fixe) {
		Fixe = fixe;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Date getDateInscription() {
		return DateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		DateInscription = dateInscription;
	}

	public Set<DTOMessage> getLesMessages1() {
		return lesMessages1;
	}

	public void setLesMessages1(Set<DTOMessage> lesMessages1) {
		this.lesMessages1 = lesMessages1;
	}

	public DTOAdresse getAdresse() {
		return adresse;
	}

	public void setAdresse(DTOAdresse adresse) {
		this.adresse = adresse;
	}


	public Set<DTOMessage> getLesMessages2() {
		return lesMessages2;
	}

	public void setLesMessages2(Set<DTOMessage> lesMessages2) {
		this.lesMessages2 = lesMessages2;
	}

    
}