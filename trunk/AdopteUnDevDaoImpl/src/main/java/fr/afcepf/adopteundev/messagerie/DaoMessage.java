package fr.afcepf.adopteundev.messagerie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Message;
import fr.afcepf.adopteundev.idao.messagerie.IDaoMessagerie;

public class DaoMessage implements IDaoMessagerie{

	@PersistenceContext(unitName="")
	private EntityManager em;
	
	@Override
	public Message creerNouveauFil(Message message) {
		
		return null;
	}

}
