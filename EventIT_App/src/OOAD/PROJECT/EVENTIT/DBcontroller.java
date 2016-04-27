package OOAD.PROJECT.EVENTIT;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OOAD.PROJECT.EVENTIT.Model.Event;
import OOAD.PROJECT.EVENTIT.Model.Ticket;
import OOAD.PROJECT.EVENTIT.Model.User;
import OOAD.PROJECT.EVENTIT.Model.Worklist;

/**
 * Servlet implementation class DBcontroller
 */
@WebServlet("/DBcontroller")
public class DBcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private int DBUSERNAME;
	private int DBPASSWORD;
    private DataBase db;
	Connection con;
	public DBcontroller() {
		
		 db=new DataBase();
		try{
			con=db.connectdb("root", "");		
		}
		catch(Exception e)
		{
             e.printStackTrace();
		}
	
		
	}
	
	public User getuser(String userid)throws Exception {
		
		ResultSet rs=db.getuser(userid, con);
		if(rs!=null)
		{
			
			   while(rs.next()){
				    
					 String email = rs.getString("email");
					 String password=rs.getString("password");
					 String firstname=rs.getString("FirstName");
					 String lastname=rs.getString("LastName");
					 String phone=rs.getString("Phone");
					 String address=rs.getString("Address");
					 float rating=rs.getInt("Rating");
					 User user=new User(email,password,firstname,lastname,phone,address,rating);
					 
					 return user;
				}
		}
		else
		{
			return null;
		}
		return null;
	}
	public int maxeventid()throws Exception{
		ResultSet rs=db.getmaxeventid(con);
		if(rs!=null)
		{
			   
			   while(rs.next()){
				   int max_event=rs.getInt("eve");
				   return max_event;
			   }
		
		}
		else
		{
			return 0;
		}
		return 0;
	}

	/**
	 * 
	 * @param u
	 */
	public boolean saveuser(User u) {
		
		return db.saveuser(u.email, u.password, u.firstname, u.lastname, u.phone, u.address,con);
		
	}

	/**
	 * 
	 * @param e
	 */
	public boolean saveEvent(Event e) {
		
		return db.saveevent(e.eventid, e.eventname, e.venue, e.dates, e.descr, e.username,e.numticket,con,e.time,e.Category);
		
		
	}

	public Worklist getworklist() throws SQLException {
		
		ResultSet rs=db.getworklist(con);
		Worklist wl=new Worklist();
		if(rs!=null)
		{
			   
			   while(rs.next()){
					int eventid = rs.getInt("eventID"); 
					wl.events.add(eventid);
					
				}
		}
		else
		{
			
		}
		return wl;
	}

	/**
	 * 
	 * @param w
	 */
	public boolean saveWorklist(Event e) {
		// TODO - implement DBcontroller.saveWorklist
		return db.saveWorklist(e.eventid,con);
		
	}
	public boolean updateWorklist(Event e) {
		// TODO - implement DBcontroller.saveWorklist
		
		return db.changeworklist(e.eventid,con);
		
	}
	public boolean updaterating(Event e,User u,Ticket t)
	{
		return db.updaterating(e.eventid, u.email, t.rating, con);
	}
	public int getratting(Event e)
	{
		
		return db.getrating(e.eventid, e.username, con);
	}

	/**
	 * 
	 * @param eventid
	 * @throws SQLException 
	 */
	public Event getevent(int eventid) throws SQLException {
		
		ResultSet rs=db.getevent(eventid, con);
		if(rs!=null)
		{
			   
			   while(rs.next()){
				    
					 String eventname=rs.getString("EventName");
					 String descr=rs.getString("Descr");
					 String venue=rs.getString("Venue");
					 String dates=rs.getString("Date");
					 String username=rs.getString("User");
					 int numticket=rs.getInt("TotalTicket"); 
					 String status=rs.getString("Status");
					 String Time=rs.getString("Time");
					 String Category=rs.getString("Category");
					 Event ev=new Event();
					 ev.getEvent(eventid,eventname, descr, venue, dates, username, numticket, status,Time,Category);
					 
					 return ev;
				}
		}
		else
		{
			return null;
		}
		return null;
		
	}

	public Event getallevents() throws SQLException {
		
		ResultSet rs=db.getallevents(con);
		Event ev=new Event();
		if(rs!=null)
		{
			   
			   while(rs.next()){
					int eventid = rs.getInt("eventID"); 
					ev.events.add(eventid);
					
				}
		}
		else
		{
			
		}
		
		return ev;
	}
	public Event getallevents_user(String username) throws SQLException {
		
		ResultSet rs=db.getallevents_user(username,con);
		Event ev=new Event();
		if(rs!=null)
		{
			
			   while(rs.next()){
				  
					int eventid = rs.getInt("eventID"); 
					ev.events.add(eventid);
					
				}
		}
		else
		{
			
		}
		
		return ev;
	}
public Event getallevents_registed_user(String username) throws SQLException {
		
		ResultSet rs=db.getallevents_registed_user(username,con);
		Event ev=new Event();
		if(rs!=null)
		{
			
			   while(rs.next()){
				  
					int eventid = rs.getInt("eventID"); 
					ev.events.add(eventid);
					
				}
		}
		else
		{
			
		}
		
		return ev;
	}

	/**
	 * getallevents_registed_user
	 * @param t
	 */
	public boolean saveticket(Ticket t) {
		// TODO - implement DBcontroller.saveticket
		//System.out.println("Going to connect DB");
		return db.saveTicket(t.eventid,t.userid,con);
	}

	/**
	 * 
	 * @param ticketid
	 */
	public boolean cancelticket(Ticket t) {
		// TODO - implement DBcontroller.getticket
	//	System.out.println("Going to connect DB");
		return db.cancelTicket(t.eventid,t.userid,con);
	}
	public boolean cancelEvent(Event e) {
		// TODO - implement DBcontroller.getticket
	//	System.out.println("Going to connect DB");
		return db.cancelEvent(e.eventid,e.username,con);
	}
   public boolean changeevent1(Event ev)
   { 
	   
	   boolean value=db.changeevent1(ev.eventid, ev.status, con);
	   return value;
   }
	

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
