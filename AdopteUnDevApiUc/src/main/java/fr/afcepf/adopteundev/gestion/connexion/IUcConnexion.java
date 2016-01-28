package fr.afcepf.adopteundev.gestion.connexion;

import dto.DTOUtilisateur;

public interface IUcConnexion {
    DTOUtilisateur seConnecter(String mail, String mdp);
}
