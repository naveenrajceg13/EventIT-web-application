package OOAD.PROJECT.EVENTIT.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class checklogin
 */
@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		boolean loged_in=false;
		HttpSession session = request.getSession(true);
		try
		{
		//String str=(getServletContext().getAttribute("Login_Name").toString());
		//System.out.println("servlet"+str);
		String str=request.getSession().getAttribute("Login_Name").toString();
		//System.out.println("session"+str1);
		if(str!=null)
		{
			if(str.length()>=1)
			{
				loged_in=true;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("logedin", loged_in);
		try {
			write(response,map);
		} catch (Exception e) {
			
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
