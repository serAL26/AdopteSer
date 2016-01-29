package fr.afcepf.adopteundev.idao.gestion.cdc;

import java.util.List;

import entity.Cdc;
import entity.TypeFonctionnalite;

public interface IDaoCdc {
	
	void ajouterCdc (Cdc cdc);
	void modifierCdc (Cdc cdc);
	List<TypeFonctionnalite> getAll();

}
