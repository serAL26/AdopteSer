package fr.afcepf.adopteundev.ibusiness.gestion.utilisateur;

import dto.DTODeveloppeur;

import java.util.List;

public interface IBusinessDeveloppeur {
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
}
