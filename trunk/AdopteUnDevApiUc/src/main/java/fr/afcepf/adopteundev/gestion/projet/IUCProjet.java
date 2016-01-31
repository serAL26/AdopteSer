package fr.afcepf.adopteundev.gestion.projet;

import java.util.List;
import java.util.Set;

import dto.DTOClient;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTypeAppli;
import dto.DTOTypeProposition;
import dto.DTOTypeService;

public interface IUCProjet {
	public Set<DTOTypeAppli> rechercherTousApplication();
	public DTOTypeAppli recupTypeAppliById(Integer id);
	public Set<DTOTypeService> rechercherTousServices();
	public Set<DTOTypeService> rechercherServicesParAppli(DTOTypeAppli application);
	public List<DTOProjet> recupProjetParIdClient(Integer id);
	public void creerProjet(DTOProjet projet);
	public void finaliserProjet(DTOProjet projet);
	public List<DTOProjet> recupProjerParEtat(String etat);
	public List<DTOProjet> recupProjerParEtatParClient(String etat, DTOClient client);
	public void modifierProposition(DTOProposition dtoProp);
	public List<DTOProposition> recupToutesLesPropos();
	public List<DTOTypeProposition> recupTousLesTypesProps();
	DTOProjet recupProjetById(int idProjet);
}