package fr.afcepf.adopteundev.business.projet;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOLivrable;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOTypeEvaluation;
import entity.Livrable;
import entity.Operation;
import enumeration.TypeEvaluationEnum;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeEvaluation;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Remote(IBusinessLivrable.class)
@Stateless
public class BusinessLivrable implements IBusinessLivrable {

    @EJB
    private IDaoLivrable daoLivrable;
    @EJB
    private IDaoOperation daoOperation;
    @EJB
    private IDaoTypeEvaluation daoTypeEvaluation;

    @Override
    public DTOLivrable creerLivrable(DTOLivrable dtoLivrable) {
        dtoLivrable.setTypeEvaluation(EntityToDTO.typeEvaluationToDTOTypeEvaluation(daoTypeEvaluation.recupererTypeEvaluationParLibelle(TypeEvaluationEnum.ATTENTE.toString())));
        Livrable livrable = daoLivrable.creerLivrable(DTOToEntity.dtoLivrableToLivrable(dtoLivrable));
        return EntityToDTO.livrableToDTOLivrable(livrable);
    }

    @Override
    public List<DTOLivrable> recupListeLivrableParProjet(DTOProjet dtoProjet) {
        List<Livrable> listeLivrable = daoLivrable.recupListeLivrableParProjet(dtoProjet.getIdProjet());
        List<DTOLivrable> listeDto= new ArrayList<>();
        for (Livrable livrable : listeLivrable){
        	DTOLivrable dtoLivrable = EntityToDTO.livrableToDTOLivrable(livrable);
        	List<Operation> listeOperation = daoOperation.operationParLivrable(livrable.getIdLivrable()); 
        	if(listeOperation.size() > 0) {
        		dtoLivrable.setLesOperation(new HashSet<DTOOperation>());
        		for (Operation operation : listeOperation) {
        			dtoLivrable.getLesOperation().add(EntityToDTO.operationToDTOOperation(operation));
				}
        	}
        	listeDto.add(dtoLivrable);
		}
        return listeDto;
    }

    @Override
    public DTOTypeEvaluation recupererTypeEvaluationParLibelle(String libelle) {
        return EntityToDTO.typeEvaluationToDTOTypeEvaluation(daoTypeEvaluation.recupererTypeEvaluationParLibelle(libelle));
    }

    @Override
    public Boolean initIsPaye(DTOLivrable livrable) {
        Boolean retour = false;
        List<Operation> listeOperation = new ArrayList<>();
        listeOperation.addAll(daoOperation.operationPayeeParLivrable(livrable.getIdLivrable()));
        if (listeOperation.size() > 0) {
            retour = true;
        }
        return retour;
    }

}
