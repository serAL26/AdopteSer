package fr.afcepf.adopteundev.managedbean.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextFactory {

	private ContextFactory() {}
	
	public static Object createProxy(String ucJNDI) {
		Context ctx = null;
		Object objet = null;
		
		Properties props = new Properties();
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "remote://192.168.100.154:4447");
		props.put("jboss.naming.client.ejb.context", true);
		
		try {
			ctx = new InitialContext(props);
			objet = ctx.lookup(ucJNDI);
		} catch (NamingException e) {
			System.out.println("ca ne marche pas au niveau de la transition entre tomcat et jboss (contextFactory)");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objet;
	}

	
}
