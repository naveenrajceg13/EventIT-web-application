package OOAD.PROJECT.EVENTIT.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Event {

	public static int eventid;
	public String eventname;
	public String descr;
	public String venue;
	public String dates;
	public String username;
	public int numticket;
	public String status;
	public String time; 
	public String Category;
	public ArrayList<Integer> events=new ArrayList<Integer>();
	public float rating;

	/**
	 * 
	 * @param EventName
	 * @param Decr
	 * @param Venue
	 * @param Date
	 * @param Time
	 */
	public boolean createEvent(String EventName, String Decr, String Venue, String Dates,String user,int numtick,String Status,String Time,String Category) {
		
		
		 eventid=eventid+1;
		 this.eventname=EventName;
		 this.descr=Decr;
		 this.venue=Venue;
		 this.dates=Dates;
		 this.username=user;
		 this.numticket=numtick;
		 this.status=Status;
		 this.time=Time;
		 this.Category=Category;
		 this.rating=0;
		return true;
		
	}
	public boolean getEvent(int eventid,String EventName, String Decr, String Venue, String Dates,String user,int numtick,String Status,String Time,String Category) {
		
		
		 this.eventid=eventid;
		 this.eventname=EventName;
		 this.descr=Decr;
		 this.venue=Venue;
		 this.dates=Dates;
		 this.username=user;
		 this.numticket=numtick;
		 this.status=Status;
		 this.time=Time;
		 this.Category=Category;
		return true;
		
	}
	
	public void changestatus(String status1) {
		// TODO - implement Event.changestatus
		this.status=status1;
	}
     
	public boolean checkevent(int fromdate, int todate) {
		// TODO - implement Event.checkevent
		return true;
	}

	public boolean checkevent() {
		
		java.sql.Date finalvalue=null;
		java.sql.Date finalvalue_now=null;
		Date date_Value=null;
		Date date_Value_now=null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//System.out.println(this.dates);
		try {
			date_Value=dateFormat.parse(this.dates);
			date_Value_now=dateFormat.parse(dateFormat.format(date));
			finalvalue=new java.sql.Date(date_Value.getTime());
			finalvalue_now=new java.sql.Date(date_Value_now.getTime());
			if(finalvalue.compareTo(finalvalue_now)>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return true;
	}
public boolean checkevent(String datevalue,int value) {
		
	  
	java.sql.Date finalvalue=null;
	java.sql.Date finalvalue_now=null;
	Date date_Value=null;
	Date date_Value_now=null;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	try {
		date_Value=dateFormat.parse(this.dates);
		date_Value_now=dateFormat1.parse(datevalue);
		finalvalue=new java.sql.Date(date_Value.getTime());
		finalvalue_now=new java.sql.Date(date_Value_now.getTime());
		
		if(value==1)
		{
		if(finalvalue_now.compareTo(finalvalue)<=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		if(value==0)
		{
			if(finalvalue.compareTo(finalvalue_now)>=0)
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	
	
	return true;
}
public boolean checkevent(String fromvalue,String tovalue) {
	
	java.sql.Date finalvalue=null;
	java.sql.Date finalvalue_now=null;
	Date date_Value=null;
	Date date_Value_from=null;
	Date date_Value_to=null;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	try {
		date_Value=dateFormat.parse(this.dates);
		date_Value_from=dateFormat1.parse(fromvalue);
		date_Value_to=dateFormat1.parse(tovalue);
		finalvalue=new java.sql.Date(date_Value.getTime());
		finalvalue_now=new java.sql.Date(date_Value_from.getTime());
		return (((date_Value.after(date_Value_from) && date_Value.before(date_Value_to))||((date_Value.compareTo(date_Value_to)==0))||((date_Value_from.compareTo(date_Value)==0))));
		
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	
	
	return true;
}
public Event() {
		
		
		
	}

}