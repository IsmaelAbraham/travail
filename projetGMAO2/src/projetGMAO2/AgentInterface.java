package projetGMAO2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class AgentInterface extends JPanel{

	private JFrame frame;
    private JTextField txtIdentifiant;
    private JPasswordField txtMotDePasse;
    private JLabel lblIdentifiant;
    private JLabel lblMotDePasse;
    private JButton btnConnexion;
    private JButton btnRetour;
    private JButton btnModifMaint;
    private JButton btnModifDevi;
    private JButton btnConsulte;
    private JButton btnConsulte1;
    private JFrame parentFrame;

    public AgentInterface(JFrame parentFrame) {
    	this.parentFrame = parentFrame;
        initialize();
    }

    private void initialize() {
      //  frame = new JFrame();
      //  frame.setBounds(100, 100, 800, 600);
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  frame.getContentPane().setLayout(null);

      //  JLabel lblAdmin = new JLabel("Bienvenue, Opérateur");
      //  lblAdmin.setBounds(140, 50, 200, 15);
      //  frame.getContentPane().add(lblAdmin);
    	 this.setLayout(null);



        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Interface2 I = new Interface2(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(I);
            }
        });
        btnRetour.setBounds(10, 10, 85, 21);
        this.add(btnRetour);
  //  }

  //  private void showOpOperations() {
    //    lblIdentifiant.setVisible(false);
      //  txtIdentifiant.setVisible(false);
        //lblMotDePasse.setVisible(false);
      //  txtMotDePasse.setVisible(false);
       // btnConnexion.setVisible(false);

        btnModifMaint = new JButton("Modifier un devis");
        btnModifMaint.setBounds(140, 220, 190, 25);
        this.add(btnModifMaint);

        btnModifDevi = new JButton("Modifier une maintenance");
        btnModifDevi.setBounds(140, 260, 190, 25);
        this.add(btnModifDevi);
        
        
        // Arranger avant demain
   //     btnModifDevi.addActionListener(new ActionListener() {
   //         public void actionPerformed(ActionEvent e) {
   //         	Maintenance maintenance = new Maintenance(/* pass parameters here */);

    //            // Ouvrir la fenêtre de modification avec la maintenance à modifier
    //            ModifierMaintenanceFenetre f = new ModifierMaintenanceFenetre(maintenance, parentFrame);
              //  ModifierMaintenanceFenetre f = new ModifierMaintenanceFenetre(maintenance,parentFrame);
    //            InterfaceHM.getInstance().addContentToCentralPanel(f);
    //        }
     //   });
    
        

        btnConsulte = new JButton("Consulter un devis");
        btnConsulte.setBounds(140, 300, 190, 25);
        this.add(btnConsulte);
        
        btnConsulte1 = new JButton("Consulter une maintenance");
        btnConsulte1.setBounds(140, 340, 190, 25);
        this.add(btnConsulte1);

     //   frame.revalidate();
     //   frame.repaint();
        btnConsulte1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MaintenanceFenetre f = new MaintenanceFenetre(parentFrame);
                InterfaceHM.getInstance().addContentToCentralPanel(f);
              //  f.setVisible(true);
              //  parentFrame.dispose();
            }
        });
    }
  
    
    private void switchPanel(JPanel panel) {
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(panel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }
    
    public JPanel getContentPanel() {
        return this;
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

   
}
