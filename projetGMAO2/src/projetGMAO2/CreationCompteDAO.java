package projetGMAO2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreationCompteDAO {
	
	  /**
     * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
     * sont des constantes
     */
    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //final static String URL = "jdbc:mysql://localhost/stock";
    
    final static String LOGIN = "prof";  //exemple BDD1
    final static String PASS = "isgeic2019";   //exemple BDD1

    /**
     * Constructeur de la classe
     */
    public CreationCompteDAO() {
        // chargement du pilote de bases de données
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    /**
     * Permet d'ajouter un compte dans la table compte. Le mode est auto-commit
     * par défaut : chaque insertion est validée
     * 
     * @param c le compte à ajouter
     * @return retourne le nombre de lignes ajoutées dans la table
     */
    public int ajouter(CreationCompte c) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        // connexion à la base de données
        try {
            // tentative de connexion
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            // préparation de l'instruction SQL, chaque ? représente une valeur
            // à communiquer dans l'insertion
            ps = con.prepareStatement("INSERT INTO Compte (matricule, password, fonction) VALUES (?, ?, ?)");
            ps.setInt(1, c.getMatricule());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getFonction());

            // Exécution de la requête
            retour = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fermeture du preparedStatement et de la connexion
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {}
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }
        return retour;
    }

    /**
     * Permet de récupérer un compte à partir de son matricule
     * 
     * @param matricule le matricule du compte à récupérer
     * @return le compte trouvé; null si aucun compte ne correspond à ce matricule
     */
    public CreationCompte getCompte(int matricule) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CreationCompte retour = null;

        // connexion à la base de données
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM compte WHERE matricule = ?");
            ps.setInt(1, matricule);

            // on exécute la requête
            rs = ps.executeQuery();
            // passe à la première (et unique) ligne retournée
            if (rs.next()) {
                retour = new CreationCompte(rs.getInt("matricule"), rs.getString("password"), rs.getString("fonction"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fermeture du ResultSet, du PreparedStatement et de la Connexion
            try {
                if (rs != null) rs.close();
            } catch (Exception ignore) {}
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {}
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }
        return retour;
    }

    /**
     * Permet de récupérer tous les comptes stockés dans la table compte
     * 
     * @return une ArrayList de CreationCompte
     */
    public List<CreationCompte> getListeCompte() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CreationCompte> retour = new ArrayList<CreationCompte>();

        // connexion à la base de données
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM compte");

            // on exécute la requête
            rs = ps.executeQuery();
            // on parcourt les lignes du résultat
            while (rs.next()) {
                retour.add(new CreationCompte(rs.getInt("matricule"), rs.getString("password"), rs.getString("fonction")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fermeture du rs, du preparedStatement et de la connexion
            try {
                if (rs != null) rs.close();
            } catch (Exception ignore) {}
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {}
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }
        return retour;
    }
    
    public String verifierCompte(int matricule, String password,String fonction) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
      //  String fonction = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT fonction FROM compte WHERE matricule = ? AND password = ? AND fonction= ?");
            ps.setInt(1, matricule);
            ps.setString(2, password);
            ps.setString(3, fonction);
            rs = ps.executeQuery();

            if (rs.next()) {
                fonction = rs.getString("fonction");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }

        return fonction;
    }




    // main permettant de tester la classe
    public static void main(String[] args) {
        CreationCompteDAO compteDAO = new CreationCompteDAO();
        
        // test de la méthode ajouter
        CreationCompte c1 = new CreationCompte(1, "password123", "admin");
        int retour = compteDAO.ajouter(c1);
        System.out.println(retour + " lignes ajoutées");

        // test de la méthode getCompte
        CreationCompte c2 = compteDAO.getCompte(1);
        System.out.println(c2);

        // test de la méthode getListeCompte
        List<CreationCompte> liste = compteDAO.getListeCompte();
        // affichage des comptes
        for (CreationCompte compte : liste) {
            System.out.println(compte.toString());
        }
    }

}
