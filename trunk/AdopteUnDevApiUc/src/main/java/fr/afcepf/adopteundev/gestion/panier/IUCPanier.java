package fr.afcepf.adopteundev.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProposition;
import dto.DTOUtilisateur;

import java.util.List;

public interface IUCPanier {
    List<DTOProposition> recupererPanier();
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
    void ajouterProposition(DTOProposition proposition);
    void retirerProposition(DTOProposition proposition);
}
