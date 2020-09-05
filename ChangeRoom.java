import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ChangeRoom {

	private JFrame chngroom;
	private JTextField sidinp;
	private JTextField curroominp;
	private JTextField newroominp;

	/**
	 * Launch the application.
	 */
	public static void Change() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeRoom window = new ChangeRoom();
					window.chngroom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chngroom = new JFrame();
		chngroom.getContentPane().setBackground(new Color(255, 255, 153));
		chngroom.getContentPane().setLayout(null);
		
		JLabel lblChangeRoomOf = new JLabel("Change Room of Student");
		lblChangeRoomOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeRoomOf.setForeground(Color.RED);
		lblChangeRoomOf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChangeRoomOf.setBounds(10, 10, 467, 32);
		chngroom.getContentPane().add(lblChangeRoomOf);
		
		JLabel sidlbl = new JLabel("Enter SID of student");
		sidlbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidlbl.setBounds(40, 86, 109, 13);
		chngroom.getContentPane().add(sidlbl);
		
		JLabel lblEnterCurrentRoom = new JLabel("Enter Current Room ID");
		lblEnterCurrentRoom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterCurrentRoom.setBounds(41, 129, 147, 13);
		chngroom.getContentPane().add(lblEnterCurrentRoom);
		
		JLabel lblEnterNewRoom = new JLabel("Enter New Room ID");
		lblEnterNewRoom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterNewRoom.setBounds(40, 170, 147, 13);
		chngroom.getContentPane().add(lblEnterNewRoom);
		
		
		sidinp = new JTextField();
		sidinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidinp.setColumns(10);
		sidinp.setBounds(289, 83, 96, 19);
		chngroom.getContentPane().add(sidinp);
		
		curroominp = new JTextField();
		curroominp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		curroominp.setColumns(10);
		curroominp.setBounds(289, 126, 96, 19);
		chngroom.getContentPane().add(curroominp);
		
		newroominp = new JTextField();
		newroominp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		newroominp.setColumns(10);
		newroominp.setBounds(289, 167, 96, 19);
		chngroom.getContentPane().add(newroominp);
		chngroom.setTitle("Change Room");
		chngroom.setBounds(100, 100, 577, 309);
		chngroom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton chngbtn = new JButton("Change");
		chngbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == chngbtn) 
				{
					String s1 = sidinp.getText();
					String s2 = curroominp.getText();
					String s3 = newroominp.getText();
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement ps = con.prepareStatement("update alloc_room set rid=? where rid=?");
						ps.setString(1,s3);
						ps.setString(2,s2);
						ps.executeUpdate();
						con.close();	
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement ps = con.prepareStatement("update room set vacancy=vacancy-1 where rid=?");
						ps.setString(1,s3);
						ps.executeUpdate();
						con.close();	
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement ps = con.prepareStatement("update room set vacancy=vacancy+1 where rid=?");
						ps.setString(1,s2);
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
		chngbtn.setForeground(Color.RED);
		chngbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		chngbtn.setBackground(new Color(255, 204, 153));
		chngbtn.setBounds(172, 212, 96, 21);
		chngroom.getContentPane().add(chngbtn);
		
		JButton dashbtn = new JButton("Dashboard");
		dashbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard db = new Dashboard();
				db.dashb();
				chngroom.dispose();
			}
		});
		dashbtn.setForeground(Color.RED);
		dashbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dashbtn.setBackground(new Color(255, 204, 153));
		dashbtn.setBounds(416, 21, 109, 21);
		chngroom.getContentPane().add(dashbtn);
		
	}

}
