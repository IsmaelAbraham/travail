package projetGMAO2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Admin2 extends JPanel {

    private JButton btnCreerOp;
    private JButton btnModifierOp;
    private JButton btnSupprimerOp;
    private JButton btnRetour;
    private JFrame parentFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    Admin2 adminPanel = new Admin2(frame);
                    frame.setContentPane(adminPanel);
                    frame.setBounds(100, 100, 800, 600);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin2(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
    }

    private void initialize() {
        this.setLayout(null);

        // Buttons for various operations
        btnCreerOp = new JButton("Ajouter un Responsable");
        btnCreerOp.setBounds(140, 220, 190, 25);
        btnCreerOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientFenetre f = new ClientFenetre(parentFrame);
               InterfaceHM.getInstance().addContentToCentralPanel(f);
               // switchPanel(f.getContentPanel());
                InterfaceHM.getInstance().activerBoutonResponsable();
            }
        });
        this.add(btnCreerOp);

        btnModifierOp = new JButton("Modifier un Responsable");
        btnModifierOp.setBounds(140, 260, 190, 25);
        btnModifierOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier f = new Modifier(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
             //   switchPanel(f);
             //   InterfaceHM.getInstance().activerBoutonUtilisateur();
            }
        });
        this.add(btnModifierOp);

        btnSupprimerOp = new JButton("Supprimer un Responsable");
        btnSupprimerOp.setBounds(140, 300, 190, 25);
        btnSupprimerOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer f = new Supprimer(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
              //  switchPanel(f);
              //  InterfaceHM.getInstance().activerBoutonUtilisateur();
            }
        });
        this.add(btnSupprimerOp);

        btnRetour = new JButton("Retour");
        btnRetour.setBounds(10, 10, 85, 21);
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
               // InterfaceHM window = InterfaceHM.getInstance();
               // window.setVisible(true);
               // parentFrame.dispose();
            }
        });
        this.add(btnRetour);
    }

    private void switchPanel(JPanel panel) {
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(panel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    public void setVisible(boolean visible) {
        parentFrame.setVisible(visible);
    }

	public JPanel getContentPanel() {
		// TODO Auto-generated method stub
		return this;
	}
}
