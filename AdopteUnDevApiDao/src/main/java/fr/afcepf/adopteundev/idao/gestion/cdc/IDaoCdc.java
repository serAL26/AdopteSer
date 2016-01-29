package fr.afcepf.adopteundev.idao.gestion.cdc;

import java.util.List;

import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
import entity.TypeCdc;
import entity.TypeFonctionnalite;

public interface IDaoCdc {
	
	void ajouterCdc (Cdc cdc);
	void modifierCdc (Cdc cdc);
	List<TypeFonctionnalite> getAll();
	void ajouterFonctionnalite (Fonctionnalite fonct);
	void ajouterAssociationCdcFonctionnalite (AssociationCdcFonctionnalite association);
	List<TypeCdc> recupTouslesTypesCdc();

}
