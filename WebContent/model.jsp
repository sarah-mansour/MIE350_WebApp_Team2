<%@page import="dao.ModelDao,model.Model,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Model View</title>
<link rel="stylesheet" href="css/default.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/70568dea68.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
 	<% 
 		int id = Integer.parseInt(request.getParameter("id")); 
 		Model m = new Model();
 		m.setId(id);
 		m = ModelDao.loadModel(m);
 	%>
 	<iframe src="header.html" id="header" frameBorder="0"></iframe>
	<h1 id="title" class="modeltitle"><%= m.getModel() %> - <%= m.getYearIssued() %></h1>
	<h3 class="modeltitle"><%= m.getBrand().getName() %> (<%= m.getCategory() %>)</h3>
	
	
	<div class="container" id="modelview">
	    <div class="row">
	        <div class="col-lg-6">
	            <img class="modelimg" src="img/car2.jpg" />
	        </div>
	        <div class="col-lg-3">
	        
	        	<div class="modeldata">
	        		<!--  do not forget to add units for each attribute/property -->
	        		<p> Starting Price: <%= m.getStartingPrice() %> </p>
	        		<p> Battery: <%= m.getBattery() %> </p>
	        		<p> Power: <%= m.getPower() %> </p>
	        		<p> Battery Range: <%= m.getBatteryRange()%> </p>
	        		<p> Top Speed: <%= m.getTopSpeed()%> </p>
	        		<p> Acceleration: <%= m.getAcceleration()%> </p>
	        		<p> Drive Type: <%= m.getDriveType() %> </p>
	        		<p> Number of seats: <%= m.getNumberOfSeats() %> </p>
	        		<p> Number of doors: <%= m.getNumberOfDoors() %> </p>
	        		<p> Power Source: <%= m.getPowerSource() %> </p>
	        	</div>
	        </div>
	        
	        <div class="col-lg-3">
	        	<div class="modeldata">
					<a href="compare.jsp?id=<%= m.getId() %>" class="comparelink">
						<i class="fas fa-chart-pie"></i> <span>Add to Compare</span>
					</a>
					<br>
					<a href="#" > <!-- note: use AJAX/JQuery for wishlist -->
						<i class="far fa-heart"></i> <span>Add to Wishlist</span>
					</a>
	        	</div>
	        </div>
	    </div>
	</div>

</body>
</html>