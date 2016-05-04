<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EventIt</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">	
	<link href="css/responsive.css" rel="stylesheet">
	<SCRIPT src="js/jquery-1.12.1.js"></SCRIPT>
    <SCRIPT src="js/home.js"></SCRIPT>
    <SCRIPT src="js/logout.js"></SCRIPT>
    <SCRIPT src="js/username.js"></SCRIPT>
    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <style type="text/css">
	.btn{
		background-color:#1B7B98 !important
		}
	table{
		border-collapse:collapse
		}
	table td{
		padding-top: .5em;
        padding-bottom: .5em;
		padding-right: .3em;
		}
	.navbar-right {
	    padding: 0px	
	}
	.inline_display{
	display: inline-flex;
	}
	.navbar-right .active a {
    background-color: transparent;
    color: #fb130b !important;
    }
    </style>
</head><!--/head-->

<body>
	<header id="header" role="banner">		
		<div class="main-nav">
			<div class="container">
				<div class="header-top">
					<div class="pull-right social-icons">

					</div>
				</div>     
		        <div class="row" style="background-color:#1B7B98;height:90px">	        		
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
		                    <div class="inline_display" id="oneh"><li class="scroll active"><a href="home.jsp">Home</a></li></div>
		                    <div class="inline_display" id="oneb"><li class="scroll "><a href="browse.jsp">Browse Events</a></li>  </div>                       
		                    <div class="inline_display" id="onec"><li class="scroll "><a href="event.jsp">Create Event</a></li></div>
                            <div class="inline_display" id="onem"><li class="scroll "><a href="manage.jsp">Manage Worklist</a></li></div>
		                    <div class="inline_display" id="oner"><li class="scroll "><a href="reservationHistory.jsp">Reservation History</a></li></div>
                            <div class="inline_display" id="onep"><li class="scroll "><a href="myprofile.jsp">My Profile</a></li></div>
                            <div class="inline_display" id="onel"><li class="scroll "><a href="#" onclick="javascript:logout()">Logout</a></li></div>
                     	</div>
		   
		               
		            </div>
		        </div>
	        </div>
        </div>                    
    </header>
    <!--/#header--> 

    <section id="menu">	
		<div>
			<img class="img-responsive" src="images/menu.jpg">						
		</div>    	
    </section>
	<!--/#home-->
    <table style="background-color: #f2f2f2; width:100%">
    	<tr>
    		
    		<td style="width:40%;">
            <div id="main-slider" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#main-slider" data-slide-to="0" class="active"></li>
				<li data-target="#main-slider" data-slide-to="1"></li>
				<li data-target="#main-slider" data-slide-to="2"></li>
                <li data-target="#main-slider" data-slide-to="3"></li>
                <li data-target="#main-slider" data-slide-to="4"></li>
                <li data-target="#main-slider" data-slide-to="5"></li>
                <li data-target="#main-slider" data-slide-to="6"></li>
                <li data-target="#main-slider" data-slide-to="7"></li>
                <li data-target="#main-slider" data-slide-to="8"></li>
                <li data-target="#main-slider" data-slide-to="9"></li>
			</ol>
			<div class="carousel-inner" style="height:460px !important; width:600px !important; margin:100px 0px 0px 175px;">
				<div class="item active">
					<img class="img-responsive" src="images/slider/1.jpg" alt="slider">						
				</div>
				<div class="item">
					<img class="img-responsive" src="images/slider/2.jpg" alt="slider">	
				</div>
				<div class="item">
					<img class="img-responsive" src="images/slider/3.jpg" alt="slider">	
				</div>	
                <div class="item">
					<img class="img-responsive" src="images/slider/4.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/5.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/6.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/7.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/8.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/9.jpg" alt="slider">	
				</div>
                <div class="item">
					<img class="img-responsive" src="images/slider/10.jpg" alt="slider">	
				</div>			
			</div>
			</div>
    		</td>
            <td style="width:40%;">
            	<div align="center" style="height:300px;color: black; padding-top:100px;">
    				<label style=" font-size: 100px; color:black" id="welcome_msg">Welcome</label>
    			</div>
   			</td>
    	</tr>
    </table>
    
	


	
	<!--/#about--><section id="about">
		<div class="guitar2">				
			<img class="img-responsive" src="images/guitar2.jpg" alt="guitar">
		</div>
		<div class="about-content">					
					<h2>About EventIt!</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eu convallis dolor, vel feugiat neque. Etiam et nisl et urna malesuada interdum. Nulla purus ligula, congue vel accumsan non, viverra at dolor. Nullam vel varius dolor. Quisque vulputate sagittis nisl vel aliquam. Maecenas et porta tellus. Duis congue nisl sit amet tellus mattis feugiat sed ac nunc. Donec porta, nibh nec volutpat egestas, elit arcu sollicitudin dui, nec facilisis enim metus non ex. Nulla varius diam vel nisl egestas vulputate. Quisque vestibulum fermentum ante, vel mattis odio cursus sed. Nulla vel placerat risus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi in dolor nec libero finibus auctor a eu dolor.</p>
					
		</div>
	</section>
	
	
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
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
  	<script type="text/javascript" src="js/gmaps.js"></script>
	<script type="text/javascript" src="js/smoothscroll.js"></script>
    <script type="text/javascript" src="js/jquery.parallax.js"></script>
    <script type="text/javascript" src="js/coundown-timer.js"></script>
    <script type="text/javascript" src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/jquery.nav.js"></script>
    <script type="text/javascript" src="js/main.js"></script>  
    
  
</body>
</html>