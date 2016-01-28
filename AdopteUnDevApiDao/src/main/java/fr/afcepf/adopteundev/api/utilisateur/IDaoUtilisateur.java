package fr.afcepf.adopteundev.api.utilisateur;

import entity.Utilisateur;

public interface IDaoUtilisateur {
    Utilisateur seConnecter(String mail,String password);
}
