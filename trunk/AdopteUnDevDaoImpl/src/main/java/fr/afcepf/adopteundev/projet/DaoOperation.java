package fr.afcepf.adopteundev.projet;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Operation;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;


@Remote(IDaoOperation.class)
@Stateless
public class DaoOperation implements IDaoOperation{

	 @PersistenceContext(unitName="AdopteUnDev")
	 private EntityManager em;
	
	@Override
	public Operation creerOperation(Operation operation) {
		em.persist(operation);
		em.flush();
		return operation;
	}

}
