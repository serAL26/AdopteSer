package fr.afcepf.adopteundev.gestion.utilisateur;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Client;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoClient;

@Remote(IDaoClient.class)
@Stateless
public class DaoClient implements IDaoClient{

	@PersistenceContext(unitName="AdopteUnDev")
	private EntityManager em;
	
	@Override
	public Client obtenirClientParId(int idUtilisateur) {
		return em.find(Client.class,idUtilisateur);
	}

}
