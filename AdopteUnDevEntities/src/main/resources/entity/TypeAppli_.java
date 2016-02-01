package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.359+0100")
@StaticMetamodel(TypeAppli.class)
public class TypeAppli_ {
	public static volatile SingularAttribute<TypeAppli, Integer> idTypeAppli;
	public static volatile SingularAttribute<TypeAppli, String> libelle;
	public static volatile SetAttribute<TypeAppli, TypeService> lesServices;
}
