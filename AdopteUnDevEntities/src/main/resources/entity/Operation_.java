package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.351+0100")
@StaticMetamodel(Operation.class)
public class Operation_ {
	public static volatile SingularAttribute<Operation, Double> montant;
	public static volatile SingularAttribute<Operation, Date> date;
	public static volatile SingularAttribute<Operation, Integer> idOperation;
	public static volatile SingularAttribute<Operation, Livrable> livrable;
	public static volatile SingularAttribute<Operation, TypeOperation> typeOperation;
}
