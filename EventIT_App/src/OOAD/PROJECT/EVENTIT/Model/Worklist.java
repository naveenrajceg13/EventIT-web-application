package OOAD.PROJECT.EVENTIT.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Worklist {

	
	public ArrayList<Integer> events = new ArrayList<Integer>();
	static Worklist w;
	/**
	 * 
	 * @param e
	 */
	
	public void updateWorklist(Event e) {
		// TODO - implement Worklist.updateWorklist
		
		this.events.add(e.eventid);
	}

	/**
	 * 
	 * @param eventid
	 */
	public boolean checkworklist(int eventid) {
		// TODO - implement Worklist.checkworklist
		return true;
	}

	/**
	 * 
	 * @param e
	 */
	public static Worklist getinstance() {
		
        if(w==null){
        	w=new Worklist();
        	return w;
        }
        else
        {
        	return w;
        }
	
}
	public boolean removefromworklist(int e) {
		// TODO - implement Worklist.removefromworklist
		throw new UnsupportedOperationException();
	}

	public Worklist() {
		w=null;
	}

}