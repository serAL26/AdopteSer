package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.371+0100")
@StaticMetamodel(TypeService.class)
public class TypeService_ {
	public static volatile SingularAttribute<TypeService, Integer> idTypeService;
	public static volatile SingularAttribute<TypeService, String> libelle;
	public static volatile SingularAttribute<TypeService, TypeAppli> typeAppli;
	public static volatile SetAttribute<TypeService, AssociationTypeServiceTechno> lesAssociationTypeServiceTechno;
}
