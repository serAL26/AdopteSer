package fr.afcepf.adopteundev.gestion.projet;

import java.util.Set;

import dto.DTOTypeAppli;
import dto.DTOTypeService;

public interface IUCProjet {
	public Set<DTOTypeAppli> rechercherTousApplication();
	public Set<DTOTypeService> rechercherTousServices();
	public Set<DTOTypeService> rechercherServicesParAppli(DTOTypeAppli application);
}
