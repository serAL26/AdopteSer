package fr.afcepf.adopteundev.managedbean.projet;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOCdc;
import dto.DTOProjet;
import dto.DTOProposition;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.gestion.proposition.IUcProposition;
import fr.afcepf.adopteundev.managedbean.connexion.MBConnexion;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBPropositionParUtilisateur {
	
	private List<DTOProposition> listeAccepteParDev;
	private List<DTOProposition> listeRefuse;
	private List<DTOProposition> listeEnAttente;
	DTOCdc cdc;
	
	private IUCProjet gestionProjet;
	private IUcProposition gestionProposition;
	private IUCGestionCdc gestionCdc;
	
	@ManagedProperty(value="#{mBConnexion}")
	private MBConnexion mBConnexion;

	public List<DTOProposition> getListeAccepteParDev() {
		return listeAccepteParDev;
	}

	public void setListeAccepteParDev(List<DTOProposition> listeAccepteParDev) {
		this.listeAccepteParDev = listeAccepteParDev;
	}

	public List<DTOProposition> getListeRefuse() {
		return listeRefuse;
	}

	public void setListeRefuse(List<DTOProposition> listeRefuse) {
		this.listeRefuse = listeRefuse;
	}

	public List<DTOProposition> getListeEnAttente() {
		return listeEnAttente;
	}

	public void setListeEnAttente(List<DTOProposition> listeEnAttente) {
		this.listeEnAttente = listeEnAttente;
	}

	public MBConnexion getmBConnexion() {
		return mBConnexion;
	}

	public void setmBConnexion(MBConnexion mBConnexion) {
		this.mBConnexion = mBConnexion;
	}
	
	
	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	@PostConstruct
	public void init() {
		gestionProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		gestionCdc = (IUCGestionCdc)ContextFactory.createProxy(UcName.UCGESTIONCDC);
		gestionProposition = (IUcProposition)ContextFactory.createProxy(UcName.UCGESTIONPROPOSITION);
		listeAccepteParDev = gestionProposition.recupPropositionParEtatParUtilisateur("Accepte par le dev", mBConnexion.getUtilisateur().getIdUtilisateur());
		listeEnAttente = gestionProposition.recupPropositionParEtatParUtilisateur("En attente", mBConnexion.getUtilisateur().getIdUtilisateur());
		listeRefuse = gestionProposition.recupPropositionParEtatParUtilisateur("refuse", mBConnexion.getUtilisateur().getIdUtilisateur());
	}
	
	public DTOCdc recupInfoCdc(DTOProjet projet)
	{
		cdc = gestionCdc.recupCdcFinalParidProjet(projet.getIdProjet());
		return cdc;
	}

}
