package enumeration;

public enum TypeEvaluationEnum {
    REFUSE("refuse"),ATTENTE("EN_ATTENTE"),VALIDE("valide");

    private String libelle = "";

    TypeEvaluationEnum(String name){
        this.libelle = name;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
