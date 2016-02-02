package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import entity.Developpeur;
import entity.Projet;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;

@Remote(IDaoDeveloppeur.class)
@Stateless
public class DaoDeveloppeurImpl implements IDaoDeveloppeur {
	private static Logger log = Logger.getLogger(DaoDeveloppeurImpl.class);
	@PersistenceContext(unitName = "AdopteUnDev")
	EntityManager em;

	private String recupDerWeb = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=8";
	private String recupDevParTechno = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=:id";
	private String obtenirProjetParDev = "SELECT p.projet FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 3";
	private String obtenirDevParTechnoEtNote = "SELECT a.developpeur FROM AssociationDevTechno a, Note no WHERE a.technologie.idTechnologie=:idTech AND no.idEstNote=a.developpeur.idUtilisateur AND no.Note>=:pnote";
	private String obtenirDevParNote = "SELECT d FROM Developpeur d, Note no WHERE d.idUtilisateur=no.idEstNote AND no.Note>=:p_note";

	@Override
	public List<Developpeur> recupererTousLesDeveloppeurs() {
		return em.createQuery("FROM Developpeur d", Developpeur.class)
				.getResultList();
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

	@Override
	public List<Projet> obtenirProjetParDev(int idDev) {
		Query query = em.createQuery(obtenirProjetParDev);
		query.setParameter("idDev", idDev);
		return query.getResultList();
	}

	@Override
	public Set<Developpeur> recupDeveloppeurParNoteEtTechno(double note,
			int idTechno) {
		log.info("idtechno : " + idTechno + "  Note : " + note);
		Query query = em.createQuery(obtenirDevParTechnoEtNote);
		query.setParameter("idTech", idTechno);
		query.setParameter("pnote", note);
		List<Developpeur> liste = query.getResultList();
		return new HashSet<>(liste);
	}

	@Override
	public Set<Developpeur> recupDevParNote(double note) {
		Query query = em.createQuery(obtenirDevParNote, Developpeur.class);
		query.setParameter("p_note", note);
		List<Developpeur> liste = query.getResultList();
		return new HashSet<>(liste);
	}

	@Override
	public Set<Developpeur> recupDeveloppeursParTechnoSet(Integer id) {
		List<Developpeur> liste = recupDeveloppeursParTechno(id);
		return new HashSet<>(liste);
	}

}
