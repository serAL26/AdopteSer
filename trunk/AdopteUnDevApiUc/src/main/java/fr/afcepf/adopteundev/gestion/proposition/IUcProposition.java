package fr.afcepf.adopteundev.gestion.proposition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IUcProposition {
    DTOProposition recupPropositionValiderParProjet(Integer idProjet);
    void validerPanier(Map<Integer, Set<NoDeveloppeur>> map);
    public List<DTOProposition> recupPropositionParEtatParUtilisateur(String etat, Integer id); 
}
