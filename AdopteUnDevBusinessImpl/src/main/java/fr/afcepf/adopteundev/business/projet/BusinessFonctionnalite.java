package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;
import entity.AssociationCdcFonctionnalite;
import fr.afcepf.adopteundev.ibusiness.gestion.cdc.IBusinessFonctionnalite;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoFonctionnalite;

@Remote(IBusinessFonctionnalite.class)
@Stateless
public class BusinessFonctionnalite implements IBusinessFonctionnalite {

	@EJB
	private IDaoFonctionnalite daoFonctionnalite;

	@Override
	public void ajouterFonctionnalite(DTOFonctionnalite fonctionnalite) {
		daoFonctionnalite.ajouterFonctionnalite(DTOToEntity
				.dtoFonctionnaliteToFonctionnalite(fonctionnalite));
	}

	@Override
	public Set<DTOFonctionnalite> recupererTousFonctionna() {

		return EntityToDTO
				.listFonctionnalitetoDTOfonctionnalite(daoFonctionnalite
						.recupererTousFonctionna());
	}

	@Override
	public Set<DTOFonctionnalite> recupeFonctionnalitesParType(
			DTOTypeFonctionnalite typeFonctionnalite) {
		return EntityToDTO
				.listFonctionnalitetoDTOfonctionnalite(daoFonctionnalite.recupeFonctionnalitesParType(DTOToEntity
						.dtoTypeFonctionnaliteToTypeFonctionnalite(typeFonctionnalite)));

	}

	@Override
	public DTOFonctionnalite recupFonctionnaliteParID(Integer id) {
		return EntityToDTO.fonctionnaliteToDTOFonctionnalite(daoFonctionnalite
				.recupFonctionnaliteParID(id));
	}

	@Override
	public void ajouterAssociationCdcFonctionnalite(
			DTOAssociationCdcFonctionnalite dtoAssociation) {
		AssociationCdcFonctionnalite association = DTOToEntity
				.dtoAssociationCdcFonctionnaliteToAssociationCdcFonctionnalite(dtoAssociation);
		daoFonctionnalite.ajouterAssociationCdcFonctionnalite(association);

	}

	@Override
	public Set<DTOTypeFonctionnalite> recupererTousLesTypesFonctionnalites() {
		return EntityToDTO.listTypeFonctionToDtoTypeFonction(daoFonctionnalite
				.recupTousTypeFonctionnalite());
	}

	@Override
	public DTOTypeFonctionnalite recupTypeFonctionnaliteParID(Integer id) {
		return EntityToDTO
				.typeFonctionnaliteToDTOTypeFonctionnalite(daoFonctionnalite
						.recupTypeFonctionnaliteParID(id));
	}
}
