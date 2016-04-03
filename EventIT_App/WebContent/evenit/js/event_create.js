/**
 * 
 */
/**
 * 
 */





$(document).ready(function(){
	
	
	$('#createevent').submit(function()
			{ 
		
		          var eventname1=document.getElementById("eventname").value;  
		          var descr1=document.getElementById("editor").value;
		          var venue1=document.getElementById("venue").value;
		          var date1=document.getElementById("date").value;
		          var numticket1=document.getElementById("numticket").value;
		          alert('sasa');
		          var time1=document.getElementById("time").value;
		          alert('asasas');
		          $.ajax({
		        	   url:'../CreateEvent_UI',
		        	   type:'POST',
		        	   dateType: 'json',
		        	   data: {eventname:eventname1,descr:descr1,venue:venue1,date:date1,numticket:numticket1,mode:"register",time:time1 },
		        	   success: function(result){
		        		           		    
		        		    
		        		    if(result.isValid_2){
		        		    	
		        		    	alert("event created successfully and send for admin approval");
		        		    	window.open("http://localhost:8080/EventIT_App/evenit/home.jsp","_self");
		        		   }
		        		   else
		        			   {
		        			      
		        			   alert('Ooops !!! something went wrong please try again ');
			        			  
		        			   } 
		        	   }
		        	  
		          })
		          return false;
			});
	
});