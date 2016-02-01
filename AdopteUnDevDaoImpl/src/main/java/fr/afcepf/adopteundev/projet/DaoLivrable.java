package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Livrable;
import entity.Projet;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;

@Remote(IDaoLivrable.class)
@Stateless
public class DaoLivrable implements IDaoLivrable{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	
	private String recupListeLivrableParProjet = "SELECT l FROM Livrable l WHERE l.projet.idProjet = :id";
	@Override
	public Livrable creerLivrable(Livrable livrable) {
		em.persist(livrable);
		em.flush();
		return livrable;
	}

	@Override
	public List<Livrable> recupListeLivrableParProjet(int idPojet) {
		Query query = em.createQuery(recupListeLivrableParProjet);
		query.setParameter("id", idPojet);
		return query.getResultList();
	}

}
