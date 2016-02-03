package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Operation;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;


@Remote(IDaoOperation.class)
@Stateless
public class DaoOperation implements IDaoOperation{

	 @PersistenceContext(unitName="AdopteUnDev")
	 private EntityManager em;
	 
	 private String recupListOperationParProjetEtTypeOperation = "SELECT o FROM Operation o  WHERE o.livrable.projet.idProjet = :idProjet AND o.typeOperation.idTypeOperation = :idTypeOperation";
	 private String recupListOperationParClientEtType = "SELECT o FROM Operation o  WHERE o.livrable.projet.client.idUtilisateur = :idClient AND o.typeOperation.idTypeOperation = :idTypeOperation";
	 private String operationPayeeParLivrable = "SELECT o FROM Operation o WHERE o.typeOperation.idTypeOperation = 1 AND o.livrable.idLivrable = :idLivrable";
	
	@Override
	public Operation creerOperation(Operation operation) {
		em.persist(operation);
		em.flush();
		return operation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation) {
		Query query = em.createQuery(recupListOperationParProjetEtTypeOperation);
		query.setParameter("idProjet", idProjet);
		query.setParameter("idTypeOperation", idTypeOperation);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> recupListOperationParClientEtType(int idTypeOperation, int idClient) {
		Query query = em.createQuery(recupListOperationParClientEtType);
		query.setParameter("idClient", idClient);
		query.setParameter("idTypeOperation", idTypeOperation);
		return query.getResultList();
	}

	@Override
	public List<Operation> operationPayeeParLivrable(int idLivrable) {
		Query query = em.createQuery(operationPayeeParLivrable);
		query.setParameter("idLivrable", idLivrable);
		return  query.getResultList();
	}
}
