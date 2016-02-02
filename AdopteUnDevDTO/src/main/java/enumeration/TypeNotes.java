package enumeration;

public enum TypeNotes {
	UN(">1"), DEUX(">2"), TROIS(">3"), QUATRE(">4");

	private String libelle = "";

	TypeNotes(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
