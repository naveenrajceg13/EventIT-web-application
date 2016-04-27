<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EventIt Create event</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">	
	<link href="css/responsive.css" rel="stylesheet">
    <link href="css/jquery.timepicker.css" rel="stylesheet">
    <SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
    <SCRIPT src="js/home.js"></SCRIPT>
    <SCRIPT src="js/event_create.js"></SCRIPT>
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
    <style>
	.form-control{
		width:800px
		}
	#date,#time,#numticket,#category{
		width:200px
		}
	</style>
   
</head><!--/head-->

<body>
	<header id="header" role="banner">		
		<div class="main-nav fixed-menu">
			<div class="container">
				<div class="row">	        		
		            <div class="navbar-header">
		               
		                <div class="navbar-brand">
		                	<img class="img-responsive" src="images/eventlogo.png" alt="logo">
		                </div>                    
		            </div>
		            <div class="collapse navbar-collapse">
                    	<div class="nav navbar-nav navbar-right"> 
		                    <li class="scroll"><a href="home.jsp">Home</a></li>
		                    <li class="scroll"><a href="browse.jsp">Browse Events</a></li>                         
		                    <li class="scroll active"><a href="event.jsp">Create Event</a></li>
                            <li class="scroll"><a href="manage.jsp">Manage Worklist</a></li>
		                    <li class="scroll"><a href="reservationHistory.jsp">Reservation History</a></li>
		   					<li class="scroll"><a href="myprofile.jsp">My Profile</a></li>
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
		<table class="table table-bordered">
            <tr>
                <td colspan="2" style="text-align:center"><h3>Create Event</h3></td>
            </tr>
            <tr>
                <td>Event Name:</td>
                <td><input type="text" id="eventname" placeholder="Event name" class="form-control" name="title"  /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea placeholder="Event description" class="form-control" name="description" id="editor"></textarea>
</td>
            </tr>
            <tr>
                <td>Event Category:</td>
                <td>
                    <select id="category" name="category" class="form-control">
                         <option value=""></option>
                         <option value="Sport">Sport</option>
                         <option value="Financial">Financial</option>
                         <option value="Education">Education</option>
                         <option value="Coporate">Coporate</option>
                         <option value="others">others </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Venue:</td>
                <td><textarea placeholder="Address" id="venue" class="form-control" ></textarea></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="text" placeholder="Event date" id="date" class="form-control datepicker" name="date" /></td>
            </tr>
            <tr>
                <td>Time:</td>
                <td><input type="text"  id="time" class="form-control timepicker" name="time" /></td>
            </tr>
            
			<tr>
                <td>Total number of tickets:</td>
                <td><input type="text" placeholder="Total tickets for the event" id="numticket" class="form-control" name="tickets"  />
                </td>
            </tr>
            
            <tr>
                <td colspan="3" style="text-align:center">
                <button class="btn btn-primary"  onclick='javascript:myFunction_create();' style="margin-right: 50px;background-color:#1B7B98">Submit</button>
                <input type="reset" value="Reset" class="btn btn-primary" style="background-color:#1B7B98" />
                </td>
            </tr>
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
   
	// Initiate and customize datepicker

    $( ".datepicker" ).datepicker({
		format: 'MM-DD-YYYY',
        minDate: new Date
    });
	$( ".timepicker" ).timepicker({
		    timeFormat: 'H:i'
	});
</script>
</body>
</html>