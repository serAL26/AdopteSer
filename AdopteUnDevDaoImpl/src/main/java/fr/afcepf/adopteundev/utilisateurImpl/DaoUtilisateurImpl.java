package fr.afcepf.adopteundev.utilisateurImpl;

import entity.Utilisateur;
import fr.afcepf.adopteundev.dao.api.IDaoUtilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DaoUtilisateurImpl implements IDaoUtilisateur{
    @PersistenceContext
    EntityManager em;

    @Override
    public Utilisateur seConnecter(String mail, String password) {
        TypedQuery<Utilisateur> query = em.createQuery("FROM Utilisateur u WHERE u.mail like :email AND u.mdp like :password", Utilisateur.class)
                .setParameter("email",mail)
                .setParameter("password",password);
        List<Utilisateur> list = query.getResultList();
        if (list.size()==1)
            return list.get(0);
        else
            return null;
    }
}
