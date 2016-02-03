package fr.afcepf.adopteundev.business.projet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOOperation;
import entity.Operation;
import entity.Projet;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeOperation;

@Remote(IBusinessOperation.class)
@Stateless
public class BusinessOperation implements IBusinessOperation {

	@EJB
	private IDaoOperation daoOperation;
	@EJB
	private IDaoDeveloppeur daoDeveloppeur;
	@EJB
	private IDaoTypeOperation daoTypeOperation;

	@Override
	public List<DTOOperation> payerLivrable(DTOOperation dtoOperation) {
		List<DTOOperation> listeDTOOperation = new ArrayList<>();
		Operation operation = DTOToEntity.dtoOperationToOperation(dtoOperation);
		if (operation.getTypeOperation().getIdTypeOperation() == 3) {
			operation.setTypeOperation(daoTypeOperation
					.obtenirTypeOperationParId(4));
			Operation op = new Operation();
			op.setDate(new Date());
			op.setLivrable(operation.getLivrable());
			op.setMontant(operation.getMontant());
			op.setTypeOperation(daoTypeOperation.obtenirTypeOperationParId(1));
			daoOperation.creerOperation(op);
			listeDTOOperation.add(EntityToDTO.operationToDTOOperation(op));
			Operation ope = new Operation();
			ope.setDate(new Date());
			ope.setLivrable(operation.getLivrable());
			ope.setMontant(operation.getMontant());
			ope.setTypeOperation(daoTypeOperation.obtenirTypeOperationParId(2));
			daoOperation.creerOperation(ope);
			listeDTOOperation.add(EntityToDTO.operationToDTOOperation(ope));
		}
		return listeDTOOperation;
	}

	@Override
	public List<DTOOperation> recupListOperationParProjetEtType(int idProjet,
			int idTypeOperation) {
		List<Operation> operationList = daoOperation
				.recupListOperationParProjetEtType(idProjet, idTypeOperation);
		List<DTOOperation> dtoOperationList = new ArrayList<>();
		for (Operation operation : operationList) {
			dtoOperationList
					.add(EntityToDTO.operationToDTOOperation(operation));
		}
		return dtoOperationList;
	}

	@Override
	public List<DTOOperation> recupListOperationParDevEtType(int idUtilisateur,
			int idTypeOperation) {
		
		List<DTOOperation> listeDTOOperation = new ArrayList<>();
		List<Operation> listeOperation = daoOperation.recupListOperationParDevEtType(idUtilisateur, idTypeOperation);
		if(listeOperation != null && listeOperation.size() > 0) {
		listeDTOOperation = EntityToDTO.listeOperationToDTOOperation(listeOperation);
		}
		return listeDTOOperation;
	}

	@Override
	public List<DTOOperation> recupListOperationParClientEtType(
			int idUtilisateur, int idTypeOperation) {
		List<DTOOperation> listeDTOOperation = new ArrayList<>();
		List<Operation> listeOperation = daoOperation.recupListOperationParClientEtType(idUtilisateur, idTypeOperation);
		if(listeOperation != null && listeOperation.size() > 0) {
		listeDTOOperation = EntityToDTO.listeOperationToDTOOperation(listeOperation);
		}
		return listeDTOOperation;
	}

	@Override
	public DTOOperation creerOperationAttente(DTOOperation operation) {
		operation.setTypeOperation(EntityToDTO
				.typeOperationToDTOTypeOperation(daoTypeOperation
						.obtenirTypeOperationParId(3)));
		Operation operationEntity = daoOperation.creerOperation(DTOToEntity
				.dtoOperationToOperation(operation));
		return EntityToDTO.operationToDTOOperation(operationEntity);
	}
}
