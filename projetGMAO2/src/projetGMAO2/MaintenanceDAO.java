package projetGMAO2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {

    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String LOGIN = "prof";  
    final static String PASS = "isgeic2019";  

    public MaintenanceDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Maintenance m) {
        String sql = "INSERT INTO Maintenance (MaintenanceId, OperateurId, TypeMaintenance, Description, Equipement, Date_d) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, m.getMaintenanceId());
            ps.setInt(2, m.getOperateurId());
            ps.setString(3, m.getTypeMaintenance());
            ps.setString(4, m.getDescription());
            ps.setString(5, m.getEquipement());
            ps.setDate(6, Date.valueOf(m.getDate()));
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int modifier(Maintenance m) {
        String sql = "UPDATE Maintenance SET OperateurId = ?, TypeMaintenance = ?, Description = ?, Equipement = ?, Date_d = ? WHERE MaintenanceId = ?";
        try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, m.getOperateurId());
            ps.setString(2, m.getTypeMaintenance());
            ps.setString(3, m.getDescription());
            ps.setString(4, m.getEquipement());
            ps.setDate(5, Date.valueOf(m.getDate()));
            ps.setInt(6, m.getMaintenanceId());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Maintenance getMaintenance(int MaintenanceId) {
        String sql = "SELECT * FROM Maintenance WHERE MaintenanceId = ?";
        try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, MaintenanceId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Maintenance(rs.getInt("MaintenanceId"), rs.getInt("OperateurId"), rs.getString("TypeMaintenance"), rs.getString("Description"), rs.getString("Equipement"), rs.getDate("Date_d").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Maintenance> getListeMaintenances() {
        String sql = "SELECT * FROM Maintenance";
        List<Maintenance> maintenances = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, LOGIN, PASS);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                maintenances.add(new Maintenance(rs.getInt("MaintenanceId"), rs.getInt("OperateurId"), rs.getString("TypeMaintenance"), rs.getString("Description"), rs.getString("Equipement"), rs.getDate("Date_d").toLocalDate()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenances;
    }
    
    
}
