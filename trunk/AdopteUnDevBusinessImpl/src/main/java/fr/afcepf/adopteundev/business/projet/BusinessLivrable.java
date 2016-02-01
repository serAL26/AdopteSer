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

@Remote(IBusinessLivrable.class)
@Stateless
public class BusinessLivrable implements IBusinessLivrable{

	@EJB
	private IDaoLivrable daoLivrable;
	
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

}
