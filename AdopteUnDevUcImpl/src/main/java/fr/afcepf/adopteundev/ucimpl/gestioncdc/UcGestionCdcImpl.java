package fr.afcepf.adopteundev.ucimpl.gestioncdc;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOCdc;
import dto.DTOTypeFonctionnalite;
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

	@Override
	public List<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites() {
		
		return businessCdc.recupererTousLesTypesFonctionnalites();
	}

}