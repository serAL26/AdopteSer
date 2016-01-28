package fr.afcepf.adopteundev.messagerie;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Message;
import fr.afcepf.adopteundev.idao.messagerie.IDaoMessagerie;
@Remote
@Stateless
public class DaoMessage implements IDaoMessagerie{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	
	private String recupTousLesMessMere = "SELECT m FROM Message m WHERE (m.utilisateur1.idUtilisateur = :id OR m.utilisateur2.idUtilisateur) AND m.messMere IS NULL";
	
	@Override
	public Message creerNouveauFil(Message message) {
		em.persist(message);
		em.flush();
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> recupereTousLesMessMere(int idUtilisateur) {
		Query query = em.createQuery(recupTousLesMessMere);
		query.setParameter(1, idUtilisateur);
		query.setParameter(2, idUtilisateur);
		return query.getResultList();
	}

}
