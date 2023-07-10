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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class signup{
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JTextField password;
	private JTextField cpassword;
	signup(){
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(0, 0, 51));
		f.setTitle("FoodX : Signup");
		f.setBounds(200,200,1280,720);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("click here......");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.setVisible(false);
				new login();
			}
		});
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel.setBounds(147, 369, 123, 37);
		f.getContentPane().add(lblNewLabel);
		
		JTextArea txtrEnterYourDetails = new JTextArea();
		txtrEnterYourDetails.setWrapStyleWord(true);
		txtrEnterYourDetails.setFont(new Font("SansSerif", Font.ITALIC, 18));
		txtrEnterYourDetails.setBounds(143, 236, 156, 233);
		f.getContentPane().add(txtrEnterYourDetails);
		txtrEnterYourDetails.setText("If you already have \r\nan account you \r\ncan sign in....!");
		txtrEnterYourDetails.setEditable(false);
		txtrEnterYourDetails.setBackground(new Color(255, 255, 204));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(626, 10, 630, 663);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton submit = new JButton("Submit");
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(0, 0, 0));
	
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				submit.setBackground(new Color(204, 204, 204));
				submit.setForeground(new Color(51, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				submit.setBackground(new Color(51, 51, 51));
				submit.setForeground(new Color(255, 255, 255));
			}
		});
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
		
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","Manish@2432");
					Statement stmt=con.createStatement();
					String sql= "INSERT INTO user(U_name,Name,Password,gmail) VALUES('"+username.getText()+"','"+name.getText()+"','"+password.getText()+"','"+email.getText()+"');";
					int i= stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Sign up Successfull");
						f.setVisible(false);
						new HomePage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submit.setBounds(94, 565, 140, 38);
		panel.add(submit);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(176, 10, 312, 56);
		panel.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblName.setBounds(75, 63, 159, 44);
		panel.add(lblName);
		
		name = new JTextField();
		name.setForeground(new Color(255, 255, 255));
		name.setBackground(new Color(0, 51, 102));
		name.setToolTipText("Enter Your Full Name");
		name.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBorder(null);
		name.setBounds(75, 100, 386, 44);
		panel.add(name);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblUsername.setBounds(75, 154, 159, 44);
		panel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEmail.setBounds(75, 245, 159, 44);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPassword.setBounds(75, 343, 159, 44);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(75, 434, 159, 44);
		panel.add(lblConfirmPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(75, 143, 448, 2);
		panel.add(separator);
		
		username = new JTextField();
		username.setToolTipText("Enter your Username");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		username.setColumns(10);
		username.setBorder(null);
		username.setBackground(new Color(0, 51, 102));
		username.setBounds(75, 185, 386, 44);
		panel.add(username);
		
		email = new JTextField();
		email.setToolTipText("Enter Your Email id");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		email.setColumns(10);
		email.setBorder(null);
		email.setBackground(new Color(0, 51, 102));
		email.setBounds(75, 280, 386, 44);
		panel.add(email);
		
		password = new JTextField();
		password.setToolTipText("Enter Your Password");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		password.setColumns(10);
		password.setBorder(null);
		password.setBackground(new Color(0, 51, 102));
		password.setBounds(75, 380, 386, 44);
		panel.add(password);
		
		cpassword = new JTextField();
		cpassword.setToolTipText("Confirm your password");
		cpassword.setForeground(Color.WHITE);
		cpassword.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		cpassword.setColumns(10);
		cpassword.setBorder(null);
		cpassword.setBackground(new Color(0, 51, 102));
		cpassword.setBounds(75, 466, 386, 44);
		panel.add(cpassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(75, 233, 445, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(75, 331, 445, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(75, 424, 445, 2);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(75, 512, 445, 2);
		panel.add(separator_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(signup.class.getResource("/Pictures/WelcomePage.jpg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 115, 615, 448);
		f.getContentPane().add(lblNewLabel_2);
		f.setVisible(true);
	}
	public static void main(String [] args) {
		new signup();
	}
}
