package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;

import dto.DTOCdc;
import dto.DTOTypeFonctionnalite;

public interface IUCGestionCdc {
	
	void ajouterCdcDto (DTOCdc cdcDto);
	void modifierCdcDto (DTOCdc cdcDto);
	List<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites();

}
