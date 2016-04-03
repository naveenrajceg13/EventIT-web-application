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
        
	
	myFunction_up();
        
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
		obj.time=elementticket_time[a];
  		obj.category=elementcategory[a];
		localStorage.setItem("obj2", JSON.stringify(obj));
		
		
		//$("#populated_result").submit();
		window.open("http://localhost:8080/EventIT_App/evenit/viewreservation.jsp","_self");
}


function  myFunction_past(){
	
	
	$.ajax({
   	   url:'../Ticket_UI',
   	   type:'POST',
   	   dateType: 'json',
   	   data: {mode:"registedevents_past"},
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
   	  
   		    if(result.isvalid1){
   		    	$('#registertable').empty();
   		    	for (i = 0; i < result.eventid.length; i++) {    
   		    	$('#registertable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><h3>"+elementname_array[i]+"</h3><h4>Hosted by: <a href='#' onClick='javascript:myFunction_host("+i+");'>Host name</a></h4><h4>"+elementdate_array[i]+"</h4><h4>"+elementuser_array[i]+"</h4><div class='row'><span >Rate Event:</span> <input id='input-7-xs' class='rating rating-loading block' value='1' data-min='0' data-max='5' data-step='0.1' data-size='xs' data-show-clear='false' style='display:inline-block'/><button class='btn btn-primary block' id='rate' style='margin-bottom:12px'>Rate</button><input type='button' class='btn btn-primary nominate eventbtn block' style='width:200px' value='View Event' onClick='javascript:myFunction_host("+i+");' /></div></div>")
   		    	}
   		    	
   		   }
   		   else
   			   {
   			$('#registertable').empty();
   			 alert('No past event to display, Please check with system admin');   
   			   } 
   	   }
   	  
     });

     return false;
}
function  myFunction_up(){
	
	
	
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
    	    elementticket_time=result.time;
	        elementcategory=result.category;
   	  
   		    if(result.isvalid1){
   		    	$('#registertable').empty();
   		    	for (i = 0; i < result.eventid.length; i++) {    
   		    	$('#registertable').append("<div class='innerright' id='tag-cloud-widget"+i+"'><input type='hidden' id='event_id' value='"+elementid_array[i]+"' /><h3>"+elementname_array[i]+"</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("+i+");'>"+elementuser_array[i]+"</a></h4><h4>"+elementdate_array[i]+"</h4><div class='row'><span >Rate Event:</span> <input id='input-7-xs' class='rating rating-loading block' value='1' data-min='0' data-max='5' data-step='0.1' data-size='xs' data-show-clear='false' style='display:inline-block'/><button class='btn btn-primary block' id='rate' style='margin-bottom:12px'>Rate</button><input type='button' class='btn btn-primary nominate eventbtn block' style='width:200px' value='View Event' onClick='javascript:myFunction_1("+i+");' /></div></div>")
   		    	}
   		    	
   		   }
   		   else
   			   {
   			 $('#registertable').empty();
   			 alert('No event active to display, Please check with system admin');   
   			   } 
   	   }
   	  
     });

     return false;
	
}



