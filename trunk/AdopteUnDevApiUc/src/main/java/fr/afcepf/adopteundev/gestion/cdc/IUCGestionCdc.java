package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;
import java.util.Set;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;


public interface IUCGestionCdc {

	public DTOCdc ajouterCdcDto (DTOCdc cdcDto);
	public DTOCdc modifierCdcDto (DTOCdc cdcDto);
	public Set<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites();
	public DTOFonctionnalite ajouterFonctionnalite(DTOFonctionnalite dtofonct);
	public void ajouterAssociationCdcFonctionnalite (DTOAssociationCdcFonctionnalite dtoAssociation);
	public List<DTOTypeCdc> recupTousLesTypeCdc();
	public void ajouterAssociationFonctCdcComplet (DTOCdc cdc, List<DTOFonctionnalite> listeFonct);
	public DTOCdc recupCdcParId(Integer id);
	public List<DTOCdc> recupRemarqueParIdDevEtIdProjet(Integer idDev, Integer idProjet);
	public void ajouterRemarqueCdcComplet (DTOCdc cdcRemarque, Integer idDev, Integer idProjet);
	public DTOCdc recupDerniereRemarque (Integer idDev, Integer idProjet);
	public DTOCdc recupCdcFinalParidProjet(Integer idProjet);
	public DTOTypeCdc recupTypeCdcByLibelle(String libelle);
}
