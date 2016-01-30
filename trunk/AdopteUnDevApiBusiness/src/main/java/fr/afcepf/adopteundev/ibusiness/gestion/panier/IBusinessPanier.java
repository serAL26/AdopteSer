package fr.afcepf.adopteundev.ibusiness.gestion.panier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IBusinessPanier {

    List<DTODeveloppeur> recupererTousLesDeveloppeurs();

    List<NoDeveloppeur> recupererFicheResumeDeveloppeur();

    Map<Integer,Set<DTODeveloppeur>> recupererPanier();

    void ajouterDeveloppeur(int idProjet, int idDeveloppeur);

    void retirerDeveloppeur(DTODeveloppeur developpeur);

    List<DTOProjet> recupererListProjetParUtilisateur(int idUtilisateur);
}
