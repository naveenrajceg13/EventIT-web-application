/**
 * 
 */

$(document).ready(function(){
	
	$('#login_check').submit(function()
			{ 
		          var username_value=document.getElementById("email").value;
		          
		          $.ajax({
		        	 
		        	   url:'update',
		        	   type:'POST',
		        	   dateType: 'json',
		        	   data: {username: username_value},
		        	   success: function(result){
		        		    
		        		    if(result.isValid){
		        		    	
		        			    $('#displayName').html('Your Name is :'+result.username);
		        			    $('#displayName').slideDown(500);
		        		   }
		        		   else
		        			   {
		        			      alert('please enter valid user name',result.isValid)
		        			   } 
		        	   }
		          })
		          
		          return false;
			});
	
});