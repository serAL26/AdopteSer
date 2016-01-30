package fr.afcepf.adopteundev.idao.gestion.cdc;

import java.util.List;

import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
import entity.TypeCdc;
import entity.TypeFonctionnalite;

public interface IDaoCdc {
	
	public void ajouterCdc (Cdc cdc);
	public void modifierCdc (Cdc cdc);
	public List<TypeCdc> recupTouslesTypesCdc();

}
