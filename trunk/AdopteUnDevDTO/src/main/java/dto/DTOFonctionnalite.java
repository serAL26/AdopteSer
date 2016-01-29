package dto;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 */
public class DTOFonctionnalite implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor
     */
    public DTOFonctionnalite() {
    }

    /**
     * 
     */
    private Integer idFonctionnalite;

    /**
     * 
     */
    private String commentaire;

    /**
     * 
     */
    public DTOTypeFonctionnalite typeFonctionnalite;

    /**
     * 
     */
    public Set<DTOAssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite;

	
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

	public DTOTypeFonctionnalite getTypeFonctionnalite() {
		return typeFonctionnalite;
	}

	public void setTypeFonctionnalite(DTOTypeFonctionnalite typeFonctionnalite) {
		this.typeFonctionnalite = typeFonctionnalite;
	}

	public Set<DTOAssociationCdcFonctionnalite> getLesAssociationCdcFonctionnalite() {
		return lesAssociationCdcFonctionnalite;
	}

	public void setLesAssociationCdcFonctionnalite(
			Set<DTOAssociationCdcFonctionnalite> lesAssociationCdcFonctionnalite) {
		this.lesAssociationCdcFonctionnalite = lesAssociationCdcFonctionnalite;
	}

	public DTOFonctionnalite(String commentaire,
			DTOTypeFonctionnalite typeFonctionnalite) {
		super();
		this.commentaire = commentaire;
		this.typeFonctionnalite = typeFonctionnalite;
	}
}