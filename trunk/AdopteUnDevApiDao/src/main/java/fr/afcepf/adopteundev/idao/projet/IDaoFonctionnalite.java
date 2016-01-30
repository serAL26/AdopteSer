package fr.afcepf.adopteundev.idao.projet;

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
		
}
