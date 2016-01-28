package fr.afcepf.adopteundev.business.gestion.utilisateur;

import assembleur.EntityToDTO;
import dto.DTOUtilisateur;
import entity.Utilisateur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.ibusiness.gestion.utilisateur.IBusinessUtilisateur;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {
    private IDaoUtilisateur daoUtilisateur;

    @Override
    public DTOUtilisateur connecterDtoUtilisateur(String mail, String mdp) {
        Utilisateur utilisateur = daoUtilisateur.seConnecter(mail, mdp);
        return EntityToDTO.utilisateurToDTOUtilisateur(utilisateur);
    }
}
