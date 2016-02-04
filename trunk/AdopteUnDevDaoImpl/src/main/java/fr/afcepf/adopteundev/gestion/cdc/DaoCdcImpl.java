package fr.afcepf.adopteundev.gestion.cdc;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

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
	private static Logger log = Logger.getLogger(DaoCdcImpl.class);
	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	
	private String recupCdcParIdProjet = "SELECT c FROM Cdc c WHERE c.projet.idProjet = :idProjet";
	private String recupCdcFinalParidProjet = "SELECT c FROM Cdc c WHERE c.projet.idProjet = :idProjet AND c.typeCdc.idTypeCdc = 2";
	
	@Override
	public Cdc ajouterCdc(Cdc cdc) {
		em.persist(cdc);
		em.flush();
		log.info("dao cdc id " + cdc.getIdCdc());
		return cdc;
	}

	@Override
	public Cdc modifierCdc(Cdc cdc) {
		em.merge(cdc);

		return cdc;
	}

	@Override
	public List<TypeFonctionnalite> getAll() {

		return em.createQuery("Select t from TypeFonctionnalite t",
				TypeFonctionnalite.class).getResultList();
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
		log.info("association cdc (cdc) : " +association.getCdc().getIdCdc()); 
		log.info("association cdc (fonctionnalite) : " +association.getFonctionnalite().getIdFonctionnalite()); 
		em.persist(association);
		log.info("association cdc" + association.getIdAssocCdcFonctionnalite());
		em.flush();
		return association;
	}

	@Override
	public List<TypeCdc> recupTouslesTypesCdc() {

		return em.createQuery("Select t from TypeCdc t", TypeCdc.class)
				.getResultList();
	}

	@Override
	public Cdc recupCdcParId(Integer id) {
		Cdc cdc = em.find(Cdc.class, id);
		return cdc;
	}

	@Override
	public List<Cdc> recupRemarqueParIdDevEtIdProjet(Integer idDev,
			Integer idProjet) {

		TypedQuery<Cdc> query = em
				.createQuery(
						"Select c from Cdc c where c.developpeurCdc.idUtilisateur =:id and "
								+ "c.projet.idProjet =:idProjet and c.typeCdc.idTypeCdc =1",
								Cdc.class);
		query.setParameter("id", idDev);
		query.setParameter("idProjet", idProjet);

		return query.getResultList();
	}

	@Override
	public Cdc recupCdcFinalParidProjet(int idProjet) {
		TypedQuery<Cdc> query = em
				.createQuery(
						"SELECT c FROM Cdc c WHERE c.projet.idProjet = :idProjet AND c.typeCdc.idTypeCdc = 2",
						Cdc.class).setParameter("idProjet", idProjet);
		return query.getSingleResult();
	}

	@Override
	public TypeCdc recupTypeRemarque() {
		TypedQuery<TypeCdc> query = em.createQuery("Select t from TypeCdc t where t.idTypeCdc = 1", TypeCdc.class);
		System.out.println(query.getSingleResult().getLibelle());
		return query.getSingleResult();
	}

	@Override
	public List<Cdc> recupCdcParidProjet(Integer idProjet) {
		Query query = em.createQuery(recupCdcParIdProjet);
		log.info(idProjet);
		query.setParameter("idProjet", idProjet);
		List<Cdc> liste = query.getResultList();
		for (Cdc cdc : liste) {
			log.info(cdc.getIdCdc() + "=>"+ cdc.getTarif());	
		}
		
		return liste;
	}
}
