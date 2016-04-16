package OOAD.PROJECT.EVENTIT.Model;

public class Ticket {

	public String ticketid;
	public int eventid;
	public String userid;
	public String Status;
    public float rating;
	/**
	 * 
	 * @param eventid
	 * @param userid
	 */
	public int reserve(int eventid, int userid) {
		// TODO - implement Ticket.reserve
		throw new UnsupportedOperationException();
	}

	public void cancelticket() {
		// TODO - implement Ticket.cancelticket
		throw new UnsupportedOperationException();
	}

	public Ticket(int eventid,String userid) {
		// TODO - implement Ticket.Ticket
		this.eventid=eventid;
		this.userid=userid;
		
	}

}