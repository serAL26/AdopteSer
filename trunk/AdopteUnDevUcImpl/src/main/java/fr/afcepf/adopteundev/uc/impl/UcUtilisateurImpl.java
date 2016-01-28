package fr.afcepf.adopteundev.uc.impl;

import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.business.api.IBusinessUtilisateur;
import fr.afcepf.adopteundev.uc.api.IUcUtilisateur;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class UcUtilisateurImpl implements IUcUtilisateur{
    private IBusinessUtilisateur businessUtilisateur;
    @Override
    public DTOUtilisateur toConnect(String mail, String mdp) {
        return businessUtilisateur.connecterDtoUtilisateur(mail, mdp);
    }
}
