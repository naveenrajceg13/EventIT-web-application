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
      	   url:'../Browse_UI',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"browseevents" },
      	   success: function(result){
      		    
      		elementid_array=result.eventid;
       		elementname_array=result.eventname;
       		elementdate_array=result.dates;
       		elementvenue_arry=result.venue;
       	    elementdescr_arry=result.descr;
       	    elementuser_array=result.username;
       	    elementticket_array=result.numticket;
      		
      	  
      		    if(result.isvalid){
      		    	
      		    	for (i = 0; i < result.eventid.length; i++) {    
      		    	$('#browsetable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><a href='javascript:myFunction("+i+");' id='anca' ><h3>"+elementname_array[i]+"</h3><h4>"+elementdate_array[i]+"</h4><h4>"+elementuser_array[i]+"</h4></a></div>")
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
function myFunction(a) {
	var obj = {};
		obj.eventid=elementid_array[a];
		obj.eventname=elementname_array[a];
		obj.eventvenue=elementvenue_arry[a];
		obj.eventdescr=elementdescr_arry[a];
		obj.numticket=elementticket_array[a];
		obj.dates=elementdate_array[a];
		obj.username=elementuser_array[a];
		localStorage.setItem("obj1", JSON.stringify(obj));
		//$("#populated_result").submit();
		window.open("http://localhost:8080/EventIT_App/evenit/reserveTicket.jsp","_self");
}
