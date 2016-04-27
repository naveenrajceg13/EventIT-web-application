function  myFunction_host(a){
	
	
	var username=elementuser_array[a];
	$.ajax({
	   	   url:'../HostProfile_Controller',
	   	   type:'POST',
	   	   dateType: 'json',
	   	   data: {mode:"hostprofile",user:username},
	   	   success: function(result){
	   		   
	   		//alert(result.isvalid)   
	   		if(result.isvalid){
	   			var obj = {};
	   			obj.emailid=result.email;
	   			obj.address=result.address;
	   			obj.phone=result.phone;
	   			obj.eventid=result.eventid;
	   			obj.eventname=result.eventname;
	   			obj.descr=result.descr;
	   			obj.venue=result.venue;
	   			obj.status=result.Status;
	   	  		obj.numticket=result.numticket;
	   	  	    obj.time=result.time;
   			    obj.category=result.category;
   			    obj.events=result.events;
   			    obj.dates=result.dates;
			    obj.username=result.username;
			    obj.rating=result.rating;
			    obj.firstname=result.firstname;
			    console.log("name",obj.firstname);
			    //alert(obj.firstname);
	   			localStorage.setItem("obj3", JSON.stringify(obj));
	   			window.open("http://localhost:8080/EventIT_App/evenit/hostprofile.jsp","_self");
	   		}
	   		else{
	   			 alert('This Host profile cannot be viewed,Please contact administrator');
	   		}
	   		}
	   	   
	 });
}