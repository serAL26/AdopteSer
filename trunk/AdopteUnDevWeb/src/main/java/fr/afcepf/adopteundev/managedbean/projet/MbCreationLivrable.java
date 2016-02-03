package fr.afcepf.adopteundev.managedbean.projet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTODeveloppeur;
import dto.DTOLivrable;
import dto.DTOOperation;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean(name = "mbCreerLivrable")
@SessionScoped
public class MbCreationLivrable {
	private String description;
	private DTODeveloppeur developpeur;
	private double montantOperation;
	private Date dateEcheance;
	private DTOLivrable livrablecree;
	private DTOOperation operation;
	private IUCProjet ucProjet;
	private List<DTOLivrable> listeLivrableCrees;

	@PostConstruct
	public void obtenirLesInterfaces() {
		ucProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		listeLivrableCrees = new ArrayList<>();
	}

	public String creerLivrable() {
		livrablecree = new DTOLivrable();
		livrablecree.setDescription(description);
		livrablecree.setEcheance(dateEcheance);
		operation = new DTOOperation();
		operation.setLivrable(livrablecree);
		operation.setMontant(montantOperation);
		ucProjet.creerOperationAttente(getOperation());
		listeLivrableCrees.add(livrablecree);
		return "";
	}

	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public DTOLivrable getLivrablecree() {
		return livrablecree;
	}

	public void setLivrablecree(DTOLivrable livrablecree) {
		this.livrablecree = livrablecree;
	}

	public DTOOperation getOperation() {
		return operation;
	}

	public void setOperation(DTOOperation operation) {
		this.operation = operation;
	}

	public List<DTOLivrable> getListeLivrableCrees() {
		return listeLivrableCrees;
	}

	public void setListeLivrableCrees(List<DTOLivrable> listeLivrableCrees) {
		this.listeLivrableCrees = listeLivrableCrees;
	}

}
