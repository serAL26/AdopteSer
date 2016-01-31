package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;
import java.util.Set;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;

public interface IUCGestionCdc {

	DTOCdc ajouterCdcDto (DTOCdc cdcDto);
	DTOCdc modifierCdcDto (DTOCdc cdcDto);
	Set<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites();
	DTOFonctionnalite ajouterFonctionnalite(DTOFonctionnalite dtofonct);
	void ajouterAssociationCdcFonctionnalite (DTOAssociationCdcFonctionnalite dtoAssociation);
	List<DTOTypeCdc> recupTousLesTypeCdc();
	void ajouterAssociationFonctCdcComplet (DTOCdc cdc, List<DTOFonctionnalite> listeFonct);
	DTOCdc recupCdcParId(Integer id);
	List<DTOCdc> recupRemarqueParIdDevEtIdProjet(Integer idDev, Integer idProjet);
	void ajouterRemarqueCdcComplet (DTOCdc cdcRemarque, Integer idDev, Integer idProjet);
	DTOCdc recupDerniereRemarque (Integer idDev, Integer idProjet);
	DTOCdc recupCdcFinalParidProjet(Integer idProjet);
}
