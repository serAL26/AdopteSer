package fr.afcepf.adopteundev.ucimpl.messagerie;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOMessage;
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
	
}
