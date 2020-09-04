package stqaproj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Dashboard {

	private JFrame dashboard;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.dashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dashboard = new JFrame();
		dashboard.getContentPane().setBackground(new Color(255, 255, 153));
		dashboard.setTitle("Dashboard");
		dashboard.setBounds(100, 100, 532, 339);
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.getContentPane().setLayout(null);
		dashboard.setVisible(true);
		
		JLabel welcomelbl = new JLabel("Welcome to Hostel Management System");
		welcomelbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomelbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		welcomelbl.setForeground(Color.RED);
		welcomelbl.setBounds(10, 10, 493, 37);
		dashboard.getContentPane().add(welcomelbl);
		
		JButton updatedetbtn = new JButton("Update Student Details");
		updatedetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDetails upd = new UpdateDetails();
				upd.Update();
				dashboard.dispose();
			}
		});
		updatedetbtn.setBackground(new Color(204, 255, 153));
		updatedetbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updatedetbtn.setBounds(56, 153, 170, 21);
		dashboard.getContentPane().add(updatedetbtn);
		
		JButton roomallocbtn = new JButton("Allocate Room");
		roomallocbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllocRoom alloc = new AllocRoom();
				alloc.Allocation();
				dashboard.dispose();
			}
		});
		roomallocbtn.setBackground(new Color(204, 255, 153));
		roomallocbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roomallocbtn.setBounds(56, 204, 170, 21);
		dashboard.getContentPane().add(roomallocbtn);
		
		JButton roomdetbtn = new JButton("See Room Details");
		roomdetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from room");  
					while(rs.next())  
					System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3));
					con.close();
				}
				catch(Exception re) {
					System.out.println(re);
				}
			}
		});
		roomdetbtn.setBackground(new Color(204, 255, 153));
		roomdetbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roomdetbtn.setBounds(292, 104, 170, 21);
		dashboard.getContentPane().add(roomdetbtn);
		
		JButton chngroombtn = new JButton("Change Student's Room");
		chngroombtn.setBackground(new Color(204, 255, 153));
		chngroombtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chngroombtn.setBounds(292, 153, 170, 21);
		dashboard.getContentPane().add(chngroombtn);
		
		JButton deallocroombtn = new JButton("De-allocate Room");
		deallocroombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeallocRoom dealloc = new DeallocRoom();
				dealloc.Deallocation();
				dashboard.dispose();
			}
		});
		deallocroombtn.setBackground(new Color(204, 255, 153));
		deallocroombtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deallocroombtn.setBounds(292, 204, 170, 21);
		dashboard.getContentPane().add(deallocroombtn);
		
		JButton addstudbtn = new JButton("Add New Student");
		addstudbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage1 reg = new RegisterPage1();
				reg.Register();
				dashboard.dispose();
			}
		});
		addstudbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addstudbtn.setBackground(new Color(204, 255, 153));
		addstudbtn.setBounds(56, 105, 170, 21);
		dashboard.getContentPane().add(addstudbtn);
	}
}
