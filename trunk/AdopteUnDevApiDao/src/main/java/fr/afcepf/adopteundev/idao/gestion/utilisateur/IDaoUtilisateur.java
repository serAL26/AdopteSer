package fr.afcepf.adopteundev.idao.gestion.utilisateur;

import entity.Utilisateur;

public interface IDaoUtilisateur {
    Utilisateur seConnecter(String mail,String password);
}
