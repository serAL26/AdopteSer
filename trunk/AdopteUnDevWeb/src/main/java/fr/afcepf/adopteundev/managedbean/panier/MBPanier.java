package fr.afcepf.adopteundev.managedbean.panier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class MBPanier {
    IUCPanier panierUc;
    private Map<Integer, Set<DTODeveloppeur>> panier = new HashMap<>();
    private List<DTOProjet> listProjet = new ArrayList<>();
    //private List<DTODeveloppeur>listeDeveloppeurDuProjet
    @PostConstruct
    public void init(){
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        listProjet = initListProjet(16);
        panier = initPanier();

    }
    public String retirerDeveloppeurAuPanier(DTODeveloppeur developpeur) {
        panierUc.retirerDeveloppeur(developpeur);
        return "";
    }



    public Set<DTODeveloppeur> getListeDeveloppeurLieAuPanier(int idProjet){
        return panier.get(idProjet);
    }

    private List<DTOProjet> initListProjet(int idUtilisateur) {
        return panierUc.recupererListProjetParUtilisateur(idUtilisateur);
    }

    private Map<Integer, Set<DTODeveloppeur>> initPanier() {
        return panierUc.recupererPanier();
    }

    public IUCPanier getPanierUc() {
        return panierUc;
    }

    public void setPanierUc(IUCPanier panierUc) {
        this.panierUc = panierUc;
    }

    public Map<Integer, Set<DTODeveloppeur>> getPanier() {
        return panier;
    }

    public void setPanier(Map<Integer, Set<DTODeveloppeur>> panier) {
        this.panier = panier;
    }

    public List<DTOProjet> getListProjet() {
        return listProjet;
    }

    public void setListProjet(List<DTOProjet> listProjet) {
        this.listProjet = listProjet;
    }
}
