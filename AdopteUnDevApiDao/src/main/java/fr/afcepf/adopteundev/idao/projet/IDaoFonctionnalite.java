package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Fonctionnalite;
import entity.TypeFonctionnalite;

public interface IDaoFonctionnalite {
	public void ajouterFonctionnalite(Fonctionnalite fonctionnalite);

	public List<Fonctionnalite> recupererTousFonctionna();

	public List<Fonctionnalite> recupeFonctionnalitesParType(
			TypeFonctionnalite typeFonctionnalite);
}
