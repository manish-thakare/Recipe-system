import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.event.MenuListener;
import javax.swing.text.JTextComponent;
import javax.swing.event.MenuEvent;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class HomePage extends Result {
	private JTextField txtButterChicken;
	private JTextField txtKhamanDhokla;
	private JTextField txtPavBhaji;
	private JTextField txtRasmalai;
	private JTextField txtVegSpringRoll;
	private JTextField txtMiloChik;
	
	PreparedStatement stm;
	void search(String rname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","Manish@2432");
			Statement stmt=con.createStatement();
			String sql="select R_name, Method, Ingredients, Image, calories from recipe where R_name= '"+rname+"' ";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()){
				String rnm=rs.getString(1);
				String method=rs.getString(2);
				String ing=rs.getString(3);
				String img=rs.getString(4);
				String cal=rs.getString(5);
				Result b;
				b=new Result();
				b.result(rnm,method, ing, img, cal);
				//f.setVisible(false);
			}
			else {
				JOptionPane.showInternalMessageDialog(null,"Result not found");
			}
			//}	
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	HomePage(){
		JFrame f=new JFrame();
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Workspace\\Java Mini Project\\src\\Pictures\\WelcomePage.jpg"));
		f.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(-6, 0, 1272, 67);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 1250, 46);
		panel_1.add(menuBar);
		menuBar.setMargin(new Insets(10, 4, 0, 4));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(255, 245, 238));
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setBackground(new Color(255, 204, 153));
		mnNewMenu.setFont(new Font("Calisto MT", Font.BOLD, 20));
		mnNewMenu.setForeground(new Color(0, 0, 128));
		mnNewMenu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				f.setVisible(false);
				new HomePage();
			}
		});
		menuBar.add(mnNewMenu);
		
		JTextField textField = new JTextField();
		String abc=textField.getText();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		menuBar.add(textField);
		
		
		JMenu mnNewMenu_5 = new JMenu("Search");
		mnNewMenu_5.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
//				if(abc.contains(",")) {
//					try {
//						Class.forName("com.mysql.cj.jdbc.Driver");
//						String str = textField.getText();
//						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","Manish@2432");
//						Statement stmt=con.createStatement();
//						Pattern p=Pattern.compile("[a-zA-Z]+");
//						Matcher m= p.matcher(str);
//						ArrayList a= new ArrayList();
//						while(m.find()) {
//							String s= m.group();
//							a.add(s);
//						}
//						ArrayList b= new ArrayList();
//						for(int i=0;i<a.size();i++) {
//						String a1="select R_name from recipe where Ingredients like '"+a.get(i)+"' ";
//						ResultSet rs= stmt.executeQuery(a1);
//						if(rs.next()){
//							b.add(1);
//						}
//						}
//						if(b.get(0)==b.get(1) && b.get(2)==b.get(3) && b.get(3)==b.get(4)) {
//							String sql="select R_name, Method, Ingredients, Image, calories from recipe where R_name= '"+b.get(0)+"' ";
//							ResultSet rs= stmt.executeQuery(sql);
//							if(rs.next()){
//								String rnm=rs.getString(1);
//								String method=rs.getString(2);
//								String ing=rs.getString(3);
//								String img=rs.getString(4);
//								String cal=rs.getString(5);
//								Result re;
//								re=new Result();
//								re.result(rnm,method, ing, img, cal);
//								f.setVisible(false);
//							}
//							else {
//								JOptionPane.showInternalMessageDialog(null,"Result not found");
//							}
//						}
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
				//else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String rname = textField.getText();
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","Manish@2432");
						Statement stmt=con.createStatement();
						String sql="select R_name, Method, Ingredients, Image, calories from recipe where R_name= '"+rname+"' ";
						ResultSet rs= stmt.executeQuery(sql);
						if(rs.next()){
							String rnm=rs.getString(1);
							String method=rs.getString(2);
							String ing=rs.getString(3);
							String img=rs.getString(4);
							String cal=rs.getString(5);
							Result b;
							b=new Result();
							b.result(rnm,method, ing, img, cal);
							f.setVisible(false);
						}
						else {
							JOptionPane.showInternalMessageDialog(null,"Result not found");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			//}
		});
		
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_5.setForeground(new Color(0, 0, 128));
		mnNewMenu_5.setBackground(new Color(255, 204, 153));
		mnNewMenu_5.setBounds(640, 0, 71, 61);
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				f.setVisible(false);
				new About();
			}
		});
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_1.setForeground(new Color(0, 0, 128));
		mnNewMenu_1.setBackground(new Color(255, 204, 153));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_2.setForeground(new Color(0, 0, 128));
		mnNewMenu_2.setBackground(new Color(255, 204, 153));
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame C=new JFrame();
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 662, 423);
				C.getContentPane().add(panel);
				panel.setLayout(null);
				
				JTextArea txtrHelloUserWe = new JTextArea();
				txtrHelloUserWe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
				txtrHelloUserWe.setText("Hello user we are here to help you.\r\nIf you are facing any issue or want \nto report some problems you can mail your query to Recipe_Admin45@gmail.com\r\n");
				txtrHelloUserWe.setLineWrap(true);
				txtrHelloUserWe.setEditable(false);
				txtrHelloUserWe.setBounds(0, 0, 662, 423);
				panel.add(txtrHelloUserWe);
				
				C.setBounds(0, 0, 676, 460);
				C.setVisible(true);
				C.setLocationRelativeTo(null);
				
			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("Log Out");
		mnNewMenu_4.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				f.setVisible(false);
				new signup();
			}
		});
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_4.setForeground(new Color(0, 0, 128));
		mnNewMenu_4.setBackground(new Color(255, 204, 153));
		menuBar.add(mnNewMenu_4);
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Guide");
		mnNewMenu_3.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				f.setVisible(false);
				new guid();
			}
		});
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_3.setForeground(new Color(0, 0, 128));
		mnNewMenu_3.setBackground(new Color(240, 240, 240));
		mnNewMenu_3.setBounds(0, 0, 50, 46);
		menuBar.add(mnNewMenu_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 66, 1246, 607);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\Dhokla1.jpeg"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255))));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(null);
			}
		});
		lblNewLabel.setBounds(63, 10, 324, 185);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\butter chicken1.jpeg"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255))));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBorder(null);
			}
		});
		lblNewLabel_1.setBounds(491, 10, 324, 185);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\pav bhaji1.jpeg"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255))));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBorder(null);
			}
		});
		lblNewLabel_2.setBounds(912, 10, 324, 185);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\Rasmalai1.jpeg"));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255)))); 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setBorder(null);
			}
		});
		lblNewLabel_3.setBounds(63, 332, 324, 185);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\chicken tikka1.jpeg"));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255))));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setBorder(null);
			}
		});
		lblNewLabel_4.setBounds(491, 332, 324, 185);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\Workspace\\Java Mini Project\\bin\\Pictures\\garlic bread1.jpeg"));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setBorder(new CompoundBorder(new LineBorder(new Color(0, 255, 255), 1, true), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(0, 255, 255))));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setBorder(null);
			}
		});
		lblNewLabel_5.setBounds(912, 332, 324, 185);
		panel_2.add(lblNewLabel_5);
		
		txtButterChicken = new JTextField();
		txtButterChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtButterChicken.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtButterChicken.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtButterChicken.setBackground(Color.DARK_GRAY);
			}
		});
		txtButterChicken.setText("Butter Chicken");
		txtButterChicken.setEditable(false);
		txtButterChicken.setHorizontalAlignment(SwingConstants.CENTER);
		txtButterChicken.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtButterChicken.setForeground(SystemColor.window);
		txtButterChicken.setBackground(Color.DARK_GRAY);
		txtButterChicken.setBounds(491, 206, 324, 32);
		panel_2.add(txtButterChicken);
		txtButterChicken.setColumns(10);
		
		txtKhamanDhokla = new JTextField();
		txtKhamanDhokla.setEditable(false);
		txtKhamanDhokla.setText("Khaman Dhokla");
		txtKhamanDhokla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtKhamanDhokla.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtKhamanDhokla.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtKhamanDhokla.setBackground(Color.DARK_GRAY);
			}
		});
		txtKhamanDhokla.setHorizontalAlignment(SwingConstants.CENTER);
		txtKhamanDhokla.setForeground(Color.WHITE);
		txtKhamanDhokla.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtKhamanDhokla.setColumns(10);
		txtKhamanDhokla.setBackground(Color.DARK_GRAY);
		txtKhamanDhokla.setBounds(63, 206, 324, 32);
		panel_2.add(txtKhamanDhokla);
		
		txtPavBhaji = new JTextField();
		txtPavBhaji.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtPavBhaji.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtPavBhaji.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtPavBhaji.setBackground(Color.DARK_GRAY);
			}
		});
		txtPavBhaji.setText("Pav Bhaji");
		txtPavBhaji.setHorizontalAlignment(SwingConstants.CENTER);
		txtPavBhaji.setForeground(Color.WHITE);
		txtPavBhaji.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtPavBhaji.setEditable(false);
		txtPavBhaji.setColumns(10);
		txtPavBhaji.setBackground(Color.DARK_GRAY);
		txtPavBhaji.setBounds(912, 205, 324, 32);
		panel_2.add(txtPavBhaji);
		
		txtRasmalai = new JTextField();
		txtRasmalai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtRasmalai.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtRasmalai.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtRasmalai.setBackground(Color.DARK_GRAY);
			}
		});
		txtRasmalai.setText("Rasmalai");
		txtRasmalai.setHorizontalAlignment(SwingConstants.CENTER);
		txtRasmalai.setForeground(Color.WHITE);
		txtRasmalai.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtRasmalai.setEditable(false);
		txtRasmalai.setColumns(10);
		txtRasmalai.setBackground(Color.DARK_GRAY);
		txtRasmalai.setBounds(63, 527, 324, 32);
		panel_2.add(txtRasmalai);
		
		txtVegSpringRoll = new JTextField();
		txtVegSpringRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtVegSpringRoll.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtVegSpringRoll.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtVegSpringRoll.setBackground(Color.DARK_GRAY);
			}
		});
		txtVegSpringRoll.setText("Chicken Tikka");
		txtVegSpringRoll.setHorizontalAlignment(SwingConstants.CENTER);
		txtVegSpringRoll.setForeground(Color.WHITE);
		txtVegSpringRoll.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtVegSpringRoll.setEditable(false);
		txtVegSpringRoll.setColumns(10);
		txtVegSpringRoll.setBackground(Color.DARK_GRAY);
		txtVegSpringRoll.setBounds(491, 527, 324, 32);
		panel_2.add(txtVegSpringRoll);
		
		txtMiloChik = new JTextField();
		txtMiloChik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(txtMiloChik.getText());
				f.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtMiloChik.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtMiloChik.setBackground(Color.DARK_GRAY);
			}
		});
		txtMiloChik.setText("Garlic Bread");
		txtMiloChik.setHorizontalAlignment(SwingConstants.CENTER);
		txtMiloChik.setForeground(Color.WHITE);
		txtMiloChik.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		txtMiloChik.setEditable(false);
		txtMiloChik.setColumns(10);
		txtMiloChik.setBackground(Color.DARK_GRAY);
		txtMiloChik.setBounds(912, 533, 324, 32);
		panel_2.add(txtMiloChik);
		f.setBackground(Color.MAGENTA);
		f.setTitle("FoodX : HomePage");
		f.setBounds(500, 500, 1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new HomePage();
	}
}


