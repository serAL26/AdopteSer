package fr.afcepf.adopteundev.dto.nosobjets;

import java.io.Serializable;
import java.util.List;

import dto.DTOMessage;
import dto.DTOUtilisateur;

public class NoMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DTOMessage> listeMessageMere;
	private DTOUtilisateur mecEnFace;
	private boolean isLu;
	public DTOUtilisateur getMecEnFace() {
		return mecEnFace;
	}
	public void setMecEnFace(DTOUtilisateur mecEnFace) {
		this.mecEnFace = mecEnFace;
	}
	public List<DTOMessage> getListeMessageMere() {
		return listeMessageMere;
	}
	public void setListeMessageMere(List<DTOMessage> listeMessageMere) {
		this.listeMessageMere = listeMessageMere;
	}
	public boolean isLu() {
		return isLu;
	}
	public void setLu(boolean isLu) {
		this.isLu = isLu;
	}
}
