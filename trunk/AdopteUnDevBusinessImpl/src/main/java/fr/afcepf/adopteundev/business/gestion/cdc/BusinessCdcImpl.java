package fr.afcepf.adopteundev.business.gestion.cdc;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;
import entity.Cdc;
import entity.Projet;
import entity.TypeFonctionnalite;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoCdc;

@Remote(IBusinessCdc.class)
@Stateless
public class BusinessCdcImpl implements IBusinessCdc{
	
	@EJB
	private IDaoCdc daoCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		Cdc cdc = DTOToEntity.dtoCdcToCdc(cdcDto);
		daoCdc.ajouterCdc(cdc);
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
		
		for (TypeFonctionnalite  typeFonct : listeFonctionnalites) {
			
			DTOTypeFonctionnalite dtoTypeFonctionnalite = EntityToDTO.typeFonctionnaliteToDTOTypeFonctionnalite(typeFonct);
			listeDto.add(dtoTypeFonctionnalite);
		}
		
		return listeDto;
	}
}