package fr.afcepf.adopteundev.gestion.proposition;

import java.util.List;

import entity.Proposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoProposition;

import org.apache.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Remote(IDaoProposition.class)
@Stateless
public class DaoPropositionImpl implements IDaoProposition{
	Logger log = Logger.getLogger(DaoPropositionImpl.class);
	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public Proposition recupPropositionValiderParProjet(Integer idProjet) {
		TypedQuery<Proposition> query = em.createQuery
				("SELECT p FROM Proposition p WHERE p.projet.idProjet=:idProjet AND p.typeProposition.idTypeProposition=3",Proposition.class)
				.setParameter("idProjet",idProjet);
		log.warn(query.getSingleResult());
		return query.getSingleResult();
	}

	@Override
	public Proposition ajouterPropositionAuDev(Proposition proposition) {
		em.persist(proposition);
		em.flush();
		return proposition;
	}

	@Override
	public List<Proposition> recupPropositionParEtatParIdClient(String etat,
			Integer id) {
		Query query = em.createQuery("SELECT p FROM Proposition p WHERE p.projet.client.idUtilisateur = :idClient "
				+ "AND p.typeProposition.libelle =:etat");
		query.setParameter("idClient", id);
		query.setParameter("etat", etat);
		List<Proposition> listePropositions = query.getResultList();
		return listePropositions;
	}

	@Override
	public List<Proposition> recupPropositionParEtatParIdDev(String etat, Integer id) {
		Query query = em.createQuery("SELECT p FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev "
				+ "AND p.typeProposition.libelle =:etat");
		query.setParameter("idDev", id);
		query.setParameter("etat", etat);
		List<Proposition> listProposition = query.getResultList();
		return listProposition;
	}
}
