package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Technologie;
import fr.afcepf.adopteundev.idao.projet.IDaoTechnologie;

@Remote(IDaoTechnologie.class)
@Stateless
public class DaoTechnologie implements IDaoTechnologie{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	
	private String recupTechnoParDev ="SELECT a.technologie FROM AssociationDevTechno a WHERE a.developpeur.idUtilisateur = :idDev ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Technologie> recupTechnoParDev(int idDev) {
		Query query = em.createQuery(recupTechnoParDev);
		query.setParameter("idDev", idDev);
		return query.getResultList();
	}

}
