package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.TypeAppli;
import entity.TypeService;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeService;

@Remote(IDaoTypeService.class)
@Stateless
public class DaoTypeService implements IDaoTypeService {
	@PersistenceContext(unitName = "AdopteUnDevEntities")
	EntityManager em;
	IDaoTypeAppli daoTypeAppli = new DaoTypeAppli();

	@Override
	public List<TypeService> getAllServices() {
		return em.createQuery("FROM TypeService t", TypeService.class)
				.getResultList();
	}

	@Override
	public TypeService getSericesById(Integer id) {
		return em.find(TypeService.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeService> getServicesByAppli(TypeAppli appli) {
		List<TypeService> liste = null;
		if (daoTypeAppli.getAppliById(appli.getIdTypeAppli()) != null) {
			Query query = em
					.createQuery("SELECT serv FROM TypeService serv WHERE serv.typeAppli=:p_typeAppli");
			query.setParameter("p_typeAppli", appli);
			liste = query.getResultList();
		}

		return liste;
	}

}
