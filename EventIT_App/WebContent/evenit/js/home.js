
{ 
        
        $.ajax({
      	   url:'../checklogin',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"checklogin" },
      	   success: function(result){
      		           	
      		   
      		   
      		    if(result.logedin){
      		    	     if(result.admin)
      		    	    	 {
      		    	    	
      		    	    	$( "#onem" ).show();
      		    	    	$( "#oneh" ).hide();
      		    	    	$( "#oneb" ).hide();
      		    	    	$( "#onec" ).hide();
      		    	    	$( "#oner" ).hide();
      		    	    	$( "#onep" ).hide();
      		    	    	 }
      		    	     else
      		    	    	 {
      		    	    	 
      		    	    	$( "#onem" ).hide();
      		    	    	$( "#oneh" ).show();
      		    	    	$( "#oneb" ).show();
      		    	    	$( "#onec" ).show();
      		    	    	$( "#oner" ).show();
      		    	    	$( "#onep" ).show();
      		    	    	 }
      			    
      		   }
      		   else
      			   {
      			       
      			 window.open("http://localhost:8080/EventIT_App/evenit/index.jsp","_self");
      			   } 
      	   }
      	  
        })
        
}