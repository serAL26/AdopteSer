package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOProposition;
import dto.DTOTypeProposition;

public interface IBusinessProposition {
	
	public void modifierProposition(DTOProposition dtoProp);
	public List<DTOProposition> recupToutesLesPropos();
	public List<DTOTypeProposition> recupToutsLesTyesPropos();
}
