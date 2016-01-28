package fr.afcepf.adopteundev.business.impl;

import assembleur.EntityToDTO;
import dto.DTOUtilisateur;
import entity.Utilisateur;
import fr.afcepf.adopteundev.dao.api.IDaoUtilisateur;
import fr.afcepf.adopteundev.business.api.IBusinessUtilisateur;

import javax.ejb.Stateless;

@Stateless
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {
    private IDaoUtilisateur daoUtilisateur;

    @Override
    public DTOUtilisateur connecterDtoUtilisateur(String mail, String mdp) {
        Utilisateur utilisateur = daoUtilisateur.seConnecter(mail, mdp);
        return EntityToDTO.utilisateurToDTOUtilisateur(utilisateur);
    }
}
