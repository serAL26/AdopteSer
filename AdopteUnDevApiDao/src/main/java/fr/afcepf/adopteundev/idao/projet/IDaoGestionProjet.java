package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Client;
import entity.Projet;

public interface IDaoGestionProjet {
	public Projet ajouter(Projet projet);

	public List<Projet> recupProjetParIdClient(Integer id);

	public void modifierProjet(Projet projet);
	
	public List<Projet> recupProjerParEtat(String etat);
	
	public List<Projet> recupProjerParEtatParClient(String etat, Client client);
	public List<Projet> recupProjerParEtatParIdClient(String etat, Integer id);
	public List<Projet> recupProjetParEtatParIdDev(String etat, Integer id);
	List<Projet> recupProjetEnAttenteParIdClient(int id);
	Projet recupProjetParId(int idProjet);
	

}
