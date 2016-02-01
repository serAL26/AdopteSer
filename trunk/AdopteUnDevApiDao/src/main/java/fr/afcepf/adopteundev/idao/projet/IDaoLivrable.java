package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Livrable;
import entity.Projet;

public interface IDaoLivrable {
	Livrable creerLivrable(Livrable livrable);
	List<Livrable> recupListeLivrableParProjet(int idProjet);
}
