package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOProjet;
import dto.DTOTypeCdc;
import dto.DTOTypeFonctionnalite;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

/**
 * @author Stagiaire
 *
 */
/**
 * @author Stagiaire
 *
 */
@ManagedBean
@SessionScoped
public class test {

	private String besoin;
	private String contexte;
	private String existant;
	private String dateFin;
	private Double tarif;
	private DTOFonctionnalite fonctionnalite;
	private DTOTypeCdc typeCdc;
	private String commentaire;
	private List<DTOFonctionnalite> listeFonct = new ArrayList<>();

	private DTOCdc cdc;
	private Set<DTOTypeFonctionnalite> listetypefonct;
	private DTOTypeFonctionnalite typefonct;


	private IUCGestionCdc gestionCdc;

	private IUCProjet gestionProjet;

	@PostConstruct
	private void obtenirLesInterfaces() {
		gestionCdc = (IUCGestionCdc) ContextFactory.createProxy(UcName.UCGESTIONCDC);
		gestionProjet = (IUCProjet)ContextFactory.createProxy(UcName.UCGESTIONPROJET);

		listetypefonct = gestionCdc.recupTousLesTypesFonctionnalites();
		typefonct = new DTOTypeFonctionnalite();
	}


	public DTOFonctionnalite getFonctionnalite() {
		return fonctionnalite;
	}


	public void setFonctionnalite(DTOFonctionnalite fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
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

	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
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


	public Set<DTOTypeFonctionnalite> getListetypefonct() {
		return listetypefonct;
	}

	public void setListetypefonct(Set<DTOTypeFonctionnalite> listetypefonct) {
		this.listetypefonct = listetypefonct;
	}


	public DTOTypeFonctionnalite getTypefonct() {
		return typefonct;
	}

	public void setTypefonct(DTOTypeFonctionnalite typefonct) {
		this.typefonct = typefonct;
	}


	public DTOTypeCdc getTypeCdc() {
		return typeCdc;
	}


	public void setTypeCdc(DTOTypeCdc typeCdc) {
		this.typeCdc = typeCdc;
	}



	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public List<DTOFonctionnalite> getListeFonct() {
		return listeFonct;
	}


	public void setListeFonct(List<DTOFonctionnalite> listeFonct) {
		this.listeFonct = listeFonct;
	}


	public void ajouterCdc()
	{

		List<DTOProjet> liste = gestionProjet.recupProjetParIdClient(17);
		List<DTOTypeCdc> listeCdc = gestionCdc.recupTousLesTypeCdc();

		//cdc = new DTOCdc(true, contexte, besoin, existant, tarif, dateFin, null, null);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFinEstimee = null;
		try {
			dateFinEstimee = sdf.parse(dateFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdc = new DTOCdc(true, contexte, besoin, existant, tarif, dateFinEstimee, liste.get(1), listeCdc.get(1));

		//cdc = gestionCdc.ajouterCdcDto(cdc);

		gestionCdc.ajouterAssociationFonctCdcComplet(cdc, listeFonct);
	}

	public void test()
	{
		List<DTOProjet> liste = gestionProjet.recupProjetParIdClient(17);
	}

	public void test2()
	{
		Set<DTOTypeFonctionnalite> liste = gestionCdc.recupTousLesTypesFonctionnalites();
		System.out.println("Taille de la liste dans le MB" + liste.size());
	}

	public void ajoutF()
	{
		fonctionnalite = new DTOFonctionnalite(commentaire, typefonct);
		listeFonct.add(fonctionnalite);
		//fonctionnalite = gestionCdc.ajouterFonctionnalite(fonctionnalite);
	}

	public void ajoutA()
	{
		DTOAssociationCdcFonctionnalite dtoAssociation = new DTOAssociationCdcFonctionnalite(cdc, fonctionnalite);
		
		gestionCdc.ajouterAssociationCdcFonctionnalite(dtoAssociation);
	}
}
