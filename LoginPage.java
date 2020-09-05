import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame login;
	private JTextField unameinp;
	private JPasswordField pwdinp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame();
		login.getContentPane().setBackground(new Color(255, 255, 153));
		login.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Here");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 21, 385, 26);
		login.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(56, 106, 85, 13);
		login.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(56, 151, 85, 13);
		login.getContentPane().add(lblNewLabel_2);
		
		unameinp = new JTextField();
		unameinp.setBounds(196, 103, 109, 19);
		login.getContentPane().add(unameinp);
		unameinp.setColumns(10);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==loginbtn)
				{
					String s1 = unameinp.getText();
					String s2 = pwdinp.getText();					
					if(s1.equals("admin") && s2.equals("password"))
					{	
						JOptionPane.showMessageDialog(null,"Login Successfull");
						Dashboard db = new Dashboard();
						db.dashb();
						login.dispose();
						
					}
					else JOptionPane.showMessageDialog(null,"Wrong Credentials");
				}
			}
		});
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginbtn.setBackground(new Color(255, 204, 153));
		loginbtn.setForeground(new Color(255, 0, 0));
		loginbtn.setBounds(147, 208, 85, 31);
		login.getContentPane().add(loginbtn);
		
		pwdinp = new JPasswordField();
		pwdinp.setBounds(196, 148, 109, 19);
		login.getContentPane().add(pwdinp);
		login.setTitle("Login Here");
		login.setBounds(100, 100, 419, 318);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
