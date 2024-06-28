package projetGMAO2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin2Connexion {

	 private JPanel contentPanel;
	    private JButton btnNewButton;
	    private JTextField textFieldMatricule;
	    private JTextField textFieldNom;
	    private JTextField textFieldPrenom;
	    private JTextField textFieldMotDePasse;
	    private ClientDAO clientDAO;
	    private JFrame parentFrame;

	    public Admin2Connexion(JFrame parentFrame) {
	        this.parentFrame = parentFrame;
	        initialize();
	        this.clientDAO = new ClientDAO();
	    }

	    private void initialize() {
	        contentPanel = new JPanel();
	        contentPanel.setLayout(null);

	        btnNewButton = new JButton("Connexion");
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnNewButton.setBounds(208, 350, 128, 23);
	        contentPanel.add(btnNewButton);

	        textFieldMatricule = new JTextField();
	        textFieldMatricule.setBounds(250, 36, 176, 32);
	        contentPanel.add(textFieldMatricule);
	        textFieldMatricule.setColumns(10);

	        textFieldNom = new JTextField();
	        textFieldNom.setBounds(250, 106, 176, 32);
	        contentPanel.add(textFieldNom);
	        textFieldNom.setColumns(10);

	        textFieldPrenom = new JTextField();
	        textFieldPrenom.setBounds(250, 176, 176, 32);
	        contentPanel.add(textFieldPrenom);
	        textFieldPrenom.setColumns(10);

	        textFieldMotDePasse = new JTextField();
	        textFieldMotDePasse.setBounds(250, 246, 176, 32);
	        contentPanel.add(textFieldMotDePasse);
	        textFieldMotDePasse.setColumns(10);

	        JLabel lblMatricule = new JLabel("Matricule:");
	        lblMatricule.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblMatricule.setBounds(105, 40, 86, 23);
	        contentPanel.add(lblMatricule);

	        JLabel lblNom = new JLabel("Nom:");
	        lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblNom.setBounds(105, 110, 98, 23);
	        contentPanel.add(lblNom);

	        JLabel lblPrenom = new JLabel("Prénom:");
	        lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblPrenom.setBounds(105, 180, 86, 23);
	        contentPanel.add(lblPrenom);

	        JLabel lblMotDePasse = new JLabel("Mot de Passe:");
	        lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblMotDePasse.setBounds(105, 250, 98, 23);
	        contentPanel.add(lblMotDePasse);

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
	                    boolean resultFonction = clientDAO.verifierCompte(matricule, motDePasse);
	                    System.out.println("Résultat de verifierCompte: " + resultFonction);

	                    if (resultFonction) {
	                        // Open a new window if verification is successful
	                        JOptionPane.showMessageDialog(contentPanel, "Connexion réussie.", "Succès", JOptionPane.INFORMATION_MESSAGE);
	                        Admin2 clientInterface = new Admin2(parentFrame);
	                        InterfaceHM.getInstance().addContentToCentralPanel(clientInterface);
	                      //  clientInterface.setVisible(true);
	                      //  parentFrame.dispose();
	                      //  InterfaceHM.getInstance().addContentToCentralPanel(clientInterface);
	                        InterfaceHM.getInstance().activerBoutonResponsable();
	                    } else {
	                        JOptionPane.showMessageDialog(contentPanel, "Identifiant ou mot de passe incorrect.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(contentPanel, "Veuillez entrer un matricule valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	    }

	    public JPanel getContentPanel() {
	        return contentPanel;
	    }
}
