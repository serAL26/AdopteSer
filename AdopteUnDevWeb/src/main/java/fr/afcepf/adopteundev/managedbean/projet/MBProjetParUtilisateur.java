package fr.afcepf.adopteundev.managedbean.projet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTOClient;
import dto.DTOProjet;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

/**
 * @author Stagiaire
 */
@ManagedBean
@SessionScoped
public class MBProjetParUtilisateur {

    private List<DTOProjet> listeProjetsValide = new ArrayList<>();
    private List<DTOProjet> listeProjetsEnCours = new ArrayList<>();
    private List<DTOProjet> listeProjetsArrete = new ArrayList<>();
    private List<DTOProjet> listeProjetsEnAttente = new ArrayList<>();
    private DTOCdc cdc = new DTOCdc();
    private DTOProjet projet = new DTOProjet();

    private IUCProjet gestionProjet;
    private IUCGestionCdc gestionCdc;

    @ManagedProperty(value = "#{mBConnexion}")
    private MBConnexion mBConnexion;


    public List<DTOProjet> getListeProjetsValide() {
        return listeProjetsValide;
    }


    public void setListeProjetsValide(List<DTOProjet> listeProjetsValide) {
        this.listeProjetsValide = listeProjetsValide;
    }


    public List<DTOProjet> getListeProjetsEnCours() {
        return listeProjetsEnCours;
    }


    public void setListeProjetsEnCours(List<DTOProjet> listeProjetsEnCours) {
        this.listeProjetsEnCours = listeProjetsEnCours;
    }


    public List<DTOProjet> getListeProjetsArrete() {
        return listeProjetsArrete;
    }


    public void setListeProjetsArrete(List<DTOProjet> listeProjetsArrete) {
        this.listeProjetsArrete = listeProjetsArrete;
    }


    public MBConnexion getmBConnexion() {
        return mBConnexion;
    }


    public void setmBConnexion(MBConnexion mBConnexion) {
        this.mBConnexion = mBConnexion;
    }


    public List<DTOProjet> getListeProjetsEnAttente() {
        return listeProjetsEnAttente;
    }


    public void setListeProjetsEnAttente(List<DTOProjet> listeProjetsEnAttente) {
        this.listeProjetsEnAttente = listeProjetsEnAttente;
    }


    public DTOCdc getCdc() {
        return cdc;
    }


    public void setCdc(DTOCdc cdc) {
        this.cdc = cdc;
    }


    public DTOProjet getProjet() {
        return projet;
    }


    public void setProjet(DTOProjet projet) {
        this.projet = projet;
    }


    @PostConstruct
    public void init() {
        gestionProjet = (IUCProjet) ContextFactory
                .createProxy(UcName.UCGESTIONPROJET);
        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
        listeProjetsValide = gestionProjet.recupProjerParEtatParUtilisateur("Termine", mBConnexion.getUtilisateur().getIdUtilisateur());
        listeProjetsArrete = gestionProjet.recupProjerParEtatParUtilisateur("Arrete", mBConnexion.getUtilisateur().getIdUtilisateur());
        listeProjetsEnCours = gestionProjet.recupProjerParEtatParUtilisateur("Demarre", mBConnexion.getUtilisateur().getIdUtilisateur());
        listeProjetsEnAttente = gestionProjet.recupProjerParEtatParUtilisateur("En attente", mBConnexion.getUtilisateur().getIdUtilisateur());
    }

    public DTOCdc recupInfoCdc(DTOProjet projet) {
        cdc = gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
        return cdc;
    }

    public String recupProjet(DTOProjet proj) {
        projet = proj;
        
        return "/ProjetDetail.xhtml?faces-redirect=true";
    }

}
