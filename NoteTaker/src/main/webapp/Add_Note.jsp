<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add_Note:</title>
 <%@include  file = "All_js_css.jsp"%>
</head>
<body>
<div class="container-fluid p-0 m-0">
    	<%@include  file = "navbar.jsp"%>
  	</div>
  	<br>
  	<h1 class="text-uppercase">Add Your Note:</h1>
  	<div class="container">
  	
  	<form action="AddNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Title:</label>
    <input type="text" name = "title" class="form-control" id="title" placeholder="Enter Title" required="required">
    
  </div>
  <div class="form-group">
    <label for="content">Content:</label>
    <textarea required="required" name = "content" class="form-control" id="content" placeholder="Enter Content" style="height: 120px;"></textarea>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  	
  	</div>
  
</body>
</html>