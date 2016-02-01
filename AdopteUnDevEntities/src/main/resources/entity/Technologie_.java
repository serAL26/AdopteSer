package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.358+0100")
@StaticMetamodel(Technologie.class)
public class Technologie_ {
	public static volatile SingularAttribute<Technologie, Integer> idTechnologie;
	public static volatile SingularAttribute<Technologie, String> technologieLibelle;
	public static volatile SetAttribute<Technologie, AssociationTypeServiceTechno> lesAssociationTypeServiceTechno;
	public static volatile SetAttribute<Technologie, AssociationDevTechno> lesAssociationDevTechno;
}
