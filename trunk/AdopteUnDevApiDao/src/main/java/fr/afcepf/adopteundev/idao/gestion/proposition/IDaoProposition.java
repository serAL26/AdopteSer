package fr.afcepf.adopteundev.idao.gestion.proposition;

import entity.Proposition;

public interface IDaoProposition {
    Proposition recupPropositionValiderParProjet(Integer idProjet);
    Proposition ajouterPropositionAuDev(Proposition proposition);
}