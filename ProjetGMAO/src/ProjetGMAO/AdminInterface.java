package ProjetGMAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInterface {

    private JFrame frame;
    private JTextField txtIdentifiant;
    private JPasswordField txtMotDePasse;
    private JLabel lblIdentifiant;
    private JLabel lblMotDePasse;
    private JButton btnConnexion;
    private JLabel lblAdmin;
    private JButton btnRetour;
    private JButton btnManageUsers;
    private JButton btnViewReports;
    private JButton btnOtherOperation;
    private JLabel lblErreur;
    private JButton btnCreerAdminEnt;
    private JButton btnModifierAdminEnt;
    private JButton btnSupprimerAdminEnt;
    private JButton btnConsulterListeClients; // Nouveau bouton
    private JButton btnConsulterListeAdmins; // Nouveau bouton

    /**
     * Create the application.
     */
    public AdminInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Set background color
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        lblAdmin = new JLabel("Bienvenue, Administrateur Système");
        lblAdmin.setFont(new Font("Arial", Font.BOLD, 18));
        lblAdmin.setBounds(260, 20, 400, 30);
        frame.getContentPane().add(lblAdmin);

        // Label Identifiant
        lblIdentifiant = new JLabel("Identifiant :");
        lblIdentifiant.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIdentifiant.setBounds(150, 80, 100, 30);
        frame.getContentPane().add(lblIdentifiant);

        // TextField Identifiant
        txtIdentifiant = new JTextField();
        txtIdentifiant.setBounds(300, 80, 300, 30);
        frame.getContentPane().add(txtIdentifiant);
        txtIdentifiant.setColumns(10);

        // Label Mot de Passe
        lblMotDePasse = new JLabel("Mot de Passe :");
        lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMotDePasse.setBounds(150, 130, 120, 30);
        frame.getContentPane().add(lblMotDePasse);

        // PasswordField Mot de Passe
        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setBounds(300, 130, 300, 30);
        frame.getContentPane().add(txtMotDePasse);
        txtMotDePasse.setColumns(10);

        // Button Connexion
        btnConnexion = new JButton("Connexion");
        btnConnexion.setFont(new Font("Arial", Font.BOLD, 16));
        btnConnexion.setBounds(300, 180, 200, 40);
        frame.getContentPane().add(btnConnexion);

        // Label Erreur (initialement caché)
        lblErreur = new JLabel("");
        lblErreur.setFont(new Font("Arial", Font.ITALIC, 14));
        lblErreur.setForeground(Color.RED);
        lblErreur.setBounds(300, 230, 300, 30);
        frame.getContentPane().add(lblErreur);

        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logique de vérification des identifiants (à compléter)
                String identifiant = txtIdentifiant.getText();
                String motDePasse = new String(txtMotDePasse.getPassword());

                if (identifiant.equals("admin") && motDePasse.equals("admin123")) {
                    // Afficher les boutons d'opérations
                    showAdminOperations();
                } else {
                    // Afficher un message d'erreur si les identifiants sont incorrects
                    lblErreur.setText("Identifiant ou mot de passe incorrect");
                    lblErreur.setVisible(true);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });

        // Bouton Retour
        btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Arial", Font.BOLD, 16));
        btnRetour.setBounds(10, 10, 100, 30);
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfaceHM window = new InterfaceHM();
                window.setVisible(true);
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnRetour);
    }

    private void showAdminOperations() {
        // Masquer les champs d'identifiant et de mot de passe, et le bouton de connexion
        lblIdentifiant.setVisible(false);
        txtIdentifiant.setVisible(false);
        lblMotDePasse.setVisible(false);
        txtMotDePasse.setVisible(false);
        btnConnexion.setVisible(false);
        lblErreur.setVisible(false);

        // Afficher les boutons d'opérations
        btnManageUsers = new JButton("Créer un compte client");
        btnManageUsers.setBounds(140, 100, 250, 40);
        btnManageUsers.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnManageUsers);

        btnViewReports = new JButton("Modifier un compte client");
        btnViewReports.setBounds(140, 150, 250, 40);
        btnViewReports.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnViewReports);

        btnOtherOperation = new JButton("Supprimer un compte client");
        btnOtherOperation.setBounds(140, 200, 250, 40);
        btnOtherOperation.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnOtherOperation);
        
        btnCreerAdminEnt = new JButton("Ajouter un Administrateur d'entreprise");
        btnCreerAdminEnt.setBounds(140, 250, 250, 40);
        btnCreerAdminEnt.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnCreerAdminEnt);
        
        btnModifierAdminEnt = new JButton("Modifier un Administrateur d'entreprise");
        btnModifierAdminEnt.setBounds(140, 300, 250, 40);
        btnModifierAdminEnt.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnModifierAdminEnt);
        
        btnSupprimerAdminEnt = new JButton("Supprimer un Administrateur d'entreprise");
        btnSupprimerAdminEnt.setBounds(140, 350, 250, 40);
        btnSupprimerAdminEnt.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnSupprimerAdminEnt);

        // Nouveau bouton Consulter liste des clients
        btnConsulterListeClients = new JButton("Consulter liste des clients");
        btnConsulterListeClients.setBounds(140, 400, 250, 40);
        btnConsulterListeClients.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnConsulterListeClients);

        // Nouveau bouton Consulter liste des administrateurs
        btnConsulterListeAdmins = new JButton("Consulter liste des administrateurs");
        btnConsulterListeAdmins.setBounds(140, 450, 250, 40);
        btnConsulterListeAdmins.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(btnConsulterListeAdmins);
        
        frame.revalidate();
        frame.repaint();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminInterface window = new AdminInterface();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
