package fr.afcepf.adopteundev.business.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOClient;
import dto.DTODeveloppeur;
import dto.DTOEtatProjet;
import dto.DTOProjet;
import dto.DTOProposition;
import dto.DTOTechnologie;
import dto.DTOTypeCdc;
import entity.Client;
import entity.Developpeur;
import entity.Projet;
import entity.Proposition;
import enumeration.EtatProjetEnum;
import fr.afcepf.adopteundev.idao.gestion.cdc.IDaoTypeCDC;
import fr.afcepf.adopteundev.idao.gestion.proposition.IDaoTypeProposition;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoClient;
import fr.afcepf.adopteundev.idao.gestion.utilisateur.IDaoDeveloppeur;
import fr.afcepf.adopteundev.idao.projet.IDaoEtatProjet;
import fr.afcepf.adopteundev.idao.projet.IDaoGestionProjet;
import fr.afcepf.adopteundev.idao.projet.IDaoTechnologie;

@Remote(IBusinessGestionProjet.class)
@Stateless
public class BusinessGestionProjet implements IBusinessGestionProjet {
	@EJB
	private IDaoGestionProjet daoGestionProjet;
	@EJB
	private IDaoEtatProjet daoEtatProjet;
	@EJB
	private fr.afcepf.adopteundev.idao.projet.IDaoProposition daoProposition;
	@EJB
	private IDaoTypeProposition daoTypeProposition;
	@EJB
	private IDaoTypeCDC daoTypeCDC;
	@EJB
	private IDaoDeveloppeur daoDev;
	@EJB 
	private IDaoClient daoClient;
	
	@EJB 
	private IDaoTechnologie daoTechnologie;

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
			Integer id) {
		List<DTOProjet> liste = new ArrayList<DTOProjet>();
		Developpeur dev = daoDev.obtenirDeveloppeurParId(id);
		Client client = daoClient.obtenirClientParId(id);
		if(dev != null)
		{
			liste =  EntityToDTO.listeProjetToDtoProjet(daoGestionProjet.
					recupProjetParEtatParIdDev(etat, id));
		}
		else if (client != null)
		{
			liste = EntityToDTO.listeProjetToDtoProjet(daoGestionProjet
					.recupProjerParEtatParIdClient(etat, id));
		}
		return liste;
	}

	@Override
	public DTOProposition validerProjet(DTOProposition dtoProposition, int idProjet) {
		Proposition proposition = DTOToEntity.dtoPropositionToProposition(dtoProposition);
		proposition.setTypeProposition(daoTypeProposition.recupTypePropositionParId(3));
		proposition.setLu(false);
		daoProposition.modifierEtatProposition(proposition);
		for (Proposition proposition2 : daoProposition.recupListPropParProjetSaufPropValidee(idProjet)) {
			proposition2.setTypeProposition(daoTypeProposition.recupTypePropositionParId(4));
			daoProposition.modifierEtatProposition(proposition2);
		}
		return EntityToDTO.propositionToDTOProposition(proposition);
	}

	@Override
	public Set<DTOTechnologie> recupTechnoParService(int idTypeService) {
		return EntityToDTO.listTechnoToDtotechno(daoTechnologie.recupTechnoParService(idTypeService));
	}

	@Override
	public DTOProposition recupPropositionValidePourProjet(DTOProjet projet) {
		List<Proposition> listeProposition = daoProposition.recupPropValideePourProjet(projet.getIdProjet());
		DTOProposition dTOPropostion = null;
		if(listeProposition != null && listeProposition.size() > 0) {
			EntityToDTO.propositionToDTOProposition(listeProposition.get(0));
		}
		return dTOPropostion;
	}
}
