package dto;


/**
 * 
 */
public class DTOAdresse {

    /**
     * Default constructor
     */
    public DTOAdresse() {
    }

    /**
     * 
     */
    private Integer idAdresse;

    /**
     * 
     */
    private String numero;

    /**
     * 
     */
    private String rue;


    /**
     * 
     */
    public DTOVille ville;


	public Integer getIdAdresse() {
		return idAdresse;
	}


	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public DTOVille getVille() {
		return ville;
	}


	public void setVille(DTOVille ville) {
		this.ville = ville;
	}

    
}