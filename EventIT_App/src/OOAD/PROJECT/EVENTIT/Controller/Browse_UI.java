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
import OOAD.PROJECT.EVENTIT.Model.Worklist;

/**
 * Servlet implementation class Browse_UI
 */
@WebServlet("/Browse_UI")
public class Browse_UI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public DBcontroller dbconnect;
	private String fromdate;
	private String todate;
	private Event ev;
	private Worklist wl;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		String mode=request.getParameter("mode");
		if(mode.equals("browseevents"))
		{
			
			displaybrowseevents(request, response, map);
		}
		if(mode.equals("browseevents_search"))
		{
			
			displaybrowseevents_search(request, response, map);
		}
		
	}
public void displaybrowseevents(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	    wl=null;
	    ev=null;
		boolean isvalid=false;
		try {
			
			ev=dbconnect.getallevents();
			ev.checkevent(1, 1);
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
				if(e.checkevent()){count=count+1;}
				}
				catch(Exception e)
				{
					
				}
			}
		
		System.out.println("arrays got size is "+events.size()+"  cout is "+count);
			
		int eventid[]=new int[count];
		String eventname[]=new String[count];
		String descr[]=new String[count];
		String venue[]=new String[count];
		String dates[]=new String[count];
		String username[]=new String[count];
		String Status[]=new String[count];
		int numticket[]=new int[count];
		String Time[]=new String[count];
		String Category[]=new String[count];
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
		map.put("isvalid",isvalid);
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
	
	
	public void displaybrowseevents_search(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	    
		boolean isvalid=false;
		
		String fromdate=request.getParameter("fromdate");
		String todate=request.getParameter("todate");
		String cat_index=request.getParameter("category");
		int category_index=Integer.parseInt(cat_index);
		if((fromdate.equals("") && todate.equals("")))
		{
			map.put("cat_index", category_index);
			displaybrowseevents(request, response, map);
			return;
		}
		
		if(true)
		{
			//System.out.println("pai");
		if(ev!=null){
			int i;
			ArrayList<Integer> events=ev.events;
			int count=0;
			
			for(i=0;i<events.size();i++)
			{
				try{
				Event e=dbconnect.getevent(events.get(i));
				if(fromdate.equals(""))
				{
					
				if(e.checkevent(todate,1)){count=count+1;}
				}
				else if(todate.equals(""))
				{
					
				if(e.checkevent(fromdate,1)){count=count+1;}	
				}
				else if(!(fromdate.equals("") && todate.equals("")))
				{
					
				if(e.checkevent(fromdate,todate)){count=count+1;}
				}
				else
				{
					count=count+1;
				}
				
				}
				catch(Exception e)
				{
					
				}
			}
		
		//System.out.println("arrays got size is "+events.size());
			//System.out.println("count value"+count);
		int eventid[]=new int[count];
		String eventname[]=new String[count];
		String descr[]=new String[count];
		String venue[]=new String[count];
		String dates[]=new String[count];
		String username[]=new String[count];
		String Status[]=new String[count];
		int numticket[]=new int[count];
		String Time[]=new String[count];
		String Category[]=new String[count];
		//System.out.println("arrays created ");
		count=0;
		for(i=0;i<events.size();i++)
		{
			try {
				
				Event e=dbconnect.getevent(events.get(i));
				if(!e.checkevent())continue;
				eventid[count]=events.get(i);
				if(fromdate.equals(""))
				{
					System.out.println("1");
				if(!e.checkevent(todate,1)){continue;}
				}
				else if(todate.equals(""))
				{
					System.out.println("2");
					System.out.println(e.checkevent(fromdate,1));
				if(!e.checkevent(fromdate,1)){continue;}	
				}
				else if(!todate.equals("")&&!fromdate.equals(""))
				{
					System.out.println("3");
					//System.out.println("asasas"+e.checkevent(fromdate,todate));
				if(!e.checkevent(fromdate,todate)){continue;}
				}
				System.out.println("ssasas "+e.dates);
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
		map.put("category",Category);
		map.put("cat_index", category_index);}
		//System.out.println("mostly done "+isvalid);
		map.put("isvalid",isvalid);
		map.put("nochange",false);
		
	}
		else
		{
			map.put("nochange",false);
			
		}
		try {
			write(response,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


