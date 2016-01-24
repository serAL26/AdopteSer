package dto;

import java.util.Set;

/**
 * 
 */
public class DTOClient extends DTOUtilisateur {

    /**
     * Default constructor
     */
    public DTOClient() {
    }


    /**
     * 
     */
    public Set<DTOProjet> lesProjet;


	public Set<DTOProjet> getLesProjet() {
		return lesProjet;
	}

	public void setLesProjet(Set<DTOProjet> lesProjet) {
		this.lesProjet = lesProjet;
	}

    
	
}