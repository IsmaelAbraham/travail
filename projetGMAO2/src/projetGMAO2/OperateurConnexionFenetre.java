package projetGMAO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperateurConnexionFenetre extends JPanel {

    private JTextField textFieldMatricule;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldMotDePasse;
    private ClientDAO compteCDAO;
    private JFrame parentFrame;

    public OperateurConnexionFenetre(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.compteCDAO = new ClientDAO();
        initialize();
    }

    private void initialize() {
        setLayout(null);

        JButton btnNewButton = new JButton("Connexion");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(208, 350, 128, 23);
        add(btnNewButton);

        textFieldMatricule = new JTextField();
        textFieldMatricule.setBounds(250, 36, 176, 32);
        add(textFieldMatricule);
        textFieldMatricule.setColumns(10);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(250, 106, 176, 32);
        add(textFieldNom);
        textFieldNom.setColumns(10);

        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(250, 176, 176, 32);
        add(textFieldPrenom);
        textFieldPrenom.setColumns(10);

        textFieldMotDePasse = new JTextField();
        textFieldMotDePasse.setBounds(250, 246, 176, 32);
        add(textFieldMotDePasse);
        textFieldMotDePasse.setColumns(10);

        JLabel lblMatricule = new JLabel("Matricule:");
        lblMatricule.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMatricule.setBounds(105, 40, 86, 23);
        add(lblMatricule);

        JLabel lblNom = new JLabel("Nom:");
        lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNom.setBounds(105, 110, 98, 23);
        add(lblNom);

        JLabel lblPrenom = new JLabel("Prénom:");
        lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrenom.setBounds(105, 180, 86, 23);
        add(lblPrenom);

        JLabel lblMotDePasse = new JLabel("Mot de Passe:");
        lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMotDePasse.setBounds(105, 250, 98, 23);
        add(lblMotDePasse);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricule = Integer.parseInt(textFieldMatricule.getText());
                    String nom = textFieldNom.getText();
                    String prenom = textFieldPrenom.getText();
                    String motDePasse = textFieldMotDePasse.getText();

                    // Messages de débogage pour vérifier les valeurs
                    System.out.println("Matricule: " + matricule);
                    System.out.println("Nom: " + nom);
                    System.out.println("Prénom: " + prenom);
                    System.out.println("Mot de Passe: " + motDePasse);

                    // Utilisation de l'instance de ClientDAO pour appeler verifierCompte
                    boolean resultFonction = compteCDAO.verifierCompte(matricule, motDePasse);
                    System.out.println("Résultat de verifierCompte: " + resultFonction);

                    if (resultFonction) {
                        // Open a new window if verification is successful
                        JOptionPane.showMessageDialog(null, "Connexion réussie.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        AgentInterface clientInterface = new AgentInterface(parentFrame);
                        InterfaceHM.getInstance().addContentToCentralPanel(clientInterface);
                        InterfaceHM.getInstance().activerBoutonResponsable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrect.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un matricule valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getContentPanel() {
        return this;
    }
}
