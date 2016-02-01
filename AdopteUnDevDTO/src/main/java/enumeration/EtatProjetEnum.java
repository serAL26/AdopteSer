package enumeration;

public enum EtatProjetEnum {

	ENCOURS("Demarre"), ARRETE("Arrete"), FINI("Termine"), ENATTENTE("En attente");
	
	private String libelle = "";

	EtatProjetEnum(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
