package fr.afcepf.adopteundev.ucimpl.gestioncdc;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOCdc;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessCdc;

@Remote(IUCGestionCdc.class)
@Stateless
public class UcGestionCdcImpl implements IUCGestionCdc {
	
	@EJB
	private IBusinessCdc businessCdc;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		businessCdc.ajouterCdcDto(cdcDto);

	}

	@Override
	public void modifierCdcDto(DTOCdc cdcDto) {
		businessCdc.modifierCdcDto(cdcDto);
	}

}
