package fr.afcepf.adopteundev.projet;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Note;
import entity.Proposition;
import fr.afcepf.adopteundev.idao.projet.IDaoNote;

@Remote(IDaoNote.class)
@Stateless
public class DaoNote implements IDaoNote{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	
	private String recupNoteParPropositionValidee = "SELECT n FROM Note n WHERE n.idEstNote = :idUtilisateur";
	
	@Override
	public List<Note> recupNoteParPropositionValidee(int idUtilisateur) {
	Query query = em.createQuery(recupNoteParPropositionValidee);
	query.setParameter("idUtilisateur", idUtilisateur);
		return query.getResultList();
	}

}
