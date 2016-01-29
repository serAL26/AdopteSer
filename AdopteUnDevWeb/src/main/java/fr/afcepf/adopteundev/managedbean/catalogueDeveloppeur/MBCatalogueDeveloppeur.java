package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import dto.DTODeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class MBCatalogueDeveloppeur {
    private List<DTODeveloppeur> ListeDeveloppeur;
    private IUCPanier panier;
    private Double note;

    @PostConstruct
    public void obtenirLesInterfaces(){
        panier = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ListeDeveloppeur = initListeDeveloppeur();
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
}
