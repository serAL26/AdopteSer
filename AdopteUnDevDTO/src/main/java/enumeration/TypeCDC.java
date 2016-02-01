package enumeration;

public enum TypeCDC {
REMARQUE("Remarque"), CDC("Cahier de charge");
	
	private String libelle = "";

	TypeCDC(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
