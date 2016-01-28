package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import assembleur.DTOToEntity;
import assembleur.EntityToDTO;
import dto.DTOTypeAppli;
import dto.DTOTypeService;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeService;

@Remote(IBusinessTypeService.class)
@Stateless
public class BusinessTypeService implements IBusinessTypeService {

	@EJB
	private IDaoTypeService daoTypeService;

	@EJB
	private IDaoTypeAppli daoTypeAppli;

	

	@Override
	public Set<DTOTypeService> getAllServices() {

		return EntityToDTO.listTypeServToDtoTypeServ(daoTypeService.getAllServices());
	}

	@Override
	public DTOTypeService getSericesById(Integer id) {

		return EntityToDTO.typeServiceToDTOTypeService(daoTypeService
				.getSericesById(id));
	}

	@Override
	public Set<DTOTypeService> getServicesByAppli(DTOTypeAppli appli) {
		if (daoTypeAppli.getAppliById(DTOToEntity
				.dtoTypeAppliToTypeAppli(appli).getIdTypeAppli()) != null) {

			return EntityToDTO.listTypeServToDtoTypeServ(daoTypeService
					.getServicesByAppli(DTOToEntity
							.dtoTypeAppliToTypeAppli(appli)));
		}

		return null;
	}

}
