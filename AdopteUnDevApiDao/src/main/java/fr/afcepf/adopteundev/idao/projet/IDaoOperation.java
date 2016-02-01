package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Livrable;
import entity.Operation;

public interface IDaoOperation {
	Operation creerOperation(Operation operation);
	List<Operation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation);
	List<Operation> recupListOperationParDevEtType(int idTypeOperation, int idDev);
	List<Operation> recupListOperationParClientEtType(int idTypeOperation, int idClient);
	Operation operationPayeeParLivrable(int idLivrable);
}
