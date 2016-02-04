package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Proposition;
import entity.TypeProposition;
import fr.afcepf.adopteundev.gestion.proposition.DaoTypeProposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoTypeProposition;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition {
	
	IDaoTypeProposition daoType = new DaoTypeProposition();
	
	 @PersistenceContext(unitName="AdopteUnDev")
	    EntityManager em;
	
	 private String propositionValideePourUnDev = "SELECT p FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 3";
	 private String recupListPropParProjetSaufPropValidee = "SELECT p FROM Proposition p WHERE p.typeProposition.idTypeProposition <> 3 AND p.projet.idProjet = :idProjet";
	 private String recupListPropValideePourProjet ="SELECT p FROM Proposition p WHERE p.typeProposition.idTypeProposition = 3 AND p.projet.idProjet = :idProjet";

	@Override
	public Proposition modifierEtatProposition(Proposition proposition) {
		Proposition prop = em.find(Proposition.class, proposition.getIdProposition());
		em.merge(prop);
		em.flush();
		return prop;
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


	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> recupListPropParProjetSaufPropValidee(int idProjet) {
		Query query = em.createQuery(recupListPropParProjetSaufPropValidee);
		query.setParameter("idProjet", idProjet);
		return query.getResultList();
	}


	@Override
	public List<Proposition> recupPropValideePourProjet(Integer idProjet) {
		Query query = em.createQuery(recupListPropValideePourProjet);
		query.setParameter("idProjet", idProjet);
		return query.getResultList();
	}


	@Override
	public Proposition trouverProposition(Proposition proposition) {
		proposition = em.find(Proposition.class, proposition.getIdProposition());
		return proposition;
	}

}
