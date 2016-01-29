package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOProjet;

public interface IBusinessGestionProjet {
	
	List<DTOProjet> recupProjetParIdClient(Integer id);

}
