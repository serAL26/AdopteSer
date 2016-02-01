package fr.afcepf.adopteundev.gestion.utilisateur;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Developpeur;
import entity.Projet;
import entity.Technologie;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
@Remote(IDaoDeveloppeur.class)
@Stateless
public class DaoDeveloppeurImpl implements IDaoDeveloppeur {

    @PersistenceContext(unitName = "AdopteUnDev")
    EntityManager em;
    
    
    private String recupDerWeb = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=8";
    private String recupDevParTechno = "Select a.developpeur from AssociationDevTechno a where a.technologie.idTechnologie=:id";
    private String obtenirProjetParDev = "SELECT p.projet FROM Proposition p WHERE p.developpeur.idUtilisateur = :idDev AND p.typeProposition.idTypeProposition = 3";
    private String obtenirDevParTechnoEtNote = "SELECT a.developpeur FROM AssociationDevTechno a, Note no WHERE a.technologie=:idTech AND no.idEstNote=a.developpeur.idUtilisateur AND no.Note>=:pnote";
    @Override
    public List<Developpeur> recupererTousLesDeveloppeurs() {
        return em.createQuery("FROM Developpeur d",Developpeur.class).getResultList();
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
	public List<Developpeur> recupDeveloppeurParNoteEtTechno(double note,
			Technologie techno) {
		Query query = em.createQuery(obtenirDevParTechnoEtNote);
		query.setParameter("idTech", techno.getIdTechnologie());
		query.setParameter("pnote", note);
		return query.getResultList();
	}

}
