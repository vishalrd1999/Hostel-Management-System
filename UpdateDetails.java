import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class UpdateDetails {

	private JFrame updatedet;
	private JTextField idinp;
	private JTextField mailinp;
	private JTextField mobinp;
	private JTextField delsidinp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDetails window = new UpdateDetails();
					window.updatedet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updatedet = new JFrame();
		updatedet.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		updatedet.getContentPane().setBackground(new Color(255, 255, 153));
		updatedet.setTitle("Update Student's Details");
		updatedet.setBounds(100, 100, 487, 510);
		updatedet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updatedet.getContentPane().setLayout(null);
		
		JLabel updatelbl = new JLabel("Update Student Details");
		updatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		updatelbl.setForeground(Color.RED);
		updatelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updatelbl.setBounds(10, 10, 443, 25);
		updatedet.getContentPane().add(updatelbl);
		
		JLabel sidlbl = new JLabel("Enter ID of Student");
		sidlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sidlbl.setBounds(44, 98, 124, 13);
		updatedet.getContentPane().add(sidlbl);
		
		JLabel maillbl = new JLabel("Updated Email Id");
		maillbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maillbl.setBounds(44, 149, 112, 13);
		updatedet.getContentPane().add(maillbl);
		
		JLabel moblbl = new JLabel("Update Mobile No");
		moblbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moblbl.setBounds(44, 244, 112, 13);
		updatedet.getContentPane().add(moblbl);
		
		JLabel clslbl = new JLabel("Update Class");
		clslbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clslbl.setBounds(44, 191, 112, 13);
		updatedet.getContentPane().add(clslbl);
		
		idinp = new JTextField();
		idinp.setBounds(256, 96, 148, 19);
		updatedet.getContentPane().add(idinp);
		idinp.setColumns(10);
		
		mailinp = new JTextField();
		mailinp.setBounds(256, 147, 148, 19);
		updatedet.getContentPane().add(mailinp);
		mailinp.setColumns(10);
		
		JComboBox clsinp = new JComboBox();
		clsinp.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE", "ME"}));
		clsinp.setMaximumRowCount(5);
		clsinp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clsinp.setBackground(new Color(255, 255, 153));
		clsinp.setBounds(256, 188, 148, 21);
		updatedet.getContentPane().add(clsinp);
		
		mobinp = new JTextField();
		mobinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mobinp.setBounds(256, 242, 148, 19);
		updatedet.getContentPane().add(mobinp);
		mobinp.setColumns(10);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.setBackground(new Color(255, 204, 153));
		updatebtn.setForeground(Color.RED);
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		updatebtn.setBounds(185, 289, 85, 30);
		updatedet.getContentPane().add(updatebtn);
		
		JLabel sidlbl_1 = new JLabel("Enter ID of Student");
		sidlbl_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sidlbl_1.setBounds(44, 359, 124, 13);
		updatedet.getContentPane().add(sidlbl_1);
		
		delsidinp = new JTextField();
		delsidinp.setColumns(10);
		delsidinp.setBounds(256, 357, 148, 19);
		updatedet.getContentPane().add(delsidinp);
		
		JButton deletebtn = new JButton("DELETE STUDENT");
		deletebtn.setForeground(Color.RED);
		deletebtn.setBackground(new Color(255, 204, 153));
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deletebtn.setBounds(143, 401, 160, 30);
		updatedet.getContentPane().add(deletebtn);
	}
}
