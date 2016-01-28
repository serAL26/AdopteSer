package fr.afcepf.adopteundev.idao.projet;

import java.util.List;

import entity.TypeAppli;



public interface IDaoTypeAppli {
	public List<TypeAppli> getAllApplis();
	public List<TypeAppli> getAppliById(Integer id);
}
