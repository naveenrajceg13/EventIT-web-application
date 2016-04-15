var name;
var address;
var phone;
var email;
var elementid_array;
var elementname_array;
var elementdate_array;
var elementvenue_arry;
var elementdescr_arry;
var elementuser_array;
var elementticket_array;
var elementticket_time;
var elementcategory;
var success = false; 
$(document).ready(function(){ 
        
	
        $.ajax({
      	   url:'../EventIT_UI',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"View_Profile" },
      	   success: function(result){
                
      		    if(result.isvalid){
      		    	console.log("check profile details"+result.events);
      		    	document.getElementById("name").value=result.name;
      		    	document.getElementById("oemail").value=result.email;
      		    	document.getElementById("address").value=result.address;
      		    	document.getElementById("phone").value=result.phone;
      		    	document.getElementById("cpassword").value=null;
      		    	if(event_present=true)
      				 {
      		    		elementid_array = result.eventid;
    					elementname_array = result.eventname;
    					elementdate_array = result.dates;
    					elementvenue_arry = result.venue;
    					elementdescr_arry = result.descr;
    					elementuser_array = result.username;
    					elementticket_array = result.numticket;
    					elementticket_time = result.time;
    					elementcategory = result.category;
    					
      				 $('#myevents').empty();
      			    	for (i = 0; i < result.eventid.length; i++) {    
      			    		$('#myevents').append("<tr><td><a onClick='javascript:myFunction_myevents("+i+");'><div class='innerright'><input type='hidden' value='"+result.eventid[i]+"' /><h3> "+result.eventname[i]+"</h3><h4>"+result.descr[i]+"</h4><h4><I>Event Venue</I>		:"+result.venue[i]+"</h4><h4><I>Event Date</I>		:"+result.dates[i]+"</h4><h4><I>No of Tickers</I>		:"+result.numticket[i]+"</h4></div><</a></td></tr>");
      			    	}  
      				 }
      		   }
      		   else
      			   {
      			 alert('Profile Doesnot Exists');   
      			   } 
      	   }
      	  
        });

        return false;
        
});
function myFunction_myevents(a)
{
	var obj = {};
	obj.eventid = elementid_array[a];
	obj.eventname = elementname_array[a];
	obj.eventvenue = elementvenue_arry[a];
	obj.eventdescr = elementdescr_arry[a];
	obj.numticket = elementticket_array[a];
	obj.dates = elementdate_array[a];
	obj.username = elementuser_array[a];
	obj.time = elementticket_time[a];
	obj.category = elementcategory[a];
	localStorage.setItem("obj5", JSON.stringify(obj));

	// $("#populated_result").submit();
	window.open("http://localhost:8080/EventIT_App/evenit/viewmyevent.jsp",
			"_self");
}

function myFunction_profile()
{
	var address_ch=document.getElementById("address").value;
	var phone_ch=document.getElementById("phone").value;
	var name_ch=document.getElementById("name").value;
	
	 $.ajax({
    	   url:'../EventIT_UI',
    	   type:'POST',
    	   dateType: 'json',
    	   data: {mode:"update_profile",address_value:address_ch,phone_value:phone_ch,name_val:name_ch },
    	   success: function(result){
    		   
    		    if(result.isvalid1){
    		    	
    		    	alert('Profile Update Success');
    		    	
    		   }
    		   else
    			   {
    			 alert('Profile Update failed');   
    			   } 
    	   }
    	  
      });

      return false;
	
}
function myFunction_pass()
{
	var passo=document.getElementById("opassword").value;
	var passn=document.getElementById("npassword").value;
	var passc=document.getElementById("cpassword").value;
	
	if(passn!=passc)
		{
		alert('password does not match');
		}
	
	$.ajax({
 	   url:'../EventIT_UI',
 	   type:'POST',
 	   dateType: 'json',
 	   data: {mode:"change_password",oldpass:passo,newpass:passn},
 	   success: function(result){
 		  
 		    if(result.isvalid2){
 		    	
 		    	alert('Password change success');
 		    	
 		   }
 		   else
 			   {
 			 alert('Password change fail');   
 			   } 
 	   }
 	  
   });

   return false;
}
function myFunction_searchevents() {
 	
	var search_val=document.getElementById("searchevent").value;
	$('#myevents').empty();
	for (i = 0; i < elementid_array.length; i++) {
		n = elementname_array[i].indexOf(search_val);
		if(n<0)continue;
		$('#myevents').append("<tr><td><a onClick='javascript:myFunction_myevents("+i+");'><div class='innerright'><input type='hidden' value='"+elementid_array[i]+"' /><h3> "+elementname_array[i]+"</h3><h4>"+elementdescr_arry[i]+"</h4><h4><I>Event Venue</I>		:"+elementvenue_arry[i]+"</h4><h4><I>Event Date</I>		:"+elementdate_array[i]+"</h4><h4><I>No of Tickers</I>		:"+elementticket_array[i]+"</h4></div><</a></td></tr>");
  	}  
	
	
}

