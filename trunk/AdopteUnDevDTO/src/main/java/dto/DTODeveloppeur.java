package dto;

import java.util.Set;

/**
 * 
 */
public class DTODeveloppeur extends DTOUtilisateur {

    /**
     * Default constructor
     */
    public DTODeveloppeur() {
    }


    private Set<DTODeveloppeur> lesLivrable;
    
    /**
     * 
     */
    public Set<DTOAssociationDevTechno> lesAssociationDevTechno;

    /**
     * 
     */
    public Set<DTOProposition> listeProposition;

    /**
     * 
     */
    public Set<DTODispo> listeDispo;

	public Set<DTOAssociationDevTechno> getLesAssociationDevTechno() {
		return lesAssociationDevTechno;
	}

	public void setLesAssociationDevTechno(
			Set<DTOAssociationDevTechno> lesAssociationDevTechno) {
		this.lesAssociationDevTechno = lesAssociationDevTechno;
	}

	public Set<DTOProposition> getListeProposition() {
		return listeProposition;
	}

	public void setListeProposition(Set<DTOProposition> listeProposition) {
		this.listeProposition = listeProposition;
	}

	public Set<DTODispo> getListeDispo() {
		return listeDispo;
	}

	public void setListeDispo(Set<DTODispo> listeDispo) {
		this.listeDispo = listeDispo;
	}

	public Set<DTODeveloppeur> getLesLivrable() {
		return lesLivrable;
	}

	public void setLesLivrable(Set<DTODeveloppeur> lesLivrable) {
		this.lesLivrable = lesLivrable;
	}
	
    
	
}