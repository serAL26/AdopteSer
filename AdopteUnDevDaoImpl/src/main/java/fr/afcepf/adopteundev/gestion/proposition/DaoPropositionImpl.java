package fr.afcepf.adopteundev.gestion.proposition;

import entity.Proposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoProposition;
import org.apache.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Remote(IDaoProposition.class)
@Stateless
public class DaoPropositionImpl implements IDaoProposition{
    Logger log = Logger.getLogger(DaoPropositionImpl.class);
    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;

    @Override
    public Proposition recupPropositionValiderParProjet(Integer idProjet) {
        TypedQuery<Proposition> query = em.createQuery
                ("SELECT p FROM Proposition p WHERE p.projet.idProjet=:idProjet AND p.typeProposition.idTypeProposition=3",Proposition.class)
                .setParameter("idProjet",idProjet);
        log.warn(query.getSingleResult());
        return query.getSingleResult();
    }
}
