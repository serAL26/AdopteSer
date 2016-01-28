package fr.afcepf.adopteundev.ucimpl.messagerie;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dto.DTOMessage;
import fr.afcepf.adopteundev.message.IUCMessage;

@Remote(IUCMessage.class)
@Stateless
public class UCMessage implements IUCMessage{

	@Override
	public DTOMessage creerNouveauFil(DTOMessage messsage) {
		return null;
	}
	
}
