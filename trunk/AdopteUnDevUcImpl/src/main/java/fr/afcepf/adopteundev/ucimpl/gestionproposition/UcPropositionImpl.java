package fr.afcepf.adopteundev.ucimpl.gestionproposition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.ibusiness.gestion.proposition.IBusinessProposition;

@Remote(IUcProposition.class)
@Stateless
public class UcPropositionImpl implements IUcProposition{

	
    @EJB
    private IBusinessProposition businessProposition;
    @Override
    public DTOProposition recupPropositionValiderParProjet(Integer idProjet) {
        return businessProposition.recupPropositionValiderParProjet(idProjet);
    }
	@Override
	public void validerPanier(Map<Integer, Set<NoDeveloppeur>> map) {
		businessProposition.validerPanier(map);
	}
	@Override
	public List<DTOProposition> recupPropositionParEtatParUtilisateur(
			String etat, Integer id) {
		return businessProposition.recupPropositionParEtatParUtilisateur(etat, id);
	}
	@Override
	public List<DTOProposition> recupPropositionNonLue(int idDeveloppeur) {
		return businessProposition.recupPropositionNonLue(idDeveloppeur);
	}
	@Override
	public void passerPropositionEnLue(int idProposition) {
		businessProposition.passerPropositionEnLue(idProposition);
	}
}
