package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOLivrable;
import dto.DTOProjet;

public interface IBusinessLivrable {
	DTOLivrable creerLivrable(DTOLivrable dtoLivrable);
	List<DTOLivrable> recupListeLivrableParProjet(DTOProjet dtoProjet);
	boolean initIsPaye(DTOLivrable livrable);
}
