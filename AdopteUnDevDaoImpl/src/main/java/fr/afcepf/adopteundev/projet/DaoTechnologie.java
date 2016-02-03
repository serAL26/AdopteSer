package fr.afcepf.adopteundev.projet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private String recupToutesTechno = "SELECT t FROM Technologie t";
	private String recupTechnoParServ = "SELECT a.technologie FROM AssociationTypeServiceTechno a WHERE a.typeService.idTypeService = :idserv";
	@SuppressWarnings("unchecked")
	@Override
	public List<Technologie> recupTechnoParDev(int idDev) {
		Query query = em.createQuery(recupTechnoParDev);
		query.setParameter("idDev", idDev);
		return query.getResultList();
	}

	@Override
	public List<Technologie> recupToutesTechnos() {
		List<Technologie> liste = em.createQuery(recupToutesTechno, Technologie.class).getResultList();
		return liste;
	}

	@Override
	public Technologie recupTechnoById(int id) {
		return em.find(Technologie.class, id);
	}

	@Override
	public Set<Technologie> recupTechnoParService(int idTypeService) {
		Query query = em.createQuery(recupTechnoParServ);
		query.setParameter("idserv", idTypeService);
		List<Technologie> liste = query.getResultList();
		return new HashSet<>(liste);
	}
}
