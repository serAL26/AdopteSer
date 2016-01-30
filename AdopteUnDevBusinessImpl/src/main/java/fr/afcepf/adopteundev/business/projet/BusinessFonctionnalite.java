package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;
import fr.afcepf.adopteundev.idao.projet.IDaoFonctionnalite;

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

}
