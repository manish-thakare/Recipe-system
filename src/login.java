import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSeparator;

public class login{
	private JTextField Username;
	private JPasswordField passwordField;
	login(){
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(47, 79, 79));
		f.setTitle("FoodX : Login");
		f.setBounds(200,200,1280,720);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(66, 35, 1126, 618);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(641, 230, 314, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(641, 352, 314, 2);
		panel.add(separator_1);
		
		Username = new JTextField();
		Username.setBackground(new Color(250, 235, 215));
		Username.setToolTipText("type your credentials here");
		Username.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		Username.setBorder(null);
		Username.setBounds(641, 186, 312, 44);
		panel.add(Username);
		Username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblNewLabel.setBounds(643, 158, 186, 30);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPassword.setBounds(647, 279, 130, 30);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Type Your Credentials......");
		passwordField.setBackground(new Color(250, 235, 215));
		passwordField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBorder(null);
		passwordField.setToolTipText("type your credentials here");
		passwordField.setBounds(641, 308, 312, 44);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(250, 128, 114));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 222, 173));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","Manish@2432");
					Statement stmt=con.createStatement();
					String sql="select * from user where U_name='"+Username.getText()+"' and Password='"+passwordField.getText()+"'";
					ResultSet rs= stmt.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Login Successfull");
						f.setVisible(false);
						new HomePage();
					}
					else
						JOptionPane.showInternalMessageDialog(null,"Sorry Check details again");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(731, 425, 140, 38);
		btnNewButton.setBorder(null);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("LOG IN");
		lblNewLabel_1.setForeground(new Color(255, 153, 102));
		lblNewLabel_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(281, 158, 312, 56);
		panel.add(lblNewLabel_1);
		
		JTextArea txtrLoginIntoYour = new JTextArea();
		txtrLoginIntoYour.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		txtrLoginIntoYour.setBounds(354, 210, 164, 97);
		panel.add(txtrLoginIntoYour);
		txtrLoginIntoYour.setWrapStyleWord(true);
		txtrLoginIntoYour.setLineWrap(true);
		txtrLoginIntoYour.setEditable(false);
		txtrLoginIntoYour.setBackground(new Color(255, 255, 204));
		txtrLoginIntoYour.setText("Login Into \r\nYour Acoount\r\nHere...!");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(new Color(250, 235, 215));
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\src\\Pictures\\WelcomePage1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1126, 630);
		panel.add(lblNewLabel_2);
		
		f.setVisible(true);
	}
	public static void main(String [] args) {
		new login();
	}
}
