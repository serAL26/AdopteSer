package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur")
public class Utilisateur {

    /**
     * Default constructor
     */
    public Utilisateur() {
    }

    /**
     *
     */
    @Column(nullable = false)
    private String mail;

    /**
     *
     */
    @Column(nullable = false)
    private String mdp;

    /**
     *
     */
    @Column(nullable = false)
    private String Nom;

    /**
     *
     */
    @Column(nullable = false)
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    /**
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_inscription", nullable = false)
    private Date DateInscription;

    @OneToMany(mappedBy = "utilisateur1")
    private Set<Message> lesMessages1;

    @ManyToOne
    @JoinColumn(name = "idAdresse", nullable = false)
    private Adresse adresse;

    @OneToMany(mappedBy = "utilisateur2")
    private Set<Message> lesMessages2;

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

    public Set<Message> getLesMessages1() {
        return lesMessages1;
    }

    public void setLesMessages1(Set<Message> lesMessages1) {
        this.lesMessages1 = lesMessages1;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Message> getLesMessages2() {
        return lesMessages2;
    }

    public void setLesMessages2(Set<Message> lesMessages2) {
        this.lesMessages2 = lesMessages2;
    }


}