package dto;

import java.io.Serializable;
import java.util.Set;


/**
 * 
 */
public class DTOTypeService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
     * Default constructor
     */
    public DTOTypeService() {
    }

    /**
     * 
     */
    private Integer idTypeService;

    private DTOTypeAppli typeAppli;
    /**
     * 
     */
    private String libelle;
    
    private Set<DTOAssociationTypeServiceTechno> lesAssociationTypeServiceTechno;
    
    
    
    
	public Integer getIdTypeService() {
		return idTypeService;
	}

	public void setIdTypeService(Integer idTypeService) {
		this.idTypeService = idTypeService;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Set<DTOAssociationTypeServiceTechno> getLesAssociationTypeServiceTechno() {
		return lesAssociationTypeServiceTechno;
	}

	public void setLesAssociationTypeServiceTechno(
			Set<DTOAssociationTypeServiceTechno> lesAssociationTypeServiceTechno) {
		this.lesAssociationTypeServiceTechno = lesAssociationTypeServiceTechno;
	}

	public DTOTypeAppli getTypeAppli() {
		return typeAppli;
	}

	public void setTypeAppli(DTOTypeAppli typeAppli) {
		this.typeAppli = typeAppli;
	}

	@Override
	public String toString() {
		return "DTOTypeService [idTypeService=" + idTypeService
				+ ", typeAppli=" + typeAppli + ", libelle=" + libelle
				+ ", lesAssociationTypeServiceTechno="
				+ lesAssociationTypeServiceTechno + "]";
	}



    
	
}