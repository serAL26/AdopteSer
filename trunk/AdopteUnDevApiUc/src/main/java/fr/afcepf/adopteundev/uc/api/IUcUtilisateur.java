package fr.afcepf.adopteundev.uc.api;

import dto.DTOUtilisateur;

public interface IUcUtilisateur {
    DTOUtilisateur toConnect(String mail,String mdp);
}
