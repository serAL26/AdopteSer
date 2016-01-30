package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import dto.DTOFonctionnalite;

public interface IBusinessFonctionnalite {
	public void ajouterFonctionnalite(DTOFonctionnalite fonctionnalite);

	public Set<DTOFonctionnalite> recupererTousFonctionna();

	public Set<DTOFonctionnalite> recupeFonctionnalitesParType(
			DTOFonctionnalite typeFonctionnalite);
	
	public DTOFonctionnalite recupFonctionnaliteParID(Integer id);

}
