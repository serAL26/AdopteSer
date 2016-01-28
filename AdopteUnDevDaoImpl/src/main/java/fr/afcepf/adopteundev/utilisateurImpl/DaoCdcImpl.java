package fr.afcepf.adopteundev.utilisateurImpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Cdc;
import fr.afcepf.adopteundev.dao.api.IDaoCdc;

@Remote
@Stateless
public class DaoCdcImpl implements IDaoCdc {

	 @PersistenceContext
	    EntityManager em;
	
	@Override
	public void ajouterCdc(Cdc cdc) {
		em.persist(cdc);
		em.flush();	
	}

}
