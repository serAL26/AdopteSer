package fr.afcepf.adopteundev.dto.nosobjets;

import java.io.Serializable;

import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOLivrable;

public class NoLivrable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DTOLivrable livrable;
	private DTOClient client;
	private DTODeveloppeur developpeur;
	private int montant;
	public DTOLivrable getLivrable() {
		return livrable;
	}
	public void setLivrable(DTOLivrable livrable) {
		this.livrable = livrable;
	}
	public DTOClient getClient() {
		return client;
	}
	public void setClient(DTOClient client) {
		this.client = client;
	}
	public DTODeveloppeur getDeveloppeur() {
		return developpeur;
	}
	public void setDeveloppeur(DTODeveloppeur developpeur) {
		this.developpeur = developpeur;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
}
