package fr.afcepf.adopteundev.ucimpl.gestionproposition;

import dto.DTOProposition;
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
    public DTOProposition recupPropositionValiderParClient(Integer idProjet) {
        return businessProposition.recupPropositionValiderParClient(idProjet);
    }
}
