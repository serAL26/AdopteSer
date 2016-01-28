package fr.afcepf.adopteundev.business.gestion.cdc;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import dto.DTOCdc;
import entity.Cdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoCdc;

@Remote
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
}