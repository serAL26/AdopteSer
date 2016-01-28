package fr.afcepf.adopteundev.uc.impl;

import dto.DTOCdc;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;

public class UcGestionCdcImpl implements IUCGestionCdc {
	
	private IBusinessCdc businessCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		businessCdc.ajouterCdcDto(cdcDto);

	}

}
