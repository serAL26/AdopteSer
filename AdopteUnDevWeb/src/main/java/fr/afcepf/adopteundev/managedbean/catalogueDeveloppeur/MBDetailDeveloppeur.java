package fr.afcepf.adopteundev.managedbean.catalogueDeveloppeur;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOClient;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.utilisateur.IUcUtilisateur;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBDetailDeveloppeur {
	
	 private IUCGestionCdc gestionCdc;
	 private IUCProjet ucProjet;
	 private boolean contacterDev = false;
	 private IUcUtilisateur ucUtilisateur;
	 private DTOClient client;
	
	  @ManagedProperty(value="#{mBCatalogueDeveloppeur}")
	    private MBCatalogueDeveloppeur mBCatalogueDeveloppeur;
	  
	    @PostConstruct
	    private void init() {
	        ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
	        gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);  
	        ucUtilisateur = (IUcUtilisateur)ContextFactory.createProxy(UcName.UCGESTIONUTILISATEUR);
	    }

		public MBCatalogueDeveloppeur getmBCatalogueDeveloppeur() {
			return mBCatalogueDeveloppeur;
		}

		public void setmBCatalogueDeveloppeur(
				MBCatalogueDeveloppeur mBCatalogueDeveloppeur) {
			this.mBCatalogueDeveloppeur = mBCatalogueDeveloppeur;
		}
		
		public DTOClient recupClientParId(Integer id)
		{
			client = ucUtilisateur.recupClientById(id);
			return client;
			
		}

		public boolean isContacterDev() {
			return contacterDev;
		}

		public void setContacterDev(boolean contacterDev) {
			this.contacterDev = contacterDev;
		}
}
