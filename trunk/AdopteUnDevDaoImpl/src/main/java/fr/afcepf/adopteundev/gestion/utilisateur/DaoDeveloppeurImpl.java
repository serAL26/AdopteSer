package fr.afcepf.adopteundev.gestion.utilisateur;

import entity.Developpeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Remote(IDaoDeveloppeur.class)
@Stateless
public class DaoDeveloppeurImpl implements IDaoDeveloppeur {

    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;
    @Override
    public List<Developpeur> recupererTousLesDeveloppeurs() {
        return em.createQuery("FROM Developpeur d",Developpeur.class).getResultList();
    }
	@Override
	public Developpeur obtenirDeveloppeurParId(int idUtilisateur) {
		return em.find(Developpeur.class, idUtilisateur);
	}
}
