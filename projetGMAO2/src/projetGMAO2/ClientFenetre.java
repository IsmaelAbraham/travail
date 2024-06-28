package projetGMAO2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientFenetre extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldMatricule;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldMotDePasse;
    private JLabel labelMatricule;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelMotDePasse;
    private JButton ajouterClient;
    private JTextArea zoneTextListClient;
    private JScrollPane zoneDefilement;
    private ClientDAO monClientDAO;
    private JFrame parentFrame;

    public ClientFenetre(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.monClientDAO = new ClientDAO();
        initialize();
    }

    private void initialize() {
        setLayout(null);
        this.setBackground(new Color(128, 128, 128));

        labelMatricule = new JLabel("Matricule");
        labelMatricule.setBounds(40, 49, 82, 25);
        labelMatricule.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(labelMatricule);

        textFieldMatricule = new JTextField();
        textFieldMatricule.setBounds(146, 46, 304, 35);
        add(textFieldMatricule);

        labelNom = new JLabel("Nom");
        labelNom.setBounds(44, 108, 123, 27);
        labelNom.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(labelNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(146, 106, 304, 35);
        add(textFieldNom);

        labelPrenom = new JLabel("Prénom");
        labelPrenom.setBounds(44, 166, 67, 24);
        labelPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(labelPrenom);

        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(149, 163, 301, 35);
        add(textFieldPrenom);

        labelMotDePasse = new JLabel("Mot de passe");
        labelMotDePasse.setBounds(44, 240, 101, 24);
        labelMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(labelMotDePasse);

        textFieldMotDePasse = new JTextField();
        textFieldMotDePasse.setBounds(149, 237, 301, 35);
        add(textFieldMotDePasse);

        ajouterClient = new JButton("Ajouter");
        ajouterClient.setBounds(153, 294, 101, 23);
        ajouterClient.setHorizontalAlignment(SwingConstants.RIGHT);
        ajouterClient.addActionListener(this);
        add(ajouterClient);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(153, 329, 101, 23);
        btnRetour.setHorizontalAlignment(SwingConstants.LEFT);
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
              //  InterfaceHM.getInstance().setVisible(true);
              //  parentFrame.dispose();
            }
        });
        add(btnRetour);

        zoneTextListClient = new JTextArea(10, 20);
        zoneTextListClient.setEditable(false);
        zoneDefilement = new JScrollPane(zoneTextListClient);
        zoneDefilement.setBounds(10, 363, 764, 186);
        add(zoneDefilement);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        int retour;

        try {
            if (ae.getSource() == ajouterClient) {
                Client client = new Client(
                        Integer.parseInt(this.textFieldMatricule.getText()),
                        this.textFieldNom.getText(),
                        this.textFieldPrenom.getText(),
                        this.textFieldMotDePasse.getText());

                retour = monClientDAO.ajouter(client);
                System.out.println("" + retour + " ligne ajoutée ");
                if (retour == 1) {
                    JOptionPane.showMessageDialog(this, "Client ajouté !");
                    InterfaceHM.activerBoutonUtilisateur();
                }
                else
                    JOptionPane.showMessageDialog(this, "Erreur ajout client", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez contrôler vos saisies", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.err.println("Veuillez contrôler vos saisies");
        }
    }

	public JPanel getContentPanel() {
		// TODO Auto-generated method stub
		return this;
	}

  //  public static void main(String[] args) {
 //       EventQueue.invokeLater(new Runnable() {
 //           public void run() {
 //               try {
 //                   JFrame frame = new JFrame();
 //                   ClientFenetre clientFenetre = new ClientFenetre(frame);
  //                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //                 frame.getContentPane().add(clientFenetre);
    //                frame.setSize(800, 600); // Taille de la fenêtre
     //               frame.setVisible(true);
     //           } catch (Exception e) {
     //               e.printStackTrace();
      //          }
      //      }
      //  });
   // }
}
