package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Operation;

public interface IDaoOperation {
	Operation creerOperation(Operation operation);
	List<Operation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation);
	List<Operation> recupListOperationParClientEtType(int idTypeOperation, int idClient);
	List<Operation> operationPayeeParLivrable(int idLivrable);
	List<Operation> operationParLivrable(int idLivrable);
}
