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
		
		TypedQuery<Projet> query = em.createQuery("Select p from Projet p where p.client.idUtilisateur =:id", Projet.class);
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
}
