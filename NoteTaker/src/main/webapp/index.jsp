<!doctype html>
<html lang="en">
  <head>
  
  <title>Note_Taker:</title>
    <!-- Required meta tags -->
    <%@include  file = "All_js_css.jsp"%>
    
  </head>
  <body>
  	<div class="container-fluid p-0 m-0">
    	<%@include  file = "navbar.jsp"%>
  	</div>
	<br>
	<div class="card container">
		<img alt="" src="images/notepad.png" class="img-fluid mx-auto" style = "max-width:400px">
		<h1 class="text-primary text-uppercase text-center ">Start Taking Your Notes</h1>
		<div class="container text-center" >
			<a href="Add_Note.jsp"><button class="btn btn-outline-primary text-center">start here</button></a>
		</div>
	</div>
   </body>
</html>