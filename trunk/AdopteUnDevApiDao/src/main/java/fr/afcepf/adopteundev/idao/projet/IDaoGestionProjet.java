package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Projet;

public interface IDaoGestionProjet {
	
	List<Projet> recupProjetParIdClient(Integer id);

}
