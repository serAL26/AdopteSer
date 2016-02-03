package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOLivrable;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOTypeEvaluation;

public interface IBusinessLivrable {
    DTOLivrable creerLivrable(DTOLivrable dtoLivrable);

    List<DTOLivrable> recupListeLivrableParProjet(DTOProjet dtoProjet);
	DTOTypeEvaluation recupererTypeEvaluationParLibelle(String libelle);
    Boolean initIsPaye(DTOLivrable livrable);
	List<DTOLivrable> recupListeLivrableParProjetEtParDev(DTOProjet dtoProjet, int idDeveloppeur);

	DTOOperation renvoiLOperationEnAttentePaiement(DTOLivrable livrable);
}
