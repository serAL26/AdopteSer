package assembleur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dto.DTOAdresse;
import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOAssociationDevTechno;
import dto.DTOCdc;
import dto.DTOClient;
import dto.DTODepartement;
import dto.DTODeveloppeur;
import dto.DTODispo;
import dto.DTOEtatProjet;
import dto.DTOFonctionnalite;
import dto.DTOLitige;
import dto.DTOLivrable;
import dto.DTOMessage;
import dto.DTONote;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTechnologie;
import dto.DTOTypeAppli;
import dto.DTOTypeCdc;
import dto.DTOTypeDispo;
import dto.DTOTypeEvaluation;
import dto.DTOTypeFonctionnalite;
import dto.DTOTypeOperation;
import dto.DTOTypeProposition;
import dto.DTOTypeService;
import dto.DTOUtilisateur;
import dto.DTOVille;
import entity.Adresse;
import entity.AssociationCdcFonctionnalite;
import entity.AssociationDevTechno;
import entity.Cdc;
import entity.Client;
import entity.Departement;
import entity.Developpeur;
import entity.Dispo;
import entity.EtatProjet;
import entity.Fonctionnalite;
import entity.Litige;
import entity.Livrable;
import entity.Message;
import entity.Note;
import entity.Operation;
import entity.Projet;
import entity.Proposition;
import entity.Technologie;
import entity.TypeAppli;
import entity.TypeCdc;
import entity.TypeDispo;
import entity.TypeEvaluation;
import entity.TypeFonctionnalite;
import entity.TypeOperation;
import entity.TypeProposition;
import entity.TypeService;
import entity.Utilisateur;
import entity.Ville;

public class EntityToDTO {

	public static DTOAdresse adresseToDTOAdresse(Adresse adresse) {
		DTOAdresse dtoAdresse = new DTOAdresse();
		dtoAdresse.setIdAdresse(adresse.getIdAdresse());
		dtoAdresse.setNumero(adresse.getNumero());
		dtoAdresse.setRue(adresse.getRue());
		dtoAdresse.setVille(villeToDTOVille(adresse.getVille()));
		return dtoAdresse;
	}

	public static DTOAssociationCdcFonctionnalite associationCdcFonctionnaliteToDTOAssociationCdcFonctionnalite(
			AssociationCdcFonctionnalite associationCdcFonctionnalite) {
		DTOAssociationCdcFonctionnalite dTOAssociationCdcFonctionnalite = new DTOAssociationCdcFonctionnalite();
		dTOAssociationCdcFonctionnalite
				.setIdAssocCdcFonctionnalite(associationCdcFonctionnalite
						.getIdAssocCdcFonctionnalite());
		dTOAssociationCdcFonctionnalite
				.setCdc(cdcToDTOCdc(associationCdcFonctionnalite.getCdc()));
		dTOAssociationCdcFonctionnalite
				.setFonctionnalite(fonctionnaliteToDTOFonctionnalite(associationCdcFonctionnalite
						.getFonctionnalite()));
		return dTOAssociationCdcFonctionnalite;
	}

	public static DTOAssociationDevTechno associationDevTechnoToDTOAssociationDevTechno(
			AssociationDevTechno associationDevTechno) {
		DTOAssociationDevTechno dTOAssociationDevTechno = new DTOAssociationDevTechno();
		dTOAssociationDevTechno.setIdAssociationDevTechno(associationDevTechno
				.getIdAssociationDevTechno());
		dTOAssociationDevTechno
				.setDeveloppeur(developpeurToDTODeveloppeur(associationDevTechno
						.getDeveloppeur()));
		dTOAssociationDevTechno
				.setTechnologie(technologieToDTOTechnologie(associationDevTechno
						.getTechnologie()));
		return dTOAssociationDevTechno;
	}

	public static DTOCdc cdcToDTOCdc(Cdc cdc) {
		DTOCdc dtoCdc = new DTOCdc();
		dtoCdc.setIdCdc(cdc.getIdCdc());
		dtoCdc.setBesoin(cdc.getBesoin());
		dtoCdc.setContexte(cdc.getContexte());
		dtoCdc.setDateFinEstimee(cdc.getDateFinEstimee());
		dtoCdc.setExistant(cdc.getExistant());
		// dtoCdc.setLesAssociationCdcFonctionnalite(listAssoCdcFonctionToDtoAssoCdcFonction(cdc.getLesAssociationCdcFonctionnalite()));
		dtoCdc.setProjet(projetToDTOProjet(cdc.getProjet()));
		dtoCdc.setTarif(cdc.getTarif());
		dtoCdc.setLu(cdc.getLu());
		dtoCdc.setTypeCdc(typeCdcToDTOTypeCdc(cdc.getTypeCdc()));
		if (cdc.getDeveloppeurCdc() !=null)
        {
			dtoCdc.setDeveloppeur(developpeurToDTODeveloppeur(cdc.getDeveloppeurCdc()));
        }
		return dtoCdc;
	}

	public static DTOClient clientToDTOClient(Client client) {
		DTOClient dto = new DTOClient();
		// TODO voir comment ca marche niveau heritage
		dto.setIdUtilisateur(client.getIdUtilisateur());
		dto.setAdresse(adresseToDTOAdresse(client.getAdresse()));
		dto.setDateInscription(client.getDateInscription());
		dto.setFixe(client.getFixe());
		// dto.setLesMessages1(listMessageToDtoMessage(client.getLesMessages1()));
		// dto.setLesMessages2(listMessageToDtoMessage(client.getLesMessages2()));
		dto.setMail(client.getMail());
		dto.setMdp(client.getMdp());
		dto.setNom(client.getNom());
		dto.setPhoto(client.getPhoto());
		dto.setPortable(client.getPortable());
		dto.setPrenom(client.getPrenom());
		// dto.setLesProjet(listProjetToDtoProjet(client.getLesProjet()));
		return dto;
	}

	public static DTODepartement departementToDTODepartement(
			Departement departement) {
		DTODepartement dTODepartement = new DTODepartement();
		dTODepartement.setIdDepartement(departement.getIdDepartement());
		dTODepartement.setNom(departement.getNom());
		dTODepartement.setNumero(departement.getNumero());
		return dTODepartement;
	}

	public static DTODeveloppeur developpeurToDTODeveloppeur(
			Developpeur developpeur) {
		DTODeveloppeur dto = new DTODeveloppeur();
		dto.setIdUtilisateur(developpeur.getIdUtilisateur());
		dto.setAdresse(adresseToDTOAdresse(developpeur.getAdresse()));
		dto.setDateInscription(developpeur.getDateInscription());
		dto.setFixe(developpeur.getFixe());
		// dto.setLesMessages1(listMessageToDtoMessage(developpeur.getLesMessages1()));
		// dto.setLesMessages2(listMessageToDtoMessage(developpeur.getLesMessages2()));
		dto.setMail(developpeur.getMail());
		dto.setMdp(developpeur.getMdp());
		dto.setNom(developpeur.getNom());
		dto.setPhoto(developpeur.getPhoto());
		dto.setPortable(developpeur.getPortable());
		dto.setPrenom(developpeur.getPrenom());
		// dto.setListeDispo(listDispoToDtoDispo(developpeur.getListeDispo()));
		// dto.setListeProposition(listPropositionsToDtoPropositions(developpeur.getListeProposition()));
		// dto.setLesAssociationDevTechno(listAssoDevTechno(developpeur.getLesAssociationDevTechno()));
		return dto;
	}

	public static DTODispo dispoToDTODispo(Dispo dispo) {
		DTODispo dTODispo = new DTODispo();
		dTODispo.setIdDispo(dispo.getIdDispo());
		dTODispo.setDebutDispo(dispo.getDebutDispo());
		dTODispo.setDeveloppeur(developpeurToDTODeveloppeur(dispo
				.getDeveloppeur()));
		dTODispo.setFinDispo(dispo.getFinDispo());
		dTODispo.setTypeDispo(typeDispoToDTOTypeDispo(dispo.getTypeDispo()));
		return dTODispo;
	}

	public static DTOEtatProjet etatProjetToDTOEtatProjet(EtatProjet etatProjet) {
		DTOEtatProjet dTOEtatProjet = new DTOEtatProjet();
		dTOEtatProjet.setIdEtatProjet(etatProjet.getIdEtatProjet());
		dTOEtatProjet.setLibelle(etatProjet.getLibelle());
		return dTOEtatProjet;
	}

	public static DTOFonctionnalite fonctionnaliteToDTOFonctionnalite(
			Fonctionnalite fonctionnalite) {
		DTOFonctionnalite dTOFonctionnalite = new DTOFonctionnalite();
		dTOFonctionnalite.setIdFonctionnalite(fonctionnalite
				.getIdFonctionnalite());
		dTOFonctionnalite.setCommentaire(fonctionnalite.getCommentaire());
		// liste
		// dTOFonctionnalite.setLesAssociationCdcFonctionnalite(lesAssociationCdcFonctionnalite);
		dTOFonctionnalite
				.setTypeFonctionnalite(typeFonctionnaliteToDTOTypeFonctionnalite(fonctionnalite
						.getTypeFonctionnalite()));
		return dTOFonctionnalite;
	}

	public static DTOLitige litigeToDTOLitige(Litige litige) {
		DTOLitige dTOLitige = new DTOLitige();
		dTOLitige.setIdLitige(litige.getIdLitige());
		dTOLitige.setLibelle(litige.getLibelle());
		dTOLitige.setMotif(litige.getMotif());
		dTOLitige.setProjet(projetToDTOProjet(litige.getProjet()));
		return dTOLitige;
	}

	public static DTOLivrable livrableToDTOLivrable(Livrable livrable) {
		DTOLivrable dTOLivrable = new DTOLivrable();
		dTOLivrable.setIdLivrable(livrable.getIdLivrable());
		dTOLivrable.setDescription(livrable.getDescription());
		if(livrable.getDateLivraison()!= null) {
		dTOLivrable.setDateLivraison(livrable.getDateLivraison());
		}
		if(livrable.getEcheance()!= null) {
		dTOLivrable.setEcheance(livrable.getEcheance());
		}
		dTOLivrable.setFichier(livrable.getFichier());
		dTOLivrable.setProjet(projetToDTOProjet(livrable.getProjet()));
		dTOLivrable
				.setTypeEvaluation(typeEvaluationToDTOTypeEvaluation(livrable
						.getTypeEvaluation()));
		// dTOLivrable.setLesOperation(listOperationToDtoOperation(livrable.getLesOperation()));
		return dTOLivrable;
	}

	public static DTOMessage messageToDTOMessage(Message message) {
		DTOMessage dTOMessage = new DTOMessage();
		dTOMessage.setIdMessage(message.getIdMessage());
		dTOMessage.setLu(message.isLu());
		dTOMessage.setDateEnvoi(message.getDateEnvoi());
		dTOMessage.setMessage(message.getMessage());
		if (message.getMessFille() != null) {
			dTOMessage.setMessFille(messageToDTOMessage(message.getMessFille()));
		}
		
		dTOMessage.setTitre(message.getTitre());
		dTOMessage.setUtilisateur1(utilisateurToDTOUtilisateur(message
				.getUtilisateur1()));
		dTOMessage.setUtilisateur2(utilisateurToDTOUtilisateur(message
				.getUtilisateur2()));
		return dTOMessage;
	}

	public static DTONote noteToDTONote(Note note) {
		DTONote dTONote = new DTONote();
		dTONote.setIdNote(note.getIdNote());
		dTONote.setCommentaire(note.getCommentaire());
		dTONote.setDate(note.getDate());
		dTONote.setIdEstNote(note.getIdEstNote());
		dTONote.setIdNoteur(note.getIdNoteur());
		dTONote.setNote(note.getNote());
		dTONote.setProjet(projetToDTOProjet(note.getProjet()));
		return dTONote;
	}

	public static DTOOperation operationToDTOOperation(Operation operation) {
		DTOOperation dTOOperation = new DTOOperation();
		dTOOperation.setIdOperation(operation.getIdOperation());
		dTOOperation.setDate(operation.getDate());
		dTOOperation.setMontant(operation.getMontant());
		dTOOperation.setTypeOperation(typeOperationToDTOTypeOperation(operation
				.getTypeOperation()));
		dTOOperation
				.setLivrable(livrableToDTOLivrable(operation.getLivrable()));
		return dTOOperation;
	}

	public static DTOProjet projetToDTOProjet(Projet projet) {
		DTOProjet dTOProjet = new DTOProjet();
		dTOProjet.setIdProjet(projet.getIdProjet());
		if (projet.getPhoto() != null){
			dTOProjet.setPhoto(projet.getPhoto());
		}
		dTOProjet.setClient(clientToDTOClient(projet.getClient()));
		dTOProjet.setEtatProjet(etatProjetToDTOEtatProjet(projet
				.getEtatProjet()));
		// dTOProjet.setLesCdc(listCdcToDtoCdc(projet.getLesCdc()));
		// dTOProjet.setLesLitige(listLitigesToDtoLitiges(projet.getLesLitige()));
		// dTOProjet.setLesLivrable(listLivrableToDtoLivrable(projet.getLesLivrable()));
		// dTOProjet.setLesNotes(listNotesToDtoNotes(projet.getLesNotes()));
		// dTOProjet.setLesProposition(listPropositionsToDtoPropositions(projet.getLesProposition()));
		dTOProjet.setLibelle(projet.getLibelle());
		dTOProjet.setService(typeServiceToDTOTypeService(projet.getService()));
		// dTOProjet.setLesServices(listTypeServToDtoTypeServ(projet.getLesServices()));
		return dTOProjet;
	}

	public static Set<DTOTypeService> listTypeServToDtoTypeServ(
			Set<TypeService> listEntity) {
		Set<DTOTypeService> listDto = new HashSet<DTOTypeService>();
		for (TypeService entity : listEntity) {
			listDto.add(typeServiceToDTOTypeService(entity));
		}
		return listDto;
	}

	public static Set<DTOTypeFonctionnalite> listTypeFonctionToDtoTypeFonction(
			Set<TypeFonctionnalite> listEntity) {
		Set<DTOTypeFonctionnalite> listDto = new HashSet<DTOTypeFonctionnalite>();
		for (TypeFonctionnalite entity : listEntity) {
			listDto.add(typeFonctionnaliteToDTOTypeFonctionnalite(entity));
		}
		return listDto;
	}

	public static DTOProposition propositionToDTOProposition(
			Proposition proposition) {
		DTOProposition dTOProposition = new DTOProposition();
		dTOProposition.setIdProposition(proposition.getIdProposition());
		dTOProposition.setDate(proposition.getDate());
		dTOProposition.setDeveloppeur(developpeurToDTODeveloppeur(proposition
				.getDeveloppeur()));
		dTOProposition.setLu(proposition.getLu());
		dTOProposition.setProjet(projetToDTOProjet(proposition.getProjet()));
		dTOProposition.setTitre(proposition.getTitre());
		dTOProposition.setTypeProposition(typePropositionToDTOTypeProposition(proposition
						.getTypeProposition()));
		return dTOProposition;
	}

	public static DTOTechnologie technologieToDTOTechnologie(
			Technologie technologie) {
		DTOTechnologie dTOTechnologie = new DTOTechnologie();
		dTOTechnologie.setIdTechnologie(technologie.getIdTechnologie());
		// liste
		// dTOTechnologie.setLesAssociationCdcTechnologie(lesAssociationCdcTechnologie);
		// liste
		// dTOTechnologie.setLesAssociationDevTechno(lesAssociationDevTechno);
		// liste
		// dTOTechnologie.setLesAssociationTechnoRep(lesAssociationTechnoRep);
		dTOTechnologie.setTechnologieLibelle(technologie
				.getTechnologieLibelle());

		return dTOTechnologie;
	}

	public static DTOTypeAppli typeAppliToDTOTypeAppli(TypeAppli typeAppli) {
		DTOTypeAppli dTOTypeAppli = new DTOTypeAppli();
		dTOTypeAppli.setIdTypeAppli(typeAppli.getIdTypeAppli());
		dTOTypeAppli.setLibelle(typeAppli.getLibelle());
		dTOTypeAppli.setLesServices(listTypeServToDtoTypeServ(typeAppli
				.getLesServices()));
		return dTOTypeAppli;
	}

	public static DTOTypeCdc typeCdcToDTOTypeCdc(TypeCdc typeCdc) {
		DTOTypeCdc dTOTypeCdc = new DTOTypeCdc();
		dTOTypeCdc.setIdTypeCdc(typeCdc.getIdTypeCdc());
		dTOTypeCdc.setLibelle(typeCdc.getLibelle());
		return dTOTypeCdc;
	}

	public static DTOTypeDispo typeDispoToDTOTypeDispo(TypeDispo typeDispo) {
		DTOTypeDispo dTOTypeDispo = new DTOTypeDispo();
		dTOTypeDispo.setIdTypeDispo(typeDispo.getIdTypeDispo());
		dTOTypeDispo.setLibelle(typeDispo.getLibelle());
		return dTOTypeDispo;
	}

	public static DTOTypeEvaluation typeEvaluationToDTOTypeEvaluation(
			TypeEvaluation typeEvaluation) {
		DTOTypeEvaluation dTOTypeEvaluation = new DTOTypeEvaluation();
		dTOTypeEvaluation.setIdTypeEvaluation(typeEvaluation
				.getIdTypeEvaluation());
		return dTOTypeEvaluation;
	}

	public static DTOTypeFonctionnalite typeFonctionnaliteToDTOTypeFonctionnalite(
			TypeFonctionnalite typeFonctionnalite) {
		DTOTypeFonctionnalite dTOTypeFonctionnalite = new DTOTypeFonctionnalite();
		dTOTypeFonctionnalite.setIdTypeFonctionnalite(typeFonctionnalite
				.getIdTypeFonctionnalite());
		dTOTypeFonctionnalite.setLibelle(typeFonctionnalite.getLibelle());
		return dTOTypeFonctionnalite;
	}

	public static DTOTypeOperation typeOperationToDTOTypeOperation(
			TypeOperation typeOperation) {
		DTOTypeOperation dTOTypeOperation = new DTOTypeOperation();
		dTOTypeOperation.setIdTypeOperation(typeOperation.getIdTypeOperation());
		dTOTypeOperation.setLibelle(typeOperation.getLibelle());
		return dTOTypeOperation;
	}

	public static DTOTypeProposition typePropositionToDTOTypeProposition(
			TypeProposition typeProposition) {
		DTOTypeProposition dTOTypeProposition = new DTOTypeProposition();
		dTOTypeProposition.setIdTypeProposition(typeProposition
				.getIdTypeProposition());
		dTOTypeProposition.setLibelle(typeProposition.getLibelle());
		return dTOTypeProposition;
	}

	public static DTOTypeService typeServiceToDTOTypeService(
			TypeService typeService) {
		DTOTypeService dTOTypeService = new DTOTypeService();
		dTOTypeService.setIdTypeService(typeService.getIdTypeService());
		dTOTypeService.setLibelle(typeService.getLibelle());
		return dTOTypeService;
	}

	public static DTOUtilisateur utilisateurToDTOUtilisateur(
			Utilisateur utilisateur) {
		DTOUtilisateur dTOUtilisateur = new DTOUtilisateur();
		dTOUtilisateur.setIdUtilisateur(utilisateur.getIdUtilisateur());
		dTOUtilisateur
				.setAdresse(adresseToDTOAdresse(utilisateur.getAdresse()));
		dTOUtilisateur.setDateInscription(utilisateur.getDateInscription());
		dTOUtilisateur.setFixe(utilisateur.getFixe());
		// dTOUtilisateur.setLesMessages1(listMessageToDtoMessage(utilisateur.getLesMessages1()));
		// dTOUtilisateur.setLesMessages2(listMessageToDtoMessage(utilisateur.getLesMessages2()));
		dTOUtilisateur.setMail(utilisateur.getMail());
		dTOUtilisateur.setMdp(utilisateur.getMdp());
		dTOUtilisateur.setNom(utilisateur.getNom());
		dTOUtilisateur.setPhoto(utilisateur.getPhoto());
		dTOUtilisateur.setPortable(utilisateur.getPortable());
		dTOUtilisateur.setPrenom(utilisateur.getPrenom());
		return dTOUtilisateur;
	}

	public static DTOVille villeToDTOVille(Ville ville) {
		DTOVille dTOVille = new DTOVille();
		dTOVille.setIdVille(ville.getIdVille());
		dTOVille.setCp(ville.getCp());
		dTOVille.setDepartement(departementToDTODepartement(ville
				.getDepartement()));
		dTOVille.setNom(ville.getNom());
		return dTOVille;
	}

	private static Set<DTOAssociationCdcFonctionnalite> listAssoCdcFonctionToDtoAssoCdcFonction(
			Set<AssociationCdcFonctionnalite> listEntity) {
		Set<DTOAssociationCdcFonctionnalite> listDto = new HashSet<DTOAssociationCdcFonctionnalite>();
		for (AssociationCdcFonctionnalite entity : listEntity) {
			listDto.add(associationCdcFonctionnaliteToDTOAssociationCdcFonctionnalite(entity));
		}
		return listDto;
	}

	private static Set<DTOProposition> listPropositionsToDtoPropositions(
			Set<Proposition> listEntity) {
		Set<DTOProposition> listDto = new HashSet<DTOProposition>();
		for (Proposition entity : listEntity) {
			listDto.add(propositionToDTOProposition(entity));
		}
		return listDto;
	}

	private static Set<DTONote> listNotesToDtoNotes(Set<Note> listEntity) {
		Set<DTONote> listDto = new HashSet<DTONote>();
		for (Note entity : listEntity) {
			listDto.add(noteToDTONote(entity));
		}
		return listDto;
	}

	private static Set<DTOLivrable> listLivrableToDtoLivrable(
			Set<Livrable> listEntity) {
		Set<DTOLivrable> listDto = new HashSet<DTOLivrable>();
		for (Livrable entity : listEntity) {
			listDto.add(livrableToDTOLivrable(entity));
		}
		return listDto;
	}

	private static Set<DTOLitige> listLitigesToDtoLitiges(Set<Litige> listEntity) {
		Set<DTOLitige> listDto = new HashSet<DTOLitige>();
		for (Litige entity : listEntity) {
			listDto.add(litigeToDTOLitige(entity));
		}
		return listDto;
	}

	private static Set<DTOCdc> listCdcToDtoCdc(Set<Cdc> listEntity) {
		Set<DTOCdc> listDto = new HashSet<DTOCdc>();
		for (Cdc entity : listEntity) {
			listDto.add(cdcToDTOCdc(entity));
		}
		return listDto;
	}

	private static Set<DTOOperation> listOperationToDtoOperation(
			Set<Operation> listEntity) {
		Set<DTOOperation> listDto = new HashSet<DTOOperation>();
		for (Operation entity : listEntity) {
			listDto.add(operationToDTOOperation(entity));
		}
		return listDto;
	}

	private static Set<DTOMessage> listMessageToDtoMessage(
			Set<Message> listEntity) {
		Set<DTOMessage> listDto = new HashSet<DTOMessage>();
		for (Message entity : listEntity) {
			listDto.add(messageToDTOMessage(entity));
		}
		return listDto;
	}

	public static List<DTOMessage> listeMessageToDTOMessage(
			List<Message> listeMessage) {
		List<DTOMessage> listeDTOMessage = new ArrayList<>();
		for (Message message : listeMessage) {
			listeDTOMessage.add(messageToDTOMessage(message));
		}
		return listeDTOMessage;
	}

	private static Set<DTOAssociationDevTechno> listAssoDevTechno(
			Set<AssociationDevTechno> listEntity) {
		Set<DTOAssociationDevTechno> listDto = new HashSet<>();
		for (AssociationDevTechno entity : listEntity) {
			listDto.add(associationDevTechnoToDTOAssociationDevTechno(entity));
		}
		return listDto;
	}

	private static Set<DTODispo> listDispoToDtoDispo(Set<Dispo> listEntity) {
		Set<DTODispo> listDto = new HashSet<>();
		for (Dispo entity : listEntity) {
			listDto.add(dispoToDTODispo(entity));
		}
		return listDto;
	}

	public static Set<DTOTypeAppli> listTypeAppliotoDTOtypeAppli(
			Set<TypeAppli> set) {
		Set<DTOTypeAppli> listDto = new HashSet<>();
		for (TypeAppli entity : set) {
			listDto.add(typeAppliToDTOTypeAppli((entity)));
		}
		return listDto;
	}

	public static Set<DTOFonctionnalite> listFonctionnalitetoDTOfonctionnalite(
			Set<Fonctionnalite> set) {
		Set<DTOFonctionnalite> listDto = new HashSet<>();
		for (Fonctionnalite entity : set) {
			listDto.add(fonctionnaliteToDTOFonctionnalite(entity));
		}
		return listDto;
	}
	public static List<DTOFonctionnalite> listFonctionnalitetoDTOfonctionnalite(
			List<Fonctionnalite> set) {
		List<DTOFonctionnalite> listDto = new ArrayList<>();
		for (Fonctionnalite entity : set) {
			listDto.add(fonctionnaliteToDTOFonctionnalite(entity));
		}
		return listDto;
	}
	
	public static List<DTODeveloppeur> listDevtoDTODeveloppeur(
			List<Developpeur> set) {
		List<DTODeveloppeur> listDto = new ArrayList<>();
		for (Developpeur entity : set) {
			listDto.add(developpeurToDTODeveloppeur((entity)));
		}
		return listDto;
	}

	private static Set<DTOProjet> listProjetToDtoProjet(Set<Projet> listEntity) {
		Set<DTOProjet> listDto = new HashSet<>();
		for (Projet entity : listEntity) {
			listDto.add(projetToDTOProjet(entity));
		}
		return listDto;
	}

	public static List<DTOProjet> listeProjetToDtoProjet(
			List<Projet> listeProjet) {
		List<DTOProjet> listeDTO = new ArrayList<>();
		for (Projet projet : listeProjet) {
			listeDTO.add(projetToDTOProjet(projet));
		}
		return listeDTO;
	}
	
	public static List<DTOProposition> listePropositionToDtoProposition(List<Proposition> listeProposition) {
		List<DTOProposition> listeDTOProposition = new ArrayList<>();
		for (Proposition proposition : listeProposition) {
			listeDTOProposition.add(EntityToDTO.propositionToDTOProposition(proposition));
		}
		return listeDTOProposition;
	}
	
	public static List<DTOTechnologie> listeTechnologieToDTOTechnologie(List<Technologie> listeTechnologie) {
		List<DTOTechnologie> listeDTOTechnologie = new ArrayList<>();
		for (Technologie technologie : listeTechnologie) {
			listeDTOTechnologie.add(technologieToDTOTechnologie(technologie));
		}
		return listeDTOTechnologie;
	}

	public static List<DTOLivrable> listeLivrableToDTOLivrable(List<Livrable> listeLivrable) {
		List<DTOLivrable> listeDTOLivrable = new ArrayList<>();
		for (Livrable livrable : listeLivrable) {
			listeDTOLivrable.add(livrableToDTOLivrable(livrable));
		}
		return listeDTOLivrable;
	}
	
	public static List<DTOOperation> listeOperationToDTOOperation (List<Operation> listeOperation) {
		List<DTOOperation> listeDTOOperation = new ArrayList<>();
		for (Operation operation : listeOperation) {
			listeDTOOperation.add(operationToDTOOperation(operation));
		}
		return listeDTOOperation;
	}
	public static List<DTONote> listeNoteToDTONote(List<Note> listeNote) {
		List<DTONote> listeDTONote = new ArrayList<>();
		for (Note note : listeNote) {
			listeDTONote.add(noteToDTONote(note));
		}
		return listeDTONote;
	}
}
