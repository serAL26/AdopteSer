package entity;

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

@Entity
@Table(name="fonctionnalite")
public class Fonctionnalite {

	/**
	 * Default constructor
	 */
	public Fonctionnalite() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fonctionnalite")
	private Integer idFonctionnalite;

	/**
	 * 
	 */
	private String commentaire;

	@ManyToOne
	@JoinColumn(name="idTypeFonctionnalite")
	private TypeFonctionnalite typeFonctionnalite;

	@OneToMany(mappedBy="fonctionnalite")
	private Set<AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;

	public Integer getIdFonctionnalite() {
		return idFonctionnalite;
	}

	public void setIdFonctionnalite(Integer idFonctionnalite) {
		this.idFonctionnalite = idFonctionnalite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public TypeFonctionnalite getTypeFonctionnalite() {
		return typeFonctionnalite;
	}

	public void setTypeFonctionnalite(TypeFonctionnalite typeFonctionnalite) {
		this.typeFonctionnalite = typeFonctionnalite;
	}

	public Set<AssociationCdcFonctionnalite> getLesAssociationCdcFonctionnalite() {
		return lesAssociationCdcFonctionnalite;
	}

	public void setLesAssociationCdcFonctionnalite(
			Set<AssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite) {
		this.lesAssociationCdcFonctionnalite = lesAssociationCdcFonctionnalite;
	}

	
}