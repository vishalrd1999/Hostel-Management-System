
public class Room {
	private int roomid;
	private int capacity;
	private int vacancy;
	
	public Room(int roomid,int capacity,int vacancy)
	{
		this.roomid = roomid;
		this.capacity=capacity;
		this.vacancy=vacancy;
	}
	public int getid() {
		return roomid;
	}
	public int getcap() {
		return capacity;
	}
	public int getvac() {
		return vacancy;
	}
}
