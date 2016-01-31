package fr.afcepf.adopteundev.managedbean.detailproposition;

import dto.DTOCdc;
import dto.DTOProjet;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private DTOProjet projet;
    private IUCProjet ucProjet;
    private IUCGestionCdc gestionCdc;


    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        projet = ucProjet.recupProjetById(2);
    }

    public DTOCdc getcdc(){
        return gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
    }

    public DTOProjet getProjet() {
        return projet;
    }

    public void setProjet(DTOProjet projet) {
        this.projet = projet;
    }
}
