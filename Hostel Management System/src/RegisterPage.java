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

public class RegisterPage {

	private JFrame frmRegister;
	private JTextField title;
	private JTextField nameinput;

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
		frmRegister.setTitle("Register");
		frmRegister.setBounds(100, 100, 560, 315);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title = new JTextField();
		title.setEditable(false);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setText("Register Page");
		title.setColumns(5);
		
		JLabel namelabel = new JLabel("Name of Student");
		namelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namelabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel classlabel = new JLabel("Select Class");
		classlabel.setHorizontalAlignment(SwingConstants.LEFT);
		classlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nameinput = new JTextField();
		nameinput.setColumns(10);
		
		JRadioButton SEclsbtn = new JRadioButton("SE");
		SEclsbtn.setHorizontalAlignment(SwingConstants.LEFT);
		SEclsbtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JRadioButton TEclsbtn = new JRadioButton("TE");
		TEclsbtn.setHorizontalAlignment(SwingConstants.LEFT);
		TEclsbtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(frmRegister.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(title, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(classlabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(namelabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(TEclsbtn, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(SEclsbtn, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameinput, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(namelabel)
						.addComponent(nameinput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(classlabel)
						.addComponent(SEclsbtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TEclsbtn)
					.addGap(144))
		);
		frmRegister.getContentPane().setLayout(groupLayout);
	}
}
