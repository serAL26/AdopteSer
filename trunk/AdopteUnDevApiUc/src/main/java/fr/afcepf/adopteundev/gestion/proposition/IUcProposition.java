package fr.afcepf.adopteundev.gestion.proposition;

import dto.DTOProposition;

public interface IUcProposition {
    DTOProposition recupPropositionValiderParClient(Integer idProjet);
}