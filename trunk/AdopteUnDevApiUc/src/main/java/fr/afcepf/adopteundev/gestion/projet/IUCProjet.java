package fr.afcepf.adopteundev.gestion.projet;

import java.util.List;
import java.util.Set;

import dto.DTOClient;
import dto.DTOLivrable;
import dto.DTONote;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTechnologie;
import dto.DTOTypeAppli;
import dto.DTOTypeProposition;
import dto.DTOTypeService;

public interface IUCProjet {
    public Set<DTOTypeAppli> rechercherTousApplication();

    public DTOTypeAppli recupTypeAppliById(Integer id);

    public Set<DTOTypeService> rechercherTousServices();

    public Set<DTOTypeService> rechercherServicesParAppli(DTOTypeAppli application);

    public List<DTOProjet> recupProjetParIdClient(Integer id);

    public DTOProjet creerProjet(DTOProjet projet);

    public void finaliserProjet(DTOProjet projet);

    public List<DTOProjet> recupProjerParEtat(String etat);

    public List<DTOProjet> recupProjerParEtatParClient(String etat, DTOClient client);

    public void modifierProposition(DTOProposition dtoProp);

    public List<DTOProposition> recupToutesLesPropos();

    public List<DTOTypeProposition> recupTousLesTypesProps();

    DTOProjet recupProjetById(int idProjet);

    DTOLivrable creerLivrable(DTOLivrable dtoLivrable);

    List<DTOOperation> payerLivrable(DTOOperation dtoOperation);

    

    Boolean initIsPaye(DTOLivrable livrable);

    public List<DTOProjet> recupProjerParEtatParUtilisateur(String etat, Integer id);

    List<DTOOperation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation);
    
    DTOProposition validerProjet(DTOProposition dtoProposition, int idProjet);
    
    List<DTONote> recupNoteParProjet(int idProjet);
    DTONote ajouterUnCommentaire(DTONote dtoNote);

    public Set<DTOTechnologie> recupTechnoParService(int idTypeService);

    DTOOperation creerOperationAttente(DTOOperation operation);
    List<DTOLivrable> recupListLivrableParProjet(DTOProjet dtoProjet);
    List<DTOLivrable> recupListLivrableParProjetEtParDev(DTOProjet dtoProjet, int idDeveloppeur);
    DTOOperation renvoiLOperationEnAttentePaiement(DTOLivrable livrable);
}
