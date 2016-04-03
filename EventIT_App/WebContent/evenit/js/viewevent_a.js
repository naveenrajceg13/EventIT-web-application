

 $(document).ready(function() {

	
	 var obj=JSON.parse(localStorage.getItem("obj"));
	 document.getElementById("eventname").value=obj.eventname;
	 document.getElementById("descr").value=obj.eventdescr;
	 document.getElementById("venue").value=obj.eventvenue;
	 document.getElementById("dates").value=obj.dates;
	 document.getElementById("tickets").value=obj.numticket;
	 document.getElementById("time").value=obj.time;
	 document.getElementById("category").value=obj.category;
	 $("#approve").click(function() {
				
				$.ajax({
			      	   url : '../approvereject',
			      	   type:'POST',
			      	   dateType: 'json',
			      	   data: {mode:"approve",eventid:obj.eventid},
			      	   success: function(result){
			      		    console.log(result);       		    
			      		    
			      		    if(result.isvalid1){
			      		    	
			      		    	alert('Event Approved Successfully');
			      		    	window.open("http://localhost:8080/EventIT_App/evenit/manage.jsp","_self");
			      			    
			      		   }
			      		   else
			      			   {
			      			 alert('Event Approval Failed');
			      			     
			      			   } 
			      	   }
			      	  
			        })
		                    
		     
				});
	 $("#reject").click(function() {
			
		 
		 $.ajax({
	      	   url:'../approvereject',
	      	   type:'POST',
	      	   dateType: 'json',
	      	   data: {mode:"reject",eventid:obj.eventid},
	      	   success: function(result){
	      		 	    
	      		 if(result.isvalid2){
	      		
	      			alert('Event Rejected Successfully');
	      			window.open("http://localhost:8080/EventIT_App/evenit/manage.jsp","_self");
	      		 }
	      		 else
	      			 {
	      			 alert('Event Rejection Failed');
	      			 }
	      		    
	      	   }
	      	  
	        })  
		     
				});
	

}); 
 
 