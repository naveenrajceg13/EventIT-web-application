<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>EventIt Revervation History</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/jquery.timepicker.css" rel="stylesheet">
	<link href="css/sidemenu.css" rel="stylesheet">
	<SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
	<SCRIPT src="js/home.js"></SCRIPT>
    <SCRIPT src="js/reservation.js"></SCRIPT>
    
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
.form-control {
	width:800px
}
.innerright {
	min-height:150px
}
.eventbtn {
	float: right;
	position: relative;
	right: 45px;
	bottom: 10px;
}
</style>
	</head>
	<!--/head-->

	<body>
<header id="header" role="banner">
      <div class="main-nav fixed-menu">
    <div class="container">
          <div class="header-top">
        <div class="pull-right social-icons"> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-google-plus"></i></a> <a href="#"><i class="fa fa-youtube"></i></a> </div>
      </div>
          <div class="row">
        <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
              <a class="navbar-brand" href="index.html"> <img class="img-responsive" src="images/eventlogo.png" alt="logo"> </a> </div>
        <div class="collapse navbar-collapse">
               <li class="scroll nav navbar-nav navbar-right"><a href="home.jsp">Home</a></li>
		                    <li class="scroll nav navbar-nav navbar-right"><a href="browse.jsp">Browse Events</a></li>                         
		                    <li class="scroll nav navbar-nav navbar-right"><a href="event.jsp">Create Event</a></li>
                            <li class="scroll nav navbar-nav navbar-right"><a href="manage.jsp">Manage Worklist</a></li>
		                    <li class="scroll active nav navbar-nav navbar-right"><a href="reservationHistory.jsp">Reservation History</a></li>
		                    
            </div>
      </div>
        </div>
  </div>
    </header>
<!--/#header-->

<section id="browse" style="min-height:500px;margin:0 auto;margin-top:5%;position:relative;color:black;width:80%">
		<div style=" margin-top: 100px; margin-bottom: 20px;">
        	<ul class="nav navbar-nav navbar-left" style="margin-right:100px !important">
            <li class="scroll active"><a href="#upcomingevents">Upcoming Events</a></li>
            <li class="scroll "><a href="#pastevents">Past Events</a></li>            
            </ul>
            <input type="text" placeholder="search event" class="form-control" name="searchevent" id="searchevent" style="margin:10px 10px 10px 0px; width:400px; display: inline !important;"/>
            <button class= "btn-search">Search</button>
         </div>
      <table id="registertable" class="table table-bordered" style="width:100%; padding-left:200px; padding-right:200px;">
   
    
   
  </table>
    </section>

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

    $( ".datepicker" ).datepicker({
		format: 'MM-DD-YYYY',
        minDate: new Date
    });
	$( ".timepicker" ).timepicker();
</script>
</body>
</html>