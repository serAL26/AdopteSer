package fr.afcepf.adopteundev.gestion.proposition;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Proposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoProposition;

@Remote(IDaoProposition.class)
@Stateless
public class DaoPropositionImpl implements IDaoProposition{
	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	private String recupPropositionNonLue = "SELECT p FROM Proposition p WHERE p.Lu = 0 AND p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 1";
	private String passerPropositionALue = "UPDATE Proposition p SET p.Lu = 1 WHERE p.idProposition = :idProposition";
	private String recupPropositoinNonLuePourClient = "SELECT p FROM Proposition p WHERE  p.Lu = 0 AND p.projet.client.idUtilisateur = :idClient AND p.typeProposition.idTypeProposition = 2";
	
	@Override
	public Proposition recupPropositionValiderParProjet(Integer idProjet) {
		TypedQuery<Proposition> query = em.createQuery
				("SELECT p FROM Proposition p WHERE p.projet.idProjet=:idProjet AND p.typeProposition.idTypeProposition=3",Proposition.class)
				.setParameter("idProjet",idProjet);
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

	@Override
	public List<Proposition> recupPropositionNonLue(int idDeveloppeur) {
		Query query = em.createQuery(recupPropositionNonLue);
		query.setParameter("idDev", idDeveloppeur);
		return query.getResultList();
	}

	@Override
	public void passerPropositionEnLue(int idProposition) {
		Query query = em.createQuery(passerPropositionALue);
		query.setParameter("idProposition", idProposition);
		query.executeUpdate();
	}

	@Override
	public List<Proposition> recupPropostionNonLueClient(int idClient) {
		Query query = em.createQuery(recupPropositoinNonLuePourClient);
		query.setParameter("idClient", idClient);
		return query.getResultList();
	}
}
