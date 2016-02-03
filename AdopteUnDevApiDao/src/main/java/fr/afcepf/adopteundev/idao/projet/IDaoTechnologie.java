package fr.afcepf.adopteundev.idao.projet;

import java.util.List;
import java.util.Set;

import entity.Technologie;

public interface IDaoTechnologie {
	List<Technologie> recupTechnoParDev(int idDev);
	List<Technologie> recupToutesTechnos();
	Technologie recupTechnoById(int id);
	Set<Technologie> recupTechnoParService(int idTypeService);

}
