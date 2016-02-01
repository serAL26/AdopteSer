package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Livrable;
import entity.Operation;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;


@Remote(IDaoOperation.class)
@Stateless
public class DaoOperation implements IDaoOperation{

	 @PersistenceContext(unitName="AdopteUnDev")
	 private EntityManager em;
	 
	 private String recupListOperationParProjetEtTypeOperation = "SELECT o FROM Operation o  WHERE o.livrable.projet.idProjet = :idProjet AND o.typeOperation.idTypeOperation = :idTypeOperation";
	 private String recupListOperationParClientEtType = "SELECT o FROM Operation o  WHERE o.livrable.projet.client.idUtilisateur = :idClient AND o.typeOperation.idTypeOperation = :idTypeOperation";
	 private String recupListOperationParDevEtType = "SELECT o FROM Operation o WHERE  o.typeOperation.idTypeOperation = :idTypeOperation AND"
	 		+ " (o.livrable.projet.idProjet = (SELECT p.projet.idProjet FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 3))";
	 private String operationPayeeParLivrable = "SELECT o FROM Operation o WHERE o.typeOperation.idTypeOperation = 1 AND o.livrable.idLivrable = :idLivrable";
	
	@Override
	public Operation creerOperation(Operation operation) {
		em.persist(operation);
		em.flush();
		return operation;
	}

	@Override
	public List<Operation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation) {
		Query query = em.createQuery(recupListOperationParProjetEtTypeOperation);
		query.setParameter("idProjet", idProjet);
		query.setParameter("idTypeOperation", idTypeOperation);
		return query.getResultList();
	}

	@Override
	public List<Operation> recupListOperationParDevEtType(int idTypeOperation, int idDev) {
		Query query = em.createQuery(recupListOperationParDevEtType);
		query.setParameter("idTypeOperation", idTypeOperation);
		query.setParameter("idDev", idDev);
		return query.getResultList();
	}

	@Override
	public List<Operation> recupListOperationParClientEtType(int idTypeOperation, int idClient) {
		Query query = em.createQuery(recupListOperationParClientEtType);
		query.setParameter("idClient", idClient);
		query.setParameter("idTypeOperation", idTypeOperation);
		return query.getResultList();
	}

	@Override
	public Operation operationPayeeParLivrable(int idLivrable) {
		Query query = em.createQuery(operationPayeeParLivrable);
		query.setParameter("idLivrable", idLivrable);
		return  (Operation) query.getSingleResult();
	}

}
