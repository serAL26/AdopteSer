package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Projet;

public interface IDaoGestionProjet {
	public void ajouter(Projet projet);
	public List<Projet> recupProjetParIdClient(Integer id);

}
