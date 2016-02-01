package fr.afcepf.adopteundev.ucimpl.gestioncdc;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessFonctionnalite;

@Remote(IUCGestionCdc.class)
@Stateless
public class UcGestionCdcImpl implements IUCGestionCdc {
static Logger log = Logger.getLogger(UcGestionCdcImpl.class);
	@EJB
	private IBusinessCdc businessCdc;

	@EJB
	private IBusinessFonctionnalite businessFonctionnalite;

	@Override
	public DTOCdc ajouterCdcDto(DTOCdc cdcDto) {
		cdcDto = businessCdc.ajouterCdcDto(cdcDto);
		log.info("uc id cdc" + cdcDto.getIdCdc());
		return cdcDto;
	}

	@Override
	public DTOCdc modifierCdcDto(DTOCdc cdcDto) {
		businessCdc.modifierCdcDto(cdcDto);
		
		return cdcDto;
	}

	@Override
	public Set<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites() {

		return businessFonctionnalite.recupererTousLesTypesFonctionnalites();
	}

	@Override
	public DTOFonctionnalite ajouterFonctionnalite(DTOFonctionnalite dtofonct) {
		return businessCdc.ajouterFonctionnalite(dtofonct);
	}

	@Override
	public DTOAssociationCdcFonctionnalite ajouterAssociationCdcFonctionnalite(
			DTOAssociationCdcFonctionnalite dtoAssociation) {
		return businessCdc.ajouterAssociationCdcFonctionnalite(dtoAssociation);

	}

	@Override
	public List<DTOTypeCdc> recupTousLesTypeCdc() {
		return businessCdc.recupererTousLesTypesCdc();
	}

	@Override
	public void ajouterAssociationFonctCdcComplet(DTOCdc cdc,
			List<DTOFonctionnalite> listeFonct) {
		businessCdc.ajouterAssociationFonctCdcComplet(cdc, listeFonct);
		
	}

	@Override
	public DTOCdc recupCdcParId(Integer id) {
		return businessCdc.recupCdcParId(id);
	}

	@Override
	public List<DTOCdc> recupRemarqueParIdDevEtIdProjet(Integer idDev,
			Integer idProjet) {
		return businessCdc.recupRemarqueParIdDevEtIdProjet(idDev, idProjet);
	}

	@Override
	public void ajouterRemarqueCdcComplet(DTOCdc cdcRemarque, Integer idDev,
			Integer idProjet) {
		businessCdc.ajouterRemarqueCdcComplet(cdcRemarque, idDev, idProjet);
		
	}

	@Override
	public DTOCdc recupDerniereRemarque(Integer idDev, Integer idProjet) {
		return businessCdc.recupDerniereRemarque(idDev, idProjet);
	}

	@Override
	public DTOCdc recupCdcFinalParidProjet(Integer idProjet) {
		return businessCdc.recupCdcFinalParidProjet(idProjet);
	}

	@Override
	public DTOTypeCdc recupTypeCdcByLibelle(String libelle) {
		return businessCdc.recupTypeCDCParLibelle(libelle);
	}


	@Override
	public DTOTypeFonctionnalite recupTypeFonctionnaliteParID(Integer id) {
		return businessFonctionnalite.recupTypeFonctionnaliteParID(id);
	}

	@Override
	public List<DTOFonctionnalite> recupFonctionnaliteParCDC(DTOCdc cdc) {
		// TODO Auto-generated method stub
		return businessFonctionnalite.recupFonctionnaliteParCDC(cdc);
	}
}
