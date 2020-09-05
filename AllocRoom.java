import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AllocRoom {

	private JFrame allocroom;
	private JTextField sidinp;
	private JTextField ridinp;

	/**
	 * Launch the application.
	 */
	public static void Allocation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllocRoom window = new AllocRoom();
					window.allocroom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllocRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		allocroom = new JFrame();
		allocroom.getContentPane().setBackground(new Color(255, 255, 153));
		allocroom.getContentPane().setLayout(null);
		
		JLabel alloclbl = new JLabel("Allocate Room to Student");
		alloclbl.setHorizontalAlignment(SwingConstants.CENTER);
		alloclbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		alloclbl.setForeground(Color.RED);
		alloclbl.setBounds(10, 10, 445, 20);
		allocroom.getContentPane().add(alloclbl);
		
		JLabel sidlbl = new JLabel("Enter SID of student");
		sidlbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidlbl.setBounds(48, 96, 109, 13);
		allocroom.getContentPane().add(sidlbl);
		
		JLabel ridlbl = new JLabel("Enter Room ID to allocate");
		ridlbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ridlbl.setBounds(48, 151, 134, 13);
		allocroom.getContentPane().add(ridlbl);
		
		sidinp = new JTextField();
		sidinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sidinp.setBounds(253, 93, 96, 19);
		allocroom.getContentPane().add(sidinp);
		sidinp.setColumns(10);
		
		ridinp = new JTextField();
		ridinp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ridinp.setBounds(253, 148, 96, 19);
		allocroom.getContentPane().add(ridinp);
		ridinp.setColumns(10);
		allocroom.setTitle("Allocate Room");
		allocroom.setBounds(100, 100, 479, 316);
		allocroom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton allocbtn = new JButton("Allocate");
		allocbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vac = 0;
				if(e.getSource() == allocbtn)
				{
					String s1 = sidinp.getText();
					String s2 = ridinp.getText();	
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
						System.out.println(re);
					}
					if(vac>0)
						{
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
										PreparedStatement ps = con.prepareStatement("insert into alloc_room(sid,rid) values(?,?)");
										ps.setString(1,s1);
										ps.setString(2,s2);
										ps.executeUpdate();
										con.close();	
									}
									catch(Exception re) {
										System.out.println(re);
									}
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
										PreparedStatement ps = con.prepareStatement("update room set vacancy=? where rid=?");
										ps.setLong(1,vac-1);
										ps.setString(2,s2);
										ps.executeUpdate();
										con.close();	
									}
									catch(Exception re) {
										System.out.println(re);
									}
						}
				}
			}
		});
		allocbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		allocbtn.setForeground(new Color(255, 0, 0));
		allocbtn.setBackground(new Color(255, 204, 153));
		allocbtn.setBounds(159, 210, 96, 21);
		allocroom.getContentPane().add(allocbtn);
	}
}
