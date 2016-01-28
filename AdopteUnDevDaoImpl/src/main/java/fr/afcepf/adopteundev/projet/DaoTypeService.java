package fr.afcepf.adopteundev.projet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.TypeAppli;
import entity.TypeService;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeService;

@Remote(IDaoTypeService.class)
@Stateless
public class DaoTypeService implements IDaoTypeService {
	@PersistenceContext(unitName = "AdopteUnDev")

	EntityManager em;

	@Override
	public Set<TypeService> getAllServices() {
		return new HashSet<>(em.createQuery("FROM TypeService t", TypeService.class)
				.getResultList());
	}

	@Override
	public TypeService getSericesById(Integer id) {
		return em.find(TypeService.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<TypeService> getServicesByAppli(TypeAppli appli) {
			Query query = em
					.createQuery("SELECT serv FROM TypeService serv WHERE serv.typeAppli=:p_typeAppli");
			query.setParameter("p_typeAppli", appli);
			List<TypeService> liste = query.getResultList();
			return new HashSet<>(liste);

	}

	

}
