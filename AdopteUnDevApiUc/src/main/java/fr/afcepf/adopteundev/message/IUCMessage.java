package fr.afcepf.adopteundev.message;

import java.util.List;

import dto.DTOMessage;
import fr.afcepf.adopteundev.dto.nosobjets.NoMessage;

public interface IUCMessage {
	DTOMessage creerNouveauFil(DTOMessage messsage);
	List<DTOMessage> recupererTousLesMessMere(int idUtilisateur);
	List<NoMessage> recupereNoMessage(int idUtilisateur);
	DTOMessage ecrireUnNouveauMesssage(DTOMessage messageNouveau);
	List<DTOMessage> recupererFilConversation(DTOMessage messMere);
	DTOMessage majDuMessMere(DTOMessage messMere);
}
