package enumeration;

public enum EtatProjetEnum {

	ENCOURS("Demarré"), ARRETE("Arreté"), FINI("Terminé"), ENATTENTE("En attente");
	
	private String libelle = "";

	EtatProjetEnum(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
