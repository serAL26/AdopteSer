package fr.afcepf.adopteundev.gestion.utilisateur;

import entity.Developpeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;
@Remote(IDaoDeveloppeur.class)
@Stateless
public class DaoDeveloppeurImpl implements IDaoDeveloppeur {

    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;
    
    
    private String recupDerWeb = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=8";
    private String recupDevParTechno = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=:id";
    
    @Override
    public List<Developpeur> recupererTousLesDeveloppeurs() {
        return em.createQuery("FROM Developpeur d",Developpeur.class).getResultList();
    }

	@Override
	public Developpeur obtenirDeveloppeurParId(int idUtilisateur) {
		return em.find(Developpeur.class, idUtilisateur);
	}

	@Override
	public List<Developpeur> recupDeveloppeurWeb() {
		Query query = em.createQuery(recupDerWeb);
		return query.getResultList();
	}

	@Override
	public List<Developpeur> recupDeveloppeursParTechno(Integer id) {
		Query query = em.createQuery(recupDevParTechno);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
