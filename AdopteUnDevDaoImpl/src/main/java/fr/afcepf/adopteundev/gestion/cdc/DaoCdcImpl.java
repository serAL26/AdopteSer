package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
import entity.Projet;
import entity.TypeCdc;
import entity.TypeFonctionnalite;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoCdc;

@Remote(IDaoCdc.class)
@Stateless
public class DaoCdcImpl implements IDaoCdc {

	 @PersistenceContext(unitName="AdopteUnDev")
	    EntityManager em;
	
	@Override
	public Cdc ajouterCdc(Cdc cdc) {
		em.persist(cdc);
		em.flush();	
		em.merge(cdc);
		
		return cdc;
	}

	@Override
	public Cdc modifierCdc(Cdc cdc) {
		em.merge(cdc);
		
		return cdc;
	}

	@Override
	public List<TypeFonctionnalite> getAll() {
		
		return em.createQuery("Select t from TypeFonctionnalite t", TypeFonctionnalite.class).getResultList();
	}

	@Override
	public Fonctionnalite ajouterFonctionnalite(Fonctionnalite fonct) {
		em.persist(fonct);
		em.flush();	
		
		return fonct;
		
	}

	@Override
	public AssociationCdcFonctionnalite ajouterAssociationCdcFonctionnalite(
			AssociationCdcFonctionnalite association) {
		em.persist(association);
		em.flush();	
		
		return association;
	}

	@Override
	public List<TypeCdc> recupTouslesTypesCdc() {
		
		return em.createQuery("Select t from TypeCdc t", TypeCdc.class).getResultList();
	}

	@Override
	public Cdc recupCdcParId(Integer id) {
		Cdc cdc = em.find(Cdc.class, id);
		return cdc;
	}

	@Override
	public List<Cdc> recupRemarqueParIdDevEtIdProjet(Integer idDev, Integer idProjet) {
		
		TypedQuery<Cdc> query = em.createQuery("Select c from Cdc c where c.developpeurCdc.idUtilisateur =:id and "
				+ "c.projet.idProjet =:idProjet and c.typeCdc.idTypeCdc =1", Cdc.class);
		query.setParameter("id", idDev);
		query.setParameter("idProjet", idProjet);
		
		return query.getResultList();
	}
}
