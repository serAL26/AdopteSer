package fr.afcepf.adopteundev.ibusiness.gestion.cdc;

import java.util.List;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;

public interface IBusinessCdc {
	
	void ajouterCdcDto (DTOCdc cdcDto);
	void modifierCdcDto (DTOCdc cdcDto);
	List<DTOTypeFonctionnalite> recupererTousLesTypesFonctionnalites();
	void ajouterFonctionnalite(DTOFonctionnalite dtoFonct);
	void ajouterAssociationCdcFonctionnalite (DTOAssociationCdcFonctionnalite dtoAssociation);
	List<DTOTypeCdc> recupererTousLesTypesCdc();
	void ajouterAssociationFonctCdcComplet (DTOCdc cdc, List<DTOFonctionnalite> listeFonct);
	DTOCdc recupCdcParId(Integer id);
	List<DTOCdc> recupRemarqueParIdDevEtIdProjet(Integer idDev, Integer idProjet);
	void ajouterRemarqueCdcComplet (DTOCdc cdcRemarque, Integer idDev, Integer idProjet);
	DTOCdc recupDerniereRemarque (Integer idDev, Integer idProjet);

	DTOCdc recupCdcFinalParidProjet(Integer idProjet);
}
