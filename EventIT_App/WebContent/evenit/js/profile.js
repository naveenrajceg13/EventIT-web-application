var name;
var address;
var phone;
var email;

var success = false; 
$(document).ready(function(){ 
        
	
        $.ajax({
      	   url:'../EventIT_UI',
      	   type:'POST',
      	   dateType: 'json',
      	   data: {mode:"View_Profile" },
      	   success: function(result){
                
      		    if(result.isvalid){
      		    	
      		    	document.getElementById("name").value=result.name;
      		    	document.getElementById("oemail").value=result.email;
      		    	document.getElementById("address").value=result.address;
      		    	document.getElementById("phone").value=result.phone;
      		    	
      		   }
      		   else
      			   {
      			 alert('Profile Doesnot Exists');   
      			   } 
      	   }
      	  
        });

        return false;
        
});

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

