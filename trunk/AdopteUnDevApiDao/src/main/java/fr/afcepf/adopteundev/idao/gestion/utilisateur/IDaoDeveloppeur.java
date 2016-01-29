package fr.afcepf.adopteundev.idao.gestion.utilisateur;

import entity.Developpeur;

import java.util.List;

/**
 * Created by Stagiaire on 29/01/2016.
 */
public interface IDaoDeveloppeur {
    List<Developpeur> recupererTousLesDeveloppeurs();
}
