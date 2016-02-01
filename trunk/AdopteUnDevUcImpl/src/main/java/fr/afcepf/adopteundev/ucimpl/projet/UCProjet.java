package fr.afcepf.adopteundev.ucimpl.projet;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import dto.DTOClient;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTypeAppli;
import dto.DTOTypeProposition;
import dto.DTOTypeService;
import dto.DTOUtilisateur;
import fr.afcepf.adopteundev.business.projet.IBusinessGestionProjet;
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
			DTOUtilisateur dtoUtilisateur) {
		
		return businessGestionProjet.recupProjerParEtatParUtilisateur(etat, dtoUtilisateur);
	}
}
