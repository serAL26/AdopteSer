package fr.afcepf.adopteundev.business.projet;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOEtatProjet;
import dto.DTOProjet;
import dto.DTOTypeCdc;
import dto.DTOUtilisateur;
import entity.EtatProjet;
import entity.Projet;
import enumeration.EtatProjetEnum;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoTypeCDC;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoClient;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoUtilisateur;
import fr.afcepf.adopteundev.idao.projet.IDaoEtatProjet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;

@Remote(IBusinessGestionProjet.class)
@Stateless
public class BusinessGestionProjet implements IBusinessGestionProjet {
	private static Logger log = Logger.getLogger(BusinessGestionProjet.class);
	@EJB
	private IDaoGestionProjet daoGestionProjet;

	@EJB
	private IDaoEtatProjet daoEtatProjet;

	@EJB
	private IDaoTypeCDC daoTypeCDC;

	@EJB
	private IDaoDeveloppeur daoDev;

	@EJB 
	private IDaoClient daoClient;

	@Override
	public List<DTOProjet> recupProjetParIdClient(Integer id) {

		List<Projet> listeProjets = daoGestionProjet.recupProjetParIdClient(id);

		return EntityToDTO.listeProjetToDtoProjet(listeProjets);
	}

	@Override
	public DTOProjet ajouter(DTOProjet projet) {
		projet.setEtatProjet(EntityToDTO
				.etatProjetToDTOEtatProjet(daoEtatProjet
						.recupEtatProjetByLibelle(EtatProjetEnum.ENATTENTE
								.toString())));
		return EntityToDTO.projetToDTOProjet(daoGestionProjet.ajouter(DTOToEntity.dtoProjetToProjet(projet)));

	}

	@Override
	public void modifierProjet(DTOProjet projet) {
		daoGestionProjet.modifierProjet(DTOToEntity.dtoProjetToProjet(projet));
	}

	@Override
	public void finaliserProjet(DTOProjet projet) {
		DTOEtatProjet etatProjet = EntityToDTO
				.etatProjetToDTOEtatProjet(daoEtatProjet
						.recupEtatProjetByLibelle(EtatProjetEnum.FINI.toString()));
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

	@Override
	public DTOProjet recupProjetParId(int idProjet) {
		Projet projet = daoGestionProjet.recupProjetParId(idProjet);
		return EntityToDTO.projetToDTOProjet(projet);
	}

	@Override
	public DTOTypeCdc recupTypeCDCparLibelle(String libelle) {
		return EntityToDTO.typeCdcToDTOTypeCdc(daoTypeCDC
				.recupTypeCdcByLibelle(libelle));
	}

	@Override
	public List<DTOProjet> recupProjerParEtatParUtilisateur(String etat,
			DTOUtilisateur dtoUtilisateur) {

		List<DTOProjet> liste = new ArrayList<DTOProjet>();

		if(daoDev.obtenirDeveloppeurParId(dtoUtilisateur.getIdUtilisateur()) != null)
		{
			DTODeveloppeur dev = (DTODeveloppeur) dtoUtilisateur;
			liste =  EntityToDTO.listeProjetToDtoProjet(daoGestionProjet.
					recupProjetParEtatParDev(etat, 
							DTOToEntity.dtoDeveloppeurToDeveloppeur(dev)));
		}
		
		else if (daoClient.obtenirClientParId(dtoUtilisateur.getIdUtilisateur()) != null)
		{
			DTOClient client = (DTOClient) dtoUtilisateur;

			liste = EntityToDTO.listeProjetToDtoProjet(daoGestionProjet
					.recupProjerParEtatParClient(etat,
							DTOToEntity.dtoClientToClient(client)));
		}

		return liste;
	}

}
