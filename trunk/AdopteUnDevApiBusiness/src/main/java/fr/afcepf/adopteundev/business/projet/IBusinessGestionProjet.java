package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOClient;
import dto.DTOProjet;

public interface IBusinessGestionProjet {

	public List<DTOProjet> recupProjetParIdClient(Integer id);
	public void ajouter(DTOProjet projet);
	public void modifierProjet(DTOProjet projet);
	public void finaliserProjet(DTOProjet projet);
	public List<DTOProjet> recupProjerParEtat(String etat);
	public List<DTOProjet> recupProjerParEtatParClient(String etat, DTOClient client);
	DTOProjet recupProjetParId(int idProjet);
}
