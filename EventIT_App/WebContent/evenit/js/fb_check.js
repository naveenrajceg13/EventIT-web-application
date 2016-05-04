// This is called with the results from from FB.getLoginStatus().
var email='';
var name='';
  function statusChangeCallback(response) {
    if (response.status === 'connected') {
    	FB.api('/me', function(response) {
    	    FB.api('/me', { locale: 'en_US', fields: 'name, email' },
    	    		  function(response) {
    	    	email=response.email;
    	    	name=response.name;
    	    	testAPI(email,name);
    	    	
    	    		  }
    	    		);
    	});
      
    } else if (response.status === 'not_authorized') {
    } else {
    }
  }
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }
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

	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));
	
	 
	  function testAPI(email,name)
	  {
		  
	  	var username_value=email;
	      var Firstname=name;
	      
	      $.ajax({
	    	   url:'../EventIT_UI',
	    	   type:'POST',
	    	   dateType: 'json',
	    	   data: {username: username_value,firstname:Firstname,mode:"fb_login" },
	    	   success: function(result){
	    		           		    
	    		
	    		    if(result.isValid){
	    		    	var obj = {};
	    				obj.Firstname=result.Firstname;
	    				console.log("hello",obj.value)
	    				localStorage.setItem("obj91", JSON.stringify(obj));
	    				localStorage.setItem("obj1", JSON.stringify(obj));
	    		    	window.open("http://localhost:8080/EventIT_App/evenit/home.jsp","_self");
	    			    
	    		   }
	    		   else
	    			   {
	    			 
	    			      //$('#displayName').html('Login Un Successful');
	        			    
	        			  //$('#displayName').slideDown(500);
	    			   } 
	    	   }
	    	  
	      })
	      return false;
	  	}
	  