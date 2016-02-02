package fr.afcepf.adopteundev.managedbean.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTODeveloppeur;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTypeCdc;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBPropositionDetail {

	private IUCGestionCdc gestionCdc;
	private IUCProjet ucProjet;
	private String besoinRemarque;
	private String contexteRemarque;
	private String existantRemarque;
	private String dateRemarque;
	private Double tarifRemarque;
	private boolean affichageModif = false;

	@ManagedProperty(value="#{mBPropositionParUtilisateur}")
	private MBPropositionParUtilisateur mBPropositionParUtilisateur;

	@PostConstruct
	private void init() {
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
		gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
		//cdc = getFinalCdc();
	}

	
	public boolean isAffichageModif() {
		return affichageModif;
	}


	public void setAffichageModif(boolean affichageModif) {
		this.affichageModif = affichageModif;
	}


	public MBPropositionParUtilisateur getmBPropositionParUtilisateur() {
		return mBPropositionParUtilisateur;
	}

	public void setmBPropositionParUtilisateur(
			MBPropositionParUtilisateur mBPropositionParUtilisateur) {
		this.mBPropositionParUtilisateur = mBPropositionParUtilisateur;
	}

	public String getBesoinRemarque() {
		return besoinRemarque;
	}

	public void setBesoinRemarque(String besoinRemarque) {
		this.besoinRemarque = besoinRemarque;
	}

	public String getContexteRemarque() {
		return contexteRemarque;
	}

	public void setContexteRemarque(String contexteRemarque) {
		this.contexteRemarque = contexteRemarque;
	}

	public String getExistantRemarque() {
		return existantRemarque;
	}

	public void setExistantRemarque(String existantRemarque) {
		this.existantRemarque = existantRemarque;
	}

	public String getDateRemarque() {
		return dateRemarque;
	}

	public void setDateRemarque(String dateRemarque) {
		this.dateRemarque = dateRemarque;
	}

	public Double getTarifRemarque() {
		return tarifRemarque;
	}

	public void setTarifRemarque(Double tarifRemarque) {
		this.tarifRemarque = tarifRemarque;
	}
	
	public String ajouterRemarque(DTOCdc cdc, DTOProjet projet, DTODeveloppeur developpeur)
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFinEstimee = null;
		try {
			dateFinEstimee = sdf.parse(dateRemarque);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		DTOCdc remarque = new DTOCdc(false, contexteRemarque, besoinRemarque, existantRemarque, tarifRemarque, dateFinEstimee, projet, developpeur, null, gestionCdc.recupTypeRemarque());
		
		gestionCdc.ajouterRemarqueCdcComplet(remarque, developpeur.getIdUtilisateur(), projet.getIdProjet());
		
		return "/ListePropositions.xhtml?faces-redirect=true";
	}
	
	public DTOCdc chargerDerniereRemarque(Integer idDev, Integer idProjet)
	{
		DTOCdc remarque = gestionCdc.recupDerniereRemarque(idDev, idProjet);
		
		return remarque;
	}
}
