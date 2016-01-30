package enumeration;

public enum EtatProjetEnum {

	ENCOURS("EN COURS"), ARRETE("ARRETE"), FINI("FINI"), ENATTENTE("EN ATTENTE");
	
	private String libelle = "";

	EtatProjetEnum(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
