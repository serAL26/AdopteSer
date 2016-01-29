package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTODeveloppeur;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBCatalogueDeveloppeur {
    private List<DTODeveloppeur> ListeDeveloppeur = new ArrayList<>();
    private List<NoDeveloppeur>listFiche = new ArrayList<>();
    private IUCPanier panier;

    @PostConstruct
    public void obtenirLesInterfaces(){
        panier = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ListeDeveloppeur = initListeDeveloppeur();
        listFiche = initFichesDeveloppeur();
    }

    public List<NoDeveloppeur> getListFiche() {
        return listFiche;
    }

    public void setListFiche(List<NoDeveloppeur> listFiche) {
        this.listFiche = listFiche;
    }

    public List<DTODeveloppeur> getListeDeveloppeur() {
        return ListeDeveloppeur;
    }

    public void setListeDeveloppeur(List<DTODeveloppeur> listeDeveloppeur) {
        ListeDeveloppeur = listeDeveloppeur;
    }
    private List<DTODeveloppeur> initListeDeveloppeur(){
        return panier.recupererTousLesDeveloppeurs();
    }

    private List<NoDeveloppeur>initFichesDeveloppeur(){
        return panier.recupererFicheResumeDeveloppeur();
    }
}
