package fr.afcepf.adopteundev.business.projet;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOProjet;
import entity.Projet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IBusinessGestionProjet.class)
@Stateless
public class BusinessGestionProjet implements IBusinessGestionProjet {

	@EJB
	private IDaoGestionProjet daoGestionProjet;

	@Override
	public List<DTOProjet> recupProjetParIdClient(Integer id) {

		List<Projet> listeProjets = daoGestionProjet.recupProjetParIdClient(id);

		return EntityToDTO.listeProjetToDtoProjet(listeProjets);
	}

	@Override
	public void ajouter(DTOProjet projet) {
		daoGestionProjet.ajouter(DTOToEntity.dtoProjetToProjet(projet));

	}

	@Override
	public void modifierProjet(DTOProjet projet) {
		daoGestionProjet.modifierProjet(DTOToEntity.dtoProjetToProjet(projet));
	}

}
