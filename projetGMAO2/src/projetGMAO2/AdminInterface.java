package projetGMAO2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class AdminInterface extends JPanel {

    private JFrame parentFrame;
    private JButton btnRetour;
    private JButton btnManageUsers;
    private JButton btnModifierAdminEnt;
    private JButton btnSupprimerAdminEnt;

    public AdminInterface(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
    }

    private void initialize() {
        setLayout(null);

        JLabel lblAdmin = new JLabel("Bienvenue, Administrateur Système");
        lblAdmin.setBounds(140, 50, 300, 15);
        add(lblAdmin);

        btnManageUsers = new JButton("Créer un Administrateur Entreprise");
        btnManageUsers.setBounds(92, 220, 268, 25);
        add(btnManageUsers);
        btnManageUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientFenetre f = new ClientFenetre(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
               //  f.setVisible(true);
           //     InterfaceHM.getInstance().activerBoutonUtilisateur();
            }
        });

        btnModifierAdminEnt = new JButton("Modifier un Administrateur d'entreprise");
        btnModifierAdminEnt.setBounds(92, 260, 268, 25);
        add(btnModifierAdminEnt);
        btnModifierAdminEnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier f = new Modifier(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
                InterfaceHM.getInstance().activerBoutonUtilisateur();
            }
        });

        btnSupprimerAdminEnt = new JButton("Supprimer un Administrateur d'entreprise");
        btnSupprimerAdminEnt.setBounds(92, 300, 268, 25);
        add(btnSupprimerAdminEnt);
        btnSupprimerAdminEnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer f = new Supprimer(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
            }
        });

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
            }
        });
        btnRetour.setBounds(10, 10, 85, 21);
        add(btnRetour);
    }
    
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
