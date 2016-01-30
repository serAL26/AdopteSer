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
	public void ajouterCdc(Cdc cdc) {
		em.persist(cdc);
		em.flush();	
	}

	@Override
	public void modifierCdc(Cdc cdc) {
		em.merge(cdc);
		
	}


	public List<TypeCdc> recupTouslesTypesCdc() {
		
		return em.createQuery("Select t from TypeCdc t", TypeCdc.class).getResultList();
	}

}
