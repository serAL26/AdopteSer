package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.EtatProjet;
import fr.afcepf.adopteundev.idao.projet.IDaoEtatProjet;

@Remote(IDaoEtatProjet.class)
@Stateless
public class DaoEtatProjet implements IDaoEtatProjet {
	private static Logger log = Logger.getLogger(DaoEtatProjet.class);
	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public EtatProjet recupEtatProjetByLibelle(String libelle) {
		Query query = em.createQuery(
				"SELECT e FROM EtatProjet e WHERE e.libelle like :plibelle")
				.setParameter("plibelle", libelle);
		List<EtatProjet> liste = query.getResultList();
		if (liste.size() == 1)
			return liste.get(0);
		return null;
	}
}
