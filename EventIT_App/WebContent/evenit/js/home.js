
{ 
        
        $.ajax({
      	   url:'../checklogin',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"checklogin" },
      	   success: function(result){
      		           	
      		   
      		   
      		    if(result.logedin){
      		    	
      		    	
      			    
      		   }
      		   else
      			   {
      			      
      			 window.open("http://localhost:8080/EventIT_App/evenit/index_1.jsp","_self");
      			   } 
      	   }
      	  
        })
        
}