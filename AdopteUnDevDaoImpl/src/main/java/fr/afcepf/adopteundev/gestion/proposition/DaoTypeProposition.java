package fr.afcepf.adopteundev.gestion.proposition;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TypeProposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoTypeProposition;

@Remote(IDaoTypeProposition.class)
@Stateless
public class DaoTypeProposition implements IDaoTypeProposition{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	@Override
	public TypeProposition recupTypePropositionParId(int idType) {
		return em.find(TypeProposition.class, idType);
	}

}
