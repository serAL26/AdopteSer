package assembleur;

import dto.*;
import entity.*;

import java.util.HashSet;
import java.util.Set;

public class EntityToDTO {

    public static DTOAdresse adresseToDTOAdresse(Adresse adresse) {
        DTOAdresse dtoAdresse = new DTOAdresse();
        dtoAdresse.setIdAdresse(adresse.getIdAdresse());
        dtoAdresse.setNumero(adresse.getNumero());
        dtoAdresse.setRue(adresse.getRue());
        dtoAdresse.setVille(villeToDTOVille(adresse.getVille()));
        return dtoAdresse;
    }

    public static DTOAppli appliToDTOAppli(Appli appli) {
        DTOAppli dtoAppli = new DTOAppli();
        dtoAppli.setIdAppli(appli.getIdAppli());
        dtoAppli.setLesService(listServiceToDTOService(appli.getLesService()));
        dtoAppli.setProjet(projetToDTOProjet(appli.getProjet()));
        dtoAppli.setTypeAppli(typeAppliToDTOTypeAppli(appli.getTypeAppli()));
        return dtoAppli;
    }

    public static DTOAssociationCdcFonctionnalite associationCdcFonctionnaliteToDTOAssociationCdcFonctionnalite(AssociationCdcFonctionnalite associationCdcFonctionnalite) {
        DTOAssociationCdcFonctionnalite dTOAssociationCdcFonctionnalite = new DTOAssociationCdcFonctionnalite();
        dTOAssociationCdcFonctionnalite.setIdAssocCdcFonctionnalite(associationCdcFonctionnalite.getIdAssocCdcFonctionnalite());
        dTOAssociationCdcFonctionnalite.setCdc(cdcToDTOCdc(associationCdcFonctionnalite.getCdc()));
        dTOAssociationCdcFonctionnalite.setFonctionnalite(fonctionnaliteToDTOFonctionnalite(associationCdcFonctionnalite.getFonctionnalite()));
        return dTOAssociationCdcFonctionnalite;
    }

    public static DTOAssociationCdcTechnologie associationCdcTechnologieToDTOAssociationCdcTechnologie(AssociationCdcTechnologie associationCdcTechnologie) {
        DTOAssociationCdcTechnologie dTOAssociationCdcTechnologie = new DTOAssociationCdcTechnologie();
        dTOAssociationCdcTechnologie.setIdAssociationCdcTechnologie(associationCdcTechnologie.getIdAssociationCdcTechnologie());
        dTOAssociationCdcTechnologie.setCdc(cdcToDTOCdc(associationCdcTechnologie.getCdc()));
        dTOAssociationCdcTechnologie.setTechnologie(technologieToDTOTechnologie(associationCdcTechnologie.getTechnologie()));
        return dTOAssociationCdcTechnologie;
    }

    public static DTOAssociationDevTechno associationDevTechnoToDTOAssociationDevTechno(AssociationDevTechno associationDevTechno) {
        DTOAssociationDevTechno dTOAssociationDevTechno = new DTOAssociationDevTechno();
        dTOAssociationDevTechno.setIdAssociationDevTechno(associationDevTechno.getIdAssociationDevTechno());
        dTOAssociationDevTechno.setDeveloppeur(developpeurToDTODeveloppeur(associationDevTechno.getDeveloppeur()));
        dTOAssociationDevTechno.setTechnologie(technologieToDTOTechnologie(associationDevTechno.getTechnologie()));
        return dTOAssociationDevTechno;
    }

    public static DTOAssociationTechnoRep associationTechnoRepToDTOAssociationTechnoRep(AssociationTechnoRep associationTechnoRep) {
        DTOAssociationTechnoRep dTOAssociationTechnoRep = new DTOAssociationTechnoRep();
        dTOAssociationTechnoRep.setIdAssociationTechnoRep(associationTechnoRep.getIdAssociationTechnoRep());
        dTOAssociationTechnoRep.setReponse(reponsesPreDefiniesDTOReponsesPreDefinies(associationTechnoRep.getReponse()));
        dTOAssociationTechnoRep.setTechnologie(technologieToDTOTechnologie(associationTechnoRep.getTechnologie()));
        return dTOAssociationTechnoRep;
    }

    public static DTOCdc cdcToDTOCdc(Cdc cdc) {
        DTOCdc dtoCdc = new DTOCdc();
        dtoCdc.setIdCdc(cdc.getIdCdc());
        dtoCdc.setAssociationCdcTechnologie(listAssoCdcTechnologieToDtoAssoCdcTechno(cdc.getAssociationCdcTechnologie()));
        dtoCdc.setBesoin(cdc.getBesoin());
        dtoCdc.setContexte(cdc.getContexte());
        dtoCdc.setDateFinEstimee(cdc.getDateFinEstimee());
        dtoCdc.setExistant(cdc.getExistant());
        dtoCdc.setLesAssociationCdcFonctionnalite(listAssoCdcFonctionToDtoAssoCdcFonction(cdc.getLesAssociationCdcFonctionnalite()));
        dtoCdc.setProjet(projetToDTOProjet(cdc.getProjet()));
        dtoCdc.setTarif(cdc.getTarif());
        dtoCdc.setTypeCdc(typeCdcToDTOTypeCdc(cdc.getTypeCdc()));
        return dtoCdc;
    }

    public static DTOClient clientToDTOClient(Client client) {
        DTOClient dto = new DTOClient();
        // TODO voir comment ca marche niveau heritage
        dto.setIdUtilisateur(client.getIdUtilisateur());
        dto.setAdresse(adresseToDTOAdresse(client.getAdresse()));
        dto.setDateInscription(client.getDateInscription());
        dto.setFixe(client.getFixe());
        dto.setLesMessages1(listMessageToDtoMessage(client.getLesMessages1()));
        dto.setLesMessages2(listMessageToDtoMessage(client.getLesMessages2()));
        dto.setLesOperation(listOperationToDtoOperation(client.getLesOperation()));
        dto.setMail(client.getMail());
        dto.setMdp(client.getMdp());
        dto.setNom(client.getNom());
        dto.setPhoto(client.getPhoto());
        dto.setPortable(client.getPortable());
        dto.setPrenom(client.getPrenom());
        dto.setLesProjet(listProjetToDtoProjet(client.getLesProjet()));
        return dto;
    }

    public static DTODepartement departementToDTODepartement(Departement departement) {
        DTODepartement dTODepartement = new DTODepartement();
        dTODepartement.setIdDepartement(departement.getIdDepartement());
        dTODepartement.setNom(departement.getNom());
        dTODepartement.setNumero(departement.getNumero());
        return dTODepartement;
    }

    public static DTODeveloppeur developpeurToDTODeveloppeur(Developpeur developpeur) {
        DTODeveloppeur dto = new DTODeveloppeur();
        dto.setIdUtilisateur(developpeur.getIdUtilisateur());
        dto.setAdresse(adresseToDTOAdresse(developpeur.getAdresse()));
        dto.setDateInscription(developpeur.getDateInscription());
        dto.setFixe(developpeur.getFixe());
        dto.setLesMessages1(listMessageToDtoMessage(developpeur.getLesMessages1()));
        dto.setLesMessages2(listMessageToDtoMessage(developpeur.getLesMessages2()));
        dto.setLesOperation(listOperationToDtoOperation(developpeur.getLesOperation()));
        dto.setMail(developpeur.getMail());
        dto.setMdp(developpeur.getMdp());
        dto.setNom(developpeur.getNom());
        dto.setPhoto(developpeur.getPhoto());
        dto.setPortable(developpeur.getPortable());
        dto.setPrenom(developpeur.getPrenom());
        dto.setListeDispo(listDispoToDtoDispo(developpeur.getListeDispo()));
        dto.setListeProposition(listPropositionsToDtoPropositions(developpeur.getListeProposition()));
        dto.setLesAssociationDevTechno(listAssoDevTechno(developpeur.getLesAssociationDevTechno()));
        return dto;
    }

    public static DTODispo dispoToDTODispo(Dispo dispo) {
        DTODispo dTODispo = new DTODispo();
        dTODispo.setIdDispo(dispo.getIdDispo());
        dTODispo.setDebutDispo(dispo.getDebutDispo());
        dTODispo.setDeveloppeur(developpeurToDTODeveloppeur(dispo.getDeveloppeur()));
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

    public static DTOFonctionnalite fonctionnaliteToDTOFonctionnalite(Fonctionnalite fonctionnalite) {
        DTOFonctionnalite dTOFonctionnalite = new DTOFonctionnalite();
        dTOFonctionnalite.setIdFonctionnalite(fonctionnalite.getIdFonctionnalite());
        dTOFonctionnalite.setCommentaire(fonctionnalite.getCommentaire());
        // liste dTOFonctionnalite.setLesAssociationCdcFonctionnalite(lesAssociationCdcFonctionnalite);
        dTOFonctionnalite.setTypeFonctionnalite(typeFonctionnaliteToDTOTypeFonctionnalite(fonctionnalite.getTypeFonctionnalite()));
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
        dTOLivrable.setDateLivraison(livrable.getDateLivraison());
        dTOLivrable.setEcheance(livrable.getEcheance());
        dTOLivrable.setFichier(livrable.getFichier());
        dTOLivrable.setProjet(projetToDTOProjet(livrable.getProjet()));
        dTOLivrable.setTypeEvaluation(typeEvaluationToDTOTypeEvaluation(livrable.getTypeEvaluation()));
        return dTOLivrable;
    }

    public static DTOMessage messageToDTOMessage(Message message) {
        DTOMessage dTOMessage = new DTOMessage();
        dTOMessage.setIdMessage(message.getIdMessage());
        dTOMessage.setDateEnvoi(message.getDateEnvoi());
        dTOMessage.setMessage(message.getMessage());
        if (message.getMessFille() != null) {
            dTOMessage.setMessFille(messageToDTOMessage(message.getMessFille()));
        }
        if (message.getMessMere() != null) {
            dTOMessage.setMessMere(messageToDTOMessage(message.getMessMere()));
        }
        dTOMessage.setTitre(message.getTitre());
        dTOMessage.setUtilisateur1(utilisateurToDTOUtilisateur(message.getUtilisateur1()));
        dTOMessage.setUtilisateur2(utilisateurToDTOUtilisateur(message.getUtilisateur2()));
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
        dTOOperation.setTypeOperation(typeOperationToDTOTypeOperation(operation.getTypeOperation()));
        dTOOperation.setUtilisateur(utilisateurToDTOUtilisateur(operation.getUtilisateur()));
        return dTOOperation;
    }

    public static DTOProjet projetToDTOProjet(Projet projet) {
        DTOProjet dTOProjet = new DTOProjet();
        dTOProjet.setIdProjet(projet.getIdProjet());
        dTOProjet.setAppli(appliToDTOAppli(projet.getAppli()));
        dTOProjet.setClient(clientToDTOClient(projet.getClient()));
        dTOProjet.setEtatProjet(etatProjetToDTOEtatProjet(projet.getEtatProjet()));
        dTOProjet.setLesCdc(listCdcToDtoCdc(projet.getLesCdc()));
        dTOProjet.setLesLitige(listLitigesToDtoLitiges(projet.getLesLitige()));
        dTOProjet.setLesLivrable(listLivrableToDtoLivrable(projet.getLesLivrable()));
        dTOProjet.setLesNotes(listNotesToDtoNotes(projet.getLesNotes()));
        dTOProjet.setLesProposition(listPropositionsToDtoPropositions(projet.getLesProposition()));
        dTOProjet.setLibelle(projet.getLibelle());
        return dTOProjet;
    }

    public static DTOProposition propositionToDTOProposition(Proposition proposition) {
        DTOProposition dTOProposition = new DTOProposition();
        dTOProposition.setIdProposition(proposition.getIdProposition());
        dTOProposition.setDate(proposition.getDate());
        dTOProposition.setDeveloppeur(developpeurToDTODeveloppeur(proposition.getDeveloppeur()));
        dTOProposition.setLu(proposition.getLu());
        dTOProposition.setProjet(projetToDTOProjet(proposition.getProjet()));
        dTOProposition.setTitre(proposition.getTitre());
        dTOProposition.setTypeProposition(typePropositionToDTOTypeProposition(proposition.getTypeProposition()));
        return dTOProposition;
    }

    public static DTOQuestions questionsToDTOQuestions(Questions questions) {
        DTOQuestions dTOQuestions = new DTOQuestions();
        dTOQuestions.setIdQuestion(questions.getIdQuestion());
        // liste dTOQuestions.setLesReponses(lesReponses);
        dTOQuestions.setLibelle(questions.getLibelle());
        return dTOQuestions;
    }

    public static DTOReponsesPreDefinies reponsesPreDefiniesDTOReponsesPreDefinies(ReponsesPreDefinies reponsesPreDefinies) {
        DTOReponsesPreDefinies dTOReponsesPreDefinies = new DTOReponsesPreDefinies();
        dTOReponsesPreDefinies.setIdReponsesPreDefinies(reponsesPreDefinies.getIdReponsesPreDefinies());
        // liste dTOReponsesPreDefinies.setLesAssociationTechnoRep(lesAssociationTechnoRep);
        dTOReponsesPreDefinies.setLibelle(reponsesPreDefinies.getLibelle());
        dTOReponsesPreDefinies.setQuestion(questionsToDTOQuestions(reponsesPreDefinies.getQuestion()));
        return dTOReponsesPreDefinies;
    }

    public static DTOService serviceToDTOService(Service service) {
        DTOService dTOService = new DTOService();
        dTOService.setIdService(service.getIdService());
        dTOService.setAppli(appliToDTOAppli(service.getAppli()));
        dTOService.setTypeService(typeServiceToDTOTypeService(service.getTypeService()));
        return dTOService;
    }

    public static DTOTechnologie technologieToDTOTechnologie(Technologie technologie) {
        DTOTechnologie dTOTechnologie = new DTOTechnologie();
        dTOTechnologie.setIdTechnologie(technologie.getIdTechnologie());
        // liste dTOTechnologie.setLesAssociationCdcTechnologie(lesAssociationCdcTechnologie);
        // liste dTOTechnologie.setLesAssociationDevTechno(lesAssociationDevTechno);
        // liste dTOTechnologie.setLesAssociationTechnoRep(lesAssociationTechnoRep);
        dTOTechnologie.setTechnologie(technologie.getTechnologie());
        return dTOTechnologie;
    }

    public static DTOTypeAppli typeAppliToDTOTypeAppli(TypeAppli typeAppli) {
        DTOTypeAppli dTOTypeAppli = new DTOTypeAppli();
        dTOTypeAppli.setIdTypeAppli(typeAppli.getIdTypeAppli());
        dTOTypeAppli.setLibelle(typeAppli.getLibelle());
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

    public static DTOTypeEvaluation typeEvaluationToDTOTypeEvaluation(TypeEvaluation typeEvaluation) {
        DTOTypeEvaluation dTOTypeEvaluation = new DTOTypeEvaluation();
        dTOTypeEvaluation.setIdTypeEvaluation(typeEvaluation.getIdTypeEvaluation());
        return dTOTypeEvaluation;
    }

    public static DTOTypeFonctionnalite typeFonctionnaliteToDTOTypeFonctionnalite(TypeFonctionnalite typeFonctionnalite) {
        DTOTypeFonctionnalite dTOTypeFonctionnalite = new DTOTypeFonctionnalite();
        dTOTypeFonctionnalite.setIdTypeFonctionnalite(typeFonctionnalite.getIdTypeFonctionnalite());
        dTOTypeFonctionnalite.setLibelle(typeFonctionnalite.getLibelle());
        return dTOTypeFonctionnalite;
    }

    public static DTOTypeOperation typeOperationToDTOTypeOperation(TypeOperation typeOperation) {
        DTOTypeOperation dTOTypeOperation = new DTOTypeOperation();
        dTOTypeOperation.setIdTypeOperation(typeOperation.getIdTypeOperation());
        dTOTypeOperation.setLibelle(typeOperation.getLibelle());
        return dTOTypeOperation;
    }

    public static DTOTypeProposition typePropositionToDTOTypeProposition(TypeProposition typeProposition) {
        DTOTypeProposition dTOTypeProposition = new DTOTypeProposition();
        dTOTypeProposition.setIdTypeProposition(typeProposition.getIdTypeProposition());
        dTOTypeProposition.setLibelle(typeProposition.getLibelle());
        return dTOTypeProposition;
    }

    public static DTOTypeService typeServiceToDTOTypeService(TypeService typeService) {
        DTOTypeService dTOTypeService = new DTOTypeService();
        dTOTypeService.setIdTypeService(typeService.getIdTypeService());
        dTOTypeService.setLibelle(typeService.getLibelle());
        return dTOTypeService;
    }

    public static DTOUtilisateur utilisateurToDTOUtilisateur(Utilisateur utilisateur) {
        DTOUtilisateur dTOUtilisateur = new DTOUtilisateur();
        dTOUtilisateur.setIdUtilisateur(utilisateur.getIdUtilisateur());
        dTOUtilisateur.setAdresse(adresseToDTOAdresse(utilisateur.getAdresse()));
        dTOUtilisateur.setDateInscription(utilisateur.getDateInscription());
        dTOUtilisateur.setFixe(utilisateur.getFixe());
        dTOUtilisateur.setLesMessages1(listMessageToDtoMessage(utilisateur.getLesMessages1()));
        dTOUtilisateur.setLesMessages2(listMessageToDtoMessage(utilisateur.getLesMessages2()));
        dTOUtilisateur.setLesOperation(listOperationToDtoOperation(utilisateur.getLesOperation()));
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
        dTOVille.setDepartement(departementToDTODepartement(ville.getDepartement()));
        dTOVille.setNom(ville.getNom());
        return dTOVille;
    }

    public static Set<DTOService> listServiceToDTOService(Set<Service> listeService) {
        Set<DTOService> listeDtoServices = new HashSet<DTOService>();
        for (Service service : listeService) {
            listeDtoServices.add(serviceToDTOService(service));
        }
        return listeDtoServices;
    }

    private static Set<DTOAssociationCdcTechnologie> listAssoCdcTechnologieToDtoAssoCdcTechno(Set<AssociationCdcTechnologie> listEntity) {
        Set<DTOAssociationCdcTechnologie> listDto = new HashSet<DTOAssociationCdcTechnologie>();
        for (AssociationCdcTechnologie entity :
                listEntity) {
            listDto.add(associationCdcTechnologieToDTOAssociationCdcTechnologie(entity));
        }
        return listDto;
    }

    private static Set<DTOAssociationCdcFonctionnalite> listAssoCdcFonctionToDtoAssoCdcFonction(Set<AssociationCdcFonctionnalite> listEntity) {
        Set<DTOAssociationCdcFonctionnalite>listDto = new HashSet<DTOAssociationCdcFonctionnalite>();
        for (AssociationCdcFonctionnalite entity :
                listEntity) {
            listDto.add(associationCdcFonctionnaliteToDTOAssociationCdcFonctionnalite(entity));
        }
        return listDto;
    }

    private static Set<DTOProposition> listPropositionsToDtoPropositions(Set<Proposition> listEntity) {
        Set<DTOProposition>listDto = new HashSet<DTOProposition>();
        for (Proposition entity :
                listEntity) {
            listDto.add(propositionToDTOProposition(entity));
        }
        return listDto;
    }

    private static Set<DTONote> listNotesToDtoNotes(Set<Note> listEntity) {
        Set<DTONote>listDto = new HashSet<DTONote>();
        for (Note entity :
                listEntity) {
            listDto.add(noteToDTONote(entity));
        }
        return listDto;
    }

    private static Set<DTOLivrable> listLivrableToDtoLivrable(Set<Livrable> listEntity) {
        Set<DTOLivrable>listDto = new HashSet<DTOLivrable>();
        for (Livrable entity :
                listEntity) {
            listDto.add(livrableToDTOLivrable(entity));
        }
        return listDto;
    }

    private static Set<DTOLitige> listLitigesToDtoLitiges(Set<Litige> listEntity) {
        Set<DTOLitige>listDto = new HashSet<DTOLitige>();
        for (Litige entity :
                listEntity) {
            listDto.add(litigeToDTOLitige(entity));
        }
        return listDto;
    }

    private static Set<DTOCdc> listCdcToDtoCdc(Set<Cdc> listEntity) {
        Set<DTOCdc>listDto = new HashSet<DTOCdc>();
        for (Cdc entity :
                listEntity) {
            listDto.add(cdcToDTOCdc(entity));
        }
        return listDto;
    }

    private static Set<DTOOperation> listOperationToDtoOperation(Set<Operation> listEntity) {
        Set<DTOOperation>listDto = new HashSet<DTOOperation>();
        for (Operation entity:
                listEntity) {
            listDto.add(operationToDTOOperation(entity));
        }
        return listDto;
    }

    private static Set<DTOMessage> listMessageToDtoMessage(Set<Message> listEntity) {
        Set<DTOMessage>listDto = new HashSet<DTOMessage>();
        for (Message entity :
                listEntity) {
            listDto.add(messageToDTOMessage(entity));
        }
        return listDto;
    }

    private static Set<DTOAssociationDevTechno> listAssoDevTechno(Set<AssociationDevTechno> listEntity) {
        Set<DTOAssociationDevTechno>listDto = new HashSet<>();
        for (AssociationDevTechno entity :
                listEntity) {
            listDto.add(associationDevTechnoToDTOAssociationDevTechno(entity));
        }
        return listDto;
    }

    private static Set<DTODispo> listDispoToDtoDispo(Set<Dispo> listEntity) {
        Set<DTODispo>listDto = new HashSet<>();
        for (Dispo entity :
                listEntity) {
            listDto.add(dispoToDTODispo(entity));
        }
        return listDto;
    }

    private static Set<DTOProjet> listProjetToDtoProjet(Set<Projet> listEntity) {
        Set<DTOProjet>listDto = new HashSet<>();
        for (Projet entity :
                listEntity) {
            listDto.add(projetToDTOProjet(entity));
        }
        return listDto;
    }
}
