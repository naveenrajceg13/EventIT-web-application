package OOAD.PROJECT.EVENTIT.Model;

import java.util.ArrayList;
import java.util.HashMap;

public final class Worklist_Singleton {

	 
	static Worklist w;


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

}