package projetGMAO2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResponsableInterface extends JPanel {

    private JFrame frame;
    private JButton btnCreerOp;
    private JButton btnModifierOp;
    private JButton btnSupprimerOp;
    private JButton btnSaisirMaint;
    private JButton btnModifierMaint;
    private JButton btnSuppMaint;
    private JButton btnConsulte;
    private JButton btnRetour;
    private JFrame parentFrame;

    public ResponsableInterface(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
    }

    private void initialize() {
        setLayout(null);

        btnCreerOp = new JButton("Ajouter un Opérateur");
        btnCreerOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientFenetre f = new ClientFenetre(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f.getContentPanel());
                InterfaceHM.getInstance().activerBoutonAgent();
            }
        });
        btnCreerOp.setBounds(140, 220, 190, 25);
        add(btnCreerOp);

        btnModifierOp = new JButton("Modifier un Opérateur");
        btnModifierOp.setBounds(140, 260, 190, 25);
        add(btnModifierOp);
        
        btnModifierOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier f = new Modifier(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f.getContentPanel());
              //  f.setVisible(true);
              //  parentFrame.dispose();
            }
        });

        btnSupprimerOp = new JButton("Supprimer un Opérateur");
        btnSupprimerOp.setBounds(140, 300, 190, 25);
        add(btnSupprimerOp);
        
        btnSupprimerOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer f = new Supprimer(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f.getContentPanel());
            //    f.setVisible(true);
            //    parentFrame.dispose();
            }
        });

        btnSaisirMaint = new JButton("Saisir Maintenance");
        btnSaisirMaint.setBounds(140, 340, 190, 25);
        add(btnSaisirMaint);
        
        btnSaisirMaint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MaintenanceFenetre f = new MaintenanceFenetre(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
              //  f.setVisible(true);
              //  parentFrame.dispose();
            }
        });

        btnModifierMaint = new JButton("Modifier demande Maintenance");
        btnModifierMaint.setBounds(140, 380, 190, 25);
        add(btnModifierMaint);

        btnSuppMaint = new JButton("Supprimer Maintenance");
        btnSuppMaint.setBounds(140, 420, 190, 25);
        add(btnSuppMaint);

        btnConsulte = new JButton("Consulter Demandes");
        btnConsulte.setBounds(140, 460, 190, 25);
        add(btnConsulte);
        
        btnConsulte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MaintenanceFenetre f = new MaintenanceFenetre(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
              //  f.setVisible(true);
                f.chargerMaintenances(); // Charger les maintenances lors de l'affichage
               // parentFrame.dispose();
            }
        });

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
              //  InterfaceHM.main(null); // Correct call to InterfaceHM main method
              //  parentFrame.dispose();
            }
        });
        btnRetour.setBounds(10, 10, 85, 21);
        add(btnRetour);
    }

    public void setVisible(boolean visible) {
        parentFrame.setVisible(visible);
    }

    public JPanel getContentPanel() {
        return this;
    }
}
