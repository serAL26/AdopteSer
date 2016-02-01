package fr.afcepf.adopteundev.projet;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TypeOperation;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeOperation;

@Remote(IDaoTypeOperation.class)
@Stateless
public class DaoTypeOperation implements IDaoTypeOperation{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;

	@Override
	public TypeOperation obtenirTypeOperationParId(int id) {
		return em.find(TypeOperation.class, id);
	}

}
