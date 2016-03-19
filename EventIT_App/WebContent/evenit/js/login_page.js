{ 
        
        $.ajax({
      	   url:'../checklogin',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"check login" },
      	   success: function(result){
      		           	
      		   
      		    if(result.logedin){
      		    	
      		    	
      		    	window.open("http://localhost:8080/EventIT_App/evenit/home.jsp","_self");
      		   }
      		   else
      			   {
      			      
      			 
      			   } 
      	   }
      	  
        })
        
}