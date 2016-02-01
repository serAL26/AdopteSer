package fr.afcepf.adopteundev.ibusiness.gestion.proposition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;

public interface IBusinessProposition {
    DTOProposition recupPropositionValiderParProjet(Integer idProjet);
    void validerPanier(Map<Integer, Set<NoDeveloppeur>>  map);
    List<DTOProposition> recupPropositionParEtatParUtilisateur(String etat, Integer id);
    List<DTOProposition> recupPropositionNonLue(int idDeveloppeur);
    void passerPropositionEnLue(int idProposition);
    List<DTOProposition> recupPropositionNonLueParClient(int idClient);
}
