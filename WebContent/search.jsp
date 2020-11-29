<%@page import="dao.ModelDao,model.Model,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Electric Cars</title>
<link rel="stylesheet" href="css/default.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="js/search.js"></script>
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
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
	%>
	<iframe src="header.html" id="header" frameBorder="0"></iframe>
	<h1 id="title" class="searchTitle">Search Results</h1>
	<% 
		ArrayList<Model> models = ModelDao.findModels(brand, model, year);
	%>
	
	<div id="resultbox">
		
		<% for(int i = 0; i < models.size(); i++){ Model m = models.get(i); %>
		
			<div class="resultitem">
				<img class="resultimg" model="<%= m.getId() %>"  src="img/car2.jpg"/>
				<div class="resultdata">
					<h3><%= m.getCategory() %></h3>
					<h4>(<%= m.getBrand().getName() %>) <%= m.getModel() %> - <%= m.getYearIssued() %></h4>
					<a href="compare.jsp?id=<%= m.getId() %>" class="comparelink">
						<i class="fas fa-chart-pie"></i> <span>Compare</span>
					</a>
					<a href="#" > <!-- note: use AJAX/JQuery for wishlist -->
						<i class="far fa-heart"></i> <span>Wishlist</span>
					</a>
				</div>
			</div>
			
		<%} %>
		
	</div>
	
</body>
</html>