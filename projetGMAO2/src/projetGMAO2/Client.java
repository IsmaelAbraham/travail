package projetGMAO2;

public class Client {
	
		
		
		
		/** 
		 * référence du numéroIFU
		 */
		private int matricule;		
		/**
		 * Mot de passe
		 */
		private String nom;	
		/**
		 * prix unitaire hors taxe
		 */
		private String prenom;		
		/**
		 * quantité en stock
		 */
		private String motDePasse;


		/**
		 * Constructeur
		 * @param reference référence de l'article
		 * @param designation désignation
		 * @param puHt prix unitaire hors taxe
		 * @param qteStock quantité en stock
		 */
		public Client(int matricule, String nom, String prenom,String motDePasse) {
			this.matricule=matricule;
			this.nom = nom;
			this.prenom = prenom;
			this.motDePasse = motDePasse;
		}
		
		/**
		 * getter pour l'attribut reference
		 * @return valeur de la reference article
		 */
		public int getMatricule() {
			return matricule;
		}
		/**
		 * getter pour l'attribut désignation
		 * @return valeur de la désignation article
		 */
		public String getNom() {
			return nom;
		}
		/**
		 * setter  pour l'attribut designation
		 * @param designation : nouvelle valeur de la désignation article
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}
		/**
		 * getter  pour l'attribut puHt
		 * @return valeur de prix unitaire HT
		 */
		public String getPrenom() {
			return prenom;
		}
		/**
		 * setter  pour l'attribut puHt
		 * @param puHt :  nouvelle valeur de prix unitaire HT
		 */
		public void setMatricule(int matricule) {
			this.matricule = matricule;
		}
		/**
		 * getter  pour l'attribut qteStock
		 * @return valeur de quantité en stock
		 */
		public String getMotDePasse() {
			return motDePasse;
		}
		/**
		 * setter  pour l'attribut qteStock
		 * @param qteStock : nouvelle valeur de prix unitaire HT
		 */
		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}

		/**
		 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
		 * pour l'affichage par exemple
		 */
		public String toString() {
			return "Administrateur [Matricule : " + matricule + ", Nom  : " + nom + ", Prénom : " + prenom + ", Mot de Passe : " + motDePasse + "]";
		}




}
