package fr.afcepf.adopteundev.ibusiness.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

import java.util.List;

public interface IBusinessPanier {
    List<DTOProposition> recupererPanier();
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
    List<NoDeveloppeur> recupererFicheResumeDeveloppeur();
    void ajouterProposition(DTODeveloppeur developpeur);
    void retirerProposition(DTOProposition proposition);
}
