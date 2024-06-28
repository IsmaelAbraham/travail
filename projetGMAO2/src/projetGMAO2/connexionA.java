package projetGMAO2;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


class connexionA extends JPanel {
    
    private JTextField textField;
    private JPasswordField textField_1;
    private JButton btnRetour;
    private JFrame parentFrame;

    public connexionA(JFrame parentFrame) {
    	this.parentFrame = parentFrame;
        initialize();
    }
    
    public JPanel getContentPanel() {
        return this;
    }

    private void initialize() {
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(166, 31, 166, 20);
        add(textField);
        textField.setColumns(10);

        textField_1 = new JPasswordField();
        textField_1.setColumns(10);
        textField_1.setBounds(166, 84, 166, 20);
        add(textField_1);

        JButton btnNewButton = new JButton("Connexion");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String text1 = new String(textField_1.getPassword());

                if ("Admin".equals(text) && "Admin123".equals(text1)) {
                    AdminInterface adm = new AdminInterface(parentFrame);
                    InterfaceHM.getInstance().addContentToCentralPanel(adm);
                  //  adm.setVisible(true);
                }
            }
        });

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 800, 600);
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/connexion.jpeg"));
        backgroundLabel.setIcon(backgroundImage);
        add(backgroundLabel);
        setComponentZOrder(backgroundLabel, 0);

        btnNewButton.setBounds(138, 195, 105, 23);
        this.add(btnNewButton);

        JTextPane txtpnIdentifiant = new JTextPane();
        txtpnIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtpnIdentifiant.setEditable(false);
        txtpnIdentifiant.setText("Identifiant");
        txtpnIdentifiant.setBounds(39, 31, 81, 20);
        this.add(txtpnIdentifiant);

        JTextPane txtpnMotDePasse = new JTextPane();
        txtpnMotDePasse.setText("Mot de passe");
        txtpnMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtpnMotDePasse.setEditable(false);
        txtpnMotDePasse.setBounds(10, 84, 110, 20);
        add(txtpnMotDePasse);

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfaceHM window = InterfaceHM.getInstance();
                window.setVisible(true);
            }
        });
        btnRetour.setBounds(50, 400, 85, 21);
        add(btnRetour);
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
