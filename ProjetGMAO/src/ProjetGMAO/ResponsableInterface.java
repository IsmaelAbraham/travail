package ProjetGMAO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ResponsableInterface {
    private JFrame frame;
    private JTextField txtIdentifiant;
    private JPasswordField txtMotDePasse;
    private JLabel lblIdentifiant;
    private JLabel lblMotDePasse;
    private JButton btnConnexion;
    private JLabel lblAdmin;
    private JButton btnRetour;
    private JButton btnSaisirMaint;
    private JButton btnModifierMaint;
    private JButton btnSuppMaint;
    private JButton btnConsulte;
    private JButton btnCreerOp;
    private JButton btnModifierOp;
    private JButton btnSupprimerOp;

    public ResponsableInterface() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Définir la couleur de fond en bleu clair
        frame.getContentPane().setBackground(new Color(173, 216, 230));

        lblAdmin = new JLabel("Bienvenue, Responsable Maintenance");
        lblAdmin.setBounds(140, 50, 220, 15);
        frame.getContentPane().add(lblAdmin);

        lblIdentifiant = new JLabel("Identifiant :");
        lblIdentifiant.setBounds(100, 80, 100, 30);
        frame.getContentPane().add(lblIdentifiant);

        txtIdentifiant = new JTextField();
        txtIdentifiant.setBounds(200, 80, 200, 30);
        frame.getContentPane().add(txtIdentifiant);
        txtIdentifiant.setColumns(10);

        lblMotDePasse = new JLabel("Mot de Passe :");
        lblMotDePasse.setBounds(100, 130, 100, 30);
        frame.getContentPane().add(lblMotDePasse);

        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setBounds(200, 130, 200, 30);
        frame.getContentPane().add(txtMotDePasse);
        txtMotDePasse.setColumns(10);

        btnConnexion = new JButton("Connexion");
        btnConnexion.setBounds(200, 180, 200, 30);
        frame.getContentPane().add(btnConnexion);

        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAdminEntOperations();
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

    private void showAdminEntOperations() {
        lblIdentifiant.setVisible(false);
        txtIdentifiant.setVisible(false);
        lblMotDePasse.setVisible(false);
        txtMotDePasse.setVisible(false);
        btnConnexion.setVisible(false);

        btnCreerOp = new JButton("Ajouter un Opérateur");
        btnCreerOp.setBounds(140, 220, 190, 25);
        frame.getContentPane().add(btnCreerOp);

        btnModifierOp = new JButton("Modifier un Opérateur");
        btnModifierOp.setBounds(140, 260, 190, 25);
        frame.getContentPane().add(btnModifierOp);

        btnSupprimerOp = new JButton("Supprimer un Opérateur");
        btnSupprimerOp.setBounds(140, 300, 190, 25);
        frame.getContentPane().add(btnSupprimerOp);

        btnSaisirMaint = new JButton("Saisir Maintenance");
        btnSaisirMaint.setBounds(140, 340, 190, 25);
        frame.getContentPane().add(btnSaisirMaint);

        btnModifierMaint = new JButton("Modifier demande Maintenance");
        btnModifierMaint.setBounds(140, 380, 190, 25);
        frame.getContentPane().add(btnModifierMaint);

        btnSuppMaint = new JButton("Supprimer Maintenance");
        btnSuppMaint.setBounds(140, 420, 190, 25);
        frame.getContentPane().add(btnSuppMaint);

        btnConsulte = new JButton("Consulter Demandes");
        btnConsulte.setBounds(140, 460, 190, 25);
        frame.getContentPane().add(btnConsulte);

        frame.revalidate();
        frame.repaint();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
