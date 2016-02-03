package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Livrable;
import entity.Operation;

public interface IDaoLivrable {
	Livrable creerLivrable(Livrable livrable);
	List<Livrable> recupListeLivrableParProjet(int idProjet);
	List<Livrable> recupListeLivrableParProjetEtParDev(Integer idProjet, int idDeveloppeur);
	List<Operation> renvoiLOperationEnAttentePaiement(Livrable dtoLivrableToLivrable);
}
