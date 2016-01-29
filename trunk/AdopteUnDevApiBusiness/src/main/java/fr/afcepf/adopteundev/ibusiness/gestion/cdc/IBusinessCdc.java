package fr.afcepf.adopteundev.ibusiness.gestion.cdc;

import java.util.List;

import dto.DTOCdc;
import dto.DTOTypeFonctionnalite;

public interface IBusinessCdc {
	
	void ajouterCdcDto (DTOCdc cdcDto);
	void modifierCdcDto (DTOCdc cdcDto);
	List<DTOTypeFonctionnalite> recupererTousLesTypesFonctionnalites();
	

}
