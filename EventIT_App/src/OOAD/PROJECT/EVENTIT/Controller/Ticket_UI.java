package OOAD.PROJECT.EVENTIT.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import OOAD.PROJECT.EVENTIT.DBcontroller;
import OOAD.PROJECT.EVENTIT.Model.Event;
import OOAD.PROJECT.EVENTIT.Model.Ticket;
import OOAD.PROJECT.EVENTIT.Model.Worklist;

/**
 * Servlet implementation class Ticket_UI
 */
@WebServlet("/Ticket_UI")
public class Ticket_UI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Ticket ticket;
	private String eventid;
	private String userid;
	public DBcontroller dbconnect;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		String mode=request.getParameter("mode");
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
		
		
	}
public void cancel(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
		
	    Ticket ti;
	    Event ev=null;
	    int eventid=Integer.parseInt(request.getParameter("eventid"));
	    String username=(getServletContext().getAttribute("Login_Name").toString());
	    //System.out.println(eventid);
	    boolean isvalid=false;
	    try {
	    	ti=new Ticket(eventid,username);
	    	//System.out.println("Ticket Rengerated");
			//ev=dbconnect.getevent(eventid);
			if(ti!=null)
			isvalid=dbconnect.cancelticket(ti);
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
		
	    Ticket ti;
	    Event ev=null;
	    int eventid=Integer.parseInt(request.getParameter("eventid"));
	    String username=(getServletContext().getAttribute("Login_Name").toString());
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
	
	Worklist wl=null;
	Event ev=null;
	boolean isvalid=false;
	String username1=(getServletContext().getAttribute("Login_Name").toString());
	try {
		
		ev=dbconnect.getallevents_user(username1);
		//System.out.println("event got");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	if(ev!=null){
	ArrayList<Integer> events=ev.events;
	//System.out.println("arrays got size is "+events.size());
	int eventid[]=new int[events.size()];
	String eventname[]=new String[events.size()];
	String descr[]=new String[events.size()];
	String venue[]=new String[events.size()];
	String dates[]=new String[events.size()];
	String username[]=new String[events.size()];
	String Status[]=new String[events.size()];
	String Time[]=new String[events.size()];
	String Category[]=new String[events.size()];
	int numticket[]=new int[events.size()];
	//System.out.println("arrays created ");
	int i;
	for(i=0;i<events.size();i++)
	{
		try {
			Event e=dbconnect.getevent(events.get(i));
			if(!e.checkevent())continue;
			eventid[i]=events.get(i);
			eventname[i]=e.eventname;
			descr[i]=e.descr;
			venue[i]=e.venue;
			dates[i]=e.dates;
			username[i]=e.username;
			Status[i]=e.status;
			numticket[i]=e.numticket;
			Time[i]=e.time;
			Category[i]=e.Category;
			isvalid=true;

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
	
	Worklist wl=null;
	Event ev=null;
	boolean isvalid=false;
	String username1=(getServletContext().getAttribute("Login_Name").toString());
	try {
		
		ev=dbconnect.getallevents_user(username1);
		//System.out.println("event got");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	if(ev!=null){
	ArrayList<Integer> events=ev.events;
	//System.out.println("arrays got size is "+events.size());
	int eventid[]=new int[events.size()];
	String eventname[]=new String[events.size()];
	String descr[]=new String[events.size()];
	String venue[]=new String[events.size()];
	String dates[]=new String[events.size()];
	String username[]=new String[events.size()];
	String Status[]=new String[events.size()];
	String Time[]=new String[events.size()];
	String Category[]=new String[events.size()];
	int numticket[]=new int[events.size()];
	//System.out.println("arrays created ");
	int i;
	for(i=0;i<events.size();i++)
	{
		try {
			Event e=dbconnect.getevent(events.get(i));
			if(e.checkevent())continue;
			eventid[i]=events.get(i);
			eventname[i]=e.eventname;
			descr[i]=e.descr;
			venue[i]=e.venue;
			dates[i]=e.dates;
			username[i]=e.username;
			Status[i]=e.status;
			numticket[i]=e.numticket;
			Time[i]=e.time;
			Category[i]=e.Category;
			isvalid=true;

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

}
