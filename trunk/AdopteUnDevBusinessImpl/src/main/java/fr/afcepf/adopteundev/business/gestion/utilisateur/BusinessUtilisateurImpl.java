package fr.afcepf.adopteundev.business.gestion.utilisateur;

import assembleur.EntityToDTO;
import dto.DTOUtilisateur;
import entity.Utilisateur;
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
}
