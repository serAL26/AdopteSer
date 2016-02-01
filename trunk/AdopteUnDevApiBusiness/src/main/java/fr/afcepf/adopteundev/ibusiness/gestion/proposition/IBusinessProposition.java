package fr.afcepf.adopteundev.ibusiness.gestion.proposition;

import java.util.Map;
import java.util.Set;

import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IBusinessProposition {
    DTOProposition recupPropositionValiderParProjet(Integer idProjet);
    void validerPanier(Map<Integer, Set<NoDeveloppeur>>  map);
}
