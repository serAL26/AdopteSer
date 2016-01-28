package fr.afcepf.adopteundev.managedbean.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextFactory {

	private ContextFactory() {}
	
	public static Object createProxy(String ucName) {
		Context ctx = null;
		Object objet = null;
		
		Properties props = new Properties();
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
		try {
			ctx = new InitialContext(props);
			objet = ctx.lookup(ucName);
		} catch (NamingException e) {
			System.out.println("ca ne marche pas au niveau de la transition entre tomcat et jboss (contextFactory)");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objet;
	}

	
}
