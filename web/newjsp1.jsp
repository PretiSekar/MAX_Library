 <%-- 
    Document   : newjsp1
    Created on : 2 Oct, 2016, 12:28:19 PM
    Author     : Preethi
--%>


<!DOCTYPE html>
<!-- saved from url=(0044)http://getbootstrap.com/examples/offcanvas/# -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>MAX LIBRARY</title>

    <!-- Bootstrap core CSS -->
    <link href="./Off Canvas Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./Off Canvas Template for Bootstrap_files/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./Off Canvas Template for Bootstrap_files/offcanvas.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./Off Canvas Template for Bootstrap_files/ie-emulation-modes-warning.js.download"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </head>

  <body>
    <nav class="navbar navbar-fixed-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" >MAX Library</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a>Home</a></li>
            <li><a>About</a></li>
            <li><a>Contact</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <h1>Welcome to MAX Library</h1>
            <p>Search for a book here. Note you can only use the ISBN,title or Author Name</p>
            <form action="servlet6" method="get">
                <input type="text" name="namesearch" id="namesearch" size="85" maxlength="50" />
                <input type="submit" name="Search" id="Search" value="Search" />
            </form>
          </div>
          <div class="row">
            <div class="col-xs-6 col-lg-4">
              <h2>Book Check Out</h2>
              <p>The book's SSN and Borrower's card number is required to check out a book </p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/checkout.jsp" role="button">Check Out>></a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2>Book Check In</h2>
              <p>The Book's or the Borrower's information is required for check in</p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/checkin.jsp" role="button">Check In>></a></p>
            </div><!--/.col-xs-6.col-lg-4-->
           <div class="col-xs-6 col-lg-4">
              <h2>Borrower</h2>
              <p>Click to add a new borrower into the system</p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/borrower.jsp" role="button">Add Borrower>></a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2>Fines</h2>
              <p>Will let you know the fine payment due for a borrower</p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/fines.jsp" role="button">View Fines >></a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2>Fine Payment</h2>
              <p>Helps in logging any amount that is payed by the borrower</p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/finepayment.jsp" role="button">Pay Fine>></a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2>Books Overdue</h2>
              <p>Displays all the book overdue for a borrower if the Borrower ID is known</p>
              <p><a class="btn btn-default" href="http://localhost:8080/Helloweb/booksoverdue.jsp" role="button">View Books Overdue »</a></p>
            </div><!--/.col-xs-6.col-lg-4-->
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
<!--
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item active">Link</a>
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item">Link</a>
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item">Link</a>
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item">Link</a>
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item">Link</a>
            <a href="http://getbootstrap.com/examples/offcanvas/#" class="list-group-item">Link</a>
          </div>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->
      

      <hr>

      <footer>
        <p>© 2016 MAX Library, Inc.</p>
      </footer>

    </div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./Off Canvas Template for Bootstrap_files/jquery.min.js.download"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./Off Canvas Template for Bootstrap_files/bootstrap.min.js.download"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./Off Canvas Template for Bootstrap_files/ie10-viewport-bug-workaround.js.download"></script>
    <script src="./Off Canvas Template for Bootstrap_files/offcanvas.js.download"></script>
  

</body></html>
