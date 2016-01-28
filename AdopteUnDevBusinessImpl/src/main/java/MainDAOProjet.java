

import java.util.List;

import org.apache.log4j.Logger;

import entity.TypeAppli;

public class MainDAOProjet {
	private static Logger log = Logger.getLogger(MainDAOProjet.class);
	public static void main(String[] args) {
		TestDaoProjet testDao = new TestDaoProjet();
		List<TypeAppli> liste = testDao.rechercherAppli();
		for (TypeAppli typeAppli : liste) {
			log.info(typeAppli);
		}

	}

}
