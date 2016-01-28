package fr.afcepf.adopteundev.idao.projet;

import java.util.List;
import java.util.Set;

import entity.TypeAppli;



public interface IDaoTypeAppli {
	public Set<TypeAppli> getAllApplis();
	public TypeAppli getAppliById(Integer id);
}
