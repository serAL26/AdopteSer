package fr.afcepf.adopteundev.ucimpl.projet;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import dto.DTOClient;
import dto.DTOLivrable;
import dto.DTOOperation;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTypeAppli;
import dto.DTOTypeProposition;
import dto.DTOTypeService;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.business.projet.IBusinessGestionProjet;
import fr.afcepf.adopteundev.business.projet.IBusinessLivrable;
import fr.afcepf.adopteundev.business.projet.IBusinessOperation;
import fr.afcepf.adopteundev.business.projet.IBusinessProposition;
import fr.afcepf.adopteundev.business.projet.IBusinessTypeAppli;
import fr.afcepf.adopteundev.business.projet.IBusinessTypeService;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;

@Remote(IUCProjet.class)
@Stateless
public class UCProjet implements IUCProjet {
	private static Logger log = Logger.getLogger(UCProjet.class);
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
	public boolean initIsPaye(DTOLivrable livrable) {
		return businessLivrable.initIsPaye(livrable);
	}
}
