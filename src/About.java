import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class About {
	private JTextField txtaRecipeHas;
	About(){
		JFrame n=new JFrame();
		n.setBackground(Color.MAGENTA);
		n.setTitle("About");
		n.setBounds(500, 500, 1280, 720);
		n.setLocationRelativeTo(null);
		n.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1266, 683);
		n.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n.setVisible(false);
				new HomePage();
			}
		});
		
		JTextPane txtpnaRecipeHas = new JTextPane();
		txtpnaRecipeHas.setText("\r\n\r\nThis app is developed in Java Eclipse 11.\r\nThis app is made on purpose of Java mini project.\r\nThis mini project entitled "
				+ "\"FoodX - Recipe App\" by Isa Rizwan, Manish Thakare, Sakshi shete & Zainab Ansari.\r\nThe tools used in preparation of this app are: Java Eclipse"
				+ " IDE , MySQL Workbench\r\n\r\nRefferences:\r\n\r\nhttps://www.w3schools.com\r\nhttps://www.geeksforgeeks.org\r\nhttps://stackoverflow.com\r\n\r\n");
		txtpnaRecipeHas.setEnabled(false);
		txtpnaRecipeHas.setEditable(false);
		txtpnaRecipeHas.setForeground(Color.WHITE);
		txtpnaRecipeHas.setFont(new Font("Calisto MT", Font.PLAIN, 24));
		txtpnaRecipeHas.setBackground(Color.DARK_GRAY);
		txtpnaRecipeHas.setBounds(10, 97, 1246, 576);
		panel.add(txtpnaRecipeHas);
		
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(0, 0, 119, 35);
		panel.add(btnNewButton);
		
		txtaRecipeHas = new JTextField();
		txtaRecipeHas.setBackground(Color.DARK_GRAY);
		txtaRecipeHas.setForeground(new Color(255, 255, 255));
		txtaRecipeHas.setFont(new Font("Calisto MT", Font.PLAIN, 24));
		txtaRecipeHas.setText("\"A Recipe has no soul. You, as the cook, must bring soul to the recipe.\"");
		txtaRecipeHas.setBounds(10, 49, 1246, 50);
		txtaRecipeHas.setBorder(null);
		panel.add(txtaRecipeHas);
		txtaRecipeHas.setColumns(10);
		n.setVisible(true);
	}
	
	public static void main(String[] args) {
		new About();
	}
}