package fr.afcepf.adopteundev.managedbean.gestioncdc;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTOProjet;
import dto.DTOTypeCdc;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;

@ManagedBean
@SessionScoped
public class MBAjoutCdc {
	
	private String besoin;
	private String contexte;
	private String existant;
	private Date dateFin;
	private Double tarif;
	
	private DTOCdc cdc;
	
	private IUCGestionCdc ucGestionCdc;

	public String getBesoin() {
		return besoin;
	}

	public void setBesoin(String besoin) {
		this.besoin = besoin;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getExistant() {
		return existant;
	}

	public void setExistant(String existant) {
		this.existant = existant;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}
	
	public void ajouterCdc()
	{
		cdc = new DTOCdc(contexte, besoin, existant, tarif, dateFin, new DTOProjet(), new DTOTypeCdc());
		
		ucGestionCdc.ajouterCdcDto(cdc);
	}

}
