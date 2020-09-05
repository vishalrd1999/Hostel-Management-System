import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateDetails {

	public JFrame updatedet;
	private JTextField idinp;
	private JTextField mailinp;
	private JTextField mobinp;
	private JTextField delsidinp;

	/**
	 * Launch the application.
	 */
	public static void Update() {
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
		updatedet.setBounds(100, 100, 621, 510);
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
		
		JComboBox classinp = new JComboBox();
		classinp.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE", "ME"}));
		classinp.setMaximumRowCount(5);
		classinp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		classinp.setBackground(new Color(255, 255, 153));
		classinp.setBounds(256, 188, 148, 21);
		updatedet.getContentPane().add(classinp);
		
		mobinp = new JTextField();
		mobinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mobinp.setBounds(256, 242, 148, 19);
		updatedet.getContentPane().add(mobinp);
		mobinp.setColumns(10);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == updatebtn)
				{
					String s1 = idinp.getText();
					String s2 = mailinp.getText();
					String s3 = (String) classinp.getItemAt(classinp.getSelectedIndex());
					String s4 = mobinp.getText();		
					
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
					PreparedStatement ps = con.prepareStatement("update student set email=?,class=?,mob=? where sid=?");
					ps.setString(1,s2);
					ps.setString(2,s3);
					ps.setString(3,s4);
					ps.setString(4,s1);
					ps.executeUpdate();
					con.close();
				}
				catch(Exception re) {
					JOptionPane.showMessageDialog(null,re);
				}
				JOptionPane.showMessageDialog(null,"Update Successfull");
			}
			}
		});
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
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == deletebtn)
				{
					String s1 = delsidinp.getText();
					int rid=0;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement stmt=con.prepareStatement("select rid from alloc_room where sid=?");
						stmt.setString(1,s1);
						ResultSet rs=stmt.executeQuery();  
						while(rs.next())  
						rid = (rs.getInt(1));
						con.close();
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement ps = con.prepareStatement("update room set vacancy=vacancy+1 where rid=?");
						ps.setLong(1,rid);
						ps.executeUpdate();
						con.close();	
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
					PreparedStatement ps = con.prepareStatement("delete from student where sid=?");
					ps.setString(1,s1);
					ps.executeUpdate();
					con.close();
				}
				catch(Exception re) {
					JOptionPane.showMessageDialog(null,re);
				}
				JOptionPane.showMessageDialog(null,"Deleted Successfully");
				}
			}
		});
		deletebtn.setForeground(Color.RED);
		deletebtn.setBackground(new Color(255, 204, 153));
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deletebtn.setBounds(143, 401, 160, 30);
		updatedet.getContentPane().add(deletebtn);
		
		JButton dashbtn = new JButton("Dashboard");
		dashbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard db = new Dashboard();
				db.dashb();
				updatedet.dispose();
			}
		});
		dashbtn.setForeground(Color.RED);
		dashbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dashbtn.setBackground(new Color(255, 204, 153));
		dashbtn.setBounds(464, 16, 109, 21);
		updatedet.getContentPane().add(dashbtn);
	}
}
