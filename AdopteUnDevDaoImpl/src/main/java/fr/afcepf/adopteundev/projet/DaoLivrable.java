package fr.afcepf.adopteundev.projet;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Livrable;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;

@Remote(IDaoLivrable.class)
@Stateless
public class DaoLivrable implements IDaoLivrable{


	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;

	@Override
	public Livrable creerLivrable(Livrable livrable) {
		em.persist(livrable);
		em.flush();
		return livrable;
	}

}
