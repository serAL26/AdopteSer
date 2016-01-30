package fr.afcepf.adopteundev.projet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.AssociationCdcFonctionnalite;
import entity.Fonctionnalite;
import entity.TypeFonctionnalite;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoFonctionnalite;

@Remote(IDaoFonctionnalite.class)
@Stateless
public class DaoFonctionnalite implements IDaoFonctionnalite {

	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public void ajouterFonctionnalite(Fonctionnalite fonctionnalite) {
		em.persist(fonctionnalite);
		em.flush();
	}

	@Override
	public Set<Fonctionnalite> recupererTousFonctionna() {
		Query query = em.createQuery("SELECT f FROM Fonctionnalite f",
				Fonctionnalite.class);
		List<Fonctionnalite> liste = query.getResultList();
		return new HashSet<>(liste);
	}

	@Override
	public Set<Fonctionnalite> recupeFonctionnalitesParType(
			TypeFonctionnalite typeFonctionnalite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fonctionnalite recupFonctionnaliteParID(Integer id) {
		Fonctionnalite fonctionnalite = em.find(Fonctionnalite.class, id);
		return fonctionnalite;
	}
	
	@Override
	public void ajouterAssociationCdcFonctionnalite(
			AssociationCdcFonctionnalite association) {
		em.persist(association);
		em.flush();	
		
	}
}
