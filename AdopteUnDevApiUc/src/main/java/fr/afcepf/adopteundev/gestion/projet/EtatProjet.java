package fr.afcepf.adopteundev.gestion.projet;

public enum EtatProjet {

	ENCOURS("EN COURS"), ARRETE("ARRETE"), FINI("FINI"), ENATTENTE("EN ATTENTE");
	
	private String libelle = "";

	EtatProjet(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
