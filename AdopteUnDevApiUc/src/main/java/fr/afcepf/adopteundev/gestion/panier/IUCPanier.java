package fr.afcepf.adopteundev.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProposition;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

import java.util.List;

public interface IUCPanier {
    List<DTOProposition> recupererPanier();
    List<DTODeveloppeur> recupererTousLesDeveloppeurs();
    List<NoDeveloppeur> recupererFicheResumeDeveloppeur();
    void ajouterProposition(DTOProposition proposition);
    void retirerProposition(DTOProposition proposition);
}
