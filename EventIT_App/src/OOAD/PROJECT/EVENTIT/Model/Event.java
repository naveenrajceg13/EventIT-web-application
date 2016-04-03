package OOAD.PROJECT.EVENTIT.Model;

import java.util.ArrayList;

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
	public ArrayList<Integer> events=new ArrayList<Integer>();

	/**
	 * 
	 * @param EventName
	 * @param Decr
	 * @param Venue
	 * @param Date
	 * @param Time
	 */
	public boolean createEvent(String EventName, String Decr, String Venue, String Dates,String user,int numtick,String Status,String Time) {
		
		
		 eventid=eventid+1;
		 this.eventname=EventName;
		 this.descr=Decr;
		 this.venue=Venue;
		 this.dates=Dates;
		 this.username=user;
		 this.numticket=numtick;
		 this.status=Status;
		 this.time=Time;
		return true;
		
	}
	public boolean getEvent(int eventid,String EventName, String Decr, String Venue, String Dates,String user,int numtick,String Status) {
		
		
		 this.eventid=eventid;
		 this.eventname=EventName;
		 this.descr=Decr;
		 this.venue=Venue;
		 this.dates=Dates;
		 this.username=user;
		 this.numticket=numtick;
		 this.status=Status;
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

	public Event() {
		
		
		
	}

}