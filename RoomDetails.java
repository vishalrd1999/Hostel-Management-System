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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomDetails {

	private JFrame roomdet;
	private JTable tbl;

	/**
	 * Launch the application.
	 */
	public static void rmdet() {
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
		show_room();
	}
	public ArrayList<Room> roomdets() {
		 ArrayList<Room> rooms = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","root");
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from room"); 
				Room robj;
				while(rs.next()) {
					robj = new Room(rs.getInt("rid"),rs.getInt("capacity"),rs.getInt("vacancy"));
					rooms.add(robj);
				}
				con.close();
		}
		catch(Exception re) {
			System.out.println(re);
		}
		 return rooms;
	}
	
	public void show_room() {
		ArrayList<Room> list = roomdets();
		DefaultTableModel model = (DefaultTableModel)tbl.getModel();
		Object[] row = new Object[3];
		for(int i =0; i<list.size();i++)
		{
			row[0]=list.get(i).getid();
			row[1]=list.get(i).getcap();
			row[2]=list.get(i).getvac();
			model.addRow(row);
		}
	}
	
	private void initialize() {		
		
		roomdet = new JFrame();
		roomdet.getContentPane().setBackground(new Color(255, 255, 153));
		roomdet.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("See Room Availability");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 20, 399, 25);
		roomdet.getContentPane().add(lblNewLabel);
		
		tbl = new JTable();
		tbl.setBackground(new Color(255, 255, 153));
		tbl.setModel(new DefaultTableModel(
			new Object[][] {
				{"Room ID", "Capacity", "Vacacy"},
			},
			new String[] {
				"Room ID", "Capacity", "Vacancy"
			}
		));
		tbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tbl.setBounds(57, 79, 335, 179);
		roomdet.getContentPane().add(tbl);
		
		JButton dashbtn = new JButton("Dashboard");
		dashbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.dashb();
				roomdet.dispose();
			}
		});
		dashbtn.setForeground(Color.RED);
		dashbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dashbtn.setBackground(new Color(255, 204, 153));
		dashbtn.setBounds(372, 26, 109, 21);
		roomdet.getContentPane().add(dashbtn);
		
		roomdet.setTitle("Room Details");
		roomdet.setBounds(100, 100, 528, 341);
		roomdet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}
