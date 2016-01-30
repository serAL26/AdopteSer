package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import dto.DTODeveloppeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

import java.util.List;

public interface IBusinessDeveloppeur {
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
    NoDeveloppeur creerNoDeveloppeur(DTODeveloppeur dtoDeveloppeur);
}
