package projetGMAO2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String LOGIN = "prof";
    final static String PASS = "isgeic2019";

    public ClientDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Client d) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("INSERT INTO Client (matricule, nom, prenom, motDePasse) VALUES (?, ?, ?, ?)");
            ps.setInt(1, d.getMatricule());
            ps.setString(2, d.getNom());
            ps.setString(3, d.getPrenom());
            ps.setString(4, d.getMotDePasse());
            retour = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    public Client getClient(int matricule) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client retour = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Client WHERE matricule = ?");
            ps.setInt(1, matricule);
            rs = ps.executeQuery();
            if (rs.next()) {
                retour = new Client(rs.getInt("matricule"), rs.getString("nom"), rs.getString("prenom"), rs.getString("motDePasse"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception ignore) {
            }
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    public List<Client> getListeClients() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Client> retour = new ArrayList<>();

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Client");
            rs = ps.executeQuery();
            while (rs.next()) {
                retour.add(new Client(rs.getInt("matricule"), rs.getString("nom"), rs.getString("prenom"), rs.getString("motDePasse")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception ignore) {
            }
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    public boolean verifierCompte(int matricule, String motDePasse) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean valide = false;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Client WHERE matricule = ? AND motDePasse = ?");
            ps.setInt(1, matricule);
            ps.setString(2, motDePasse);
            rs = ps.executeQuery();

            if (rs.next()) {
                valide = true;
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

        return valide;
    }
    
    
 // Méthode pour modifier un client existant
    public int modifierClient(Client d) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("UPDATE Client SET nom = ?, prenom = ?, motDePasse = ? WHERE matricule = ?");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getPrenom());
            ps.setString(3, d.getMotDePasse());
            ps.setInt(4, d.getMatricule());
            retour = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {}
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }
        return retour;
    }
    
    // Méthode pour supprimer un client par matricule
    public int supprimerClient(int matricule) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        try {
            // Connexion à la base de données
            con = DriverManager.getConnection(URL, LOGIN, PASS);

            // Préparation de l'instruction SQL pour supprimer un client par matricule
            ps = con.prepareStatement("DELETE FROM Client WHERE matricule = ?");
            ps.setInt(1, matricule);

            // Exécution de la requête
            retour = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermeture du PreparedStatement et de la connexion
            try {
                if (ps != null) ps.close();
            } catch (Exception ignore) {}
            try {
                if (con != null) con.close();
            } catch (Exception ignore) {}
        }
        return retour;
    }


}
