package OOAD.PROJECT.EVENTIT.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import OOAD.PROJECT.EVENTIT.DBcontroller;
import OOAD.PROJECT.EVENTIT.Model.EmailObserver;
import OOAD.PROJECT.EVENTIT.Model.Event;
import OOAD.PROJECT.EVENTIT.Model.Worklist;
import OOAD.PROJECT.EVENTIT.Model.observer;

/**
 * Servlet implementation class approvereject
 */
@WebServlet("/approvereject")
public class approvereject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public DBcontroller dbconnect;
	public observer ob;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ob= new EmailObserver();
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		String mode=request.getParameter("mode");
		if(mode.equals("approve"))
		{
			
			approves(request, response, map);
		}
		else
		{
			
			reject(request, response, map);
		}
	}

	
	private void write(HttpServletResponse response, Map<String, Object> map)throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
	}
public void approves(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
		
	    Event ev;
	    int eventid=Integer.parseInt(request.getParameter("eventid"));
	    //System.out.println(eventid);
	    boolean isvalid=false;
	    try {
			ev=dbconnect.getevent(eventid);
			if(ev!=null)
			{
			ev.changestatus("A");
			}
			
			if(ev!=null)
			isvalid=dbconnect.updateWorklist(ev);
			//System.out.println(isvalid);
			if(isvalid)
			isvalid=dbconnect.changeevent1(ev);
			try {
				ob.sendmessage("Your event approved "+eventid, ev.username, "Event IT event approved");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println(isvalid);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		map.put("isvalid1", isvalid);
		try {
			write(response,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void reject(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map){
	Event ev;
    int eventid=Integer.parseInt(request.getParameter("eventid"));
    boolean isvalid=false;
    try {
		ev=dbconnect.getevent(eventid);
		ev.changestatus("C");
		if(ev!=null)
		isvalid=dbconnect.updateWorklist(ev);
	//System.out.println(isvalid);
		if(isvalid)
		isvalid=dbconnect.changeevent1(ev);
		try {
			ob.sendmessage("Your event Rejected "+eventid, ev.username, "Event IT event Rejected");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		//System.out.println(isvalid);
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	map.put("isvalid2", isvalid);
	try {
		write(response,map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
