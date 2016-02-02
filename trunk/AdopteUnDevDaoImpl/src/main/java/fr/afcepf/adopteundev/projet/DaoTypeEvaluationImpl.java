package fr.afcepf.adopteundev.projet;

import entity.TypeEvaluation;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeEvaluation;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
@Remote(IDaoTypeEvaluation.class)
@Stateless
public class DaoTypeEvaluationImpl implements IDaoTypeEvaluation{
    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;
    String recupParLibelle = "SELECT t FROM TypeEvaluation t WHERE t.libelle like :libelle";
    @Override
    public TypeEvaluation recupererTypeEvaluationParLibelle(String libelle) {
        TypedQuery<TypeEvaluation> query = em.createQuery(recupParLibelle,TypeEvaluation.class).setParameter("libelle",libelle);
        return query.getSingleResult();
    }
}
