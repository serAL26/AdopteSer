package fr.afcepf.adopteundev.business.projet;

import java.util.ArrayList;
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
public class BusinessOperation implements IBusinessOperation{

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
		operation.setTypeOperation(daoTypeOperation.obtenirTypeOperationParId(1));
		daoOperation.creerOperation(operation);
		listeDTOOperation.add(EntityToDTO.operationToDTOOperation(operation));
		operation.setTypeOperation(daoTypeOperation.obtenirTypeOperationParId(2));
		daoOperation.creerOperation(operation);
		listeDTOOperation.add(EntityToDTO.operationToDTOOperation(operation));
		return listeDTOOperation;
	}

	@Override
	public List<DTOOperation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation) {
		return null;
	}

	@Override
	public List<DTOOperation> recupListOperationParDevEtType(int idUtilisateur, int idTypeOperation) {
		List<Projet> listeProjet = daoDeveloppeur.obtenirProjetParDev(idUtilisateur);
		List<DTOOperation> listeDTOProjet = new ArrayList<>();
		for (Projet projet : listeProjet) {
			listeDTOProjet.addAll(EntityToDTO.listeOperationToDTOOperation(daoOperation.recupListOperationParProjetEtType(projet.getIdProjet(), idTypeOperation)));
		}
		return listeDTOProjet;
	}

	@Override
	public List<DTOOperation> recupListOperationParClientEtType(int idUtilisateur, int idTypeOperation) {
		return null;
	}
}
