package fr.afcepf.adopteundev.business.projet;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOLivrable;
import dto.DTOProjet;
import dto.DTOTypeEvaluation;
import entity.Livrable;
import enumeration.TypeEvaluationEnum;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeEvaluation;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
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
        dtoLivrable.setTypeEvaluation(EntityToDTO
                .typeEvaluationToDTOTypeEvaluation(daoTypeEvaluation.recupererTypeEvaluationParLibelle(TypeEvaluationEnum.ATTENTE.toString())));
        Livrable livrable = daoLivrable.creerLivrable(DTOToEntity.dtoLivrableToLivrable(dtoLivrable));
        return EntityToDTO.livrableToDTOLivrable(livrable);
    }

    @Override
    public List<DTOLivrable> recupListeLivrableParProjet(DTOProjet dtoProjet) {
        List<Livrable> listeLivrable = daoLivrable.recupListeLivrableParProjet(dtoProjet.getIdProjet());
        return EntityToDTO.listeLivrableToDTOLivrable(listeLivrable);
    }

    @Override
    public DTOTypeEvaluation recupererTypeEvaluationParLibelle(String libelle) {
        return EntityToDTO.typeEvaluationToDTOTypeEvaluation(daoTypeEvaluation.recupererTypeEvaluationParLibelle(libelle));
    }

    @Override
    public boolean initIsPaye(DTOLivrable livrable) {
        boolean retour = false;
        if (daoOperation.operationPayeeParLivrable(livrable.getIdLivrable()) != null) {
            retour = true;
        }
        return retour;
    }

}
