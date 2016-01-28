

import java.util.List;

import javax.ejb.EJB;

import entity.TypeAppli;
import fr.afcepf.adopteundev.idao.projet.IDaoTypeAppli;

public class TestDaoProjet {
	
	
	 @EJB
     private IDaoTypeAppli daoTypeAppli;
	 
	public List<TypeAppli> rechercherAppli(){
		return daoTypeAppli.getAllApplis();
	}

}
