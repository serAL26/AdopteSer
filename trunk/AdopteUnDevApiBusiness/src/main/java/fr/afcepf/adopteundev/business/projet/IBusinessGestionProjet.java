package fr.afcepf.adopteundev.business.projet;

import java.util.List;
import java.util.Set;

import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTechnologie;
import dto.DTOTypeCdc;

public interface IBusinessGestionProjet {

	public List<DTOProjet> recupProjetParIdClient(Integer id);
	public DTOProjet ajouter(DTOProjet projet);
	public void modifierProjet(DTOProjet projet);
	public void finaliserProjet(DTOProjet projet);
	public List<DTOProjet> recupProjerParEtat(String etat);
	public List<DTOProjet> recupProjerParEtatParClient(String etat, DTOClient client);
	public DTOProjet recupProjetParId(int idProjet);
	public DTOTypeCdc recupTypeCDCparLibelle(String libelle);
	
	public List<DTOProjet> recupProjerParEtatParUtilisateur(String etat, Integer id);
	public DTOProposition validerProjet(DTOProposition dtoProposition, int idProjet);
	public Set<DTOTechnologie> recupTechnoParService(int idTypeService);
	public DTOProposition recupPropositionValidePourProjet(DTOProjet projet);
	
}
