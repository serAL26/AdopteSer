package fr.afcepf.adopteundev.business.gestion.cdc;

import assembleur.DTOToEntity;
import dto.DTOCdc;
import entity.Cdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoCdc;

public class BusinessCdcImpl implements IBusinessCdc{
	
	private IDaoCdc daoCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		
		Cdc cdc = DTOToEntity.dtoCdcToCdc(cdcDto);
		daoCdc.ajouterCdc(cdc);
	}
}
