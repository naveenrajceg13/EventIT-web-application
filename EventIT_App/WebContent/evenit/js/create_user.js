/**
 * 
 */
/**
 * 
 */




$(document).ready(function(){
	$('#create_user_error').html(' '); 
	$('#ResultofRegister').html(' ');  
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
	
	$('#register_user').submit(function()
			{ 
		          $('#create_user_error').html(' '); 
		          $('#ResultofRegister').html(' ');
		          var username_value=document.getElementById("email1").value;
		          var password_value=document.getElementById("password1").value;
		          var conform_password=document.getElementById("cpassword1").value;
		          var firstname=document.getElementById("fname").value;
		          var lastname=document.getElementById("lname").value;
		          var phone=document.getElementById("phone").value;
		          var address=document.getElementById("address").value;
		          
		          if(password_value!=conform_password){
		        	  
		        	  $('#create_user_error').html('Passwords didnt match');  
        			  return false;
		          }
		          $.ajax({
		        	   url:'../EventIT_UI',
		        	   type:'POST',
		        	   dateType: 'json',
		        	   data: {username: username_value,password:password_value,fname:firstname,lname:lastname,ph:phone,ad:address,mode:"register" },
		        	   success: function(result){
		        		           		    
		        		    
		        		    if(result.isValid_1){
		        		    	
		        		    	$( "#closing" ).click();
		        		    	$('#ResultofRegister').html('Registraion Successful. Login to EventIT'); 
		        		    	//document.getElementById("account_Create").reset();
		        		    	//$('.modal').collapse('hide'); 
		        		    	//window.open("http://localhost:8080/EventIT_App/evenit/index_1.jsp","_self");
		        			    
		        		   }
		        		   else
		        			   {
		        			      
		        			      $('#create_user_error').html('Register Un Successfull, Email id should be registed already');  
			        			  $('#create_user_error').slideDown(500);
			        			  
		        			   } 
		        	   }
		        	  
		          })
		          return false;
			});
	
});