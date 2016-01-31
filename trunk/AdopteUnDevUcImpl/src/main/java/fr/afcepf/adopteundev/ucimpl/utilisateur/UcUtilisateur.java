package fr.afcepf.adopteundev.ucimpl.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTODeveloppeur;
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
}