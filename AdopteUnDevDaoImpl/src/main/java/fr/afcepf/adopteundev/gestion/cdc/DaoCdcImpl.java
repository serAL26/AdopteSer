package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AssociationCdcFonctionnalite;
import entity.Cdc;
import entity.Fonctionnalite;
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

}
