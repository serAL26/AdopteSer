package fr.afcepf.adopteundev.business.impl;

import assembleur.DTOToEntity;
import dto.DTOCdc;
import entity.Cdc;
import fr.afcepf.adopteundev.business.api.IBusinessCdc;
import fr.afcepf.adopteundev.dao.api.IDaoCdc;

public class BusinessCdcImpl implements IBusinessCdc{
	
	private IDaoCdc daoCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		
		Cdc cdc = DTOToEntity.dtoCdcToCdc(cdcDto);
		daoCdc.ajouterCdc(cdc);
	}
}
