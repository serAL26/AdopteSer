package fr.afcepf.adopteundev.managedbean.gestioncdc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dto.DTOAssociationCdcFonctionnalite;
import dto.DTOCdc;
import dto.DTOFonctionnalite;
import dto.DTOTypeFonctionnalite;
import fr.afcepf.adopteundev.gestion.cdc.IUCGestionCdc;
import fr.afcepf.adopteundev.gestion.projet.IUCProjet;
import fr.afcepf.adopteundev.managedbean.util.ContextFactory;
import fr.afcepf.adopteundev.managedbean.util.UcName;

@ManagedBean
@SessionScoped
public class MBAjoutFonctionnalite {

	private Set<DTOTypeFonctionnalite> listTypeFonctionn;
	private DTOTypeFonctionnalite selectedTypeFonction = new DTOTypeFonctionnalite();
	private List<DTOFonctionnalite> listeFonctionnaliteCree = new ArrayList<>();
	private String commentaire;
	private DTOCdc cdc;
	private boolean actionAjout = true;
	@ManagedProperty(value = "#{MBAjoutCdc}")
	MBAjoutCdc beanCDC;
	private IUCGestionCdc gestionCdc;

	private IUCProjet gestionProjet;

	@PostConstruct
	private void obtenirLesInterfaces() {

		gestionCdc = (IUCGestionCdc) ContextFactory
				.createProxy(UcName.UCGESTIONCDC);
		gestionProjet = (IUCProjet) ContextFactory
				.createProxy(UcName.UCGESTIONPROJET);
		listTypeFonctionn = gestionCdc.recupTousLesTypesFonctionnalites();
		cdc = gestionCdc.recupCdcParId(2);
		// cdc = beanCDC.getCdc();
	}

	public List<DTOFonctionnalite> getListeFonctionnaliteCree() {
		return listeFonctionnaliteCree;
	}

	public void setListeFonctionnaliteCree(
			List<DTOFonctionnalite> listeFonctionnaliteCree) {
		this.listeFonctionnaliteCree = listeFonctionnaliteCree;
	}

	public DTOTypeFonctionnalite getSelectedTypeFonction() {
		return selectedTypeFonction;
	}

	public void setSelectedTypeFonction(
			DTOTypeFonctionnalite selectedTypeFonction) {
		this.selectedTypeFonction = selectedTypeFonction;
	}

	public Set<DTOTypeFonctionnalite> getListTypeFonctionn() {
		return listTypeFonctionn;
	}

	public void setListTypeFonctionn(
			Set<DTOTypeFonctionnalite> listTypeFonctionn) {
		this.listTypeFonctionn = listTypeFonctionn;
	}

	public DTOCdc getCdc() {
		return cdc;
	}

	public void setCdc(DTOCdc cdc) {
		this.cdc = cdc;
	}

	public void ajouterFonctionnaliteSaisi() {
		DTOFonctionnalite fonctionnaliteCree = new DTOFonctionnalite();
		fonctionnaliteCree.setCommentaire(commentaire);
		System.out.println("type fonctionnalite "
				+ selectedTypeFonction.getIdTypeFonctionnalite());
		selectedTypeFonction = gestionCdc
				.recupTypeFonctionnaliteParID(selectedTypeFonction
						.getIdTypeFonctionnalite());
			fonctionnaliteCree.setTypeFonctionnalite(selectedTypeFonction);
			System.out.println("fonctionnalite id : "
					+ fonctionnaliteCree.getIdFonctionnalite());
			listeFonctionnaliteCree.add(fonctionnaliteCree);
			for (DTOFonctionnalite fonctionna : listeFonctionnaliteCree) {
				System.out.println("fonctionnalite : "
						+ fonctionna.getCommentaire());
			}

			actionAjout = false;
		}

		public String validerCDC() {
			gestionCdc.ajouterAssociationFonctCdcComplet(cdc,
					listeFonctionnaliteCree);
			return "";
		}

		public MBAjoutCdc getBeanCDC() {
			return beanCDC;
		}

		public void setBeanCDC(MBAjoutCdc beanCDC) {
			this.beanCDC = beanCDC;
		}

		public boolean isActionAjout() {
			return actionAjout;
		}

		public void setActionAjout(boolean actionAjout) {
			this.actionAjout = actionAjout;
		}

		public String getCommentaire() {
			return commentaire;
		}

		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}

	}
