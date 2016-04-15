var elementid_array;
var elementname_array;
var elementdate_array;
var elementvenue_arry;
var elementdescr_arry;
var elementuser_array;
var elementticket_array;
var success = false; 
$(document).ready(function(){ 
        
	
        $.ajax({
      	   url:'../Worklist_UI',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"manageevents" },
      	   success: function(result){
      		           	
      		elementid_array=result.eventid;
      		elementname_array=result.eventname;
      		elementdate_array=result.dates;
      		elementvenue_arry=result.venue;
      	    elementdescr_arry=result.descr;
      	    elementuser_array=result.username;
      	    elementticket_array=result.numticket;
      	    elementticket_time=result.time;
      	    elementcategory=result.category;
      	    
      		    if(result.isvalid){
      		    	
      		    	
      		    	
      		    	for (i = 0; i < result.eventid.length; i++) {    
      		    	$('#myTable').append("<tr><td><a href='#'><div class='innerright'><input type='hidden' value='"+result.eventid[i]+"' /><h3> "+result.eventname[i]+"</h3><h4>"+result.descr[i]+"</h4><h4><I>Event Venue</I>		:"+result.venue[i]+"</h4><h4><I>Event Date</I>		:"+result.dates[i]+"</h4><h4><I>Created by</I>		:"+result.username[i]+"</h4><h4><I>No of Tickers</I>		:"+result.numticket[i]+"</h4><input type='button' class='btn btn-primary nominate' style='width:200px' value='View Event' /></div><</a></td></tr>");
      		    	}
      		    	loaded = true;
      		    	$(".nominate").click(function() {
      		    		var obj = {};
      		    		obj.eventid=elementid_array[$(this).closest("tr").index()-1];
      		    		obj.eventname=elementname_array[$(this).closest("tr").index()-1];
      		    		obj.eventvenue=elementvenue_arry[$(this).closest("tr").index()-1];
      		    		obj.eventdescr=elementdescr_arry[$(this).closest("tr").index()-1];
      		    		obj.numticket=elementticket_array[$(this).closest("tr").index()-1];
      		    		obj.dates=elementdate_array[$(this).closest("tr").index()-1];
      		    		obj.username=elementuser_array[$(this).closest("tr").index()-1];
      		    		obj.time=elementticket_time[$(this).closest("tr").index()-1];
      		    		obj.category=elementcategory[$(this).closest("tr").index()-1];
      		    		localStorage.setItem("obj", JSON.stringify(obj));
      		    		
      		    		
      		    		$("#populated_result").submit();
      		    		window.open("http://localhost:8080/EventIT_App/evenit/viewevent.jsp","_self");

      		  		});
      		    
      		    	
      		   }
      		   else
      			   {
      			   alert('No event to mange or role not there, Please check with system admin');   
      			   window.open("http://localhost:8080/EventIT_App/evenit/home.jsp","_self");
      			   } 
      	   }
      	  
        });

        return false;
        
});




/* $(document).ready(function() {

	           //alert("Click View event to view and approve Event ");


}); */