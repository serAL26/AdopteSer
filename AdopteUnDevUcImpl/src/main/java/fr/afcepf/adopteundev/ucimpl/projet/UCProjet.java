package fr.afcepf.adopteundev.ucimpl.projet;

import dto.*;
import fr.afcepf.adopteundev.business.projet.*;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.List;
import java.util.Set;

@Remote(IUCProjet.class)
@Stateless
public class UCProjet implements IUCProjet {
    @EJB
    private IBusinessTypeAppli businessTypeAppli;
    @EJB
    private IBusinessTypeService businessTypeService;
    @EJB
    private IBusinessGestionProjet businessGestionProjet;
    @EJB
    private IBusinessProposition businessProposition;
    @EJB
    private IBusinessLivrable businessLivrable;
    @EJB
    private IBusinessOperation businessOperation;
    @EJB
    private IBusinessNote businessNote;

    @Override
    public Set<DTOTypeAppli> rechercherTousApplication() {
        return businessTypeAppli.getAllApplis();
    }

    @Override
    public Set<DTOTypeService> rechercherTousServices() {
        return businessTypeService.getAllServices();
    }

    @Override
    public Set<DTOTypeService> rechercherServicesParAppli(
            DTOTypeAppli application) {
        return businessTypeService.getServicesByAppli(application);
    }

    @Override
    public List<DTOProjet> recupProjetParIdClient(Integer id) {

        return businessGestionProjet.recupProjetParIdClient(id);
    }

    @Override
    public DTOProjet creerProjet(DTOProjet projet) {
        return businessGestionProjet.ajouter(projet);

    }

    @Override
    public DTOTypeAppli recupTypeAppliById(Integer id) {

        return businessTypeAppli.getAppliById(id);
    }

    @Override
    public void finaliserProjet(DTOProjet projet) {
        businessGestionProjet.finaliserProjet(projet);
    }

    @Override
    public void modifierProposition(DTOProposition dtoProp) {
        businessProposition.modifierProposition(dtoProp);
    }

    @Override
    public List<DTOProposition> recupToutesLesPropos() {
        return businessProposition.recupToutesLesPropos();
    }

    @Override
    public List<DTOTypeProposition> recupTousLesTypesProps() {
        return businessProposition.recupToutsLesTyesPropos();
    }

    @Override
    public List<DTOProjet> recupProjerParEtat(String etat) {
        return businessGestionProjet.recupProjerParEtat(etat);
    }

    @Override
    public List<DTOProjet> recupProjerParEtatParClient(String etat,
                                                       DTOClient client) {
        return businessGestionProjet.recupProjerParEtatParClient(etat, client);
    }

    @Override
    public DTOProjet recupProjetById(int idProjet) {
        return businessGestionProjet.recupProjetParId(idProjet);
    }

    @Override
    public List<DTOProjet> recupProjerParEtatParUtilisateur(String etat,
                                                            Integer id) {

        return businessGestionProjet.recupProjerParEtatParUtilisateur(etat, id);
    }

    @Override
    public List<DTOOperation> recupListOperationParProjetEtType(int idProjet, int idTypeOperation) {
        return businessOperation.recupListOperationParProjetEtType(idProjet, idTypeOperation);
    }

    @Override
    public DTOLivrable creerLivrable(DTOLivrable dtoLivrable) {
        return businessLivrable.creerLivrable(dtoLivrable);
    }

    @Override
    public List<DTOOperation> payerLivrable(DTOOperation dtoOperation) {
        return businessOperation.payerLivrable(dtoOperation);
    }

    @Override
    public List<DTOLivrable> recupListLivrableParProjet(DTOProjet dtoProjet) {
        return businessLivrable.recupListeLivrableParProjet(dtoProjet);
    }

    @Override
    public Boolean initIsPaye(DTOLivrable livrable) {
        return businessLivrable.initIsPaye(livrable);
    }

    @Override
    public DTOProposition validerProjet(DTOProposition dtoProposition, int idProjet) {
        return businessGestionProjet.validerProjet(dtoProposition, idProjet);
    }

    @Override
    public List<DTONote> recupNoteParProjet(int idProjet) {
        return businessNote.recupNoteParProjet(idProjet);
    }

    @Override
    public DTONote ajouterUnCommentaire(DTONote dtoNote) {
        return businessNote.ajouterUnCommentaire(dtoNote);
    }

	@Override
	public DTOOperation creerOperationAttente(DTOOperation operation) {
		return businessOperation.creerOperationAttente(operation);
	}

}
