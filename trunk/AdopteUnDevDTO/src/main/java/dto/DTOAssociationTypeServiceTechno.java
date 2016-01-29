package dto;

import java.io.Serializable;

public class DTOAssociationTypeServiceTechno implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idAssociationTypeServiceTechno;
	  
	  private DTOTypeService typeService;

	    
	    private DTOTechnologie technologie;


		public Integer getIdAssociationTypeServiceTechno() {
			return idAssociationTypeServiceTechno;
		}


		public void setIdAssociationTypeServiceTechno(
				Integer idAssociationTypeServiceTechno) {
			this.idAssociationTypeServiceTechno = idAssociationTypeServiceTechno;
		}


		public DTOTypeService getTypeService() {
			return typeService;
		}


		public void setTypeService(DTOTypeService typeService) {
			this.typeService = typeService;
		}


		public DTOTechnologie getTechnologie() {
			return technologie;
		}


		public void setTechnologie(DTOTechnologie technologie) {
			this.technologie = technologie;
		}

}
