package fr.afcepf.adopteundev.projet;

import entity.Livrable;
import entity.Operation;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Remote(IDaoLivrable.class)
@Stateless
public class DaoLivrable implements IDaoLivrable {

    @PersistenceContext(unitName = "AdopteUnDev")
    private EntityManager em;

    private String recupListeLivrableParProjet = "SELECT l FROM Livrable l WHERE l.projet.idProjet = :id";
    private String recupListeLivrableParProjetEtParDev = "SELECT l FROM Livrable l WHERE l.projet.idProjet = :id AND l.developpeur.idUtilisateur = :idDeveloppeur";
    private String recupOperationEnAttente = "SELECT o FROM Operation o WHERE o.livrable.idLivrable = :idLivrable AND o.typeOperation.idTypeOperation = 3";

    @Override
    public Livrable creerLivrable(Livrable livrable) {
        em.persist(livrable);
        em.flush();
        return livrable;
    }

    @Override
    public List<Livrable> recupListeLivrableParProjet(int idPojet) {
        Query query = em.createQuery(recupListeLivrableParProjet);
        query.setParameter("id", idPojet);
        return query.getResultList();
    }

    @Override
    public List<Livrable> recupListeLivrableParProjetEtParDev(Integer idProjet, int idDeveloppeur) {
        Query query = em.createQuery(recupListeLivrableParProjetEtParDev);
        query.setParameter("id", idProjet);
        query.setParameter("idDeveloppeur", idDeveloppeur);
        return query.getResultList();
    }

    @Override
    public List<Operation> renvoiLOperationEnAttentePaiement(Livrable dtoLivrableToLivrable) {
        Query query = em.createQuery(recupOperationEnAttente);
        query.setParameter("idLivrable", dtoLivrableToLivrable);
        return query.getResultList();
    }

    @Override
    public void ajouterLeFichierDansLeLivrable(Livrable livrable) {
        TypedQuery<Livrable> query = em.createQuery("UPDATE l FROM Livrable l WHERE l.idLivrable = :idLivrable", Livrable.class)
                .setParameter("idLivrable",livrable.getIdLivrable());
    }

}
