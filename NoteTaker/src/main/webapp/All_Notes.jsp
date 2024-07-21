<!doctype html>
<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<html lang="en">
<head>

<title>All Notes:</title>
<!-- Required meta tags -->
<%@include file="All_js_css.jsp"%>

</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="navbar.jsp"%>
	</div>
	<h1 class="text-uppercase">All notes:</h1>

	<div class="row">
		<div class="col-12">

			<%
			Session s = FactoryProvider.getFactory().openSession();
			Query q = s.createQuery("from Note");
			List<Note> note = q.list();
			for (Note n : note) {
			%>

			<div class="card mt-3 container" style="max-width:700px">
				<img class="card-img-top mt-3 ml-3" style="max-width:40px" src="images/notepad.png" alt="Card image cap">
				<div class="card-body px-5">
					<h5 class="card-title"><%=n.getTitle() %></h5>
					<p class="card-text"><%=n.getContent() %></p>
					<p class="card-text" align="right"><b class="text-primary"><%=n.getAddedDate() %></b></p>
					<div class="container text-center ">
					<a href="Delete_Servlet?note_id=<%= n.getId()%>" class="btn btn-danger">Delete</a>
					<a href="Update_Note.jsp?note_id=<%= n.getId() %>" class="btn btn-primary">update</a>
					
					</div>
				</div>
			</div>



			<%
			}

			s.close();
			%>

		</div>
	</div>


</body>
</html>