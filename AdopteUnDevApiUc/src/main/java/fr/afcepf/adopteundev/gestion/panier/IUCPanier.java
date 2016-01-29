package fr.afcepf.adopteundev.gestion.panier;

import dto.DTOProposition;

import java.util.List;

public interface IUCPanier {
    List<DTOProposition> recupererPanier();
    void ajouterProposition(DTOProposition proposition);
    void retirerProposition();
}
