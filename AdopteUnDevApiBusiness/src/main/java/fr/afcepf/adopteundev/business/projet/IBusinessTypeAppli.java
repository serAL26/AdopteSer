package fr.afcepf.adopteundev.business.projet;

import java.util.Set;

import dto.DTOTypeAppli;

public interface IBusinessTypeAppli {
	
	public Set<DTOTypeAppli> getAllApplis();

	public DTOTypeAppli getAppliById(Integer id);
}
