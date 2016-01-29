package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import assembleur.EntityToDTO;
import dto.DTOTypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;

@Remote(IBusinessTypeAppli.class)
@Stateless
public class BusinessTypeAppli implements IBusinessTypeAppli {
	private static Logger log = Logger.getLogger(BusinessTypeAppli.class);
	@EJB
	private IDaoTypeAppli daoTypeAppli;

	@Override
	public Set<DTOTypeAppli> getAllApplis() {
		log.info("Business tous les applis");
		return EntityToDTO.listTypeAppliotoDTOtypeAppli(daoTypeAppli
				.getAllApplis());
	}

	@Override
	public DTOTypeAppli getAppliById(Integer id) {
		return EntityToDTO.typeAppliToDTOTypeAppli(daoTypeAppli
				.getAppliById(id));
	}

}
