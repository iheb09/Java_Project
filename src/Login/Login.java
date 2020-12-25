package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		user = new JTextField();
		user.setBounds(28, 74, 278, 51);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(28, 181, 278, 51);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pharmacie","root","");
					PreparedStatement ps = con.prepareStatement("insert into user(id,user,pass) values(?,?,?);");
					ps.setString(1,"1");
					ps.setString(2,user.getText());
					ps.setString(3,pass.getText());
					int x= ps.executeUpdate();
					if(x>0)
						System.out.println("done ");
					
				} catch (Exception e) {
					System.out.println( e);
					
				}
				
			}
		});
		btnLogin.setBounds(77, 278, 186, 40);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 152, 96, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("Username ");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(28, 44, 96, 30);
		contentPane.add(lblUserName);
	}
}
