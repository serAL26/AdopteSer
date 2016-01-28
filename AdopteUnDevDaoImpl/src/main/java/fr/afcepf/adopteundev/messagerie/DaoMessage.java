package fr.afcepf.adopteundev.messagerie;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Message;
import fr.afcepf.adopteundev.idao.messagerie.IDaoMessagerie;
@Remote
@Stateless
public class DaoMessage implements IDaoMessagerie{

	@PersistenceContext(unitName="AdopteUnDevEntities")
	private EntityManager em;
	
	@Override
	public Message creerNouveauFil(Message message) {
		
		return null;
	}

}
