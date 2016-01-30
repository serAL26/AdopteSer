package fr.afcepf.adopteundev.business.projet;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOProposition;
import dto.DTOTypeProposition;
import entity.Proposition;
import entity.TypeProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;

@Remote(IBusinessProposition.class)
@Stateless
public class BusinessProposition implements IBusinessProposition {

	@EJB
	IDaoProposition daoProposition;

	@Override
	public void modifierProposition(DTOProposition dtoProp) {
		Proposition prop = DTOToEntity.dtoPropositionToProposition(dtoProp);
		daoProposition.modifierEtatProposition(prop);
	}

	@Override
	public List<DTOProposition> recupToutesLesPropos() {
		
		List<Proposition> listeProp = daoProposition.recupToutesLesPropositions();
		
		List<DTOProposition> listeDtoProp = new ArrayList<>();
		
		for (Proposition prop : listeProp) {
			
			DTOProposition dtoProp = EntityToDTO.propositionToDTOProposition(prop);
			listeDtoProp.add(dtoProp);
			
		}
		
		return listeDtoProp;
	}

	@Override
	public List<DTOTypeProposition> recupToutsLesTyesPropos() {
		List<TypeProposition> listeTypeProp = daoProposition.recupTousLesTypesPropos();
		List<DTOTypeProposition> listeDto = new ArrayList<>();
		for (TypeProposition typeProp : listeTypeProp)
		{
			DTOTypeProposition dto = EntityToDTO.typePropositionToDTOTypeProposition(typeProp);
			listeDto.add(dto);
		}
		return listeDto;
	}

}
