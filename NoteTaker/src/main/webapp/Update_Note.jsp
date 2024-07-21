<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Note</title>
<%@include file="All_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="navbar.jsp"%>
	</div>
	<h1 class="text-uppercase">update your note:</h1>
	
	<%
			int noteid = Integer.parseInt(request.getParameter("note_id"));
			Session s = FactoryProvider.getFactory().openSession();
			Note n = s.get(Note.class, noteid);
			s.close();
	%>
			<div class="container">
		<form action="UpdateNoteServlet" method="post">
		
		<input value="<%= n.getId()%>" name = "note_id" type ="hidden">
  <div class="form-group">
    <label for="title">Title:</label>
    <input type="text" name = "title" class="form-control" id="title" placeholder="Enter Title" required="required" value="<%= n.getTitle()%>">
    
  </div>
  <div class="form-group">
    <label for="content">Content:</label>
    <textarea required="required" name = "content" class="form-control" id="content" placeholder="Enter Content" style="height: 120px;"> <%=n.getContent()%></textarea>
  </div>
  
  <button type="submit" class="btn btn-success">Update Note</button>
</form>
	</div>
</body>
</html>