<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EventIt My Profile</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">	
	<link href="css/responsive.css" rel="stylesheet">
    <link href="css/jquery.timepicker.css" rel="stylesheet">
    <SCRIPT src="js/logout.js"></SCRIPT>
    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <link rel="stylesheet" href="jquery-ui/jquery-ui.css" />
    <SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
    <SCRIPT src="js/home.js"></SCRIPT>
    <SCRIPT src="js/profile.js"></SCRIPT>
    <style>
	.form-control{
		width:800px
		}
	#email,#phone,#username,#opassword,#cpassword,#npassword{
		width:200px
		}
	.table-borderless tbody tr td, .table-borderless tbody tr th, .table-borderless thead tr th {
        border: none;
    }
	</style>
    <script type="text/javascript">
	$(document).ready(function(){
		$('#edit').click(function(){
			$('#name').prop('readonly',false);
			$('#address').prop('readonly',false);
			$('#phone').prop('readonly',false);
			$('#email').prop('readonly',false);
			return false;
			});
		});
    </script>
</head><!--/head-->

<body>
	<header id="header" role="banner">		
		<div class="main-nav fixed-menu">
			<div class="container">
				<div class="row">	        		
		            <div class="navbar-header">
		                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		                    <span class="sr-only">Toggle navigation</span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                </button>
		                <div class="navbar-brand">
		                	<img class="img-responsive" src="images/eventlogo.png" alt="logo">
		                </div>                    
		            </div>
		            <div class="collapse navbar-collapse">
		            	<div class="nav navbar-nav navbar-right">       
		                    <li class="scroll"><a href="home.jsp">Home</a></li>
		                    <li class="scroll"><a href="browse.jsp">Browse Events</a></li>                            
                            <li class="scroll"><a href="event.jsp">Create Event</a></li>
                            <li class="scroll"><a href="manage.jsp">Manage Worklist</a></li>
		                    <li class="scroll"><a href="reservationHistory.jsp">Reservation History</a></li>
		                    <li class="scroll active"><a href="myprofile.jsp">My Profile</a></li>
               				<li class="scroll"><a href="#" onclick="javascript:logout()">Logout</a></li>
                       	</div>
		            </div>
		        </div>
	        </div>
        </div>                    
    </header>
    <!--/#header--> 
    
    <center>
    <section id="create" style="min-height:500px;margin-top:95px;position:relative;color:black;width:80%;">	
		<table class="table table-borderless">
            <tr>
                <td colspan="2" style="text-align:center"><h3>My Profile</h3></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" placeholder="Name" class="form-control" name="name" id="name" readonly /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><textarea placeholder="Address" class="form-control" readonly id="address"></textarea></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><input type="text" placeholder="phone number" class="form-control" name="phone" id="phone" readonly /></td>
            </tr>
            
            <tr>
                <td colspan="2">
                <button id="edit" class="btn btn-primary">Edit</button>
                <button id="save" class="btn btn-primary" onclick='javascript:myFunction_profile();' style="margin-left:15px">Save Changes</button>
            </tr>
            <tr>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" placeholder="Email" class="form-control datepicker" name="email" id="oemail" readonly/></td>
            </tr>
            <tr>
                <td>Current Password:</td>
                <td><input type="password" class="form-control" name="opassword" id="opassword" style="" /></td>
            </tr>
            <tr>
                <td>New Password:</td>
                <td><input type="password" class="form-control" name="npassword" id="npassword"  /></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" class="form-control" name="cpassword" id="cpassword"  /></td>
            </tr>
            <tr>
                <td colspan="2">
                <button class="btn btn-primary eventbtn" onclick='javascript:myFunction_pass();'>Change Password</button>
                </td>
            </tr>
            
        </table>
        <table id="search_box" class="table table-bordered" style="width:100%">
    <tr>
          <th>
          <div>
          Hosted Events
          <input type="text" placeholder="search event" class="form-control" name="searchevent" id="searchevent" style="margin:10px 10px 10px 0px; width:400px; display: inline !important;"/>
            <button class= "btn-search" onClick='myFunction_searchevents()'>Search</button>
          </div>
          </th>
         </tr>
     </table>
     <table id="myevents" class="table table-bordered" style="width:100%">
     </table>
    </section>
    </center>
    
    <!--/#contact-->

    <footer id="footer">
        <div class="container">
            <div class="text-center">
           		<p> Copyright  &copy;2016 EvenIt.</p>                   
            </div>
        </div>
    </footer>
    <!--/#footer-->
  
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoothscroll.js"></script>
    <script type="text/javascript" src="js/jquery.parallax.js"></script>
    <script type="text/javascript" src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/jquery.nav.js"></script>
    <script type="text/javascript" src="js/jquery.timepicker.js"></script>
    <script src="jquery-ui/jquery-ui.js"></script>
    
     <script type="text/javascript">
  
    $( ".datepicker" ).datepicker({
		format: 'MM-DD-YYYY',
        minDate: new Date
    });
	$( ".timepicker" ).timepicker();
</script>
</body>
</html>