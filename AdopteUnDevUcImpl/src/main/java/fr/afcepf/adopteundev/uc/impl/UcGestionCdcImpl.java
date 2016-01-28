package fr.afcepf.adopteundev.uc.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOCdc;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;

@Remote(IUCGestionCdc.class)
@Stateless
public class UcGestionCdcImpl implements IUCGestionCdc {
	
	private IBusinessCdc businessCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		businessCdc.ajouterCdcDto(cdcDto);

	}

}
