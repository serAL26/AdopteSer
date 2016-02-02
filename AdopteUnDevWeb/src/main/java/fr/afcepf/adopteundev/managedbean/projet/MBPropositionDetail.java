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
import dto.DTOTypeProposition;
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
	
	private String besoinModif;
	private String contexteModif;
	private String existantModif;
	private String dateModif;
	private double tarifModif;
	private boolean paiement=false;
	
	@ManagedProperty(value="#{mBPropositionParUtilisateur}")
	private MBPropositionParUtilisateur mBPropositionParUtilisateur;

	@PostConstruct
	private void init() {
		ucProjet = (IUCProjet) ContextFactory.createProxy(UcName.UCGESTIONPROJET);
		gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
		//cdc = getFinalCdc();
	}

	
	
	
	public boolean isPaiement() {
		return paiement;
	}




	public void setPaiement(boolean paiement) {
		this.paiement = paiement;
	}




	public String getBesoinModif() {
		return besoinModif;
	}



	public void setBesoinModif(String besoinModif) {
		this.besoinModif = besoinModif;
	}



	public String getContexteModif() {
		return contexteModif;
	}



	public void setContexteModif(String contexteModif) {
		this.contexteModif = contexteModif;
	}



	public String getExistantModif() {
		return existantModif;
	}



	public void setExistantModif(String existantModif) {
		this.existantModif = existantModif;
	}



	public String getDateModif() {
		return dateModif;
	}



	public void setDateModif(String dateModif) {
		this.dateModif = dateModif;
	}

	public double getTarifModif() {
		return tarifModif;
	}



	public void setTarifModif(double tarifModif) {
		this.tarifModif = tarifModif;
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
	
	public void affichageModification(DTOCdc cdc)
	{
		besoinModif = cdc.getBesoin();
		contexteModif = cdc.getContexte();
		existantModif = cdc.getExistant();
		dateModif = cdc.getDateFinEstimee().toString().substring(0, 10);
		tarifModif = cdc.getTarif();
		affichageModif = true;
	}
	
	public void modificationCdc(DTOCdc cdc)
	{
			cdc.setBesoin(besoinModif);
			cdc.setContexte(contexteModif);
			cdc.setExistant(existantModif);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFinEstimee = null;
		try {
			dateFinEstimee = sdf.parse(dateModif);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			cdc.setDateFinEstimee(dateFinEstimee);
		cdc.setTarif(tarifModif);
		
		DTOCdc cdcDtp = new DTOCdc(cdc.getIdCdc(), false, cdc.getContexte(), cdc.getBesoin(), cdc.getExistant(), 
				cdc.getTarif(), cdc.getDateFinEstimee(), cdc.getProjet(), cdc.getTypeCdc());
		
		gestionCdc.modifierCdcDto(cdcDtp);		
	}
	
	public void accepterProposition(DTOProposition proposition)
	{
		List<DTOTypeProposition> listeType = ucProjet.recupTousLesTypesProps();
		
		proposition.setTypeProposition(listeType.get(1));
		ucProjet.modifierProposition(proposition);
	}
	
	public void refuserProposition(DTOProposition prop)
	{
		List<DTOTypeProposition> listeType = ucProjet.recupTousLesTypesProps();
		
		prop.setTypeProposition(listeType.get(4));
		ucProjet.modifierProposition(prop);
	}
	
	public void validerLeProjet(DTOProposition proposition)
	{
		//ucProjet.validerProjet(proposition, proposition.projet.getIdProjet());
		paiement=true;
	}
	
	
}
