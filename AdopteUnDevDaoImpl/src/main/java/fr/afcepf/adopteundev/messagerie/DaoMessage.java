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
	
	private String recupTousLesMessMere = "SELECT m FROM Message m WHERE (m.utilisateur1.idUtilisateur = :id1 OR m.utilisateur2.idUtilisateur = :id2) AND m.messMere IS NULL";
	
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
		query.setParameter("id1", idUtilisateur);
		query.setParameter("id2", idUtilisateur);
		return query.getResultList();
	}

	@Override
	public Message ecrireUnNouveauMesssage(Message messageNouveau) {
		em.persist(messageNouveau);
		em.flush();
		return messageNouveau;
	}

	@Override
	public void majMessageMere(Message messageFille) {
		Message messMere = em.find(Message.class, messageFille.getMessMere().getIdMessage());
		messMere.setMessFille(messageFille);
		em.merge(messMere);
		em.flush();
	}

	@Override
	public Message obtenirMessageParId(Message message) {
		return em.find(Message.class, message.getIdMessage());
	}

	@Override
	public Message majDuMessMere(Message messMere) {
		em.merge(messMere);
		em.flush();
		return messMere;
	}

	

}
