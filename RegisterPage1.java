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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class RegisterPage1 {

	private JFrame frame;
	private JTextField nameinp;
	private JTextField mailinp;
	private JTextField mobinp;
	private JTextField dobinp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage1 window = new RegisterPage1();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 522, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titlelbl = new JLabel("Register Here");
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setForeground(Color.RED);
		titlelbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titlelbl.setBackground(new Color(255, 255, 153));
		titlelbl.setBounds(10, 10, 488, 37);
		frame.getContentPane().add(titlelbl);
		
		JLabel namelbl = new JLabel("Enter Name of Student");
		namelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namelbl.setBounds(38, 94, 131, 13);
		frame.getContentPane().add(namelbl);
		
		JLabel emaillbl = new JLabel("Enter Email Id");
		emaillbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emaillbl.setBounds(38, 123, 131, 13);
		frame.getContentPane().add(emaillbl);
		
		JLabel genlbl = new JLabel("Gender");
		genlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genlbl.setBounds(38, 178, 131, 13);
		frame.getContentPane().add(genlbl);
		
		JLabel clslbl = new JLabel("Select Class");
		clslbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clslbl.setBounds(38, 242, 131, 13);
		frame.getContentPane().add(clslbl);
		
		JLabel moblbl = new JLabel("Enter Mobile No");
		moblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moblbl.setBounds(38, 278, 131, 13);
		frame.getContentPane().add(moblbl);
		
		JLabel doblbl = new JLabel("Date of birth");
		doblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		doblbl.setBounds(38, 307, 131, 13);
		frame.getContentPane().add(doblbl);
		
		JButton submitbtn = new JButton("SUBMIT");
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"You clicked button");
			}
		});
		submitbtn.setForeground(Color.RED);
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		submitbtn.setBackground(new Color(255, 153, 102));
		submitbtn.setBounds(197, 355, 85, 21);
		frame.getContentPane().add(submitbtn);
		
		nameinp = new JTextField();
		nameinp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		nameinp.setColumns(10);
		nameinp.setBounds(234, 92, 202, 19);
		frame.getContentPane().add(nameinp);
		
		mailinp = new JTextField();
		mailinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		mailinp.setColumns(10);
		mailinp.setBounds(234, 121, 202, 19);
		frame.getContentPane().add(mailinp);
		
		JComboBox classinp = new JComboBox();
		classinp.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE", "ME"}));
		classinp.setMaximumRowCount(5);
		classinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		classinp.setBackground(new Color(255, 255, 153));
		classinp.setBounds(234, 239, 96, 21);
		frame.getContentPane().add(classinp);
		
		mobinp = new JTextField();
		mobinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		mobinp.setColumns(10);
		mobinp.setBounds(234, 275, 202, 19);
		frame.getContentPane().add(mobinp);
		
		dobinp = new JTextField();
		dobinp.setFont(new Font("Dialog", Font.PLAIN, 11));
		dobinp.setColumns(10);
		dobinp.setBounds(234, 304, 202, 19);
		frame.getContentPane().add(dobinp);
		
		JRadioButton selmaleinp = new JRadioButton("MALE");
		buttonGroup.add(selmaleinp);
		selmaleinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selmaleinp.setBackground(new Color(255, 255, 153));
		selmaleinp.setBounds(234, 175, 96, 21);
		frame.getContentPane().add(selmaleinp);
		
		JRadioButton selfemaleinp = new JRadioButton("FEMALE");
		buttonGroup.add(selfemaleinp);
		selfemaleinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selfemaleinp.setBackground(new Color(255, 255, 153));
		selfemaleinp.setBounds(234, 197, 96, 21);
		frame.getContentPane().add(selfemaleinp);
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
