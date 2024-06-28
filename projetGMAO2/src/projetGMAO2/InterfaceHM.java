package projetGMAO2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class InterfaceHM {

    private JFrame frame;
    private static JButton btnAgent;
    private static InterfaceHM instance;
    private static JButton btnUtilisateur;
    private static JButton btnResponsable;
    private JPanel centralPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceHM window = InterfaceHM.getInstance();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static InterfaceHM getInstance() {
        if (instance == null) {
            instance = new InterfaceHM();
        }
        return instance;
    }

    private InterfaceHM() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 1, 10, 10));
        frame.getContentPane().add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1, 10, 10));
        frame.getContentPane().add(rightPanel, BorderLayout.EAST);

        JButton btnAdmin = new JButton("Administrateur Système", new ImageIcon(getClass().getResource("/Images/imagesAdmin.png")));
        btnAdmin.setVerticalTextPosition(JButton.BOTTOM);
        btnAdmin.setHorizontalTextPosition(JButton.CENTER);
        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connexionA k = new connexionA(frame);
                addContentToCentralPanel(k.getContentPanel());
            }
        });
        leftPanel.add(btnAdmin);

        btnAgent = new JButton("Opérateur", new ImageIcon(getClass().getResource("/Images/Operateur.jpeg")));
        btnAgent.setVerticalTextPosition(JButton.BOTTOM);
        btnAgent.setHorizontalTextPosition(JButton.CENTER);
        btnAgent.setEnabled(false);
        btnAgent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OperateurConnexionFenetre f = new OperateurConnexionFenetre(frame);
                addContentToCentralPanel(f.getContentPanel());
            }
        });
        leftPanel.add(btnAgent);

        btnResponsable = new JButton("Responsable Maintenance", new ImageIcon(getClass().getResource("/Images/imagesResponsableMaint.png")));
        btnResponsable.setVerticalTextPosition(JButton.BOTTOM);
        btnResponsable.setHorizontalTextPosition(JButton.CENTER);
        btnResponsable.setEnabled(false);
        btnResponsable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientConnexionFenetre clientConnexionFenetre = new ClientConnexionFenetre(frame);
                addContentToCentralPanel(clientConnexionFenetre.getContentPanel());
            }
        });
        rightPanel.add(btnResponsable);

        btnUtilisateur = new JButton("Administrateur Entreprise", new ImageIcon(getClass().getResource("/Images/AdminGMAO.jpeg")));
        btnUtilisateur.setVerticalTextPosition(JButton.BOTTOM);
        btnUtilisateur.setHorizontalTextPosition(JButton.CENTER);
        btnUtilisateur.setEnabled(false);
        btnUtilisateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin2Connexion f = new Admin2Connexion(frame);
                addContentToCentralPanel(f.getContentPanel());
            }
        });
        rightPanel.add(btnUtilisateur);

        centralPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(centralPanel, BorderLayout.CENTER);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public void activerBoutonAgent() {
        if (btnAgent != null) {
            btnAgent.setEnabled(true);
        }
    }

    public static void activerBoutonUtilisateur() {
        if (btnUtilisateur != null) {
            btnUtilisateur.setEnabled(true);
        }
    }

    public void activerBoutonResponsable() {
        if (btnResponsable != null) {
            btnResponsable.setEnabled(true);
        }
    }

    public void addContentToCentralPanel(JPanel content) {
        centralPanel.removeAll();
        centralPanel.add(content, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

	public void addContentToCentralPanel(ModifierMaintenanceFenetre f) {
		// TODO Auto-generated method stub
		
	}
}