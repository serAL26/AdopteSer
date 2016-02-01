package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOClient;
import dto.DTOProjet;
import dto.DTOTypeCdc;
import dto.DTOUtilisateur;

public interface IBusinessGestionProjet {

	public List<DTOProjet> recupProjetParIdClient(Integer id);
	public DTOProjet ajouter(DTOProjet projet);
	public void modifierProjet(DTOProjet projet);
	public void finaliserProjet(DTOProjet projet);
	public List<DTOProjet> recupProjerParEtat(String etat);
	public List<DTOProjet> recupProjerParEtatParClient(String etat, DTOClient client);
	public DTOProjet recupProjetParId(int idProjet);
	public DTOTypeCdc recupTypeCDCparLibelle(String libelle);
	
	public List<DTOProjet> recupProjerParEtatParUtilisateur(String etat, DTOUtilisateur dtoUtilisateur);
}
