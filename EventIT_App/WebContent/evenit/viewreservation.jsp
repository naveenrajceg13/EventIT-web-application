<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EventIt View Ticket</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">	
	<link href="css/responsive.css" rel="stylesheet">
    <link href="css/jquery.timepicker.css" rel="stylesheet">
    <SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
    <SCRIPT src="js/home.js"></SCRIPT>
    <SCRIPT src="js/viewreservation.js"></SCRIPT>
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
	</style>
   
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
		                <a class="navbar-brand" href="index.html">
		                	<img class="img-responsive" src="images/eventlogo.png" alt="logo">
		                </a>                    
		            </div>
		            <div class="collapse navbar-collapse">
		                   <li class="scroll nav navbar-nav navbar-right"><a href="home.jsp">Home</a></li>
		                    <li class="scroll active nav navbar-nav navbar-right"><a href="browse.jsp">Browse Events</a></li>                         
		                    <li class="scroll nav navbar-nav navbar-right"><a href="event.jsp">Create Event</a></li>
                            <li class="scroll nav navbar-nav navbar-right"><a href="manage.jsp">Manage Worklist</a></li>
		                    <li class="scroll nav navbar-nav navbar-right"><a href="reservationHistory.jsp">Reservation History</a></li>
		                    
		            </div>
		        </div>
	        </div>
        </div>                    
    </header>
    <!--/#header--> 
    <form action="" method="post" enctype="multipart/form-data">
    <center>
    <section id="create" style="min-height:500px;margin-top:95px;position:relative;color:black;width:80%;">	
		<table class="table table-bordered">
            <tr>
                <td colspan="2" style="text-align:center"><h3>Ticket Details</h3></td>
            </tr>
            <tr>
                <td>Event Name:</td>
                <td><input type="text" placeholder="Event name" class="form-control" name="title" id="eventname" readonly /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea placeholder="Description" class="form-control" id="descr" readonly></textarea></td>
            </tr>
            <tr>
                <td>Venue:</td>
                <td><textarea placeholder="Address" class="form-control" id="venue" readonly></textarea></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="text" placeholder="Event date" class="form-control datepicker" id="dates" name="date" readonly/></td>
            </tr>
            <tr>
			<tr>
                <td>Number of tickets:</td>
                <td><input type="text" placeholder="No of tickets purchased" class="form-control" name="tickets" id="tickets" readonly />
                </td>
            </tr>
            
            <tr>
                <td colspan="3" style="text-align:center">
                	<input type="button" id="register" value="Cancel Reservation" class="btn btn-primary" style="background-color:#1B7B98" />
                </td>
            </tr>
        </table>
    </section>
    </center>
    </form>
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
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
     <script type="text/javascript">
    CKEDITOR.replace("editor");
	// Initiate and customize datepicker

    $( ".datepicker" ).datepicker({
		format: 'MM-DD-YYYY',
        minDate: new Date
    });
	$( ".timepicker" ).timepicker();
</script>
</body>
</html>