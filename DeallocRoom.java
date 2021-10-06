import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DeallocRoom {

	private JFrame deallocroom;
	private JTextField sidinp;
	private JTextField ridinp;

	/**
	 * Launch the application.
	 */
	public static void Deallocation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeallocRoom window = new DeallocRoom();
					window.deallocroom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeallocRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deallocroom = new JFrame();
		deallocroom.getContentPane().setBackground(new Color(255, 255, 153));
		deallocroom.getContentPane().setLayout(null);
		
		JLabel lblDeallocateTheRoom = new JLabel("De-Allocate the Room");
		lblDeallocateTheRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeallocateTheRoom.setForeground(Color.RED);
		lblDeallocateTheRoom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDeallocateTheRoom.setBounds(10, 10, 445, 20);
		deallocroom.getContentPane().add(lblDeallocateTheRoom);
		
		JLabel sidlbl = new JLabel("Enter SID of student");
		sidlbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidlbl.setBounds(60, 115, 109, 13);
		deallocroom.getContentPane().add(sidlbl);
		
		JLabel lblEnterRoomId = new JLabel("Enter Room ID to Deallocate");
		lblEnterRoomId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterRoomId.setBounds(60, 150, 147, 13);
		deallocroom.getContentPane().add(lblEnterRoomId);
		
		sidinp = new JTextField();
		sidinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidinp.setColumns(10);
		sidinp.setBounds(286, 112, 96, 19);
		deallocroom.getContentPane().add(sidinp);
		
		ridinp = new JTextField();
		ridinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ridinp.setColumns(10);
		ridinp.setBounds(286, 146, 96, 19);
		deallocroom.getContentPane().add(ridinp);
		
		JButton deallocbtn = new JButton("De-Allocate");
		deallocbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==deallocbtn)
				{
					String s1 = sidinp.getText();
					String s2 = ridinp.getText();
					int vac=0;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement stmt=con.prepareStatement("select vacancy from room where rid=?");
						stmt.setString(1,s2);
						ResultSet rs=stmt.executeQuery();  
						while(rs.next())  
						vac = (rs.getInt(1));
						con.close();
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
						PreparedStatement ps = con.prepareStatement("delete from alloc_room where sid=? and rid=?");
						ps.setString(1,s1);
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
						PreparedStatement ps = con.prepareStatement("update room set vacancy=? where rid=?");
						ps.setLong(1,vac+1);
						ps.setString(2,s2);
						ps.executeUpdate();
						con.close();	
					}
					catch(Exception re) {
						JOptionPane.showMessageDialog(null,re);
					}
					JOptionPane.showMessageDialog(null,"Deallocation successfull");
				}
			}
		});
		deallocbtn.setForeground(Color.RED);
		deallocbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deallocbtn.setBackground(new Color(255, 204, 153));
		deallocbtn.setBounds(171, 218, 109, 21);
		deallocroom.getContentPane().add(deallocbtn);
		
		JButton dashbtn = new JButton("Dashboard");
		dashbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.dashb();
				deallocroom.dispose();
			}
		});
		dashbtn.setForeground(Color.RED);
		dashbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dashbtn.setBackground(new Color(255, 204, 153));
		dashbtn.setBounds(421, 15, 109, 21);
		deallocroom.getContentPane().add(dashbtn);
		deallocroom.setTitle("De-Allocate Room");
		deallocroom.setBounds(100, 100, 583, 341);
		deallocroom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int deallocactivity(String s1)
	{
		int rid = -1;
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
		return rid;
	}
}
