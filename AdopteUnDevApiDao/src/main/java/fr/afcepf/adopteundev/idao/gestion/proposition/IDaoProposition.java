package fr.afcepf.adopteundev.idao.gestion.proposition;

import java.util.List;

import entity.Proposition;

public interface IDaoProposition {
    Proposition recupPropositionValiderParProjet(Integer idProjet);
    Proposition ajouterPropositionAuDev(Proposition proposition);
    List<Proposition> recupPropositionParEtatParIdClient(String etat, Integer id);
    List<Proposition> recupPropositionParEtatParIdDev(String etat, Integer id);
    List<Proposition> recupPropositionNonLue(int idDeveloppeur);
    List<Proposition> recupPropostionNonLueClient(int idClient);
    void passerPropositionEnLue(int idProposition);
}