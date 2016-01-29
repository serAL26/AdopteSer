package fr.afcepf.adopteundev.projet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.TypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;

@Remote(IDaoTypeAppli.class)
@Stateless
public class DaoTypeAppli implements IDaoTypeAppli {
private static Logger log = Logger.getLogger(DaoTypeAppli.class);
	@PersistenceContext(unitName="AdopteUnDev")
	EntityManager em;

	@Override
	public Set<TypeAppli> getAllApplis() {
		Query query = em.createQuery("SELECT t FROM TypeAppli t", TypeAppli.class);
		List<TypeAppli> listeType = query.getResultList();
		for (TypeAppli typeAppli : listeType) {
			log.info(typeAppli);
		}
		return  new HashSet<>(listeType);
	}

	@Override
	public TypeAppli getAppliById(Integer id) {
		log.info("dans dao recup id typeAppli");
		TypeAppli type = em.find(TypeAppli.class, id);
		log.info(type);
		return type;
	}

}
