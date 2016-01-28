package fr.afcepf.adopteundev.business.api;

import dto.DTOUtilisateur;

public interface BusinessUtilisateurApi {
DTOUtilisateur seConnecter(String mail,String mdp);
}
