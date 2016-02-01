package fr.afcepf.adopteundev.business.projet;

import java.util.List;

import dto.DTOLivrable;
import dto.DTOOperation;

public interface IBusinessOperation {
	List<DTOOperation> payerLivrable(DTOOperation dtoOperation);
}
