package fr.afcepf.adopteundev.managedbean.panier;

import dto.DTODeveloppeur;
import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur.MBCatalogueDeveloppeur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.util.*;

@ManagedBean
@SessionScoped
public class MBPanier {
    IUCPanier panierUc;
    IUcUtilisateur ucUtilisateur;
    
    @ManagedProperty(value="#{mBCatalogueDeveloppeur}")
    private MBCatalogueDeveloppeur mBCatalogueDeveloppeur;
    
    private DTOProjet dtoProjet;
    private List<Integer> listProjet = new ArrayList<>();
    //private List<DTODeveloppeur>listeDeveloppeurDuProjet
    @PostConstruct
    public void init(){
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
        listProjet = initListProjet();
    }
    
    public String retirerDeveloppeurAuPanier(DTODeveloppeur developpeur) {
    	
        return "";
    }

    public List<NoDeveloppeur> obtenirListeDeveloppeurLieAuPanier(int idProjet){
    	Set<DTODeveloppeur> set = mBCatalogueDeveloppeur.getPanier().get(idProjet);
    	List<NoDeveloppeur> liste = new ArrayList<>();
    	for (DTODeveloppeur dtoDeveloppeur : set) {
			liste.add(ucUtilisateur.creerNoDeveloppeur(dtoDeveloppeur));
		}
        return liste;
    }

    private List<Integer> initListProjet() {
    	Set<Integer> set = mBCatalogueDeveloppeur.getPanier().keySet();
    	List<Integer> liste =  new ArrayList<>();
    	liste.addAll(set);
        return liste;
    }

    public IUCPanier getPanierUc() {
        return panierUc;
    }

    public void setPanierUc(IUCPanier panierUc) {
        this.panierUc = panierUc;
    }

	public List<Integer> getListProjet() {
		return listProjet;
	}

	public void setListProjet(List<Integer> listProjet) {
		this.listProjet = listProjet;
	}

	public DTOProjet getDtoProjet() {
		return dtoProjet;
	}
	public void setDtoProjet(DTOProjet dtoProjet) {
		this.dtoProjet = dtoProjet;
	}

	public MBCatalogueDeveloppeur getmBCatalogueDeveloppeur() {
		return mBCatalogueDeveloppeur;
	}

	public void setmBCatalogueDeveloppeur(MBCatalogueDeveloppeur mBCatalogueDeveloppeur) {
		this.mBCatalogueDeveloppeur = mBCatalogueDeveloppeur;
	}
	
}
