package ProjetGMAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtilisateurInterface {

    private JFrame frame;
    private JTextField txtIdentifiant;
    private JPasswordField txtMotDePasse;
    private JLabel lblIdentifiant;
    private JLabel lblMotDePasse;
    private JButton btnConnexion;
    private JLabel lblAdmin;
    private JButton btnRetour;
    private JButton btnManageResponsable;
    private JButton btnModifResp;
    private JButton btnSuppResp;
    private JButton btnConsulterListeResp; // Nouveau bouton
    private JButton btnModifierListeResp; // Nouveau bouton

    public UtilisateurInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color to light blue
        frame.getContentPane().setBackground(new Color(173, 216, 230));

        frame.getContentPane().setLayout(null);

        JLabel lblAdmin = new JLabel("Bienvenue, Administrateur Entreprise");
        lblAdmin.setBounds(140, 50, 350, 15);
        frame.getContentPane().add(lblAdmin);

        // Label Identifiant
        lblIdentifiant = new JLabel("Identifiant :");
        lblIdentifiant.setBounds(100, 80, 100, 30);
        frame.getContentPane().add(lblIdentifiant);

        // TextField Identifiant
        txtIdentifiant = new JTextField();
        txtIdentifiant.setBounds(200, 80, 200, 30);
        frame.getContentPane().add(txtIdentifiant);
        txtIdentifiant.setColumns(10);

        // Label Mot de Passe
        lblMotDePasse = new JLabel("Mot de Passe :");
        lblMotDePasse.setBounds(100, 130, 100, 30);
        frame.getContentPane().add(lblMotDePasse);

        // PasswordField Mot de Passe
        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setBounds(200, 130, 200, 30);
        frame.getContentPane().add(txtMotDePasse);
        txtMotDePasse.setColumns(10);

        // Button Connexion
        btnConnexion = new JButton("Connexion");
        btnConnexion.setBounds(200, 180, 200, 30);
        frame.getContentPane().add(btnConnexion);

        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showRespMaintOperations();
            }
        });

        // Bouton Retour
        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfaceHM window = new InterfaceHM();
                window.main(null);
                frame.dispose();
            }
        });
        btnRetour.setBounds(10, 10, 85, 21);
        frame.getContentPane().add(btnRetour);
    }

    private void showRespMaintOperations() {
        // Masquer les champs d'identifiant et de mot de passe, et le bouton de connexion
        lblIdentifiant.setVisible(false);
        txtIdentifiant.setVisible(false);
        lblMotDePasse.setVisible(false);
        txtMotDePasse.setVisible(false);
        btnConnexion.setVisible(false);

        // Afficher les boutons d'opérations
        btnManageResponsable = new JButton("Créer un compte Responsable Maintenance");
        btnManageResponsable.setBounds(140, 100, 300, 25);
        frame.getContentPane().add(btnManageResponsable);

        btnModifResp = new JButton("Modifier un compte Responsable Maintenance");
        btnModifResp.setBounds(140, 140, 300, 25);
        frame.getContentPane().add(btnModifResp);

        btnSuppResp = new JButton("Supprimer un compte Responsable de Maintenance");
        btnSuppResp.setBounds(140, 180, 300, 25);
        frame.getContentPane().add(btnSuppResp);

        // Nouveau bouton Consulter liste responsable de maintenance
        btnConsulterListeResp = new JButton("Consulter liste responsable de maintenance");
        btnConsulterListeResp.setBounds(140, 220, 300, 25);
        frame.getContentPane().add(btnConsulterListeResp);

        // Nouveau bouton Modifier liste responsable de maintenance
        btnModifierListeResp = new JButton("Modifier liste responsable de maintenance");
        btnModifierListeResp.setBounds(140, 260, 300, 25);
        frame.getContentPane().add(btnModifierListeResp);

        frame.revalidate();
        frame.repaint();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        UtilisateurInterface window = new UtilisateurInterface();
        window.setVisible(true);
    }
}
