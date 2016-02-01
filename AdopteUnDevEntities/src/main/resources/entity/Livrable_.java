package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.345+0100")
@StaticMetamodel(Livrable.class)
public class Livrable_ {
	public static volatile SingularAttribute<Livrable, Date> echeance;
	public static volatile SingularAttribute<Livrable, Integer> idLivrable;
	public static volatile SingularAttribute<Livrable, String> fichier;
	public static volatile SingularAttribute<Livrable, Date> dateLivraison;
	public static volatile SingularAttribute<Livrable, Projet> projet;
	public static volatile SingularAttribute<Livrable, TypeEvaluation> typeEvaluation;
	public static volatile SetAttribute<Livrable, Operation> lesOperation;
}
