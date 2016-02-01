package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Client;
import entity.Developpeur;
import entity.Projet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IDaoGestionProjet.class)
@Stateless
public class DaoGestionProjetImpl implements IDaoGestionProjet {

	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;
	
	private String recupProjetEnAttenteParIdClient = "SELECT p FROM Projet p WHERE p.client.idUtilisateur = :id AND p.etatProjet.idEtatProjet = 4";
	
	@Override
	public List<Projet> recupProjetParIdClient(Integer id) {

		TypedQuery<Projet> query = em.createQuery(
				"Select p from Projet p where p.client.idUtilisateur =:id",
				Projet.class);
		query.setParameter("id", id);

		return query.getResultList();
	}

	@Override
	public Projet ajouter(Projet projet) {
		em.persist(projet);
		em.flush();
		return projet;
	}

	@Override
	public void modifierProjet(Projet projet) {
		em.merge(projet);
		em.flush();
	}

	@Override
	public List<Projet> recupProjerParEtat(String etat) {
		Query query = em.createQuery("SELECT p FROM Projet p WHERE p.etatProjet.libelle like :petat").setParameter("petat", etat);
		List<Projet> listProjet = query.getResultList();
		return listProjet;
	}

	@Override
	public List<Projet> recupProjerParEtatParClient(String etat, Client client) {
		Query query = em.createQuery("SELECT p FROM Projet p WHERE p.etatProjet.libelle like :petat AND p.client.idUtilisateur=:pId");
		query.setParameter("petat", etat);
		query.setParameter("pId", client.getIdUtilisateur());
		List<Projet> listProjet = query.getResultList();
		return listProjet;
	}
	
	@Override
	public List<Projet> recupProjerParEtatParIdClient(String etat, Integer id) {
		Query query = em.createQuery("SELECT p FROM Projet p WHERE p.etatProjet.libelle like :petat AND p.client.idUtilisateur=:pId");
		query.setParameter("petat", etat);
		query.setParameter("pId", id);
		List<Projet> listProjet = query.getResultList();
		return listProjet;
	}

	@Override
	public Projet recupProjetParId(int idProjet) {
		Projet projet = em.find(Projet.class, idProjet);
		return projet;
	}

	@Override
	public List<Projet> recupProjetParEtatParIdDev(String etat, Integer id) {
		Query query = em.createQuery("SELECT p.projet FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev "
				+ "AND p.typeProposition.idTypeProposition = 3 and p.projet.etatProjet.libelle like :petat");
		query.setParameter("idDev", id);
		query.setParameter("petat", etat);
		List<Projet> listProjet = query.getResultList();
		return listProjet;
	}

	@Override
	public List<Projet> recupProjetEnAttenteParIdClient(int id) {
		Query query = em.createQuery(recupProjetEnAttenteParIdClient);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
