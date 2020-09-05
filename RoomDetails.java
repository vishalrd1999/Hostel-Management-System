import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;

public class RoomDetails {

	private JFrame roomdet;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomDetails window = new RoomDetails();
					window.roomdet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*try {
			table = new JTable();
			String col[] ={"Room ID","Capacity","Vacancy"}; 
			String data=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from room");
			while(rs.next()) 				
			{
				data = rs.getString(1);
			table.setModel(new DefaultTableModel(
				data,col
			));
			table.setBounds(59, 107, 302, 48);
			roomdet.getContentPane().add(table);	
		}
			con.close();
		}
		catch(Exception re) {
			System.out.println(re);
		}*/
		
		roomdet = new JFrame();
		roomdet.getContentPane().setBackground(new Color(255, 255, 153));
		roomdet.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("See Room Availability");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 20, 399, 25);
		roomdet.getContentPane().add(lblNewLabel);
		
		
		roomdet.setTitle("Room Details");
		roomdet.setBounds(100, 100, 433, 341);
		roomdet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
