package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOOperation;

public interface IBusinessOperation {
	List<DTOOperation> payerLivrable(DTOOperation dtoOperation);
	List<DTOOperation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation);
	List<DTOOperation> recupListOperationParDevEtType(int idUtilisateur, int idTypeOperation);
	List<DTOOperation> recupListOperationParClientEtType(int idUtilisateur, int idTypeOperation);
	DTOOperation creerOperationAttente(DTOOperation operation);
}
