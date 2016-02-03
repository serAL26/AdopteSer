package fr.afcepf.adopteundev.business.gestion.cdc;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterOutputStream;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;
import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
import entity.TypeCdc;
import entity.TypeFonctionnalite;
import enumeration.TypeCDC;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoCdc;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoTypeCDC;

@Remote(IBusinessCdc.class)
@Stateless
public class BusinessCdcImpl implements IBusinessCdc {
	static Logger log = Logger.getLogger(BusinessCdcImpl.class);
	@EJB
	private IDaoCdc daoCdc;

	@EJB
	private IDaoTypeCDC daoTypeCdc;

	@Override
	public DTOCdc ajouterCdcDto(DTOCdc cdcDto) {
		DTOTypeCdc typeCDC = EntityToDTO.typeCdcToDTOTypeCdc(daoTypeCdc
				.recupTypeCdcByLibelle(TypeCDC.CDC.toString()));
		cdcDto.setTypeCdc(typeCDC);
		Cdc cdc = DTOToEntity.dtoCdcToCdc(cdcDto);
		cdc = daoCdc.ajouterCdc(cdc);
		log.info("business cdc id : " + EntityToDTO.cdcToDTOCdc(cdc).getIdCdc());
		return EntityToDTO.cdcToDTOCdc(cdc);
	}

	@Override
	public void modifierCdcDto(DTOCdc cdcDto) {
		Cdc cdc = DTOToEntity.dtoCdcToCdc(cdcDto);
		daoCdc.modifierCdc(cdc);

	}

	@Override
	public List<DTOTypeFonctionnalite> recupererTousLesTypesFonctionnalites() {

		List<TypeFonctionnalite> listeFonctionnalites = daoCdc.getAll();

		List<DTOTypeFonctionnalite> listeDto = new ArrayList<DTOTypeFonctionnalite>();

		for (TypeFonctionnalite typeFonct : listeFonctionnalites) {

			DTOTypeFonctionnalite dtoTypeFonctionnalite = EntityToDTO
					.typeFonctionnaliteToDTOTypeFonctionnalite(typeFonct);
			listeDto.add(dtoTypeFonctionnalite);
		}

		return listeDto;
	}

	@Override
	public DTOFonctionnalite ajouterFonctionnalite(DTOFonctionnalite dtoFonct) {
		if (dtoFonct.getIdFonctionnalite() != null)
			dtoFonct.setIdFonctionnalite(null);
		
		Fonctionnalite fonct = DTOToEntity
				.dtoFonctionnaliteToFonctionnalite(dtoFonct);
		return EntityToDTO.fonctionnaliteToDTOFonctionnalite(daoCdc
				.ajouterFonctionnalite(fonct));

	}

	@Override
	public DTOAssociationCdcFonctionnalite ajouterAssociationCdcFonctionnalite(
			DTOAssociationCdcFonctionnalite dtoAssociation) {
		AssociationCdcFonctionnalite association = DTOToEntity
				.dtoAssociationCdcFonctionnaliteToAssociationCdcFonctionnalite(dtoAssociation);
		return EntityToDTO
				.associationCdcFonctionnaliteToDTOAssociationCdcFonctionnalite(daoCdc
						.ajouterAssociationCdcFonctionnalite(association));
	}

	@Override
	public List<DTOTypeCdc> recupererTousLesTypesCdc() {
		List<TypeCdc> listeTypeCdc = daoCdc.recupTouslesTypesCdc();
		List<DTOTypeCdc> listeDto = new ArrayList<DTOTypeCdc>();

		for (TypeCdc typeCdc : listeTypeCdc) {
			DTOTypeCdc dtotypecdc = EntityToDTO.typeCdcToDTOTypeCdc(typeCdc);
			listeDto.add(dtotypecdc);
		}
		return listeDto;
	}

	@Override
	public void ajouterAssociationFonctCdcComplet(DTOCdc cdc,
			List<DTOFonctionnalite> listeFonct) {
		Cdc cdcEntity = DTOToEntity.dtoCdcToCdc(cdc);
		cdcEntity = daoCdc.modifierCdc(cdcEntity);

		for (DTOFonctionnalite dtoFonctionnalite : listeFonct) {
			Fonctionnalite fonct = DTOToEntity
					.dtoFonctionnaliteToFonctionnalite(dtoFonctionnalite);
			fonct = daoCdc.ajouterFonctionnalite(fonct);
			AssociationCdcFonctionnalite assoc = new AssociationCdcFonctionnalite(
					cdcEntity, fonct);
			daoCdc.ajouterAssociationCdcFonctionnalite(assoc);
		}
	}

	@Override
	public DTOCdc recupCdcParId(Integer id) {
		return EntityToDTO.cdcToDTOCdc(daoCdc.recupCdcParId(id));
	}

	@Override
	public List<DTOCdc> recupRemarqueParIdDevEtIdProjet(Integer idDev,
			Integer idProjet) {
		List<Cdc> listeCdc = daoCdc.recupRemarqueParIdDevEtIdProjet(idDev,
				idProjet);
		List<DTOCdc> listeDto = new ArrayList<DTOCdc>();

		for (Cdc cdc : listeCdc) {
			DTOCdc dtoCdc = EntityToDTO.cdcToDTOCdc(cdc);
			listeDto.add(dtoCdc);
		}
		return listeDto;
	}

	@Override
	public void ajouterRemarqueCdcComplet(DTOCdc cdcRemarque, Integer idDev,
			Integer idProjet) {

		List<Cdc> listeCdc = daoCdc.recupRemarqueParIdDevEtIdProjet(idDev,
				idProjet);

		Cdc cdcEntity = DTOToEntity.dtoCdcToCdc(cdcRemarque);
		cdcEntity = daoCdc.ajouterCdc(cdcEntity);

		for (Cdc cdc : listeCdc) {
			if (cdc.getRemarque() == null) {
				cdc.setRemarque(cdcEntity);
				daoCdc.modifierCdc(cdc);
			}
		}
	}

	@Override
	public DTOCdc recupDerniereRemarque(Integer idDev, Integer idProjet) {
		List<Cdc> listeCdc = daoCdc.recupRemarqueParIdDevEtIdProjet(idDev,
				idProjet);
		DTOCdc dtoCdc = new DTOCdc();
		for (Cdc cdc : listeCdc) {
			if (cdc.getRemarque() == null) {
				dtoCdc = EntityToDTO.cdcToDTOCdc(cdc);
			}
		}
		return dtoCdc;
	}

	@Override
	public DTOCdc recupCdcFinalParidProjet(Integer idProjet) {
		List<Cdc> cdc = daoCdc.recupCdcParidProjet(idProjet);
		DTOCdc dtoCdc = new DTOCdc();
		for (Cdc cdc2 : cdc) {
			if(cdc2.getTypeCdc().getIdTypeCdc() == 2) {
				dtoCdc = EntityToDTO.cdcToDTOCdc(cdc2);
			}
		}
		return dtoCdc;
	}

	public DTOTypeCdc recupTypeCDCParLibelle(String libelle) {
		return EntityToDTO.typeCdcToDTOTypeCdc(daoTypeCdc
				.recupTypeCdcByLibelle(libelle));
	}

	@Override
	public DTOTypeCdc recupTypeRemarque() {
		
		return EntityToDTO.typeCdcToDTOTypeCdc(daoCdc.recupTypeRemarque());
	}
}