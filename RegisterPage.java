import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RegisterPage {

	private JFrame frmRegister;
	private JTextField nameinp;
	private JTextField emailinp;
	private JTextField mobinp;
	private JTextField dobinp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setBackground(new Color(255, 255, 153));
		frmRegister.getContentPane().setForeground(new Color(255, 255, 153));
		frmRegister.setTitle("Register Page");
		frmRegister.getContentPane().setLayout(null);
		
		JLabel titlelbl = new JLabel("Register Here");
		titlelbl.setForeground(Color.RED);
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titlelbl.setBackground(new Color(255, 255, 153));
		titlelbl.setBounds(131, 10, 177, 37);
		frmRegister.getContentPane().add(titlelbl);
		
		JLabel namelbl = new JLabel("Enter Name of Student");
		namelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namelbl.setBounds(44, 85, 131, 13);
		frmRegister.getContentPane().add(namelbl);
		
		JLabel emaillbl = new JLabel("Enter Email Id");
		emaillbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emaillbl.setBounds(44, 114, 131, 13);
		frmRegister.getContentPane().add(emaillbl);
		
		JLabel clslbl = new JLabel("Select Class");
		clslbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clslbl.setBounds(44, 211, 131, 13);
		frmRegister.getContentPane().add(clslbl);
		
		JLabel moblbl = new JLabel("Enter Mobile No");
		moblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moblbl.setBounds(44, 247, 131, 13);
		frmRegister.getContentPane().add(moblbl);
		
		JLabel doblbl = new JLabel("Date of birth");
		doblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		doblbl.setBounds(44, 277, 131, 13);
		frmRegister.getContentPane().add(doblbl);
		
		JLabel genlbl = new JLabel("Gender");
		genlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genlbl.setBounds(44, 151, 131, 13);
		frmRegister.getContentPane().add(genlbl);
		
		nameinp = new JTextField();
		nameinp.setBounds(218, 83, 202, 19);
		frmRegister.getContentPane().add(nameinp);
		nameinp.setColumns(10);
		
		emailinp = new JTextField();
		emailinp.setBounds(218, 112, 202, 19);
		frmRegister.getContentPane().add(emailinp);
		emailinp.setColumns(10);
		
		JRadioButton malesel = new JRadioButton("MALE");
		malesel.setBackground(new Color(255, 255, 153));
		malesel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		malesel.setBounds(218, 148, 96, 21);
		frmRegister.getContentPane().add(malesel);
		
		JRadioButton femalesel = new JRadioButton("FEMALE");
		femalesel.setBackground(new Color(255, 255, 153));
		femalesel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		femalesel.setBounds(218, 171, 96, 21);
		frmRegister.getContentPane().add(femalesel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 153));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE", "ME"}));
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(218, 208, 96, 21);
		frmRegister.getContentPane().add(comboBox);
		
		mobinp = new JTextField();
		mobinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mobinp.setColumns(10);
		mobinp.setBounds(218, 245, 202, 19);
		frmRegister.getContentPane().add(mobinp);
		
		dobinp = new JTextField();
		dobinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dobinp.setBounds(218, 274, 202, 19);
		frmRegister.getContentPane().add(dobinp);
		dobinp.setColumns(10);
		
		JButton submitbtn = new JButton("SUBMIT");
		submitbtn.setForeground(new Color(255, 0, 0));
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		submitbtn.setBackground(new Color(255, 153, 102));
		submitbtn.setBounds(184, 329, 85, 21);
		frmRegister.getContentPane().add(submitbtn);
	}
}
