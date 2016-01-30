package assembleur;

import dto.*;
import entity.*;

import java.util.HashSet;
import java.util.Set;

public class DTOToEntity {

    public static AssociationCdcFonctionnalite dtoAssociationCdcFonctionnaliteToAssociationCdcFonctionnalite(DTOAssociationCdcFonctionnalite dtoAssociationCdcFonctionnalite) {
        AssociationCdcFonctionnalite associationCdcFonctionnalite = new AssociationCdcFonctionnalite();
        associationCdcFonctionnalite.setIdAssocCdcFonctionnalite(dtoAssociationCdcFonctionnalite.getIdAssocCdcFonctionnalite());
        associationCdcFonctionnalite.setCdc(dtoCdcToCdc(dtoAssociationCdcFonctionnalite.getCdc()));
        associationCdcFonctionnalite.setFonctionnalite(dtoFonctionnaliteToFonctionnalite(dtoAssociationCdcFonctionnalite.getFonctionnalite()));
        return associationCdcFonctionnalite;
    }



    public static AssociationDevTechno dtoAssociationDevTechnoToAssociationDevTechno(DTOAssociationDevTechno dto) {
        AssociationDevTechno entity = new AssociationDevTechno();
        entity.setIdAssociationDevTechno(dto.getIdAssociationDevTechno());
        entity.setDeveloppeur(dtoDeveloppeurToDeveloppeur(dto.getDeveloppeur()));
        entity.setTechnologie(dtoTechnologieToTechnologie(dto.getTechnologie()));
        return entity;
    }
    
    public static AssociationTypeServiceTechno dtoAssociationTypeServTechnoToAssociationTypeServTechno(DTOAssociationTypeServiceTechno dto) {
    	AssociationTypeServiceTechno entity = new AssociationTypeServiceTechno();
    	entity.setIdAssociationTypeServiceTechno(dto.getIdAssociationTypeServiceTechno());
    	entity.setTechnologie(dtoTechnologieToTechnologie(dto.getTechnologie()));
    	entity.setTypeService(dtoTypeServiceToTypeService(dto.getTypeService()));
        return entity;
    }

    public static Adresse dtoAdresseToAdresse(DTOAdresse dtoAdresse) {
        Adresse adresse = new Adresse();
        adresse.setIdAdresse(dtoAdresse.getIdAdresse());
        adresse.setNumero(dtoAdresse.getNumero());
        adresse.setRue(dtoAdresse.getRue());
        adresse.setVille(dtoVilleToVille(dtoAdresse.getVille()));
        return adresse;
    }

    public static Departement dtoDepartementToDepartement(DTODepartement dtoDepartement) {
        Departement departement = new Departement();
        departement.setIdDepartement(dtoDepartement.getIdDepartement());
        departement.setNom(dtoDepartement.getNom());
        departement.setNumero(dtoDepartement.getNumero());
        return departement;
    }

    public static Ville dtoVilleToVille(DTOVille dtoVille) {
        Ville ville = new Ville();
        ville.setIdVille(dtoVille.getIdVille());
        ville.setNom(dtoVille.getNom());
        ville.setCp(dtoVille.getCp());
        ville.setDepartement(dtoDepartementToDepartement(dtoVille.getDepartement()));
        return ville;
    }

  

    public static Fonctionnalite dtoFonctionnaliteToFonctionnalite(DTOFonctionnalite dtoFonctionnalite) {
        Fonctionnalite fonctionnalite = new Fonctionnalite();
        fonctionnalite.setIdFonctionnalite(dtoFonctionnalite.getIdFonctionnalite());
        fonctionnalite.setCommentaire(dtoFonctionnalite.getCommentaire());
        //fonctionnalite.setLesAssociationCdcFonctionnalite(listDtoAssociationsCdcFonctionnaliteToAssociationFonctionnalite(dtoFonctionnalite.getLesAssociationCdcFonctionnalite()));
        fonctionnalite.setTypeFonctionnalite(dtoTypeFonctionnaliteToTypeFonctionnalite(dtoFonctionnalite.getTypeFonctionnalite()));
        return fonctionnalite;
    }

    public static TypeFonctionnalite dtoTypeFonctionnaliteToTypeFonctionnalite(DTOTypeFonctionnalite dtoTypeFonctionnalite) {
        TypeFonctionnalite typeFonctionnalite = new TypeFonctionnalite();
        typeFonctionnalite.setIdTypeFonctionnalite(dtoTypeFonctionnalite.getIdTypeFonctionnalite());
        typeFonctionnalite.setLibelle(dtoTypeFonctionnalite.getLibelle());
        return typeFonctionnalite;
    }

    public static Cdc dtoCdcToCdc(DTOCdc dtoCdc) {
        Cdc cdc = new Cdc();
        cdc.setIdCdc(dtoCdc.getIdCdc());
        cdc.setProjet(dtoProjetToProjet(dtoCdc.getProjet()));
        cdc.setBesoin(dtoCdc.getBesoin());
        cdc.setContexte(dtoCdc.getContexte());
        cdc.setDateFinEstimee(dtoCdc.getDateFinEstimee());
        cdc.setExistant(dtoCdc.getExistant());
        cdc.setTarif(dtoCdc.getTarif());
        cdc.setLu(dtoCdc.getLu());
        cdc.setTypeCdc(dtoTypeCdcToTypeCdc(dtoCdc.getTypeCdc()));
        if (dtoCdc.getDeveloppeur() !=null)
        {
        	cdc.setDeveloppeurCdc(dtoDeveloppeurToDeveloppeur(dtoCdc.getDeveloppeur()));
        }
        if (dtoCdc.getRemarque() != null)
        {
        	System.out.println("je passe dans le dto");
        	cdc.setRemarque(dtoCdcToCdc(dtoCdc.getRemarque()));
        }
        return cdc;
    }

    public static TypeCdc dtoTypeCdcToTypeCdc(DTOTypeCdc dtoTypeCdc) {
        TypeCdc typeCdc = new TypeCdc();
        typeCdc.setIdTypeCdc(dtoTypeCdc.getIdTypeCdc());
        typeCdc.setLibelle(dtoTypeCdc.getLibelle());
        return typeCdc;
    }

    public static Technologie dtoTechnologieToTechnologie(DTOTechnologie dtoTechnologie) {
        Technologie technologie = new Technologie();
        technologie.setIdTechnologie(dtoTechnologie.getIdTechnologie());
        //technologie.setLesAssociationDevTechno(listDtoAssoDevTechnoToAssoDevTechno(dtoTechnologie.getLesAssociationDevTechno()));
        //technologie.setLesAssociationTypeServiceTechno(listDtoAssoTypeServTechnoToAssoTypeServTechno(dtoTechnologie.getLesAssociationTypeServiceTechno()));
        technologie.setTechnologieLibelle(dtoTechnologie.getTechnologieLibelle());
        return technologie;
    }

   

    public static Developpeur dtoDeveloppeurToDeveloppeur(DTODeveloppeur dtoDeveloppeur) {
        Developpeur entity = new Developpeur();
        entity.setIdUtilisateur(dtoDeveloppeur.getIdUtilisateur());
        entity.setNom(dtoDeveloppeur.getNom());
        entity.setPrenom(dtoDeveloppeur.getPrenom());
        entity.setFixe(dtoDeveloppeur.getFixe());
        entity.setPortable(dtoDeveloppeur.getPortable());
        entity.setMail(dtoDeveloppeur.getMail());
        entity.setMdp(dtoDeveloppeur.getMdp());
        entity.setPhoto(dtoDeveloppeur.getPhoto());
        entity.setDateInscription(dtoDeveloppeur.getDateInscription());
        entity.setAdresse(dtoAdresseToAdresse(dtoDeveloppeur.getAdresse()));
        //entity.setLesAssociationDevTechno(listDtoAssoDevTechnoToAssoDevTechno(dtoDeveloppeur.getLesAssociationDevTechno()));
       // entity.setListeDispo(listDtoDispoToDispo(dtoDeveloppeur.getListeDispo()));
        //entity.setListeProposition(listDtoPropositionToProposition(dtoDeveloppeur.getListeProposition()));
        //entity.setLesMessages1(listDtoMessageToMessage(dtoDeveloppeur.getLesMessages1()));
        //entity.setLesMessages2(listDtoMessageToMessage(dtoDeveloppeur.getLesMessages1()));
        return entity;
    }

    public static Operation dtoOperationToOperation(DTOOperation dto) {
        Operation entity = new Operation();
        entity.setIdOperation(dto.getIdOperation());
        entity.setDate(dto.getDate());
        entity.setMontant(dto.getMontant());
        entity.setTypeOperation(dtoTypeOperationToTypeOperation(dto.getTypeOperation()));
        entity.setLivrable(dtoLivrableToLivrable(dto.getLivrable()));
        return entity;
    }

    public static Utilisateur dtoUtilisateurToUtilisateur(DTOUtilisateur dto) {
        Utilisateur entity = new Utilisateur();
        entity.setIdUtilisateur(dto.getIdUtilisateur());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setFixe(dto.getFixe());
        entity.setPortable(dto.getPortable());
        entity.setMail(dto.getMail());
        entity.setMdp(dto.getMdp());
        entity.setPhoto(dto.getPhoto());
        entity.setDateInscription(dto.getDateInscription());
        if(dto.getAdresse() != null) {
        entity.setAdresse(dtoAdresseToAdresse(dto.getAdresse()));
        }
        //entity.setLesMessages1(listDtoMessageToMessage(dto.getLesMessages1()));
        //entity.setLesMessages2(listDtoMessageToMessage(dto.getLesMessages2()));
        return entity;
    }

    public static TypeOperation dtoTypeOperationToTypeOperation(DTOTypeOperation dto) {
        TypeOperation entity = new TypeOperation();
        entity.setIdTypeOperation(dto.getIdTypeOperation());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }

    public static Message dtoMessageToMessage(DTOMessage dto) {
        Message entity = new Message();
        entity.setIdMessage(dto.getIdMessage());
        entity.setDateEnvoi(dto.getDateEnvoi());
        entity.setMessage(dto.getMessage());
        if (dto.getMessFille()!= null)
            entity.setMessFille(dtoMessageToMessage(dto.getMessFille()));
        if (dto.getMessMere()!= null)
            entity.setMessMere(dtoMessageToMessage(dto.getMessMere()));
        entity.setTitre(dto.getTitre());
        if (dto.getUtilisateur1()!=null){
        entity.setUtilisateur1(dtoUtilisateurToUtilisateur(dto.getUtilisateur1()));
        }
        if (dto.getUtilisateur2() != null) {
        entity.setUtilisateur2(dtoUtilisateurToUtilisateur(dto.getUtilisateur2()));
        }
        return entity;
    }

    public static Proposition dtoPropositionToProposition(DTOProposition dto) {
        Proposition entity = new Proposition();
        entity.setIdProposition(dto.getIdProposition());
        entity.setTitre(dto.getTitre());
        entity.setDate(dto.getDate());
        entity.setLu(dto.getLu());
        entity.setProjet(dtoProjetToProjet(dto.getProjet()));
        entity.setDeveloppeur(dtoDeveloppeurToDeveloppeur(dto.getDeveloppeur()));
        entity.setTypeProposition(dtoTypePropositionToProposition(dto.getTypeProposition()));
        return entity;
    }

    public static TypeProposition dtoTypePropositionToProposition(DTOTypeProposition dto) {
        TypeProposition entity = new TypeProposition();
        entity.setIdTypeProposition(dto.getIdTypeProposition());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }

    public static Dispo dtoDispoToDispo(DTODispo dto) {
        Dispo entity = new Dispo();
        entity.setIdDispo(dto.getIdDispo());
        entity.setDebutDispo(dto.getDebutDispo());
        entity.setFinDispo(dto.getFinDispo());
        entity.setDeveloppeur(dtoDeveloppeurToDeveloppeur(dto.getDeveloppeur()));
        entity.setTypeDispo(dtoTypeDispoToTypeDispo(dto.getTypeDispo()));
        return entity;
    }

    public static TypeDispo dtoTypeDispoToTypeDispo(DTOTypeDispo dto) {
        TypeDispo entity = new TypeDispo();
        entity.setIdTypeDispo(dto.getIdTypeDispo());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }


    public static TypeService dtoTypeServiceToTypeService(DTOTypeService dtoTypeService) {
        TypeService typeService = new TypeService();
        typeService.setIdTypeService(dtoTypeService.getIdTypeService());
        typeService.setLibelle(dtoTypeService.getLibelle());
        return typeService;
    }

    public static TypeAppli dtoTypeAppliToTypeAppli(DTOTypeAppli dtoTypeAppli) {
        TypeAppli typeAppli = new TypeAppli();
        typeAppli.setIdTypeAppli(dtoTypeAppli.getIdTypeAppli());
        typeAppli.setLibelle(dtoTypeAppli.getLibelle());
        return typeAppli;
    }

    public static Projet dtoProjetToProjet(DTOProjet dto) {
        Projet entity = new Projet();
        entity.setIdProjet(dto.getIdProjet());
        entity.setClient(dtoClientToClient(dto.getClient()));
        entity.setEtatProjet(dtoEtatProjetToEtatProjet(dto.getEtatProjet()));
        //entity.setLesCdc(listDtoCdcToCdc(dto.getLesCdc()));
        //entity.setLesLitige(listDtoLitigesToLitiges(dto.getLesLitige()));
        //entity.setLesLivrable(listDtoLivrableToLivrable(dto.getLesLivrable()));
        //entity.setLesNotes(listDtoNotesToNotes(dto.getLesNotes()));
        //entity.setLesProposition(listDtoPropositionToProposition(dto.getLesProposition()));
        entity.setLibelle(dto.getLibelle());
        //entity.setLesServices(listDtoTypeServToTypeServ(dto.getLesServices()));
        return entity;
    }

	public static Note dtoNoteToNote(DTONote dto) {
        Note entity = new Note();
        entity.setIdNote(dto.getIdNote());
        entity.setIdEstNote(dto.getIdEstNote());
        entity.setIdNoteur(dto.getIdNoteur());
        entity.setCommentaire(dto.getCommentaire());
        entity.setDate(dto.getDate());
        entity.setNote(dto.getNote());
        entity.setProjet(dtoProjetToProjet(dto.getProjet()));
        return entity;
    }

    public static Livrable dtoLivrableToLivrable(DTOLivrable dto) {
        Livrable entity = new Livrable();
        entity.setIdLivrable(dto.getIdLivrable());
        entity.setFichier(dto.getFichier());
        entity.setTypeEvaluation(dtoTypeEvaluationToEvaluation(dto.getTypeEvaluation()));
        entity.setEcheance(dto.getEcheance());
        entity.setDateLivraison(dto.getDateLivraison());
        return entity;
    }

    public static TypeEvaluation dtoTypeEvaluationToEvaluation(DTOTypeEvaluation dto) {
        TypeEvaluation entity = new TypeEvaluation();
        entity.setIdTypeEvaluation(dto.getIdTypeEvaluation());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }

    public static Litige dtoLitigeToLitige(DTOLitige dto) {
        Litige entity = new Litige();
        entity.setIdLitige(dto.getIdLitige());
        entity.setLibelle(dto.getLibelle());
        entity.setProjet(dtoProjetToProjet(dto.getProjet()));
        entity.setMotif(dto.getMotif());
        return entity;
    }

    public static EtatProjet dtoEtatProjetToEtatProjet(DTOEtatProjet dto) {
        EtatProjet entity = new EtatProjet();
        entity.setIdEtatProjet(dto.getIdEtatProjet());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }

    public static Client dtoClientToClient(DTOClient dto) {
        Client entity = new Client();
        entity.setIdUtilisateur(dto.getIdUtilisateur());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setFixe(dto.getFixe());
        entity.setPortable(dto.getPortable());
        entity.setMail(dto.getMail());
        entity.setMdp(dto.getMdp());
        entity.setPhoto(dto.getPhoto());
        entity.setDateInscription(dto.getDateInscription());
        entity.setAdresse(dtoAdresseToAdresse(dto.getAdresse()));
        //entity.setLesMessages1(listDtoMessageToMessage(dto.getLesMessages1()));
        //entity.setLesMessages2(listDtoMessageToMessage(dto.getLesMessages1()));
        return entity;
    }


    public static Set<AssociationCdcFonctionnalite> listDtoAssociationsCdcFonctionnaliteToAssociationFonctionnalite(Set<DTOAssociationCdcFonctionnalite> dtoFonctionnaliteLesAssociationCdcFonctionnalite) {
        Set<AssociationCdcFonctionnalite> listAssociationFonctionnalite = new HashSet<AssociationCdcFonctionnalite>();
        for (DTOAssociationCdcFonctionnalite dto :
                dtoFonctionnaliteLesAssociationCdcFonctionnalite) {
            listAssociationFonctionnalite.add(dtoAssociationCdcFonctionnaliteToAssociationCdcFonctionnalite(dto));
        }
        return listAssociationFonctionnalite;
    }



    public static Set<AssociationDevTechno> listDtoAssoDevTechnoToAssoDevTechno(Set<DTOAssociationDevTechno> listDto) {
        Set<AssociationDevTechno> listEntity = new HashSet<AssociationDevTechno>();
        for (DTOAssociationDevTechno dto :
                listDto) {
            listEntity.add(dtoAssociationDevTechnoToAssociationDevTechno(dto));
        }
        return listEntity;
    }
    public static Set<AssociationTypeServiceTechno> listDtoAssoTypeServTechnoToAssoTypeServTechno(Set<DTOAssociationTypeServiceTechno> listDto) {
        Set<AssociationTypeServiceTechno> listEntity = new HashSet<AssociationTypeServiceTechno>();
        for (DTOAssociationTypeServiceTechno dto :
                listDto) {
            listEntity.add(dtoAssociationTypeServTechnoToAssociationTypeServTechno(dto));
        }
        return listEntity;
    }
    public static Set<Operation> listDtoOperationsToOperation(Set<DTOOperation> listDto) {
        Set<Operation> listEntity = new HashSet<Operation>();
        for (DTOOperation dto :
                listDto) {
            listEntity.add(dtoOperationToOperation(dto));
        }
        return listEntity;
    }

    public static Set<Message> listDtoMessageToMessage(Set<DTOMessage> listDto) {
        Set<Message> listEntity = new HashSet<Message>();
        for (DTOMessage dto :
                listDto) {
            listEntity.add(dtoMessageToMessage(dto));
        }
        return listEntity;
    }

    public static Set<Proposition> listDtoPropositionToProposition(Set<DTOProposition> listDto) {
        Set<Proposition> listEntity = new HashSet<Proposition>();
        for (DTOProposition dto :
                listDto) {
            listEntity.add(dtoPropositionToProposition(dto));
        }
        return listEntity;
    }

    public static Set<Dispo> listDtoDispoToDispo(Set<DTODispo> listDto) {
        Set<Dispo> listEntity = new HashSet<Dispo>();
        for (DTODispo dto :
                listDto) {
            listEntity.add(dtoDispoToDispo(dto));
        }
        return listEntity;
    }

    public static Set<Note> listDtoNotesToNotes(Set<DTONote> listDto) {
        Set<Note> listEntity = new HashSet<Note>();
        for (DTONote dto :
                listDto) {
            listEntity.add(dtoNoteToNote(dto));
        }
        return listEntity;
    }

    public static Set<Cdc> listDtoCdcToCdc(Set<DTOCdc> listDto) {
        Set<Cdc> listEntity = new HashSet<Cdc>();
        for (DTOCdc dto :
                listDto) {
            listEntity.add(dtoCdcToCdc(dto));
        }
        return listEntity;
    }

    public static Set<Livrable> listDtoLivrableToLivrable(Set<DTOLivrable> listDto) {
        Set<Livrable> listEntity = new HashSet<Livrable>();
        for (DTOLivrable dto :
                listDto) {
            listEntity.add(dtoLivrableToLivrable(dto));
        }
        return listEntity;
    }

    public static Set<Litige> listDtoLitigesToLitiges(Set<DTOLitige> listDto) {
        Set<Litige> listEntity = new HashSet<Litige>();
        for (DTOLitige dto :
                listDto) {
            listEntity.add(dtoLitigeToLitige(dto));
        }
        return listEntity;
    }

    public static Set<TypeService> listDtoTypeServToTypeServ(
            Set<DTOTypeService> listDto) {
        Set<TypeService> listEntity = new HashSet<TypeService>();
        for (DTOTypeService dto :
                listDto) {
            listEntity.add(dtoTypeServiceToTypeService(dto));
        }
        return listEntity;
    }
}