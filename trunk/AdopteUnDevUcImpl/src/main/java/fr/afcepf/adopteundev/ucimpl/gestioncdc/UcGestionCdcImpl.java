package fr.afcepf.adopteundev.ucimpl.gestioncdc;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

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

	@EJB
	private IBusinessCdc businessCdc;

	@EJB
	private IBusinessFonctionnalite businessFonctionnalite;

	@Override
	public void ajouterCdcDto(DTOCdc cdcDto) {
		businessCdc.ajouterCdcDto(cdcDto);

	}

	@Override
	public void modifierCdcDto(DTOCdc cdcDto) {
		businessCdc.modifierCdcDto(cdcDto);
	}

	@Override
	public Set<DTOTypeFonctionnalite> recupTousLesTypesFonctionnalites() {

		return businessFonctionnalite.recupererTousLesTypesFonctionnalites();
	}

	@Override
	public void ajouterFonctionnalite(DTOFonctionnalite dtofonct) {
		businessCdc.ajouterFonctionnalite(dtofonct);

	}

	@Override
	public void ajouterAssociationCdcFonctionnalite(
			DTOAssociationCdcFonctionnalite dtoAssociation) {
		businessCdc.ajouterAssociationCdcFonctionnalite(dtoAssociation);

	}

	@Override
	public List<DTOTypeCdc> recupTousLesTypeCdc() {
		return businessCdc.recupererTousLesTypesCdc();
	}
}
