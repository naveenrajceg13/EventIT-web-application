$(document).ready(function(){
var obj=JSON.parse(localStorage.getItem("obj91"));
value=obj.Firstname;
if(true)
{
$('#welcome_msg').empty();
$('#welcome_msg').append('<label style=" font-size: 70px; color:black" id="welcome_msg">Welcome '+value+'</label>');
}

});