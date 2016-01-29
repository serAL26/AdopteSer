package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;

public interface IUCGestionCdc {
	
	void ajouterCdcDto (DTOCdc cdcDto);
	void modifierCdcDto (DTOCdc cdcDto);
	List<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites();
	void ajouterFonctionnalite(DTOFonctionnalite dtofonct);
	void ajouterAssociationCdcFonctionnalite (DTOAssociationCdcFonctionnalite dtoAssociation);

}
