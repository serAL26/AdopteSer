package enumeration;

public enum TypeCDC {
REMARQUE("REMARQUE"), CDC("CAHIER DE CHARGE");
	
	private String libelle = "";

	TypeCDC(String name) {
		this.libelle = name;
	}

	public String toString() {
		return libelle;
	}
}
