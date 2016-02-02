package fr.afcepf.adopteundev.ucimpl.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOTechnologie;
import dto.DTOUtilisateur;
import enumeration.RoleUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessDeveloppeur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;

@Remote(IUcUtilisateur.class)
@Stateless
public class UcUtilisateur implements IUcUtilisateur{

	@EJB
	private IBusinessUtilisateur businessUtilisateur;
	@EJB
	private IBusinessDeveloppeur businessDeveloppeur;
	
	@Override
	public DTOUtilisateur obtenirUtilisateurById(int idUtilisateur) {
		return businessUtilisateur.obtenirUtilisateurById(idUtilisateur);
	}

	@Override
	public List<DTODeveloppeur> recupTousLesDeveloppeurs() {
		return businessUtilisateur.recupTousLesDev();
	}

	@Override
	public NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
		return businessDeveloppeur.creerNoDeveloppeur(dtoDeveloppeur);
	}

	@Override
	public int typeUtilisateur(int idUtilisateur) {
		return businessUtilisateur.typeUtilisateur(idUtilisateur);
	}

	@Override
	public List<DTODeveloppeur> recupDevWeb() {
		return businessDeveloppeur.recupDevWeb();
	}

	@Override
	public List<DTODeveloppeur> recupDevParTechno(Integer id) {
		return businessDeveloppeur.recupDevParTechno(id);
	}

	@Override
	public DTOClient recupClientById(int id) {
		return businessUtilisateur.recupClientById(id);
	}

	@Override
	public List<DTODeveloppeur> recupDevParListeTechnoEtNote(double note,
			List<DTOTechnologie> technologies) {
		return businessDeveloppeur.recupDevParListeTechnoEtNote(note, technologies);
	}

	@Override
	public List<DTOTechnologie> recupToutesTechnos() {
		return businessDeveloppeur.recupToutesTechnos();
	}

	@Override
	public DTOTechnologie recupTechnoById(int id) {
		return businessDeveloppeur.recupTechnoById(id);
	}
}
