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
import OOAD.PROJECT.EVENTIT.Model.User;

/**
 * Servlet implementation class EventIT_UI
 */
@WebServlet("/EventIT_UI")
public class EventIT_UI extends HttpServlet {

	public DBcontroller dbconnect;
	public User user;
	private String username;
	private String password;
	private String Emailid;
	private String lastname;
	private String phone;
	private String address;
	private String firstname;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,Object> map=new HashMap<String,Object>();
		dbconnect=new DBcontroller();
		 String mode=request.getParameter("mode");
		 if(mode.equals("login"))
		 {
			 try {
				login(request, response, map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(mode.equals("register"))
		 {
			 try {
				 register(request, response, map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(mode.equals("View_Profile"))
		 {
			 try {
				 view_profile(request, response, map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(mode.equals("update_profile"))
		 {
			 try {
				 update_profile(request, response, map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(mode.equals("change_password"))
		 {
			 try {
				 update_pass(request, response, map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
		 
		 
		
	}

	private void write(HttpServletResponse response, Map<String, Object> map)throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		boolean isValid=false;
		boolean result=false;
		username=request.getParameter("username");
		password=request.getParameter("password");
		if((username!=null && username.trim().length()!=0) && (password!=null && password.trim().length()!=0))
		{
			
			
			try {
				user=dbconnect.getuser(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user!=null){
				result=user.Checklogin(username, password);
			}
			if(result==true)
			{
				getServletContext().setAttribute("Login_Name", username);
				request.setAttribute("Login_Name",username);
				isValid=true;
			}
		}
		map.put("isValid", isValid);
		try{
		write(response,map);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	private void register(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		boolean isValid=false;
		boolean result=false;
		username=request.getParameter("username");
		password=request.getParameter("password");
		firstname=request.getParameter("fname");
		lastname=request.getParameter("lname");
		phone=request.getParameter("ph");
		address=request.getParameter("ad");
		if((username!=null && username.trim().length()!=0) && (password!=null && password.trim().length()!=0))
		{
			
			
			try {
				user=new User();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user!=null){
				result=user.updateuser(username, password, firstname, lastname, phone, address);
				
			}
			if(result==true)
			{
				isValid=dbconnect.saveuser(user);
				
				
			}
		}
		map.put("isValid_1", isValid);
		try{
		write(response,map);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	private void view_profile(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		
		String username=(getServletContext().getAttribute("Login_Name").toString());
		try {
			user=dbconnect.getuser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
		
			if(user.firstname!=null){
			map.put("name",user.firstname);}
			else
			{
				map.put("name",username);
			}
			map.put("email",user.email );
			map.put("address",user.address );
			map.put("phone",user.phone );
			map=view_host(request, response, map);
			map.put("isvalid", true);
			System.out.println(true);
		}
		else
		{
			map.put("isvalid", false);
			System.out.println(false);
		}
		
		try{
			write(response,map);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
	}
	private Map<String, Object> view_host(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		     String userid=(getServletContext().getAttribute("Login_Name").toString());
      	     Event ev=null;
      	     boolean isvalid=false;
	     try {
				user=dbconnect.getuser(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user!=null){
				map.put("email",user.email );
				map.put("address",user.address );
				map.put("phone",user.phone );
				try {
					
					ev=dbconnect.getallevents_user(userid);
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
						isvalid=false;
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
				map.put("isvalid", isvalid);
				map.put("events", true);
				System.out.println(true);
			}
			else
			{
				map.put("events", false);
				System.out.println(false);
			}
	          }
			else
			{
				map.put("isvalid", isvalid);
				System.out.println(false);
			}
			try {
				return map;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return map;
	}
	private void update_profile(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		boolean result=false,isValid=false;
		firstname=request.getParameter("name_val");
		phone=request.getParameter("phone_value");
		address=request.getParameter("address_value");
		String username=(getServletContext().getAttribute("Login_Name").toString());
	    if(user!=null)
	    {
	    	
	    	result=user.updateuser(user.email, user.password, firstname, user.lastname, phone, address);
	    	
	    	if(result==true)
			{
				isValid=dbconnect.saveuser(user);
				
				
			}
	    }
	    map.put("isvalid1", isValid);
	    try{
			write(response,map);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	private void update_pass(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map)
	{
		password=request.getParameter("newpass");
		String old_password=request.getParameter("oldpass");
		boolean result=false,isValid=false;
		if(user!=null)
	    {
	    	if(old_password.equals(user.password))
	    		
	    		result=user.updateuser(user.email, password, user.firstname, user.lastname, user.phone, user.address);
	    	
	    	if(result==true)
			{
				isValid=dbconnect.saveuser(user);
				map.put("result", "password_crt");
				
			}
	    	}
	    	else
	    	{
	    		map.put("result", "password_error");
	    	}
		
		map.put("isvalid2", isValid);
		try{
			write(response,map);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	    }
	

}
