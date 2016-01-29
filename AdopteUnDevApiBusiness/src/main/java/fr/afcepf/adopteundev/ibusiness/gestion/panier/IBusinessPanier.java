package fr.afcepf.adopteundev.ibusiness.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProposition;

import java.util.List;

public interface IBusinessPanier {
    List<DTOProposition> recupererPanier();
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();

    void ajouterProposition(DTODeveloppeur developpeur);
    void retirerProposition(DTOProposition proposition);
}
