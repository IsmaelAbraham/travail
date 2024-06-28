package projetGMAO2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceN extends JPanel {

    private JButton btnCreerAdm;
    private JButton btnModifierAdm;
    private JButton btnSupprimerAdm;
    private JButton btnSaisirMaint;
    private JButton btnModifierMaint;
    private JButton btnSuppMaint;
    private JButton btnConsulte;
    private JButton btnRetour;
    private ClientDAO clientDAO;
    private JFrame parentFrame;

    public InterfaceN(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
        this.clientDAO = new ClientDAO();
    }

    private void initialize() {
        setLayout(null);

        JButton btnNewButton = new JButton("Connexion");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(208, 350, 128, 23);
        add(btnNewButton);

        JTextField textFieldMatricule = new JTextField();
        textFieldMatricule.setBounds(250, 36, 176, 32);
        add(textFieldMatricule);
        textFieldMatricule.setColumns(10);

        JTextField textFieldNom = new JTextField();
        textFieldNom.setBounds(250, 106, 176, 32);
        add(textFieldNom);
        textFieldNom.setColumns(10);

        JTextField textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(250, 176, 176, 32);
        add(textFieldPrenom);
        textFieldPrenom.setColumns(10);

        JTextField textFieldMotDePasse = new JTextField();
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

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
               // InterfaceHM window = InterfaceHM.getInstance();
               // window.setVisible(true);
               // parentFrame.dispose();
            }
        });
        btnRetour.setBounds(10, 10, 85, 21);
        add(btnRetour);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matriculeStr = textFieldMatricule.getText();
                String nom = textFieldNom.getText();
                String prenom = textFieldPrenom.getText();
                String motDePasse = textFieldMotDePasse.getText();

                try {
                    int matricule = Integer.parseInt(matriculeStr);
                    boolean resultFonction = clientDAO.verifierCompte(matricule, motDePasse);

                    if (resultFonction) {
                        JOptionPane.showMessageDialog(null, "Connexion réussie.");
                        ResponsableInterface adminInterface = new ResponsableInterface(parentFrame);
                        InterfaceHM.getInstance().addContentToCentralPanel(adminInterface);
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

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}
