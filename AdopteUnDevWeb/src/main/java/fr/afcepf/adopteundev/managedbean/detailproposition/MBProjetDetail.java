package fr.afcepf.adopteundev.managedbean.detailproposition;

import dto.DTOCdc;
import dto.DTODeveloppeur;
import dto.DTOProjet;
import dto.DTOProposition;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Set;

@ManagedBean
@SessionScoped
public class MBProjetDetail {
    private Logger log = Logger.getLogger(MBProjetDetail.class);
    private DTOProjet projet;
    private IUCProjet ucProjet;
    private IUCGestionCdc gestionCdc;
    private DTOCdc cdc;
    private DTOProposition proposition;
    private String tarifCdc;


    @PostConstruct
    private void init() {
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        projet = ucProjet.recupProjetById(2);
        cdc = getFinalCdc();
        tarifCdc = transformTarif(cdc);
        proposition = recupPropositionValiderParClient(projet.getIdProjet());
    }

    public DTOProposition recupPropositionValiderParClient(Integer idProjet) {
        return ;
    }

    public DTOCdc getFinalCdc(){
        return gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
    }

    public String transformTarif(DTOCdc cdc){
       return String.valueOf(cdc);
    }

    public DTOProjet getProjet() {
        return projet;
    }

    public DTODeveloppeur getDeveloppeur(){
        log.info("mbProjetDetail : In");
        Set<DTOProposition> propositionSet = projet.getLesProposition();
        log.info("mbProjetDetail : les propositions = "+ propositionSet);
        DTODeveloppeur dev = new DTODeveloppeur();
        if (propositionSet != null){
            for (DTOProposition proposition :
                    propositionSet) {
                if (proposition.getTypeProposition().getIdTypeProposition()==3){
                    dev = proposition.getDeveloppeur();
                }
            }
        }
        log.info("mbProjetDetail : getDeveloppeur = "+dev);
        return dev;
    }

    public void setProjet(DTOProjet projet) {
        this.projet = projet;
    }

    public DTOCdc getCdc() {
        return cdc;
    }

    public void setCdc(DTOCdc cdc) {
        this.cdc = cdc;
    }

    public String getTarifCdc() {
        return tarifCdc;
    }

    public void setTarifCdc(String tarifCdc) {
        this.tarifCdc = tarifCdc;
    }
}
