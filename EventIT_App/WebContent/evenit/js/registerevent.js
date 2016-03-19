 $(document).ready(function() {

	 var obj=JSON.parse(localStorage.getItem("obj1"));
	 document.getElementById("eventname").value=obj.eventname;
	 document.getElementById("descr").value=obj.eventdescr;
	 document.getElementById("venue").value=obj.eventvenue;
	 document.getElementById("dates").value=obj.dates;
	 document.getElementById("tickets").value=obj.numticket;
	 
	 
	 $("#register").click(function() {
			
		 $.ajax({
	      	   url : '../Ticket_UI',
	      	   type:'POST',
	      	   dateType: 'json',
	      	   data: {mode:"registerall",eventid:obj.eventid},
	      	   success: function(result){
	      		           		    
	      		    
	      		    if(result.isvalid){
	      		    	
	      		    	alert('Event Registed Successfully');
	      		    	window.open("http://localhost:8080/EventIT_App/evenit/browse.jsp","_self");
	      			    
	      		   }
	      		   else
	      			   {
	      			 alert('Event Registration Failed,You should be already registed to this event');
	      			     
	      			   } 
	      	   }
	      	  
	        })
	                    
	     
			});
 });