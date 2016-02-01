package fr.afcepf.adopteundev.ibusiness.gestion.proposition;

import dto.DTOProposition;

public interface IBusinessProposition {
    DTOProposition recupPropositionValiderParProjet(Integer idProjet);
}
