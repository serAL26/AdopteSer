package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Proposition;
import entity.TypeProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition {
	
	 @PersistenceContext(unitName="AdopteUnDev")
	    EntityManager em;
	
	 private String propositionValideePourUnDev = "SELECT p FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 3";

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


	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> recupPropositionValideeParDev(int idDev) {
		Query query = em.createQuery(propositionValideePourUnDev);
		query.setParameter("idDev", idDev);
		return query.getResultList();
	}

}
