package fr.afcepf.adopteundev.business.messagerie;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOMessage;
import dto.DTOUtilisateur;
import entity.Message;
import entity.Utilisateur;
import fr.afcepf.adopteundev.dto.nosobjets.NoMessage;
import fr.afcepf.adopteundev.ibusiness.messagerie.IBusinessMessagerie;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.messagerie.IDaoMessagerie;

@Remote(IBusinessMessagerie.class)
@Stateless
public class BusinessMessagerie implements IBusinessMessagerie{

	@EJB 
	private IDaoMessagerie daoMessagerie;
	@EJB
	private IDaoUtilisateur daoUtilisateur;

	@Override
	public DTOMessage creerNouveauFil(DTOMessage message) {
		Message messageEntity = daoMessagerie.creerNouveauFil(DTOToEntity.dtoMessageToMessage(message));
		return EntityToDTO.messageToDTOMessage(messageEntity);
	}

	@Override
	public List<DTOMessage> recupereTousLesMessMere(int idUtilisateur) {
		List<Message> listeMessage = daoMessagerie.recupereTousLesMessMere(idUtilisateur);
		return EntityToDTO.listeMessageToDTOMessage(listeMessage);
	}

	public List<NoMessage> creerListeNoMessageIncomplete (int idUtilisateur) {
		List<NoMessage> listeNoMessage = new ArrayList<>();
		List<DTOMessage> listeMessMere = recupereTousLesMessMere(idUtilisateur);
		for (DTOMessage dtoMessage : listeMessMere) {
			NoMessage noMessage = new NoMessage();
			noMessage.setListeMessageMere(new ArrayList<DTOMessage>());
			noMessage.setMecEnFace(trouveMecEnFace(idUtilisateur, dtoMessage));
			noMessage.getListeMessageMere().add(dtoMessage);
		}
		return listeNoMessage;
	}

	private DTOUtilisateur trouveMecEnFace(int idUtilisateur, DTOMessage dtoMessage) {
		Utilisateur mecEnFace;
		if(dtoMessage.getUtilisateur1().getIdUtilisateur() == idUtilisateur) {
			mecEnFace = daoUtilisateur.obtenirUtilisateurParId(dtoMessage.getUtilisateur2().getIdUtilisateur());
		}
		else {
			mecEnFace = daoUtilisateur.obtenirUtilisateurParId(dtoMessage.getUtilisateur1().getIdUtilisateur());
		}
		return EntityToDTO.utilisateurToDTOUtilisateur(mecEnFace);
	}
	
	
	public List<NoMessage> creerListeNoMessageComplete(int idUtilisateur, List<NoMessage> listeNonComplete) {
		List<NoMessage> listeComplete = new ArrayList<>();
		for (NoMessage noMessage : listeComplete) {
			boolean plusieursFilsAvecMemePersonne = false;
			for (NoMessage noMessageComplet : listeComplete) {
				if(noMessageComplet.getMecEnFace() == noMessage.getMecEnFace()) {
					plusieursFilsAvecMemePersonne = true;
					noMessageComplet.getListeMessageMere().add(noMessage.getListeMessageMere().get(0));
				}
			}
			if(!plusieursFilsAvecMemePersonne) {
				listeComplete.add(noMessage);
			}
		}
	return listeComplete;
	}

	@Override
	public List<NoMessage> creerListeNoMessage(int idUtilisateur) {
		List<NoMessage> listeNonComplete = creerListeNoMessageIncomplete(idUtilisateur);
		return creerListeNoMessageComplete(idUtilisateur, listeNonComplete);
	}

	@Override
	public DTOMessage ecrireUnNouveauMesssage(DTOMessage messageNouveau) {
		Message message = DTOToEntity.dtoMessageToMessage(messageNouveau);
		message = daoMessagerie.ecrireUnNouveauMesssage(message);
		daoMessagerie.majMessageMere(message);
		return EntityToDTO.messageToDTOMessage(message);
	}
}