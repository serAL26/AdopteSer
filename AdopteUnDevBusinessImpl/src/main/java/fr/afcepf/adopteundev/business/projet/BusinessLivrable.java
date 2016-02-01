package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOLivrable;
import dto.DTOProjet;
import entity.Livrable;
import fr.afcepf.adopteundev.idao.projet.IDaoLivrable;
import fr.afcepf.adopteundev.idao.projet.IDaoOperation;

@Remote(IBusinessLivrable.class)
@Stateless
public class BusinessLivrable implements IBusinessLivrable{

	@EJB
	private IDaoLivrable daoLivrable;
	@EJB
	private IDaoOperation daoOperation;
	
	@Override
	public DTOLivrable creerLivrable(DTOLivrable dtoLivrable) {
		Livrable livrable = daoLivrable.creerLivrable(DTOToEntity.dtoLivrableToLivrable(dtoLivrable));
		return EntityToDTO.livrableToDTOLivrable(livrable);
	}

	@Override
	public List<DTOLivrable> recupListeLivrableParProjet(DTOProjet dtoProjet) {
		List<Livrable> listeLivrable = daoLivrable.recupListeLivrableParProjet(dtoProjet.getIdProjet());
		return EntityToDTO.listeLivrableToDTOLivrable(listeLivrable);
	}

	@Override
	public boolean initIsPaye(DTOLivrable livrable) {
		boolean  retour = false;
		if (daoOperation.operationPayeeParLivrable(livrable.getIdLivrable())!= null) {
			retour = true;
		}
		return retour;
	}

}
