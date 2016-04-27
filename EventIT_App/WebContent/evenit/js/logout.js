function logout()
{
	logout
	$.ajax({
	  	   url : '../EventIT_UI',
	  	   type:'POST',
	  	   dateType: 'json',
	  	   data: {mode:"logout"},
	  	   success: function(result){
	  		    console.log(result);       		    
	  		    
	  		    if(result.isvalid){
	  		    	
	  		    	location.reload();
	  			    
	  		   }
	  		   else
	  			   {
	  			 alert('Logout Failed');
	  			     
	  			   } 
	  	   }
	  	  
	    })
	}