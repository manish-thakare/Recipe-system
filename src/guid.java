import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class guid{
	private JTextField txtGuidToUse;
	guid(){
		JFrame n=new JFrame();
		n.setBackground(Color.MAGENTA);
		n.setTitle("Guide Page");
		n.setBounds(500, 500, 1280, 720);
		n.setLocationRelativeTo(null);
		n.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1266, 683);
		n.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnAppStarts = new JTextPane();
		txtpnAppStarts.setText("1) App starts up with a Sign up page, You have to enter your details for proper sign up.\r\n2) "
				+ "If you already have an accout you can Sign_in directly by clicking on click here, then enter proper Username & Password and sign_in."
				+ "\r\n3) After Sign_up or Sign_in next Home Page  became visible. Home Page have a menubar here Menu Home returns us to Home Page screen."
				+ "\r\n4) You can search any recipe you want by entering name of Food Dish. After entering name you have to click on search menu. "
				+ "It will lead to recipe Page & you can get all information about that food dish that you searched."
				+ "\r\n5) You can return to homepage by clicking on button Home. It will return you to the main Home screen."
				+ "\r\n6) About contains information of our app.\r\n7) Log Out will logged you out from your current accout & "
				+ "Sign Up page will open You can create new account or sign in into existing account from there.\r\n8) Clicking on Help will open you a frame"
				+ " where you can enter your query.\r\n9) On Home Screen you will see some food Dishes by clicking them you can also see their recipe.");
		txtpnAppStarts.setEditable(false);
		txtpnAppStarts.setForeground(new Color(255, 255, 255));
		txtpnAppStarts.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		txtpnAppStarts.setBackground(Color.BLACK);
		txtpnAppStarts.setBounds(10, 37, 1246, 636);
		panel.add(txtpnAppStarts);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n.setVisible(false);
				new HomePage();
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(0, 0, 119, 35);
		panel.add(btnNewButton);
		
		txtGuidToUse = new JTextField();
		txtGuidToUse.setBackground(Color.CYAN);
		txtGuidToUse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGuidToUse.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuidToUse.setText("Guide to Use the App");
		txtGuidToUse.setBounds(491, 0, 249, 35);
		txtGuidToUse.setEditable(false);
		panel.add(txtGuidToUse);
		txtGuidToUse.setColumns(10);
		n.setVisible(true);
	}
	
	public static void main(String[] args) {
		new guid();
	}
}
