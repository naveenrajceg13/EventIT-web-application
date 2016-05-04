
{ 
        
        $.ajax({
      	   url:'../checklogin',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"checklogin" },
      	   success: function(result){
      		           	
      		   
      		   
      		    if(result.logedin){
      		    	    
      		    	    	$( "#onem" ).hide();
      		    	    	$( "#oneh" ).show();
      		    	    	$( "#oneb" ).show();
      		    	    	$( "#onec" ).show();
      		    	    	$( "#oner" ).show();
      		    	    	$( "#tonep" ).show();
      		    	    	
      			    
      		   }
      		   else
      			   {
      			    $( "#onem" ).hide();
	    	    	$( "#oneh" ).hide();
	    	    	$( "#oneb" ).show();
	    	    	$( "#onec" ).hide();
	    	    	$( "#oner" ).hide();
	    	    	$( "#tonep" ).hide(); 
      			 
      			   } 
      	   }
      	  
        })
        
}