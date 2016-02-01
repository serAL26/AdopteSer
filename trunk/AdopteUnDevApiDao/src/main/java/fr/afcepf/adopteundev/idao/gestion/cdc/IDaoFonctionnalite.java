package fr.afcepf.adopteundev.idao.gestion.cdc;

import java.util.Set;

import entity.AssociationCdcFonctionnalite;
import entity.Fonctionnalite;
import entity.TypeFonctionnalite;

public interface IDaoFonctionnalite {
	public void ajouterFonctionnalite(Fonctionnalite fonctionnalite);

	public Set<Fonctionnalite> recupererTousFonctionna();

	public Set<Fonctionnalite> recupeFonctionnalitesParType(
			TypeFonctionnalite typeFonctionnalite);
	
	public Fonctionnalite recupFonctionnaliteParID(Integer id);
	
	public void ajouterAssociationCdcFonctionnalite(
			AssociationCdcFonctionnalite association);	
	
	public Set<TypeFonctionnalite> recupTousTypeFonctionnalite();
	public TypeFonctionnalite recupTypeFonctionnaliteParID(Integer id);
		
}
