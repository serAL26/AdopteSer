package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T10:34:48.347+0100")
@StaticMetamodel(Message.class)
public class Message_ {
	public static volatile SingularAttribute<Message, Integer> idMessage;
	public static volatile SingularAttribute<Message, String> message;
	public static volatile SingularAttribute<Message, Date> dateEnvoi;
	public static volatile SingularAttribute<Message, String> titre;
	public static volatile SingularAttribute<Message, Message> messFille;
	public static volatile SingularAttribute<Message, Message> messMere;
	public static volatile SingularAttribute<Message, Utilisateur> utilisateur1;
	public static volatile SingularAttribute<Message, Utilisateur> utilisateur2;
}
