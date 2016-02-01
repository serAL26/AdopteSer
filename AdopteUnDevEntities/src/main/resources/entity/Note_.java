package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.349+0100")
@StaticMetamodel(Note.class)
public class Note_ {
	public static volatile SingularAttribute<Note, Integer> idNote;
	public static volatile SingularAttribute<Note, Integer> idNoteur;
	public static volatile SingularAttribute<Note, Integer> idEstNote;
	public static volatile SingularAttribute<Note, String> Commentaire;
	public static volatile SingularAttribute<Note, Double> Note;
	public static volatile SingularAttribute<Note, Date> Date;
	public static volatile SingularAttribute<Note, Projet> projet;
}
