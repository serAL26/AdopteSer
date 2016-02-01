package fr.afcepf.adopteundev.business.gestion.proposition;

import assembleur.EntityToDTO;
import dto.DTOProposition;
import entity.Proposition;
import fr.afcepf.adopteundev.ibusiness.gestion.proposition.IBusinessProposition;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoProposition;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessProposition.class)
@Stateless
public class BusinessPropositionImpl implements IBusinessProposition {
    private Logger log = Logger.getLogger(BusinessPropositionImpl.class);
    @EJB
    private IDaoProposition daoProposition;

    @Override
    public DTOProposition recupPropositionValiderParProjet(Integer idProjet) {
        log.info("BusinessPropositionImpl : In");
        log.info("BusinessPropositionImpl : idProjet = "+idProjet);
        Proposition proposition = daoProposition.recupPropositionValiderParProjet(idProjet);
        log.info("BusinessPropositionImpl : proposition = "+proposition.toString());
        return EntityToDTO.propositionToDTOProposition(proposition);
    }
}
