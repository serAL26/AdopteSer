package fr.afcepf.adopteundev.managedbean.gestioncdc;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOProjet;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;
import enumeration.TypeCDC;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.projet.MBCreationProjet;
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
	private DTOTypeFonctionnalite selectedTypeFonction = new DTOTypeFonctionnalite();
	private Set<DTOFonctionnalite> listeFonctionnaliteCree = new HashSet<>();
	private DTOFonctionnalite fonctionnaliteCree = new DTOFonctionnalite();
	private DTOCdc cdc;
	private DTOProjet projet;
	@ManagedProperty(value = "#{mbCreationProjet}")
	MBCreationProjet beanProjet;

	private IUCGestionCdc gestionCdc;

	private IUCProjet gestionProjet;

	@PostConstruct
	private void obtenirLesInterfaces() {

		gestionCdc = (IUCGestionCdc) ContextFactory
				.createProxy(UcName.UCGESTIONCDC);
		gestionProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		setProjet(beanProjet.getProjetcree());
		listTypeFonctionn = gestionCdc.recupTousLesTypesFonctionnalites();
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

	public void ajouterFonctionnaliteSaisi(ActionEvent e) {
		System.out.println(selectedTypeFonction.getIdTypeFonctionnalite());
		if (listeFonctionnaliteCree == null)
			listeFonctionnaliteCree = new HashSet<>();
		if (fonctionnaliteCree != null) {
			fonctionnaliteCree.setTypeFonctionnalite(selectedTypeFonction);
			System.out.println(fonctionnaliteCree.getCommentaire());
			listeFonctionnaliteCree.add(fonctionnaliteCree);
		}

	}

	public String redirectAjouterFonctionnalite() {
		cdc = ajouterCDC();
		if (cdc.getIdCdc() != null)
			return "AjoutFonctionnalite.xhtml" + "?faces-redirect=true";
		return "";
	}

	private DTOCdc ajouterCDC() {
		cdc = new DTOCdc();
		cdc.setBesoin(besoin);
		cdc.setContexte(contexte);
		cdc.setDateFinEstimee(dateFin);
		cdc.setExistant(existant);
		cdc.setLu(true);
		cdc.setProjet(projet);
		cdc.setTarif(tarif);
		return gestionCdc.ajouterCdcDto(cdc);
	}

	public String creerCdc() {

		cdc = ajouterCDC();
		System.out.println(cdc.getIdCdc());
		if (cdc.getIdCdc() != null)
			return "Accueil.xhtml" + "?faces-redirect=true";
		return "";
	}

	public DTOFonctionnalite getFonctionnaliteCree() {
		return fonctionnaliteCree;
	}

	public void setFonctionnaliteCree(DTOFonctionnalite fonctionnaliteCree) {
		this.fonctionnaliteCree = fonctionnaliteCree;
	}

	public DTOProjet getProjet() {
		return projet;
	}

	public void setProjet(DTOProjet projet) {
		this.projet = projet;
	}

	public MBCreationProjet getBeanProjet() {
		return beanProjet;
	}

	public void setBeanProjet(MBCreationProjet beanProjet) {
		this.beanProjet = beanProjet;
	}

}
