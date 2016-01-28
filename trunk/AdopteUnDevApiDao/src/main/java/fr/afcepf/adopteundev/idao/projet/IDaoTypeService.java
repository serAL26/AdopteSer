package fr.afcepf.adopteundev.idao.projet;

import java.util.Set;


import entity.TypeAppli;
import entity.TypeService;

public interface IDaoTypeService {

	public Set<TypeService> getAllServices();

	public TypeService getSericesById(Integer id);

	public Set<TypeService> getServicesByAppli(TypeAppli dtoTypeAppli);
}
