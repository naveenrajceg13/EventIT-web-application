package OOAD.PROJECT.EVENTIT.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
import OOAD.PROJECT.EVENTIT.Model.User;
import OOAD.PROJECT.EVENTIT.Model.Worklist;

/**
 * Servlet implementation class CreateEvent_UI
 */
@WebServlet("/CreateEvent_UI")
public class CreateEvent_UI extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public DBcontroller dbconnect;
    private Event ev;
	public String EventName;
	public String Decr;
	public String Venue;
	public String Dates;
	public String Time;
	public String Category;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		register(request, response, map);
	}
	private void register(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		boolean isValid=false;
		boolean result=false;
		
		EventName=request.getParameter("eventname");
		Decr=request.getParameter("descr");
		Venue=request.getParameter("venue");
		Dates=request.getParameter("date");
		Time=request.getParameter("time");
		Category=request.getParameter("cate");
		int numticket=Integer.parseInt(request.getParameter("numticket"));
		int max_event=1;
		String username=(getServletContext().getAttribute("Login_Name").toString());
		if(true)
		{
			try {
				max_event=dbconnect.maxeventid();
				
				Event.eventid=max_event;
				ev=new Event();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ev!=null){
				result=ev.createEvent(EventName, Decr, Venue, Dates,username,numticket,"P",Time,Category);
				
			}
			if(result==true)
			{
				isValid=dbconnect.saveEvent(ev);
				
				
			}
			if(isValid)
			{
				Worklist wl;
				try {
					wl = dbconnect.getworklist();
					wl.updateWorklist(ev);
					isValid=dbconnect.saveWorklist(ev);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		map.put("isValid_2", isValid);
		try{
		write(response,map);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	private void write(HttpServletResponse response, Map<String, Object> map)throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
	}

}
