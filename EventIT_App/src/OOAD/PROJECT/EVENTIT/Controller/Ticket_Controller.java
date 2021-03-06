package OOAD.PROJECT.EVENTIT.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import OOAD.PROJECT.EVENTIT.DBcontroller;
import OOAD.PROJECT.EVENTIT.Model.EmailObserver;
import OOAD.PROJECT.EVENTIT.Model.Event;
import OOAD.PROJECT.EVENTIT.Model.Ticket;
import OOAD.PROJECT.EVENTIT.Model.Worklist;
import OOAD.PROJECT.EVENTIT.Model.observer;

/**
 * Servlet implementation class Ticket_UI
 */
@WebServlet("/Ticket_UI")
public class Ticket_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Ticket ticket;
	private String eventid;
	private String userid;
	public DBcontroller dbconnect;
	public observer ob;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ob=new EmailObserver();
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		String mode=request.getParameter("mode");
		System.out.println(mode);
		if(mode.equals("registerall"))
		{
			register(request, response, map);
		}
		if(mode.equals("registedevents"))
		{
			
			displaybrowseevents_user(request, response, map);
		}
		
		if(mode.equals("cancelreservation"))
		{
			
			cancel(request, response, map);
		}
		if(mode.equals("registedevents_past"))
		{
			
			displaybrowseevents_user_past(request, response, map);
		}
		if(mode.equals("cancelevent"))
		{
			
			cancel_event(request, response, map);
		}
		if(mode.equals("update_event"))
		{
			
			update_event(request, response, map);
		}
		
		
	}
public void cancel(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	    HttpSession session = request.getSession(true);
	    Ticket ti;
	    Event ev=null;
	    int eventid=Integer.parseInt(request.getParameter("eventid"));
	    String username=(session.getAttribute("Login_Name").toString());
	    //System.out.println(eventid);
	    boolean isvalid=false;
	    try {
	    	ti=new Ticket(eventid,username);
	    	//System.out.println("Ticket Rengerated");
			//ev=dbconnect.getevent(eventid);
			if(ti!=null)
			isvalid=dbconnect.cancelticket(ti);
			//System.out.println(isvalid);
			try {
				if(isvalid)
				ob.sendmessage("Ticket Cancelled for event "+eventid, username, "Event IT ticket cancelled");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("ticket save detail "+isvalid);
			//System.out.println(isvalid);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(isvalid);
		map.put("isvalid3", isvalid);
		try {
			write(response,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void update_event(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	System.out.println("isvalid");
	int eventid=Integer.parseInt(request.getParameter("eventid"));
	String descr=request.getParameter("decr");
	String date=request.getParameter("date");
	String time=request.getParameter("time");
	String venue=request.getParameter("venue");
	boolean isvalid=false;
	try {
		Event ev=dbconnect.getevent(eventid);
		ev.changeDetails(descr,ev.dates,ev.time,venue);
		dbconnect.cancelEvent(ev);
		isvalid=dbconnect.saveEvent(ev);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	map.put("isvalid3", isvalid);
	try {
		write(response,map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void cancel_event(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	
    Ticket ti;
    Event ev=null;
    int eventid=Integer.parseInt(request.getParameter("eventid"));
    String username=(getServletContext().getAttribute("Login_Name").toString());
    //System.out.println(eventid);
    boolean isvalid=false;
    try {
    	ev=dbconnect.getevent(eventid);
    	//System.out.println("Ticket Rengerated");
		//ev=dbconnect.getevent(eventid);
		if(ev!=null)
		isvalid=dbconnect.cancelEvent(ev);
		try {
			ob.sendmessage(" Cancelled event "+eventid, username, "Event IT Event cancelled");
			ev=null;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("ticket save detail "+isvalid);
		//System.out.println(isvalid);
		
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	//System.out.println(isvalid);
	map.put("isvalid3", isvalid);
	try {
		write(response,map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void register(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	    HttpSession session = request.getSession(true);
	    Ticket ti;
	    Event ev=null;
	    int eventid=Integer.parseInt(request.getParameter("eventid"));
	    String username=(session.getAttribute("Login_Name").toString());
	   // System.out.println(eventid);
	    boolean isvalid=false;
	    try {
	    	ti=new Ticket(eventid,username);
	    	//System.out.println("Ticket Rengerated");
			//ev=dbconnect.getevent(eventid);
			if(ti!=null)
			isvalid=dbconnect.saveticket(ti);
			//System.out.println("ticket save detail "+isvalid);
			//System.out.println(isvalid);
			try {
				ob.sendmessage("Ticket Registered for event "+eventid, username, "Event IT ticket registered");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(isvalid);
		map.put("isvalid", isvalid);
		try {
			write(response,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
private void write(HttpServletResponse response, Map<String, Object> map)throws Exception {
	// TODO Auto-generated method stub
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(new Gson().toJson(map));
}

public void displaybrowseevents_user(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	HttpSession session = request.getSession(true);
	Worklist wl=null;
	Event ev=null;
	boolean isvalid=false;
	String username1=(session.getAttribute("Login_Name").toString());
	try {
		
		ev=dbconnect.getallevents_registed_user(username1);
		//System.out.println("event got");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	if(ev!=null){
	ArrayList<Integer> events=ev.events;
	int i;
	
	int count=0;
	for(i=0;i<events.size();i++)
	{
		try{
		Event e=dbconnect.getevent(events.get(i));
		if(e.checkevent()){count=count+1;}
		}
		catch(Exception e)
		{
			
		}
	}
	//System.out.println("arrays got size is "+events.size());
	int eventid[]=new int[count];
	String eventname[]=new String[count];
	String descr[]=new String[count];
	String venue[]=new String[count];
	String dates[]=new String[count];
	String username[]=new String[count];
	String Status[]=new String[count];
	String Time[]=new String[count];
	String Category[]=new String[count];
	int numticket[]=new int[count];
	//System.out.println("arrays created ");
	count=0;
	for(i=0;i<events.size();i++)
	{
		try {
			Event e=dbconnect.getevent(events.get(i));
			if(!e.checkevent())continue;
			eventid[count]=events.get(i);
			eventname[count]=e.eventname;
			descr[count]=e.descr;
			venue[count]=e.venue;
			dates[count]=e.dates;
			username[count]=e.username;
			Status[count]=e.status;
			numticket[count]=e.numticket;
			Time[count]=e.time;
			Category[count]=e.Category;
			isvalid=true;count++;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	map.put("eventid", eventid);
	map.put("eventname", eventname);
	map.put("descr", descr);
	map.put("venue", venue);
	map.put("dates", dates);
	map.put("username", username);
	map.put("Status", Status);
	map.put("numticket",numticket);
	map.put("time",Time);
	map.put("category",Category);}
	//System.out.println("mostly done "+isvalid);
	map.put("isvalid1",isvalid);
	try {
		write(response,map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void displaybrowseevents_user_past(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	HttpSession session = request.getSession(true);
	Worklist wl=null;
	Event ev=null;
	boolean isvalid=false;
	String username1=(session.getAttribute("Login_Name").toString());
	try {
		
		ev=dbconnect.getallevents_registed_user(username1);
		//System.out.println("event got");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	if(ev!=null){
		int i;
	ArrayList<Integer> events=ev.events;
	int count=0;
	for(i=0;i<events.size();i++)
	{
		try{
		Event e=dbconnect.getevent(events.get(i));
		if(!e.checkevent()){count=count+1;}
		}
		catch(Exception e)
		{
			
		}
	}
	//System.out.println("arrays got size is "+events.size());
	int eventid[]=new int[count];
	String eventname[]=new String[count];
	String descr[]=new String[count];
	String venue[]=new String[count];
	String dates[]=new String[count];
	String username[]=new String[count];
	String Status[]=new String[count];
	String Time[]=new String[count];
	String Category[]=new String[count];
	int numticket[]=new int[count];
	int rated[]=new int[count];
	//System.out.println("arrays created ");
	count=0;
	for(i=0;i<events.size();i++)
	{
		try {
			Event e=dbconnect.getevent(events.get(i));
			if(e.checkevent())continue;
			eventid[count]=events.get(i);
			eventname[count]=e.eventname;
			descr[count]=e.descr;
			venue[count]=e.venue;
			dates[count]=e.dates;
			username[count]=e.username;
			Status[count]=e.status;
			numticket[count]=e.numticket;
			Time[count]=e.time;
			Category[count]=e.Category;
			rated[count]=dbconnect.getratting(e);
			
			isvalid=true;count++;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	map.put("eventid", eventid);
	map.put("eventname", eventname);
	map.put("descr", descr);
	map.put("venue", venue);
	map.put("dates", dates);
	map.put("username", username);
	map.put("Status", Status);
	map.put("numticket",numticket);
	map.put("time",Time);
	map.put("category",Category);
	map.put("rating",rated);}
	//System.out.println("mostly done "+isvalid);
	map.put("isvalid1",isvalid);
	try {
		write(response,map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
