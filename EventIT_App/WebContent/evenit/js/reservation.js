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
      	   url:'../Ticket_UI',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"registedevents"},
      	   success: function(result){
      		    
      		elementid_array=result.eventid;
       		elementname_array=result.eventname;
       		elementdate_array=result.dates;
       		elementvenue_arry=result.venue;
       	    elementdescr_arry=result.descr;
       	    elementuser_array=result.username;
       	    elementticket_array=result.numticket;
      		
      	  
      		    if(result.isvalid1){
      		    	
      		    	for (i = 0; i < result.eventid.length; i++) {    
      		    	$('#registertable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><h3>"+elementname_array[i]+"</h3><h4>Hosted by: <a href='#'>Host name</a></h4><h4>"+elementdate_array[i]+"</h4><h4>"+elementuser_array[i]+"</h4><input type='button' class='btn btn-primary nominate' style='width:200px' value='View Event' onClick='javascript:myFunction_1("+i+");' /></div>")
      		    	}
      		    	
      		   }
      		   else
      			   {
      			 alert('No event to display, Please check with system admin');   
      			   } 
      	   }
      	  
        });

        return false;
        
});
function myFunction_1(a) {
	
		var obj = {};
		obj.eventid=elementid_array[a];
		obj.eventname=elementname_array[a];
		obj.eventvenue=elementvenue_arry[a];
		obj.eventdescr=elementdescr_arry[a];
		obj.numticket=elementticket_array[a];
		obj.dates=elementdate_array[a];
		obj.username=elementuser_array[a];
		localStorage.setItem("obj2", JSON.stringify(obj));
		
		
		//$("#populated_result").submit();
		window.open("http://localhost:8080/EventIT_App/evenit/viewreservation.jsp","_self");
}