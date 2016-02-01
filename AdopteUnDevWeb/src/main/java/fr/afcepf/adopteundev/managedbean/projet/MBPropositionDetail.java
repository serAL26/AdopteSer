package fr.afcepf.adopteundev.managedbean.projet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTOProjet;
import dto.DTOProposition;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBPropositionDetail {

	private IUCGestionCdc gestionCdc;
	private DTOCdc cdc;
	private IUCProjet ucProjet;

	@ManagedProperty(value="#{mBPropositionParUtilisateur}")
	private MBPropositionParUtilisateur mBPropositionParUtilisateur;

	@PostConstruct
	private void init() {
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
		gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
		//cdc = getFinalCdc();
	}

	public MBPropositionParUtilisateur getmBPropositionParUtilisateur() {
		return mBPropositionParUtilisateur;
	}

	public void setmBPropositionParUtilisateur(
			MBPropositionParUtilisateur mBPropositionParUtilisateur) {
		this.mBPropositionParUtilisateur = mBPropositionParUtilisateur;
	}
	
	
}
