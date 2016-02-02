package fr.afcepf.adopteundev.ucimpl.messagerie;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOMessage;
import fr.afcepf.adopteundev.dto.nosobjets.NoMessage;
import fr.afcepf.adopteundev.ibusiness.messagerie.IBusinessMessagerie;
import fr.afcepf.adopteundev.message.IUCMessage;

@Remote(IUCMessage.class)
@Stateless
public class UCMessage implements IUCMessage{

	@EJB
	private IBusinessMessagerie businessMessagerie;
	
	@Override
	public DTOMessage creerNouveauFil(DTOMessage messsage) {
		return businessMessagerie.creerNouveauFil(messsage);
	}

	@Override
	public List<DTOMessage> recupererTousLesMessMere(int idUtilisateur) {
		return businessMessagerie.recupereTousLesMessMere(idUtilisateur);
	}

	@Override
	public List<NoMessage> recupereNoMessage(int idUtilisateur) {
		return businessMessagerie.creerListeNoMessage(idUtilisateur);
	}

	@Override
	public DTOMessage ecrireUnNouveauMesssage(DTOMessage messageNouveau) {
		return businessMessagerie.ecrireUnNouveauMesssage(messageNouveau);
	}

	@Override
	public List<DTOMessage> recupererFilConversation(DTOMessage messMere, int idUtilisateur) {
		return businessMessagerie.recupererFilConversation(messMere, idUtilisateur);
	}

	@Override
	public DTOMessage majDuMessMere(DTOMessage messMere) {
		return businessMessagerie.majDuMessMere(messMere) ;
	}

	@Override
	public boolean dernierMessIsLu(DTOMessage messMere) {
		return businessMessagerie.dernierMessIsLu(messMere);
	}
	
}
