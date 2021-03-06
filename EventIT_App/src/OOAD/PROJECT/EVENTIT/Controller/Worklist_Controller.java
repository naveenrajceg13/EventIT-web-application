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
import OOAD.PROJECT.EVENTIT.Model.Worklist_Singleton;

/**
 * Servlet implementation class Worklist_UI
 */
@WebServlet("/Worklist_UI")
public class Worklist_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public DBcontroller dbconnect;
	private String eventid;
	private String status;
	private Worklist_Singleton ws;
	private Worklist wl;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("isvalid",true);
		try {
			write(response,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		String mode=request.getParameter("mode");
		if(mode.equals("manageevents"))
		{
			
			displayworklistevents(request, response, map);
		}
		
	}
	public void displayworklistevents(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
		
		Worklist wl=null;
		
		try {
			wl=dbconnect.getworklist();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> events=wl.events;
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
		boolean isvalid=false;
		int i;
		System.out.println("size "+events.size());
		for(i=0;i<events.size();i++)
		{
			try {
				wl.checkworklist(events.get(i));
				System.out.println(i);
				Event e=dbconnect.getevent(events.get(i));
				if(e!=null)
				{
				eventid[i]=events.get(i);
				eventname[i]=e.eventname;
				descr[i]=e.descr;
				venue[i]=e.venue;
				dates[i]=e.dates;
				username[i]=e.username;
				Status[i]=e.status;
				numticket[i]=e.numticket;
				Time[i]=e.time;
				isvalid=true;
				Category[i]=e.Category;
				}
				
	
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
		map.put("time",Time);
		map.put("category",Category);
		map.put("numticket",numticket);
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

}
