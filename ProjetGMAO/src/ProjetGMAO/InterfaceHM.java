package ProjetGMAO;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class InterfaceHM {
	
	
	private JFrame frame;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceHM window = new InterfaceHM();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

		
		
	}




public InterfaceHM() {
    initialize();
}



private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.getContentPane().setLayout(null);
    frame.getContentPane().setLayout(new GridLayout(2, 2, 10, 10)); // Grid layout for 4 buttons
    
    
    JButton btnAdmin = new JButton("Administrateur Système", new ImageIcon(getClass().getResource("/Images/imagesAdmin.png")));
    btnAdmin.setVerticalTextPosition(JButton.BOTTOM);
    btnAdmin.setHorizontalTextPosition(JButton.CENTER);
    btnAdmin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            AdminInterface adminInterface = new AdminInterface();
            adminInterface.setVisible(true);
            frame.dispose();
        }
    });
    frame.getContentPane().add(btnAdmin);
    
    
    JButton btnAgent = new JButton("Opérateur", new ImageIcon(getClass().getResource("/Images/Operateur.jpeg")));
    btnAgent.setVerticalTextPosition(JButton.BOTTOM);
    btnAgent.setHorizontalTextPosition(JButton.CENTER);
    btnAgent.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            AgentInterface agentInterface = new AgentInterface();
            agentInterface.setVisible(true);
            frame.dispose();
        }
    });
    frame.getContentPane().add(btnAgent);
    
 // Button for Responsable
    JButton btnResponsable = new JButton("Responsable Maintenance", new ImageIcon(getClass().getResource("/Images/imagesResponsableMaint.png")));
    btnResponsable.setVerticalTextPosition(JButton.BOTTOM);
    btnResponsable.setHorizontalTextPosition(JButton.CENTER);
    btnResponsable.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ResponsableInterface responsableInterface = new ResponsableInterface();
            responsableInterface.setVisible(true);
            frame.dispose();
        }
    });
    frame.getContentPane().add(btnResponsable);
    
    
    // Button for Utilisateur
    JButton btnUtilisateur = new JButton("Administrateur GMAO", new ImageIcon(getClass().getResource("/Images/AdminGMAO.jpeg")));
    btnUtilisateur.setVerticalTextPosition(JButton.BOTTOM);
    btnUtilisateur.setHorizontalTextPosition(JButton.CENTER);
    btnUtilisateur.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            UtilisateurInterface utilisateurInterface = new UtilisateurInterface();
            utilisateurInterface.setVisible(true);
            frame.dispose();
        }
    });
    frame.getContentPane().add(btnUtilisateur);
    

    //JLabel lblSelectProfile = new JLabel("Sélectionnez votre profil:");
    //lblSelectProfile.setBounds(220, 50, 160, 15);
    //frame.getContentPane().add(lblSelectProfile);

    //JComboBox<String> comboBoxProfiles = new JComboBox<>();
    //comboBoxProfiles.setModel(new DefaultComboBoxModel<>(new String[] {"Administrateur Système", "Administrateur GMAO", "Responsable Maintenance", "Opérateur"}));
    ///comboBoxProfiles.setBounds(140, 80, 160, 25);
    //frame.getContentPane().add(comboBoxProfiles);

   // JButton btnLogin = new JButton("Connexion");
    //btnLogin.addActionListener(new ActionListener() {
      //  public void actionPerformed(ActionEvent e) {
        //   String selectedProfile = (String) comboBoxProfiles.getSelectedItem();
          //  if ("Administrateur Système".equals(selectedProfile)) {
            //    AdminInterface adminInterface = new AdminInterface();
              //  adminInterface.setVisible(true);
           // } else if ("Administrateur GMAO".equals(selectedProfile)) {
            //    AgentInterface agentInterface = new AgentInterface();
              //  agentInterface.setVisible(true);
           // } else if ("Responsable Maintenance".equals(selectedProfile)) {
            //    ResponsableInterface responsableInterface = new ResponsableInterface();
              //  responsableInterface.setVisible(true);
            //} else if ("Opérateur".equals(selectedProfile)) {
               // UtilisateurInterface utilisateurInterface = new UtilisateurInterface();
               // utilisateurInterface.setVisible(true);
            //}
           // frame.dispose();
        //}
    //});
//    btnLogin.setBounds(170, 130, 100, 25);
  //  frame.getContentPane().add(btnLogin);
}

public void setVisible(boolean visible) {
    frame.setVisible(visible);
}
}
