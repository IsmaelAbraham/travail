package ProjetGMAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgentInterface {

    private JFrame frame;
    private JTextField txtIdentifiant;
    private JPasswordField txtMotDePasse;
    private JLabel lblIdentifiant;
    private JLabel lblMotDePasse;
    private JButton btnConnexion;
    private JButton btnRetour;
    private JButton btnModifMaint;
    private JButton btnModifDevi;
    private JButton btnConsulte;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgentInterface agt = new AgentInterface();
                    agt.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AgentInterface() {
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

        JLabel lblAdmin = new JLabel("Bienvenue, Opérateur");
        lblAdmin.setBounds(140, 50, 200, 15);
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
                showOpOperations();
            }
        });

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

    private void showOpOperations() {
        // Masquer les champs d'identifiant et de mot de passe, et le bouton de connexion
        lblIdentifiant.setVisible(false);
        txtIdentifiant.setVisible(false);
        lblMotDePasse.setVisible(false);
        txtMotDePasse.setVisible(false);
        btnConnexion.setVisible(false);

        // Afficher les boutons d'opérations
        btnModifMaint = new JButton("Modifier un devis");
        btnModifMaint.setBounds(140, 220, 190, 25);
        frame.getContentPane().add(btnModifMaint);

        btnModifDevi = new JButton("Modifier une maintenance");
        btnModifDevi.setBounds(140, 260, 190, 25);
        frame.getContentPane().add(btnModifDevi);

        btnConsulte = new JButton("Consulter un devis");
        btnConsulte.setBounds(140, 300, 190, 25);
        frame.getContentPane().add(btnConsulte);

        frame.revalidate();
        frame.repaint();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
