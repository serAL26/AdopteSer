package fr.afcepf.adopteundev.idao.gestion.proposition;

import entity.Proposition;

public interface IDaoProposition {
    Proposition recupPropositionValiderParClient(Integer idProjet);
}