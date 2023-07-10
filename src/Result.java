import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Result {
	
	void result(String rname, String method, String ing, String img, String cal ) {
		JFrame c=new JFrame();
		c.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Workspace\\Java Mini Project\\src\\Pictures\\WelcomePage.jpg"));
		c.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		c.getContentPane().setBackground(Color.DARK_GRAY);
		c.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setSize(1266, 683);
		panel_2.setLocation(0, 0);
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setLayout(null);
		c.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomePage();
				c.setVisible(false);
			}
		});
		btnNewButton.setBounds(546, 0, 121, 35);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(rname);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(546, 31, 316, 42);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nutrition Info:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(546, 83, 145, 35);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingredients:");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(872, 10, 193, 35);
		panel_2.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 368, 852, 315);
		panel_2.add(scrollPane_1);
		scrollPane_1.setBorder(null);
		
		JTextArea txtrEhwbddh = new JTextArea();
		txtrEhwbddh.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtrEhwbddh.setForeground(Color.WHITE);
		txtrEhwbddh.setBackground(new Color(0, 0, 0));
		txtrEhwbddh.setWrapStyleWord(true);
		txtrEhwbddh.setLineWrap(true);
		txtrEhwbddh.setEditable(false);
		//txtrEhwbddh.setLineWrap(true);
		txtrEhwbddh.setText(method);
		scrollPane_1.setViewportView(txtrEhwbddh);
				
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(11, 4, 525, 329);
		panel_2.add(lblNewLabel_3);
		
		JTextArea txtrEwidbj = new JTextArea();
		txtrEwidbj.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtrEwidbj.setForeground(Color.WHITE);
		txtrEwidbj.setBackground(new Color(0, 0, 0));
		txtrEwidbj.setText(cal);
		txtrEwidbj.setBounds(546, 128, 316, 230);
		panel_2.add(txtrEwidbj);
		
		JTextArea txtrEbcdjc = new JTextArea();
		txtrEbcdjc.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtrEbcdjc.setForeground(Color.WHITE);
		txtrEbcdjc.setBackground(new Color(0, 0, 0));
		txtrEbcdjc.setText(ing);
		txtrEbcdjc.setEditable(false);
		txtrEbcdjc.setLineWrap(true);
		txtrEbcdjc.setBounds(872, 44, 384, 629);
		panel_2.add(txtrEbcdjc);
		
		JLabel lblNewLabel_1_1 = new JLabel("Process");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(10, 334, 145, 35);
		panel_2.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(857, 0, 5, 683);
		panel_2.add(separator);
		
		c.setBackground(Color.MAGENTA);
		c.setTitle("Result Page");
		c.setBounds(500, 500, 1280, 720);
		c.setLocationRelativeTo(null);
		c.setVisible(true);
	}
	public static void main(String[] args) {
		Result r;
		r=new Result();
		r.result("cas","xsa","wdx","E:\\Workspace\\Java Mini Project\\bin\\Pictures\\panir tikka.jpg","hffgvu");
	}
}
