package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Client;
import entity.Projet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IDaoGestionProjet.class)
@Stateless
public class DaoGestionProjetImpl implements IDaoGestionProjet {

	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public List<Projet> recupProjetParIdClient(Integer id) {

		TypedQuery<Projet> query = em.createQuery(
				"Select p from Projet p where p.client.idUtilisateur =:id",
				Projet.class);
		query.setParameter("id", id);

		return query.getResultList();
	}

	@Override
	public void ajouter(Projet projet) {
		em.persist(projet);
		em.flush();
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
	public Projet recupProjetParId(int idProjet) {
		Projet projet = em.find(Projet.class, idProjet);
		return projet;
	}

}
