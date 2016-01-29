package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import entity.Projet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IDaoGestionProjet.class)
@Stateless
public class DaoGestionProjetImpl implements IDaoGestionProjet {
	
	 @PersistenceContext(unitName="AdopteUnDev")
	 EntityManager em;

	@Override
	public List<Projet> recupProjetParIdClient(Integer id) {
		
		TypedQuery<Projet> query = em.createQuery("from projet p where p.client.idClient =:id", Projet.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}
}
