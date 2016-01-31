package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.TypeCdc;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeCDC;

@Remote(IDaoTypeCDC.class)
@Stateless
public class DaoTypeCDC implements IDaoTypeCDC {

	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	@Override
	public TypeCdc recupTypeCdcByLibelle(String libelle) {
		Query query = em.createQuery(
				"SELECT t FROM DaoTypeCDC t WHERE t.libelle like :plibelle")
				.setParameter("plibelle", libelle);
		List<TypeCdc> liste = query.getResultList();
		if (liste.size() == 1)
			return liste.get(0);
		return null;
	}
}
