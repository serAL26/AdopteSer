package fr.afcepf.adopteundev.message;

import java.util.List;

import dto.DTOMessage;

public interface IUCMessage {
	DTOMessage creerNouveauFil(DTOMessage messsage);
	List<DTOMessage> recupererTousLesMessMere(int idUtilisateur);
	
}
