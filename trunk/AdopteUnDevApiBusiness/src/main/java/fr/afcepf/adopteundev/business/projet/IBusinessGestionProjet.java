package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOProjet;

public interface IBusinessGestionProjet {

	public List<DTOProjet> recupProjetParIdClient(Integer id);

	public void ajouter(DTOProjet projet);
	public void modifierProjet(DTOProjet projet);
}
