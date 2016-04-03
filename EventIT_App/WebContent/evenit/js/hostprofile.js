$(document).ready(function() {

	
	 var obj=JSON.parse(localStorage.getItem("obj3"));
	 document.getElementById("address").value=obj.emailid;
	 document.getElementById("phone").value=obj.address;
	 document.getElementById("email").value=obj.phone;
	 var event_present=obj.events;
	 if(event_present=true)
		 {
		 $('#hostevents').empty();
	    	for (i = 0; i < obj.eventid.length; i++) {    
	    		$('#hostevents').append("<tr><td><a href='#'><div class='innerright'><input type='hidden' value='"+obj.eventid[i]+"' /><h3> "+obj.eventname[i]+"</h3><h4>"+obj.descr[i]+"</h4><h4><I>Event Venue</I>		:"+obj.venue[i]+"</h4><h4><I>Event Date</I>		:"+obj.dates[i]+"</h4><h4><I>No of Tickers</I>		:"+obj.numticket[i]+"</h4></div><</a></td></tr>");
	    	}  
		 }
});