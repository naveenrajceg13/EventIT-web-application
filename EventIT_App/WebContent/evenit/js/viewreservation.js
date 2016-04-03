 $(document).ready(function() {

	 var obj=JSON.parse(localStorage.getItem("obj2"));
	 document.getElementById("eventname").value=obj.eventname;
	 document.getElementById("descr").value=obj.eventdescr;
	 document.getElementById("venue").value=obj.eventvenue;
	 document.getElementById("dates").value=obj.dates;
	 document.getElementById("tickets").value=obj.numticket;
	 document.getElementById("time").value=obj.time;
	 document.getElementById("category").value=obj.category;
	 
	 $("#register").click(function() {
			
		 $.ajax({
	      	   url : '../Ticket_UI',
	      	   type:'POST',
	      	   dateType: 'json',
	      	   data: {mode:"cancelreservation",eventid:obj.eventid},
	      	   success: function(result){
	      		           		    
	      		    
	      		    if(result.isvalid3){
	      		    	
	      		    	
	      		    	alert('Reservation Canceled Successfully');
	      		    	
	      		    	
	      		    	
	      		    	
	      		    	window.open("http://localhost:8080/EventIT_App/evenit/reservationHistory.jsp","_self");
	      			    
	      		   }
	      		   else
	      			   {
	      			 alert('Reservation Cancel Failed');
	      			     
	      			   } 
	      	   }
	      	  
	        })
	                    
	     
			});
 });