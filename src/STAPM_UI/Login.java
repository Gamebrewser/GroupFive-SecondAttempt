package STAPM_UI;
import mgmt.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame{

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JFrame frame;
	private STAPM stapm;
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
	
	public Login() {
		frame = this;
		this.stapm=new STAPM();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 800, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Login");
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Verdana", Font.PLAIN, 46));
		title.setBounds(77, 137, 311, 64);
		contentPane.add(title);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(111, 253, 113, 33);
		contentPane.add(lblUsername);
		
		JLabel lblpasswordField = new JLabel("Password");
		lblpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpasswordField.setBounds(111, 297, 89, 33);
		contentPane.add(lblpasswordField);
		
		usernameField = new JTextField();
		usernameField.setBounds(232, 262, 190, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(232, 306, 190, 20);
		contentPane.add(passwordField);	
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(111, 353, 311, 48);
		contentPane.add(btnNewButton);
		
		//trying login failed line. Since login is not important, I'm not paying a lot of attention to it.
		/*		JLabel lblLoginFailed = new JLabel("Login Failed");
				lblLoginFailed.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblLoginFailed.setBounds(190, 400, 355, 33);
				contentPane.add(lblLoginFailed);	
		*/
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(193, 29, 80, 14);
		contentPane.add(lblWelcome);
		
		JLabel systemName = new JLabel("STAP MANAGEMENT");
		systemName.setForeground(Color.WHITE);
		systemName.setFont(new Font("Tahoma", Font.PLAIN, 72));
		systemName.setBounds(10, 54, 700, 64);
		contentPane.add(systemName);
		
		usernameField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				usernameField.setForeground(Color.BLACK);
			}
		});
		
		passwordField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				passwordField.setForeground(Color.BLACK);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Login Attempt");
				if(stapm.userValidation(usernameField.getText(), passwordField.getText())) {
					Main mainSystem = new Main(stapm);
					mainSystem.setVisible(true);
					frame.setVisible(false);
					System.out.println("Login Successful");
				}else{
					usernameField.setForeground(Color.RED);
					passwordField.setForeground(Color.RED);
					
					System.out.println("Incorrect username or password.");
				}
			}
		});
	}
	
}