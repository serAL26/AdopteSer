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
		return  EntityToDTO.listeMessageToDTOMessage(listeMessage);
	}

	@Override
	public List<NoMessage> creerListeNoMessage(int idUtilisateur) {
		List<NoMessage> listeNoMessage = new ArrayList<>();
		for (DTOMessage dtoMessage : recupereTousLesMessMere(idUtilisateur)) {
			NoMessage noMessage = new NoMessage();
			noMessage.setMecEnFace(trouveMecEnFace(idUtilisateur, dtoMessage));
			noMessage.setDtoMessage(dtoMessage);
			listeNoMessage.add(noMessage);
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
}
