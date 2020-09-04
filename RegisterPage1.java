import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class RegisterPage1 {

	private JFrame registerpage1;
	private JTextField nameinp;
	private JTextField mailinp;
	private JTextField mobinp;
	private JTextField dobinp;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage1 window = new RegisterPage1();
					window.registerpage1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterPage1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registerpage1 = new JFrame();
		registerpage1.setTitle("Register Student");
		registerpage1.getContentPane().setBackground(new Color(255, 255, 153));
		registerpage1.setBounds(100, 100, 522, 446);
		registerpage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerpage1.getContentPane().setLayout(null);
		
		JLabel titlelbl = new JLabel("Register Here");
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setForeground(Color.RED);
		titlelbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titlelbl.setBackground(new Color(255, 255, 153));
		titlelbl.setBounds(10, 10, 488, 37);
		registerpage1.getContentPane().add(titlelbl);
		
		JLabel namelbl = new JLabel("Enter Name of Student");
		namelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namelbl.setBounds(38, 94, 131, 13);
		registerpage1.getContentPane().add(namelbl);
		
		JLabel emaillbl = new JLabel("Enter Email Id");
		emaillbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emaillbl.setBounds(38, 123, 131, 13);
		registerpage1.getContentPane().add(emaillbl);
		
		JLabel genlbl = new JLabel("Gender");
		genlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genlbl.setBounds(38, 178, 131, 13);
		registerpage1.getContentPane().add(genlbl);
		
		JLabel clslbl = new JLabel("Select Class");
		clslbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clslbl.setBounds(38, 242, 131, 13);
		registerpage1.getContentPane().add(clslbl);
		
		JLabel moblbl = new JLabel("Enter Mobile No");
		moblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moblbl.setBounds(38, 278, 131, 13);
		registerpage1.getContentPane().add(moblbl);
		
		JLabel doblbl = new JLabel("Date of birth");
		doblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		doblbl.setBounds(38, 307, 131, 13);
		registerpage1.getContentPane().add(doblbl);
		
		
		
		
		nameinp = new JTextField();
		nameinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		nameinp.setColumns(10);
		nameinp.setBounds(234, 92, 202, 19);
		registerpage1.getContentPane().add(nameinp);
		
		mailinp = new JTextField();
		mailinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		mailinp.setColumns(10);
		mailinp.setBounds(234, 121, 202, 19);
		registerpage1.getContentPane().add(mailinp);
		
		JComboBox classinp = new JComboBox();
		classinp.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE", "ME"}));
		classinp.setMaximumRowCount(5);
		classinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		classinp.setBackground(new Color(255, 255, 153));
		classinp.setBounds(234, 239, 96, 21);
		registerpage1.getContentPane().add(classinp);
		
		mobinp = new JTextField();
		mobinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		mobinp.setColumns(10);
		mobinp.setBounds(234, 275, 202, 19);
		registerpage1.getContentPane().add(mobinp);
		
		dobinp = new JTextField();
		dobinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		dobinp.setColumns(10);
		dobinp.setBounds(234, 304, 202, 19);
		registerpage1.getContentPane().add(dobinp);
		
		JRadioButton selmaleinp = new JRadioButton("MALE");
		buttonGroup.add(selmaleinp);
		selmaleinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selmaleinp.setBackground(new Color(255, 255, 153));
		selmaleinp.setBounds(234, 175, 96, 21);
		registerpage1.getContentPane().add(selmaleinp);
		
		JRadioButton selfemaleinp = new JRadioButton("FEMALE");
		buttonGroup.add(selfemaleinp);
		selfemaleinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selfemaleinp.setBackground(new Color(255, 255, 153));
		selfemaleinp.setBounds(234, 197, 96, 21);
		registerpage1.getContentPane().add(selfemaleinp);
		
		JButton submitbtn = new JButton("SUBMIT");
		submitbtn.setForeground(Color.RED);
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		submitbtn.setBackground(new Color(255, 153, 102));
		submitbtn.setBounds(197, 355, 85, 21);
		registerpage1.getContentPane().add(submitbtn);
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == submitbtn)
				{
					String s1 = nameinp.getText();
					String s2 = mailinp.getText();
					String s3 = null;
					String s4 = (String) classinp.getItemAt(classinp.getSelectedIndex());
					String s5 = mobinp.getText();
					String s6 = dobinp.getText();
					if(selmaleinp.isSelected()){    
						s3 = "MALE";
						}    
						if(selfemaleinp.isSelected()){    
						s3 = "FEMALE";
						}    
					
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
					PreparedStatement ps = con.prepareStatement("insert into student(name,email,gender,class,mob,dob) values(?,?,?,?,?,?)");
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.executeUpdate();
					con.close();
				}
				catch(Exception re) {
					System.out.println(re);
				}
			}
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
