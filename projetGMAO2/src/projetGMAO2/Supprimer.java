package projetGMAO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Supprimer extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldMatricule;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldMotDePasse;
    private JLabel labelMatricule;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelMotDePasse;
    private JButton supprimerButton;
    private JTextArea zoneTextListClient;
    private JScrollPane zoneDefilement;
    private ClientDAO monClientDAO;
    private JFrame parentFrame;

    public Supprimer(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.monClientDAO = new ClientDAO();
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(new Color(128, 128, 128));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        labelMatricule = new JLabel("Matricule");
        labelMatricule.setFont(new Font("Tahoma", Font.BOLD, 14));
        formPanel.add(labelMatricule);

        textFieldMatricule = new JTextField();
        formPanel.add(textFieldMatricule);

        labelNom = new JLabel("Nom");
        labelNom.setFont(new Font("Tahoma", Font.BOLD, 14));
        formPanel.add(labelNom);

        textFieldNom = new JTextField();
        formPanel.add(textFieldNom);

        labelPrenom = new JLabel("Prénom");
        labelPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
        formPanel.add(labelPrenom);

        textFieldPrenom = new JTextField();
        formPanel.add(textFieldPrenom);

        labelMotDePasse = new JLabel("Mot de Passe");
        labelMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        formPanel.add(labelMotDePasse);

        textFieldMotDePasse = new JTextField();
        formPanel.add(textFieldMotDePasse);

        supprimerButton = new JButton("Supprimer");
        supprimerButton.addActionListener(this);
        formPanel.add(supprimerButton);

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
            //    InterfaceHM window = InterfaceHM.getInstance(); // Utiliser l'instance existante
              //  window.setVisible(true);
              //  parentFrame.dispose();
            }
        });
        formPanel.add(retourButton);

        add(formPanel, BorderLayout.NORTH);

        zoneTextListClient = new JTextArea(10, 20);
        zoneTextListClient.setEditable(false);
        zoneDefilement = new JScrollPane(zoneTextListClient);
        add(zoneDefilement, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == supprimerButton) {
                int matricule = Integer.parseInt(textFieldMatricule.getText());
                Client client = new Client(
                    matricule,
                    textFieldNom.getText(),
                    textFieldPrenom.getText(),
                    textFieldMotDePasse.getText()
                );

                int retour = monClientDAO.supprimerClient(matricule);
                if (retour == 1) {
                    JOptionPane.showMessageDialog(this, "Client supprimé !");
                } else {
                    JOptionPane.showMessageDialog(this, "Erreur Suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez contrôler vos saisies", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.err.println("Veuillez contrôler vos saisies");
        }
    }

    public JPanel getContentPanel() {
        return this;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Supprimer Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(new Supprimer(frame).getContentPanel());
        frame.setVisible(true);
    }
}
