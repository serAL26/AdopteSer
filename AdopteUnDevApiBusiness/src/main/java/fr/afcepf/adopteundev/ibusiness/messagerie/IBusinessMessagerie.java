package fr.afcepf.adopteundev.ibusiness.messagerie;

import java.util.List;

import dto.DTOMessage;
import fr.afcepf.adopteundev.dto.nosobjets.NoMessage;

public interface IBusinessMessagerie {
	DTOMessage creerNouveauFil(DTOMessage message);
	List<DTOMessage> recupereTousLesMessMere(int idUtilisateur);
	List<NoMessage> creerListeNoMessage(int idUtilisateur);
	DTOMessage ecrireUnNouveauMesssage(DTOMessage messageNouveau);
	List<DTOMessage> recupererFilConversation(DTOMessage messMere, int idUtilisateur);
	DTOMessage majDuMessMere(DTOMessage message);
	boolean dernierMessIsLu(DTOMessage dtoMessage);
}
