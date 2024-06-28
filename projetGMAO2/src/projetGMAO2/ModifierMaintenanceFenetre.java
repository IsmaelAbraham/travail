package projetGMAO2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ModifierMaintenanceFenetre extends JFrame {
    private JTextField txtMaintenanceId, txtNomOperateur, txtTypeMaintenance, txtDescription, txtEquipement, txtDate;
    private JButton btnModifier;
    private Maintenance maintenance;
    private MaintenanceDAO maintenanceDAO;
    private JFrame parentFrame;

    public ModifierMaintenanceFenetre(JFrame parentFrame) {
    	this.parentFrame = parentFrame;
        this.maintenance = maintenance;
        this.maintenanceDAO = new MaintenanceDAO();

        setTitle("Modifier Maintenance");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelInput = new JPanel(new GridLayout(7, 2));
        panelInput.add(new JLabel("ID de Maintenance:"));
        txtMaintenanceId = new JTextField(String.valueOf(maintenance.getMaintenanceId()));
        txtMaintenanceId.setEditable(false);
        panelInput.add(txtMaintenanceId);

        panelInput.add(new JLabel("Nom de l'Opérateur:"));
        txtNomOperateur = new JTextField(String.valueOf(maintenance.getOperateurId()));
        panelInput.add(txtNomOperateur);

        panelInput.add(new JLabel("Type de Maintenance:"));
        txtTypeMaintenance = new JTextField(maintenance.getTypeMaintenance());
        panelInput.add(txtTypeMaintenance);

        panelInput.add(new JLabel("Description:"));
        txtDescription = new JTextField(maintenance.getDescription());
        panelInput.add(txtDescription);

        panelInput.add(new JLabel("Équipement:"));
        txtEquipement = new JTextField(maintenance.getEquipement());
        panelInput.add(txtEquipement);

        panelInput.add(new JLabel("Date (yyyy-mm-dd):"));
        txtDate = new JTextField(maintenance.getDate().toString());
        panelInput.add(txtDate);

        btnModifier = new JButton("Modifier");
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifierMaintenance();
            }
        });
        panelInput.add(btnModifier);

        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.CENTER);
    }

    private void modifierMaintenance() {
        try {
            int maintenanceId = Integer.parseInt(txtMaintenanceId.getText());
            int operateurId = Integer.parseInt(txtNomOperateur.getText());
            String typeMaintenance = txtTypeMaintenance.getText();
            String description = txtDescription.getText();
            String equipement = txtEquipement.getText();
            LocalDate date = LocalDate.parse(txtDate.getText());

            Maintenance newMaintenance = new Maintenance(maintenanceId, operateurId, typeMaintenance, description, equipement, date);
            maintenanceDAO.modifier(newMaintenance);

            JOptionPane.showMessageDialog(this, "Maintenance modifiée avec succès.");
            dispose(); // Ferme la fenêtre après modification
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification de la maintenance: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
