package fr.afcepf.adopteundev.managedbean.panier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOProjet;
import fr.afcepf.adopteundev.dto.nosobjets.NoDeveloppeur;
import fr.afcepf.adopteundev.gestion.panier.IUCPanier;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur.MBCatalogueDeveloppeur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBPanier {
    IUCPanier panierUc;
    IUcUtilisateur ucUtilisateur;
    IUCProjet ucProjet;
    IUcProposition ucProposition;

    @ManagedProperty(value="#{mBCatalogueDeveloppeur}")
    private MBCatalogueDeveloppeur mBCatalogueDeveloppeur;

    private DTOProjet dtoProjet;
    private List<DTOProjet> listProjet = new ArrayList<>();
    private List<NoDeveloppeur> listNoDeveloppeur = new ArrayList<>();
		
    @PostConstruct
    public void init() {
        panierUc = (IUCPanier) ContextFactory.createProxy(UcName.UCGESTIONPANIER);
        ucUtilisateur = (IUcUtilisateur) ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
        ucProposition = (IUcProposition) ContextFactory.createProxy(UcName.UCGESTIONPROPOSITION);
        initListProjet();
    }

    public void validerPanier() {
    	ucProposition.validerPanier(mBCatalogueDeveloppeur.getPanier());
    	mBCatalogueDeveloppeur.setPanier(new HashMap<Integer, Set<NoDeveloppeur>>());
    }
    
    public String retirerDeveloppeurAuPanier(int idProjet,NoDeveloppeur developpeur) {
        Set<NoDeveloppeur> noDeveloppeurSet = mBCatalogueDeveloppeur.getPanier().get(idProjet);
        noDeveloppeurSet.remove(developpeur);
        Map<Integer,Set<NoDeveloppeur>> map = mBCatalogueDeveloppeur.getPanier();
        if (noDeveloppeurSet.size() ==0 ){
        	map.remove(idProjet);
        }
        else {
        map.put(idProjet,noDeveloppeurSet);
        }
        mBCatalogueDeveloppeur.setPanier(map);
        return "";
    }

    public List<NoDeveloppeur> obtenirListeDeveloppeurLieAuPanier(int idProjet){
    	Set<NoDeveloppeur> set = mBCatalogueDeveloppeur.getPanier().get(idProjet);
        listNoDeveloppeur = new ArrayList<>();
        for (NoDeveloppeur noDeveloppeur : set) {
            listNoDeveloppeur.add(noDeveloppeur);
        }
        return listNoDeveloppeur;
    }

    public int obtenirTotalDesDev() {
    	Map<Integer, Set<NoDeveloppeur>> map = mBCatalogueDeveloppeur.getPanier();
    	Set<Integer> set = map.keySet();
    	int nbTotal = 0;
    	for (Integer integer : set) {
			nbTotal += map.get(integer).size();
		}
    	return nbTotal;
    }

    public void initListProjet() {
    	Set<Integer> set = mBCatalogueDeveloppeur.getPanier().keySet();
    	listProjet =  new ArrayList<>();
    	for (Integer integer : set) {
			listProjet.add(ucProjet.recupProjetById(integer));
		}
    }

    public IUCPanier getPanierUc() {
        return panierUc;
    }

    public void setPanierUc(IUCPanier panierUc) {
        this.panierUc = panierUc;
    }

	public List<DTOProjet> getListProjet() {
		return listProjet;
	}

	public void setListProjet(List<DTOProjet> listProjet) {
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

	public List<NoDeveloppeur> getListNoDeveloppeur() {
		return listNoDeveloppeur;
	}

	public void setListNoDeveloppeur(List<NoDeveloppeur> listNoDeveloppeur) {
		this.listNoDeveloppeur = listNoDeveloppeur;
	}
    
}
