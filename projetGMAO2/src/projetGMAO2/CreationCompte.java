package projetGMAO2;

public class CreationCompte {
	
	/** 
	 * référence du matricule
	 */
	private int matricule;		
	/**
	 * Mot de passe
	 */
	private String password;	
	/**
	 * Fonction de l'utilisateur
	 */
	private String fonction;		

	/**
	 * Constructeur
	 * @param matricule référence du matricule
	 * @param password mot de passe
	 * @param fonction fonction de l'utilisateur
	 */
	public CreationCompte(int matricule, String password, String fonction) {
		this.matricule = matricule;
		this.password = password;
		this.fonction = fonction;
	}
	
	/**
	 * getter pour l'attribut matricule
	 * @return valeur du matricule
	 */
	public int getMatricule() {
		return matricule;
	}

	/**
	 * setter pour l'attribut matricule
	 * @param matricule : nouvelle valeur du matricule
	 */
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	/**
	 * getter pour l'attribut password
	 * @return valeur du mot de passe
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter pour l'attribut password
	 * @param password : nouvelle valeur du mot de passe
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter pour l'attribut fonction
	 * @return valeur de la fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * setter pour l'attribut fonction
	 * @param fonction : nouvelle valeur de la fonction
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	@Override
	public String toString() {
		return "CreationCompte [Matricule : " + matricule + ", Password : " + password + ", Fonction : " + fonction + "]";
	}

}
