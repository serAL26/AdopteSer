package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOClient;
import dto.DTOEtatProjet;
import dto.DTOProjet;
import entity.Projet;
import enumeration.EtatProjetEnum;
import fr.afcepf.adopteundev.idao.projet.IDaoEtatProjet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IBusinessGestionProjet.class)
@Stateless
public class BusinessGestionProjet implements IBusinessGestionProjet {

	@EJB
	private IDaoGestionProjet daoGestionProjet;

	@EJB
	private IDaoEtatProjet daoEtatProjet;

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

	@Override
	public void finaliserProjet(DTOProjet projet) {
		DTOEtatProjet etatProjet = EntityToDTO
				.etatProjetToDTOEtatProjet(daoEtatProjet
						.recupEtatProjetByLibelle(EtatProjetEnum.FINI.name()));
		projet.setEtatProjet(etatProjet);
		daoGestionProjet.modifierProjet(DTOToEntity.dtoProjetToProjet(projet));
	}

	@Override
	public List<DTOProjet> recupProjerParEtat(String etat) {
		return EntityToDTO.listeProjetToDtoProjet(daoGestionProjet
				.recupProjerParEtat(etat));
	}

	@Override
	public List<DTOProjet> recupProjerParEtatParClient(String etat,
			DTOClient client) {
		return EntityToDTO.listeProjetToDtoProjet(daoGestionProjet
				.recupProjerParEtatParClient(etat,
						DTOToEntity.dtoClientToClient(client)));
	}

}
