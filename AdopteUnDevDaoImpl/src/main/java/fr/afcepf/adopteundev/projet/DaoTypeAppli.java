package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;

@Remote(IDaoTypeAppli.class)
@Stateless
public class DaoTypeAppli implements IDaoTypeAppli {

	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public List<TypeAppli> getAllApplis() {
		return em.createQuery("FROM TypeAppli t", TypeAppli.class)
				.getResultList();
	}

	@Override
	public TypeAppli getAppliById(Integer id) {
		return em.find(TypeAppli.class, id);
	}

}
