package fr.afcepf.adopteundev.gestion.projet;

import java.util.List;
import java.util.Set;

import dto.DTOProjet;
import dto.DTOTypeAppli;
import dto.DTOTypeService;

public interface IUCProjet {
	public Set<DTOTypeAppli> rechercherTousApplication();
	public DTOTypeAppli recupTypeAppliById(Integer id);
	public Set<DTOTypeService> rechercherTousServices();
	public Set<DTOTypeService> rechercherServicesParAppli(DTOTypeAppli application);
	public List<DTOProjet> recupProjetParIdClient(Integer id);
	public void creerProjet(DTOProjet projet);
}
