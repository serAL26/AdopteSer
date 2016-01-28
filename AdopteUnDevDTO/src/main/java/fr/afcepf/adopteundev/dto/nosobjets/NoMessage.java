package fr.afcepf.adopteundev.dto.nosobjets;

import dto.DTOMessage;
import dto.DTOUtilisateur;

public class NoMessage {
	private DTOMessage dtoMessage;
	private DTOUtilisateur mecEnFace;
	public DTOMessage getDtoMessage() {
		return dtoMessage;
	}
	public void setDtoMessage(DTOMessage dtoMessage) {
		this.dtoMessage = dtoMessage;
	}
	public DTOUtilisateur getMecEnFace() {
		return mecEnFace;
	}
	public void setMecEnFace(DTOUtilisateur mecEnFace) {
		this.mecEnFace = mecEnFace;
	}

}
