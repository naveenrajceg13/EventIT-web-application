var elementid_array;
var elementname_array;
var elementdate_array;
var elementvenue_arry;
var elementdescr_arry;
var elementuser_array;
var elementticket_array;
var elementticket_time;
var elementcategory;
var elementrating;
var success = false;
var run=true;
$(document).ready(function() {

	console.log(run);
	myFunction_up();
	$( ".oneh" ).show();
  	$( ".oneb" ).show();
  	$( ".onec" ).show();
  	$( ".oner" ).show();
  	$( ".tonep" ).show();
  	$( ".tonem" ).hide();
});
function myFunction_1(a) {

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
	localStorage.setItem("obj2", JSON.stringify(obj));

	// $("#populated_result").submit();
	window.open("http://localhost:8080/EventIT_App/evenit/viewreservation.jsp",
			"_self");
}


function myFunction_2(){
	var value=document.getElementById("input-7-xs").value;
	alert(value);
}

function myFunction_past() {

	$
			.ajax({
				url : '../Ticket_UI',
				type : 'POST',
				async: false,
				dateType : 'json',
				data : {
					mode : "registedevents_past"
				},
				success : function(result) {

					elementid_array = result.eventid;
					elementname_array = result.eventname;
					elementdate_array = result.dates;
					elementvenue_arry = result.venue;
					elementdescr_arry = result.descr;
					elementuser_array = result.username;
					elementticket_array = result.numticket;
					elementticket_time = result.time;
					elementcategory = result.category;
					elementrating=result.rating;
                    console.log("rating array",elementrating.length);
					if (result.isvalid1) {

						$('#registertable').empty();
						for (i = 0; i < result.eventid.length; i++) {
							var divStr = "<div class='innerright' id='tag-cloud-widget"
									+ i
									+ "'><input type='hidden' id='event_id' value='"
									+ elementid_array[i]
									+ "' /><h3>"
									+ elementname_array[i]
									+ "</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("
									+ i
									+ ");'>"
									+ elementuser_array[i]
									+ "</a></h4><h4>"
									+ elementdate_array[i]
									+ "</h4>"
									+ "<div class='row'>"
									+ "<span >Rate Event:</span>"
									//+ "<input id='input-7-xs' class='rating rating-loading block' value='1' data-min='0' data-max='5' data-step='0.1' data-size='xs' data-show-clear='false' style='display:inline-block'/>"
									+ "<input type='radio' name='rating_button_"+i+"' value='1'  class='radio_button' onclick='javascript:myFunction_rate("+i+");'/> 1"
									+ "<input type='radio' name='rating_button_"+i+"' value='2'  class='radio_button' onclick='javascript:myFunction_rate("+i+");'/> 2"
									+ "<input type='radio' name='rating_button_"+i+"' value='3'  class='radio_button' onclick='javascript:myFunction_rate("+i+");'/> 3"
									+ "<input type='radio' name='rating_button_"+i+"' value='4'  class='radio_button' onclick='javascript:myFunction_rate("+i+");'/> 4"
									+ "<input type='radio' name='rating_button_"+i+"' value='5'  class='radio_button' onclick='javascript:myFunction_rate("+i+");'/> 5"
									//+ "<button class='btn btn-primary block' id='rate' style='margin-bottom:12px' onClick='javascript:myFunction_2();'>Rate</button>"
									+ "<input type='button' class='btn btn-primary nominate eventbtn block' style='width:200px' value='View Event' onClick='javascript:myFunction_1("+i+");'/>" 
									+ "</div>" 
									+ "</div>";
							$('#registertable').append(divStr);
							if(elementrating[i]!=0){
							var value='rating_button_'+i;
							var rate_value=document.getElementsByName(value);
							var rated=0;
							var index=0
							var ratint=elementrating[i];
							console.log("rating",elementrating[i]);
							for (i=0; i<rate_value.length; i++)
								{
								rate_value[i].disabled=true;
								}
							rate_value[ratint-1].checked=true;
						}
						}
						

					} else {
						$('#registertable').empty();
						alert('No past event to display, Please check with system admin');
					}
					},
				
				complete: function() {
					//alert('hi');
					//$('#input-7-xs').rating('refresh', {disabled: true, showClear: false, showCaption: true});
					//$(document).trigger("doSomething");
				}

			});
	

	return false;

}


function myFunction_up() {

	$
			.ajax({
				url : '../Ticket_UI',
				type : 'POST',
				
				dateType : 'json',
				data : {
					mode : "registedevents"
				},
				success : function(result) {

					elementid_array = result.eventid;
					elementname_array = result.eventname;
					elementdate_array = result.dates;
					elementvenue_arry = result.venue;
					elementdescr_arry = result.descr;
					elementuser_array = result.username;
					elementticket_array = result.numticket;
					elementticket_time = result.time;
					elementcategory = result.category;

					if (result.isvalid1) {

						$('#registertable').empty();
						for (i = 0; i < result.eventid.length; i++) {
							var divStr = "<div class='innerright' id='tag-cloud-widget"
								+ i
								+ "'><input type='hidden' id='event_id' value='"
								+ elementid_array[i]
								+ "' /><h3>"
								+ elementname_array[i]
								+ "</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("
								+ i
								+ ");'>"
								+ elementuser_array[i]
								+ "</a></h4><h4>"
								+ elementdate_array[i]
								+ "</h4>"
								+ "<div class='row'>"
								//+ "<span >Rate Event:</span>"
								//+ "<input id='input-7-xs' class='rating rating-loading block' value='1' data-min='0' data-max='5' data-step='0.1' data-size='xs' disabled='true' data-show-clear='false' style='display:inline-block'/>"
								//+ "<button class='btn btn-primary block' id='rate' style='margin-bottom:12px' onClick='javascript:myFunction_2();'>Rate</button>"
								+ "<input type='button' class='btn btn-primary nominate eventbtn block' style='width:200px' value='View Event' onClick='javascript:myFunction_1("+i+");'/>" 
								+ "</div>" 
								+ "</div>";
							$('#registertable').append(divStr);
							//$('#input-7-xs').rating('refresh', {disabled: true, showClear: false, showCaption: true});
						}
						

					} else {
						$('#registertable').empty();
						alert('No event active to display, Please check with system admin');
					}
					},
				
				complete: function() {
					//alert('hi');
					
					
					// $(document).trigger("doSomething");
				}

			});
	

	return false;

}
function myFunction_searchevents() {
 	
	var search_val=document.getElementById("searchevent_txt").value;
	$('#registertable').empty();
	for (i = 0; i < elementid_array.length; i++) {
		n = elementname_array[i].indexOf(search_val);
		if(n<0)continue;
		var divStr = "<div class='innerright' id='tag-cloud-widget"
			+ i
			+ "'><input type='hidden' id='event_id' value='"
			+ elementid_array[i]
			+ "' /><h3>"
			+ elementname_array[i]
			+ "</h3><h4>Hosted by: <a onClick='javascript:myFunction_host("
			+ i
			+ ");'>"
			+ elementuser_array[i]
			+ "</a></h4><h4>"
			+ elementdate_array[i]
			+ "</h4>"
			+ "<div class='row'>"
			+ "<span >Rate Event:</span>"
			+ "<input id='input-7-xs' class='rating rating-loading block' value='1' data-min='0' data-max='5' data-step='0.1' data-size='xs' data-show-clear='false' style='display:inline-block'/>"
			+ "<button class='btn btn-primary block' id='rate' style='margin-bottom:12px' onClick='javascript:myFunction_2();'>Rate</button>"
			+ "<input type='button' class='btn btn-primary nominate eventbtn block' style='width:200px' value='View Event' onClick='javascript:myFunction_1("+i+");'/>" 
			+ "</div>" 
			+ "</div>";
		$('#registertable').append(divStr);
	}
	
}

function myFunction_rate(num){
	
	var value='rating_button_'+num;
	var rate_value=document.getElementsByName(value);
	var rated=0;
	var index=0
	for (i=0; i<rate_value.length; i++)
		{	
        if (rate_value[i].checked) {rated=i; index=i}
		}
   var event_id=elementid_array[num];
   var user_id=elementuser_array[num];
   rated=rate_value[index].value;
   console.log(rated);
   $.ajax({
  	   url : '../HostProfile_Controller',
  	   type:'POST',
  	   dateType: 'json',
  	   data: {mode:"rate_event",eventid:event_id,userid:user_id,rating:rated},
  	   success: function(result){
  		    console.log(result);       		    
  		    
  		    if(result.valid){
  		    	
  		    	for (i=0; i<rate_value.length; i++)
  				{	rate_value[i].disabled=true;	
  				}
  		    	alert('Event Rated Successfully');
  		    	//window.open("http://localhost:8080/EventIT_App/evenit/manage.jsp","_self");
  			    
  		   }
  		   else
  			   {
  			 alert('Event Rating Failed');
  			     
  			   } 
  	   }
  	  
    })
	
	
}
