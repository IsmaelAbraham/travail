package projetGMAO2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class MaintenanceFenetre extends JPanel {
    private JTextField txtMaintenanceId, txtNomOperateur, txtTypeMaintenance, txtDescription, txtEquipement, txtDate;
    private JTable table;
    private DefaultTableModel tableModel;
    private MaintenanceDAO maintenanceDAO;
    private JFrame parentFrame;

    public MaintenanceFenetre(JFrame parentFrame) {
    	this.parentFrame = parentFrame;
        maintenanceDAO = new MaintenanceDAO();

        // Panel de saisie
        JPanel panelInput = new JPanel(new GridLayout(7, 2));
        panelInput.add(new JLabel("ID de Maintenance:"));
        txtMaintenanceId = new JTextField();
        panelInput.add(txtMaintenanceId);

        panelInput.add(new JLabel("Nom de l'Opérateur:"));
        txtNomOperateur = new JTextField();
        panelInput.add(txtNomOperateur);

        panelInput.add(new JLabel("Type de Maintenance:"));
        txtTypeMaintenance = new JTextField();
        panelInput.add(txtTypeMaintenance);

        panelInput.add(new JLabel("Description:"));
        txtDescription = new JTextField();
        panelInput.add(txtDescription);

        panelInput.add(new JLabel("Équipement:"));
        txtEquipement = new JTextField();
        panelInput.add(txtEquipement);

        panelInput.add(new JLabel("Date (yyyy-mm-dd):"));
        txtDate = new JTextField();
        panelInput.add(txtDate);

        JButton btnAjouter = new JButton("Ajouter Maintenance");
        panelInput.add(btnAjouter);

        // Table pour afficher les maintenances
        tableModel = new DefaultTableModel(new String[]{"ID", "Nom Opérateur", "Type Maintenance", "Description", "Équipement", "Date"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout de la fenêtre
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action listener pour le bouton Ajouter
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterMaintenance();
            }
        });

        // Charger les maintenances existantes
        chargerMaintenances();
    }

    private void ajouterMaintenance() {
        try {
            int maintenanceId = Integer.parseInt(txtMaintenanceId.getText());
            int operateurId = Integer.parseInt(txtNomOperateur.getText());
            String typeMaintenance = txtTypeMaintenance.getText();
            String description = txtDescription.getText();
            String equipement = txtEquipement.getText();
            LocalDate date = LocalDate.parse(txtDate.getText());

            Maintenance maintenance = new Maintenance(maintenanceId, operateurId, typeMaintenance, description, equipement, date);
            maintenanceDAO.ajouter(maintenance);

            // Ajouter la maintenance à la table
            tableModel.addRow(new Object[]{maintenanceId, operateurId, typeMaintenance, description, equipement, date});

            // Clear input fields
            txtMaintenanceId.setText("");
            txtNomOperateur.setText("");
            txtTypeMaintenance.setText("");
            txtDescription.setText("");
            txtEquipement.setText("");
            txtDate.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout de la maintenance: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void chargerMaintenances() {
        tableModel.setRowCount(0);  // Clear existing rows
        List<Maintenance> maintenances = maintenanceDAO.getListeMaintenances();
        for (Maintenance maintenance : maintenances) {
            tableModel.addRow(new Object[]{maintenance.getMaintenanceId(), maintenance.getOperateurId(), maintenance.getTypeMaintenance(), maintenance.getDescription(), maintenance.getEquipement(), maintenance.getDate()});
        }
    }

 //   public static void main(String[] args) {
 //       SwingUtilities.invokeLater(new Runnable() {
 //           @Override
  //          public void run() {
  //              JFrame frame = new JFrame();
  //              MaintenanceFenetre panel = new MaintenanceFenetre(parentFrame);
  //              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //              frame.setSize(800, 600);
  //              frame.setContentPane(panel);
  //              frame.setVisible(true);
  //          }
  //      });
  //  }
}
