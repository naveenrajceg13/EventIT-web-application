function logout()
{
	
	$.ajax({
	  	   url : '../EventIT_UI',
	  	   type:'POST',
	  	   dateType: 'json',
	  	   data: {mode:"logout"},
	  	   success: function(result){
	  		    console.log(result);       		    
	  		  
	  		    if(result.isvalid){
	  		    	console.log(result.lmode)
	  		    	if(result.lmode=="fb")
	  		    		{
	  		    		window.fbAsyncInit = function() {
	  		    		  FB.init({
	  		    		    appId      : '617268818432268',
	  		    		    cookie     : false,  
	  		    		    xfbml      : true,  
	  		    		    version    : 'v2.5' 
	  		    		  });

	  		    		  FB.getLoginStatus(function(response) {
	  		    		    statusChangeCallback(response);
	  		    		  });

	  		    		  };
	  		    		function statusChangeCallback(response) {
	  		    		    if (response.status === 'connected') {
	  		    		    	FB.api('/me', function(response) {
	  		    		    	    FB.api('/me', { locale: 'en_US', fields: 'name, email' },
	  		    		    	    		  function(response) {
	  		    		    	    	email=response.email;
	  		    		    	    	name=response.name;
	  		    		    	    	FB.logout(function(response) {
	  		    		    	    		location.reload();
	  		    			    		});
	  		    		    	    	
	  		    		    	    	
	  		    		    	    	
	  		    		    	    		  }
	  		    		    	    		);
	  		    		    	});
	  		    		      
	  		    		    } else if (response.status === 'not_authorized') {
	  		    		    } else {
	  		    		    }
	  		    		  }

	  		    		  (function(d, s, id) {
	  		    		    var js, fjs = d.getElementsByTagName(s)[0];
	  		    		    if (d.getElementById(id)) return;
	  		    		    js = d.createElement(s); js.id = id;
	  		    		    js.src = "//connect.facebook.net/en_US/sdk.js";
	  		    		    fjs.parentNode.insertBefore(js, fjs);
	  		    		  }(document, 'script', 'facebook-jssdk'));
	  		    		
	  		    		
	  		    		}
	  		    	
	  		    	else
	  		    	{
	  		    		location.reload();
	  		    	}
	  		    	
	  		    	
	  			    
	  		   }
	  		   else
	  			   {
	  			 alert('Logout Failed');
	  			     
	  			   } 
	  	   }
	  	  
	    })
	}
