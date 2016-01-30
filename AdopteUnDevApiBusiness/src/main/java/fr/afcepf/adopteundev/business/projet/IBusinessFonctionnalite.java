package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;

public interface IBusinessFonctionnalite {
	public void ajouterFonctionnalite(DTOFonctionnalite fonctionnalite);

	public Set<DTOFonctionnalite> recupererTousFonctionna();

	public Set<DTOFonctionnalite> recupeFonctionnalitesParType(
			DTOTypeFonctionnalite typeFonctionnalite);
	
	public DTOFonctionnalite recupFonctionnaliteParID(Integer id);

}
