package fr.afcepf.adopteundev.gestion.utilisateur;

import entity.Utilisateur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Remote(IDaoUtilisateur.class)
@Stateless
public class DaoUtilisateurImpl implements IDaoUtilisateur {
    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;

    @Override
    public Utilisateur seConnecter(String mail, String password) {
        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.mail = :email AND u.mdp = :password", Utilisateur.class);
        query.setParameter("email", mail);
        query.setParameter("password", password);
        List<Utilisateur> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Utilisateur obtenirUtilisateurParId(int idUtilisateur) {
        return em.find(Utilisateur.class, idUtilisateur);
    }
}
