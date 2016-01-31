package fr.afcepf.adopteundev.business.gestion.utilisateur;

import java.util.ArrayList;
import java.util.List;

import assembleur.EntityToDTO;
import dto.DTODeveloppeur;
import dto.DTOTypeFonctionnalite;
import dto.DTOUtilisateur;
import entity.Developpeur;
import entity.TypeFonctionnalite;
import entity.Utilisateur;
import enumeration.RoleUtilisateur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoClient;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessUtilisateur.class)
@Stateless
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {
	@EJB
    private IDaoUtilisateur daoUtilisateur;
	
	@EJB
	private IDaoDeveloppeur daoDeveloppeur;
	
	@EJB
	private IDaoClient daoClient;

    @Override
    public DTOUtilisateur connecterDtoUtilisateur(String mail, String mdp) {
      Utilisateur utilisateur = daoUtilisateur.seConnecter(mail, mdp);
      DTOUtilisateur dtoUtilisateur = null;
      if(utilisateur!=null) {
    	  dtoUtilisateur = EntityToDTO.utilisateurToDTOUtilisateur(utilisateur);
      }
      return dtoUtilisateur;
    }

	@Override
	public DTOUtilisateur obtenirUtilisateurById(int idUtilisateur) {
		Utilisateur utilisateur = daoUtilisateur.obtenirUtilisateurParId(idUtilisateur); 
		return EntityToDTO.utilisateurToDTOUtilisateur(utilisateur);
	}

	@Override
	public List<DTODeveloppeur> recupTousLesDev() {
		
		List<Developpeur> listeDev = daoDeveloppeur.recupererTousLesDeveloppeurs();
		List<DTODeveloppeur> listeDto = new ArrayList<>();
		
		for (Developpeur dev : listeDev) {
			DTODeveloppeur dtoDev = EntityToDTO.developpeurToDTODeveloppeur(dev);
			listeDto.add(dtoDev);
		}
		return listeDto;
	}

	@Override
	public int typeUtilisateur(int idUtilisateur) {
		int role =0;
		if(daoDeveloppeur.obtenirDeveloppeurParId(idUtilisateur) != null) {
			role = 1;
		}
		else if(daoClient.obtenirClientParId(idUtilisateur) != null) {
			role = 2;
		}
		else {
			role = 3;
		}
		return role;
	}
}
