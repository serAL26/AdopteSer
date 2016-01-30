package fr.afcepf.adopteundev.ibusiness.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

import java.util.List;

public interface IBusinessPanier {
    List<DTODeveloppeur> recupererPanier();

    List<DTODeveloppeur> recupererTousLesDeveloppeurs();

    List<NoDeveloppeur> recupererFicheResumeDeveloppeur();

    void ajouterDeveloppeur(int idProjet, int idDeveloppeur);

    void retirerDeveloppeur(DTODeveloppeur developpeur);

    List<DTOProjet> recupererListProjetParUtilisateur(int idUtilisateur);
}
