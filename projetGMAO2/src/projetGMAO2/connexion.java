package projetGMAO2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class connexion {

    private JFrame frame;
    private JButton btnNewButton;
    private JTextField textFieldMatricule;
    private JPasswordField textFieldPassword;
    private ClientDAO clientDAO;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    connexion window = new connexion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public connexion() {
        initialize();
        this.clientDAO = new ClientDAO();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.setBounds(100, 100, 637, 510);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btnNewButton = new JButton("Connexion");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(208, 300, 128, 23);
        frame.getContentPane().add(btnNewButton);

        textFieldMatricule = new JTextField();
        textFieldMatricule.setBounds(250, 36, 176, 32);
        frame.getContentPane().add(textFieldMatricule);
        textFieldMatricule.setColumns(10);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(250, 106, 176, 32);
        frame.getContentPane().add(textFieldPassword);

        JLabel lblNewLabel = new JLabel("Identifiant:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(105, 40, 86, 23);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblMotDePasse = new JLabel("Mot de Passe:");
        lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMotDePasse.setBounds(104, 115, 98, 23);
        frame.getContentPane().add(lblMotDePasse);

     //   JButton btnNewButton_1 = new JButton("Créer un compte");
     //   btnNewButton_1.addActionListener(new ActionListener() {
     //       public void actionPerformed(ActionEvent e) {
     //           CreationCompteFenetre k = new CreationCompteFenetre();
     //           k.frame.setVisible(true);
     //           frame.dispose();
     //       }
     //   });
     //   btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
     //   btnNewButton_1.setBounds(208, 350, 128, 23);
     //   frame.getContentPane().add(btnNewButton_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricule = Integer.parseInt(textFieldMatricule.getText());
                    String password = new String(textFieldPassword.getPassword());

                    // Utilisation de l'instance de ClientDAO pour appeler verifierCompte
                    boolean valide = clientDAO.verifierCompte(matricule, password);

                    if (valide) {
                        // Remplacer par votre logique d'interface appropriée
                        JOptionPane.showMessageDialog(frame, "Connexion réussie.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        InterfaceN f=new InterfaceN(frame);
                        InterfaceHM.getInstance().addContentToCentralPanel(f);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Identifiant ou mot de passe incorrect.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un identifiant valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
