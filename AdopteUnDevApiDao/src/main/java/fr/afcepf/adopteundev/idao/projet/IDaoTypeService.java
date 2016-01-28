package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.TypeAppli;
import entity.TypeService;

public interface IDaoTypeService {
	
	public List<TypeService> getAllServices();
	public TypeService getSericesById(Integer id);
	public List<TypeService> getServicesByAppli(TypeAppli appli);
}
