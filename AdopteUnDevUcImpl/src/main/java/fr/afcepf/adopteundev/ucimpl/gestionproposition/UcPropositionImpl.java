package fr.afcepf.adopteundev.ucimpl.gestionproposition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import dto.DTOProposition;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.ibusiness.gestion.proposition.IBusinessProposition;

import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IUcProposition.class)
@Stateless
public class UcPropositionImpl implements IUcProposition{
    private Logger log = Logger.getLogger(UcPropositionImpl.class);

    @EJB
    private IBusinessProposition businessProposition;
    @Override
    public DTOProposition recupPropositionValiderParProjet(Integer idProjet) {
        log.info("UCPropositionImpl : In");
        log.info("UCPropositionImpl : idProjet = "+idProjet);
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

}
