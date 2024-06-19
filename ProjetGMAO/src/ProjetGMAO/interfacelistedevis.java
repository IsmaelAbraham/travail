package ProjetGMAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class interfacelistedevis {

	private JFrame frame;
	private JTextField txtGmao;
	private JButton btnGestionDeLa;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JLabel lblNewLabel_1;
	private JTextField txtListeDevis;
	private JButton btnVa;
	private JButton btnRetou;
	private JButton button_1;
	private JTable table;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfacelistedevis window = new interfacelistedevis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfacelistedevis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		txtGmao = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtGmao, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtGmao, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtGmao, 518, SpringLayout.WEST, frame.getContentPane());
		txtGmao.setText("                                                                     GMAO          ");
		txtGmao.setColumns(10);
		txtGmao.setBackground(Color.BLUE);
		frame.getContentPane().add(txtGmao);
		
		btnGestionDeLa = new JButton("Gestion de la maintenance");
		springLayout.putConstraint(SpringLayout.NORTH, btnGestionDeLa, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnGestionDeLa, 0, SpringLayout.WEST, frame.getContentPane());
		btnGestionDeLa.setBackground(new Color(250, 250, 210));
		frame.getContentPane().add(btnGestionDeLa);
		
		btnNewButton = new JButton("Facturation");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 157, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 267, SpringLayout.WEST, frame.getContentPane());
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(250, 250, 210));
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Payement");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 264, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 362, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(250, 250, 210));
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Edition");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 358, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 500, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(250, 250, 210));
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("<");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 57, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, 46, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_3.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton(">");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 57, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 59, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_4, 105, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_4.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(btnNewButton_4);
		
		lblNewLabel = new JLabel("Accueil >Gestion maintenance > Creer une demande");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 61, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 115, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 79, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 374, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_5 = new JButton("Déconnexion");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_5, 59, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 391, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_5, 490, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_5.setBackground(Color.RED);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Creer une demande");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_6, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_6, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 162, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_6, 138, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_6.setBackground(new Color(169, 169, 169));
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Creer un devis");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7, 162, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7, 197, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7, 138, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_7.setBackground(new Color(169, 169, 169));
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("Liste devis");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_8, 196, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_8, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_8, 231, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_8, 138, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_8.setBackground(new Color(105, 105, 105));
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Afficher liste");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_9, 234, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_9, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_9, 263, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_9, 138, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_9.setBackground(new Color(169, 169, 169));
		frame.getContentPane().add(btnNewButton_9);
		
		lblNewLabel_1 = new JLabel("Gestion maintenance");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 103, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 24, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 126, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 136, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1);
		
		txtListeDevis = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtListeDevis, 133, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtListeDevis, 148, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtListeDevis, 156, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtListeDevis, 498, SpringLayout.WEST, frame.getContentPane());
		txtListeDevis.setText("                                                 Liste Devis");
		txtListeDevis.setForeground(Color.WHITE);
		txtListeDevis.setColumns(10);
		txtListeDevis.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(txtListeDevis);
		
		btnVa = new JButton("Valider");
		springLayout.putConstraint(SpringLayout.NORTH, btnVa, 285, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnVa, 189, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnVa, 278, SpringLayout.WEST, frame.getContentPane());
		btnVa.setBackground(Color.GREEN);
		frame.getContentPane().add(btnVa);
		
		btnRetou = new JButton("retour");
		springLayout.putConstraint(SpringLayout.NORTH, btnRetou, 285, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnRetou, 296, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRetou, 385, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnRetou);
		
		button_1 = new JButton("Enregistrer");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 285, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_1, 401, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, 490, SpringLayout.WEST, frame.getContentPane());
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(button_1);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 162, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 148, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 219, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 500, SpringLayout.WEST, frame.getContentPane());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "N\u00B0"},
				{"2", "N\u00B078978"},
				{"3", "N\u00B098456"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		frame.getContentPane().add(table);
		
		lblNewLabel_2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 234, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 148, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 375, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 500, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_2.setForeground(new Color(250, 250, 210));
		frame.getContentPane().add(lblNewLabel_2);
	}
}
