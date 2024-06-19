package ProjetGMAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class interfacedevis {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtSdfghj;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfacedevis window = new interfacedevis();
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
	public interfacedevis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GMAO");
		lblNewLabel.setBounds(232, 14, 35, 14);
		lblNewLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Gestion de la maintenace");
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setBounds(0, 32, 158, 23);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Facturation");
		btnNewButton_1.setBackground(new Color(250, 250, 210));
		btnNewButton_1.setBounds(152, 32, 100, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Payement");
		btnNewButton_2.setBackground(new Color(250, 250, 210));
		btnNewButton_2.setBounds(250, 32, 89, 23);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edition");
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setBounds(335, 32, 89, 23);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.setBackground(new Color(30, 144, 255));
		btnNewButton_4.setBounds(10, 61, 46, 23);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton(">");
		btnNewButton_5.setBackground(new Color(30, 144, 255));
		btnNewButton_5.setBounds(66, 61, 46, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Accueil >Gestion maintenance > Creer une demande");
		lblNewLabel_1.setBounds(122, 66, 259, 18);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("Déconnexion");
		btnNewButton_6.setBackground(new Color(255, 0, 0));
		btnNewButton_6.setBounds(397, 61, 99, 23);
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion maintenance");
		lblNewLabel_2.setBounds(20, 95, 112, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_7 = new JButton("Creer une demande");
		btnNewButton_7.setBounds(0, 129, 138, 35);
		btnNewButton_7.setBackground(new Color(245, 245, 245));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Creer un devis");
		btnNewButton_8.setBounds(0, 164, 138, 35);
		btnNewButton_8.setBackground(new Color(245, 245, 245));
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Liste devis");
		btnNewButton_9.setBackground(new Color(245, 245, 245));
		btnNewButton_9.setBounds(0, 198, 138, 35);
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Afficher liste");
		btnNewButton_10.setBackground(new Color(245, 245, 245));
		btnNewButton_10.setBounds(0, 236, 138, 29);
		btnNewButton_10.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_10);
		
		textField = new JTextField();
		textField.setBounds(0, 11, 486, 20);
		textField.setBackground(Color.BLUE);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtSdfghj = new JTextField();
		txtSdfghj.setForeground(Color.WHITE);
		txtSdfghj.setText("                                         creation de devis");
		txtSdfghj.setBackground(new Color(95, 158, 160));
		txtSdfghj.setBounds(136, 129, 350, 23);
		txtSdfghj.setColumns(10);
		frame.getContentPane().add(txtSdfghj);
		
		JLabel lblNewLabel_3 = new JLabel("N°devis");
		lblNewLabel_3.setBounds(161, 164, 46, 14);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 160, 131, 23);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date");
		lblNewLabel_3_1.setBounds(355, 164, 46, 14);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(382, 160, 89, 23);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(171, 198, 5, 5);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 236, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(215, 222, 1, 1);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(470, 288, 1, 1);
		frame.getContentPane().add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(157, 208, 1, 1);
		frame.getContentPane().add(table_2);
		
		table_3 = new JTable();
		table_3.setBounds(230, 208, 1, 1);
		frame.getContentPane().add(table_3);
		
		table_4 = new JTable();
		table_4.setBounds(232, 288, 1, 1);
		frame.getContentPane().add(table_4);
		
		table_5 = new JTable();
		table_5.setToolTipText("tyuiop");
		table_5.setBounds(232, 232, 1, 1);
		frame.getContentPane().add(table_5);
		
		table_6 = new JTable();
		table_6.setToolTipText("trre");
		table_6.setBounds(266, 264, 1, 1);
		frame.getContentPane().add(table_6);
		
		table_7 = new JTable();
		table_7.setBackground(new Color(250, 250, 210));
		table_7.setFillsViewportHeight(true);
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_7.setToolTipText("qsdfg");
		table_7.setBounds(133, 214, 363, 85);
		frame.getContentPane().add(table_7);
		
		JLabel lblNewLabel_3_2 = new JLabel("N°demande");
		lblNewLabel_3_2.setToolTipText("");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(136, 189, 59, 14);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(203, 189, 131, 23);
		frame.getContentPane().add(textField_1);
		
		JButton btnRetou = new JButton("retour");
		btnRetou.setBounds(292, 326, 89, 23);
		frame.getContentPane().add(btnRetou);
		
		JButton btnVa = new JButton("Valider");
		btnVa.setBackground(new Color(0, 255, 0));
		btnVa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVa.setBounds(127, 326, 89, 23);
		frame.getContentPane().add(btnVa);
		
		JButton button_1_1 = new JButton("Enregistrer");
		button_1_1.setBounds(397, 326, 89, 23);
		frame.getContentPane().add(button_1_1);
	}
}
