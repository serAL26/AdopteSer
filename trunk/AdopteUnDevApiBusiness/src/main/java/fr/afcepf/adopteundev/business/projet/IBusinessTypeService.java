package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import dto.DTOTypeAppli;
import dto.DTOTypeService;


public interface IBusinessTypeService {
	
	public Set<DTOTypeService> getAllServices();

	public DTOTypeService getSericesById(Integer id);

	public Set<DTOTypeService> getServicesByAppli(DTOTypeAppli appli);


}
