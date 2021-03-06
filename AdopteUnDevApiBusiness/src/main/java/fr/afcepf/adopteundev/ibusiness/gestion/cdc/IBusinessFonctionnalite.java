package fr.afcepf.adopteundev.ibusiness.gestion.cdc;

import java.util.List;
import java.util.Set;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;

public interface IBusinessFonctionnalite {
	public void ajouterFonctionnalite(DTOFonctionnalite fonctionnalite);

	public Set<DTOTypeFonctionnalite> recupererTousLesTypesFonctionnalites();

	public Set<DTOFonctionnalite> recupererTousFonctionna();

	public Set<DTOFonctionnalite> recupeFonctionnalitesParType(
			DTOTypeFonctionnalite typeFonctionnalite);

	public DTOFonctionnalite recupFonctionnaliteParID(Integer id);

	public void ajouterAssociationCdcFonctionnalite(
			DTOAssociationCdcFonctionnalite dtoAssociation);

	public DTOTypeFonctionnalite recupTypeFonctionnaliteParID(Integer id);

	public List<DTOFonctionnalite> recupFonctionnaliteParCDC(DTOCdc cdc);
}
