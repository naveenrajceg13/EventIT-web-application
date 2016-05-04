
$(document).ready(function(){	   
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
	
	
	
});

function login_fu()
{
	var username_value=document.getElementById("email").value;
    var password_value=document.getElementById("password").value;
   
    $.ajax({
  	   url:'../EventIT_UI',
  	   type:'POST',
  	   dateType: 'json',
  	   data: {username: username_value,password:password_value,mode:"login" },
  	   success: function(result){
  		           		    
  		
  		    if(result.isValid){
  		    	var obj = {};
  				obj.Firstname=result.Firstname;
  				
  				localStorage.setItem("obj91", JSON.stringify(obj));
  				localStorage.setItem("obj1", JSON.stringify(obj));
  		    	window.open("http://localhost:8080/EventIT_App/evenit/home.jsp","_self");
  			    
  		   }
  		   else
  			   {
  			 
  			      $('#displayName').html('Login Un Successful');
      			    
      			  $('#displayName').slideDown(500);
  			   } 
  	   }
  	  
    })
    return false;
	}