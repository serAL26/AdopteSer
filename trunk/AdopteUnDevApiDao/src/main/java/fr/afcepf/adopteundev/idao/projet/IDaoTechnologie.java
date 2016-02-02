package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.Technologie;

public interface IDaoTechnologie {
	List<Technologie> recupTechnoParDev(int idDev);
	List<Technologie> recupToutesTechnos();

}
