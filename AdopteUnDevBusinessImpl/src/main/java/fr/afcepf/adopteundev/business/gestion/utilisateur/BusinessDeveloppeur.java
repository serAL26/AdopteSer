package fr.afcepf.adopteundev.business.gestion.utilisateur;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTONote;
import dto.DTOProposition;
import dto.DTOTechnologie;
import entity.Developpeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoProposition;

@Remote(IBusinessDeveloppeur.class)
@Stateless
public class BusinessDeveloppeur implements IBusinessDeveloppeur{

	@EJB
	private IDaoUtilisateur daoUtilisateur;
	
	@EJB
	private IDaoProposition daoProposition;
	
	@Override
	public List<DTODeveloppeur> recupererTousLesDeveloppeurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
		NoDeveloppeur noDev = new NoDeveloppeur(dtoDeveloppeur);
		noDev.setNote(obtenirNote(dtoDeveloppeur));
		noDev.setTechnologie(obtenirTechnologie(dtoDeveloppeur));
		return null;
	}

	private List<DTOTechnologie> obtenirTechnologie(DTODeveloppeur dtoDeveloppeur) {
		
		return null;
	}

	private Double obtenirNote(DTODeveloppeur dtoDeveloppeur) {
		List<DTOProposition> listeDTOProposition = EntityToDTO.listePropositionToDtoProposition(daoProposition.recupPropositionValideeParDev(dtoDeveloppeur.getIdUtilisateur()));
		double nbProjet = 0;
		Double sommeNote = new Double(0);
		for (DTOProposition dtoProposition : listeDTOProposition) {
			Set<DTONote> listeNote = dtoProposition.getProjet().getLesNotes();
			for (DTONote dtoNote : listeNote) {
				if(dtoNote.getIdEstNote()==dtoDeveloppeur.getIdUtilisateur()){
					sommeNote += dtoNote.getNote();
					nbProjet++;
				}
			}
		}
		return sommeNote/nbProjet;
	}

}
