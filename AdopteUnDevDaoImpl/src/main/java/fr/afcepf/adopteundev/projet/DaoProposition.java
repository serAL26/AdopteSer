package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Proposition;
import entity.TypeFonctionnalite;
import entity.TypeProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition {
	
	 @PersistenceContext(unitName="AdopteUnDev")
	    EntityManager em;
	

	@Override
	public Proposition modifierEtatProposition(Proposition proposition) {
		em.merge(proposition);
		
		return proposition;
	}


	@Override
	public List<Proposition> recupToutesLesPropositions() {

		return em.createQuery("Select p from Proposition p", Proposition.class).getResultList();
	}


	@Override
	public List<TypeProposition> recupTousLesTypesPropos() {
		return em.createQuery("Select t from TypeProposition t", TypeProposition.class).getResultList();
	}

}
