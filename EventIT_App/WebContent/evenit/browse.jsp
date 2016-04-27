<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EventIt Browse events</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">	
	<link href="css/responsive.css" rel="stylesheet">
    <link href="css/jquery.timepicker.css" rel="stylesheet">
    <SCRIPT src="js/logout.js"></SCRIPT>
    <link href="css/sidemenu.css" rel="stylesheet">
    <SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
    <SCRIPT src="js/browse.js"></SCRIPT>
    <SCRIPT src="js/gethostprofile.js"></SCRIPT>
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
				<div class="header-top">
					<div class="pull-right social-icons">
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-google-plus"></i></a>
						<a href="#"><i class="fa fa-youtube"></i></a>
					</div>
				</div>     
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
		                    <li class="scroll active"><a href="browse.jsp">Browse Events</a></li>    
                            <li class="scroll"><a href="event.jsp">Create Event</a></li>
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
  
    <section id="browse" style="min-height:500px;margin-top:95px;position:relative;color:black;width:80%;">	
	    <div class="wrapper">
           <div class="leftdiv">
               <div class="nav-side-menu">
    <div class="brand">Filter Events</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">

                <li  data-toggle="" data-target="#cat" class=" active" style="padding-left:5px">
                  <a href="#"> Categories</a>
                </li>
                <ul class="sub-menu " id="cat">
                    <li style="padding-left:5px"><input type="radio" name="one2" value=1>Sport</input></li>
                    <li style="padding-left:5px"><input type="radio" name="one2" value=2>Financial</input></li>
                    <li style="padding-left:5px"><input type="radio" name="one2" value=3>Education</input></li>
                    <li style="padding-left:5px"><input type="radio" name="one2" value=4>Corporate</input></li>
                    <li style="padding-left:5px"><input type="radio" name="one2" value=5>Others</input></li>
                    <li style="padding-left:5px"><input type="radio" name="one2" value=6 checked>All</input></li>
                </ul>


                <li class="active" style="padding-left:5px">
                  <a href="#">
                  Event Date
                  </a>
                </li>
                <ul class="sub-menu " id="date" style="content:inherit">
                    <li style="line-height: 50px !important;">
                    	<table>
                        	<tr>
                                <td style="width:50px; padding-left:5px">
                                From
                                </td>
                                <td>
                                <input type="text" class="form-control datepicker" style="width:200px;display:inline-block" name="fromdate" id="fromdate" />
                                </td>
                            </tr>
                            <tr>
                                <td style="width:50px; padding-left:5px">
                                To
                                </td>
                                <td>
                                <input type="text" class="form-control datepicker" style="width:200px;display:inline-block" name="todate" id="todate" />
                                </td>
                            </tr>
                        </table>
                    </li>
                                        
                </ul>
               
            </ul>
            <br/>
            <div align="center">
            <input type="button" value="Search" class="btn btn-primary" onclick='javascript:search_events();' style="background-color:#1B7B98;" id="browser_search" />
            </div>
	</div>
	</div>
    </div>
           <div class="rightdiv" id="browsetable">
          	
       </div>

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