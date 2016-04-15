var elementid_array;
var elementname_array;
var elementdate_array;
var elementvenue_arry;
var elementdescr_arry;
var elementuser_array;
var elementticket_array;
var elementticket_time;
var elementcategory;
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
       	    elementticket_time=result.time;
   	        elementcategory=result.category;
      	  
      		    if(result.isvalid){
      		    	$('#browsetable').empty();
      		    	for (i = 0; i < result.eventid.length; i++) {    
      		    	$('#browsetable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><h3>"+elementname_array[i]+"</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("+i+");'>"+elementuser_array[i]+"</a></h4><h4>"+elementdate_array[i]+"</h4><button class='btn btn-primary eventbtn' onclick='javascript:myFunction("+i+");' id='anca' style='float:right'>View Event</button></div></div>");
      		    	
      		    	}
      		    	
      		    	
      		   }
      		   else
      			   {
      			 $('#browsetable').empty();
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
		obj.time=elementticket_time[a];
  		obj.category=elementcategory[a];
  		
  		
		localStorage.setItem("obj1", JSON.stringify(obj));
		//$("#populated_result").submit();
		window.open("http://localhost:8080/EventIT_App/evenit/reserveTicket.jsp","_self");
}

function search_events()
		{
	                  
	               var from_date=document.getElementById("fromdate").value;
	               var to_date=document.getElementById("todate").value;
	               $.ajax({
	              	   url:'../Browse_UI',
	              	   type:'POST',
	              	   dateType: 'json',
	              	   data: {mode:"browseevents_search",fromdate:from_date,todate:to_date },
	              	   success: function(result){
	              		 
	              		 if(!result.nochange){
	              		    if(result.isvalid){
	              		    	elementid_array=result.eventid;
	              	       		elementname_array=result.eventname;
	              	       		elementdate_array=result.dates;
	              	       		elementvenue_arry=result.venue;
	              	       	    elementdescr_arry=result.descr;
	              	       	    elementuser_array=result.username;
	              	       	    elementticket_array=result.numticket;
	              	       	    elementticket_time=result.time;
	              	   	        elementcategory=result.category;
	              	   	        console.log(result.eventid.length);
	              	   	   $('#browsetable').empty();
	              		    	for (i = 0; i < result.eventid.length; i++) {    
	              		    	$('#browsetable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><h3>"+elementname_array[i]+"</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("+i+");'>"+elementuser_array[i]+"</a></h4><h4>"+elementdate_array[i]+"</h4><button class='btn btn-primary eventbtn' onclick='javascript:myFunction("+i+");' id='anca' style='float:right'>View Event</button></div></div>");
	              		    	}
	              		    	
	              		   }
	              		   else
	              			   {
	              			 $('#browsetable').empty();
	              			 alert('No event to display, Please check with system admin');   
	              			 
	              			   } 
	              	   }}
	              	  
	                });

	                return false;
	
		}
