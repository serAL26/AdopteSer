package enumeration;

public enum EtatProjetEnum {

	ENCOURS("Demarr�"), ARRETE("Arret�"), FINI("Termin�"), ENATTENTE("En attente");
	
	private String libelle = "";

	EtatProjetEnum(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
