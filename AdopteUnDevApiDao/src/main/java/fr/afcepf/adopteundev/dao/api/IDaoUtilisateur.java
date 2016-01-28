package fr.afcepf.adopteundev.dao.api;

import entity.Utilisateur;

public interface IDaoUtilisateur {
    Utilisateur seConnecter(String mail,String password);
}
