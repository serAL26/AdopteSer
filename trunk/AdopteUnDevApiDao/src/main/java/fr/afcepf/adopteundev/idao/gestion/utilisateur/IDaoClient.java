package fr.afcepf.adopteundev.idao.gestion.utilisateur;

import entity.Client;

public interface IDaoClient {
	Client obtenirClientParId(int idUtilisateur);
}
