package OOAD.PROJECT.EVENTIT;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataBase {

	public Connection connectdb(String username,String password)
	{  
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");	
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		String url="jdbc:mysql://localhost:3306/EventIT_App";
		try{
		con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return con;
	}
	public ResultSet getuser(String username,Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT * FROM users where Email like '"+username+"'";
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public boolean saveuser(String emailid,String password,String fname,String lname,String phone,String address,Connection con)
	{
		Statement st;
		String query1="Delete from users where Email='"+emailid+"'";
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query="Insert into users values ('"+emailid+"','"+password+"','"+fname+"','"+lname+"','"+phone+"','"+address+"')";
    	
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
			if(rows==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return false;
		}
		
		return true;
	}
	
	public ResultSet getmaxeventid(Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT max(eventid) as eve FROM Events";
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public boolean saveevent(int eventid, String eventname,String venue, String dates, String descr, String username,int numtick,Connection con,String time,String Category)
	{
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format

		   
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		Date date_Value=null;
		java.sql.Time time_value = null;
		java.sql.Date finalvalue=null;
		try {
			date_Value=df.parse(dates);
			 java.util.Date d1 =(java.util.Date)format.parse(time);
             java.sql.Time ppstime = new java.sql.Time(d1.getTime());
		    finalvalue=new java.sql.Date(date_Value.getTime());
		    time_value=ppstime;
		 
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query="INSERT INTO `Events` (`EventID`, `User`, `EventName`, `Descr`, `Venue`, `Time`, `Date`, `TotalTicket`, `Status`, `Category`) VALUES ('"+eventid+"', '"+username+"', '"+eventname+"', '"+descr+"', '"+venue+"','"+time_value+"','"+finalvalue+"', '"+numtick+"', 'P','"+Category+"')";
		
		Statement st;
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
			if(rows==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return false;
		}
		
		return true;
	}
	public ResultSet getworklist(Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT * FROM worklist ";
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public boolean saveWorklist(int eventid,Connection con)
	{
		
		
		//String query="Insert into Events values ('"+eventid+"','"+username+"','"+eventname+"','"+descr+"','"+venue+"','TO_DATE('"+date+"','DD-MM-YYYY')','"+numtick+"','"+numtick+"')";
		String query="INSERT INTO `Worklist` (`EventID`) VALUES ('"+eventid+"')";
    	Statement st;
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
			if(rows==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return false;
		}
		
		return true;
	}
	public ResultSet getevent(int username,Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT * FROM Events where EventID = '"+username+"'";
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public boolean changeevent1(int eventid,String status,Connection con)
	{
		
		String query="Update Events set Status='"+status+"' where EventID="+eventid;
	//	System.out.println("here"+query);
    	Statement st;
    	try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
			
			 if(rows==0)
			{
				
				return false;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   
			   return false;
		}
		 
		return true;
	}
	public boolean changeworklist(int eventid,Connection con)
	{
		
		
		String query="Delete from Worklist where EventID="+eventid;
		//System.out.println("babe"+query);
    	Statement st;
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
			if(rows==0)
			{ 
				
				return false;
			}
		} catch (SQLException e) {
			   e.printStackTrace();
			   
			   return false;
		}
		
		return true;
	}
	public ResultSet getallevents(Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT * FROM Events where status='A' ";
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public ResultSet getallevents_user(String username,Connection con)
	{
		ResultSet rs=null;
		Statement st=null;
		try{		
		String query="SELECT * FROM registration where Userid='"+username+"'";
	//	System.out.println(query);
		st=con.createStatement();
		rs=st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public boolean saveTicket(int eventid,String username,Connection con)
	{
		
		
		//String query="Insert into Events values ('"+eventid+"','"+username+"','"+eventname+"','"+descr+"','"+venue+"','TO_DATE('"+date+"','DD-MM-YYYY')','"+numtick+"','"+numtick+"')";
		String query="INSERT INTO `registration` ( `userid`, `eventid`) VALUES ('"+username+"','"+eventid+"')";
		//System.out.println(query);
    	Statement st;
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
		//	System.out.println("query executed rows"+rows);
			if(rows==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return false;
		}
		
		return true;
	}
	public boolean cancelTicket(int eventid,String username,Connection con)
	{
		
		
		//String query="Insert into Events values ('"+eventid+"','"+username+"','"+eventname+"','"+descr+"','"+venue+"','TO_DATE('"+date+"','DD-MM-YYYY')','"+numtick+"','"+numtick+"')";
		//String query="INSERT INTO `registration` ( `userid`, `eventid`) VALUES ('"+username+"','"+eventid+"')";
		String query="Delete from registration where userid='"+username+"' and eventid='"+eventid+"'";
	//	System.out.println(query);
    	Statement st;
		try {
			st = con.createStatement();
			int rows=st.executeUpdate(query);
		//	System.out.println("query executed rows"+rows);
			if(rows==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return false;
		}
		
		return true;
	}
	
}
