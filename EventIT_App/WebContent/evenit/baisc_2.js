/**
 * 
 */

$(document).ready(function(){
	
	$('#login_check').submit(function()
			{ 
		          var username_value=document.getElementById("email").value;
		          alert('hi sd');
		          $.ajax({ 
		        	   url:'../update',
		        	   type:'POST',
		        	   dateType: 'json',
		        	   data: {username: 'babe'},
		        	   success: function(result){
		        		   alert('hi');
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