package fr.afcepf.adopteundev.business.api;

import dto.DTOUtilisateur;

public interface IBusinessUtilisateur {
DTOUtilisateur connecterDtoUtilisateur(String mail,String mdp);
}
