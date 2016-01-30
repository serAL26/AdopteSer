package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Proposition;
import entity.TypeProposition;

public interface IDaoProposition {
	
	Proposition modifierEtatProposition(Proposition proposition);
	List<Proposition> recupToutesLesPropositions();
	List<TypeProposition> recupTousLesTypesPropos();

}
