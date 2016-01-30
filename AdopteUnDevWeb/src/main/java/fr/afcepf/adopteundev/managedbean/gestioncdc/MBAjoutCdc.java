package fr.afcepf.adopteundev.managedbean.gestioncdc;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBAjoutCdc {

	private String besoin;
	private String contexte;
	private String existant;
	private Date dateFin;
	private Double tarif;
	private Set<DTOTypeFonctionnalite> listTypeFonctionn;
	private DTOTypeFonctionnalite selectedTypeFonction;
	private Set<DTOFonctionnalite> listeFonctionnaliteCree;
	private DTOFonctionnalite fonctionnaliteCree;
	private DTOCdc cdc;

	private IUCGestionCdc gestionCdc;

	private IUCProjet gestionProjet;

	@PostConstruct
	private void obtenirLesInterfaces() {
		gestionCdc = (IUCGestionCdc) ContextFactory
				.createProxy(UcName.UCGESTIONCDC);
		gestionProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		listTypeFonctionn = gestionCdc.recupTousLesTypesFonctionnalites();
		setFonctionnaliteCree(new DTOFonctionnalite());
	}

	public Set<DTOFonctionnalite> getListeFonctionnaliteCree() {
		return listeFonctionnaliteCree;
	}

	public void setListeFonctionnaliteCree(
			Set<DTOFonctionnalite> listeFonctionnaliteCree) {
		this.listeFonctionnaliteCree = listeFonctionnaliteCree;
	}

	public DTOTypeFonctionnalite getSelectedTypeFonction() {
		return selectedTypeFonction;
	}

	public void setSelectedTypeFonction(
			DTOTypeFonctionnalite selectedTypeFonction) {
		this.selectedTypeFonction = selectedTypeFonction;
	}

	public Set<DTOTypeFonctionnalite> getListTypeFonctionn() {
		return listTypeFonctionn;
	}

	public void setListTypeFonctionn(
			Set<DTOTypeFonctionnalite> listTypeFonctionn) {
		this.listTypeFonctionn = listTypeFonctionn;
	}

	public String getBesoin() {
		return besoin;
	}

	public void setBesoin(String besoin) {
		this.besoin = besoin;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getExistant() {
		return existant;
	}

	public void setExistant(String existant) {
		this.existant = existant;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	public String ajouterCdc() {
		cdc = new DTOCdc(true, contexte, besoin, existant, tarif, dateFin);

		gestionCdc.ajouterCdcDto(cdc);

		return "";
	}

	public void ajouterFonctionnaliteSaisi() {
		if (listeFonctionnaliteCree == null)
			listeFonctionnaliteCree = new HashSet<>();
		if (fonctionnaliteCree != null){
			System.out.println(fonctionnaliteCree.getCommentaire());
			listeFonctionnaliteCree.add(fonctionnaliteCree);
		}
		
		
	}

	public DTOFonctionnalite getFonctionnaliteCree() {
		return fonctionnaliteCree;
	}

	public void setFonctionnaliteCree(DTOFonctionnalite fonctionnaliteCree) {
		this.fonctionnaliteCree = fonctionnaliteCree;
	}
}
