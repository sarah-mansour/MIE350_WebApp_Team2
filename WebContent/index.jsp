<%@page import="util.DbUtil,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electric Cars Search Website</title>
<link rel="stylesheet" href="css/default.css">
<script src="js/default.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
	<iframe src="header.html" id="header" frameBorder="0"></iframe>

	<div id="carouselExampleControls" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/car1.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="img/car1.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="img/car1.jpg" class="d-block w-100" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleControls"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div id="searcharea">
		<h1 id="title">Start Your Search Now!</h1>
		<div style="height: 20px;"></div>
		<h3>Search All Cars:</h3>

		<%
			Connection connection = DbUtil.getConnection();

		ResultSet brands = connection.createStatement().executeQuery("SELECT name FROM Brand");

		ResultSet models = connection.createStatement().executeQuery("SELECT model FROM Model");
		
		ResultSet years = connection.createStatement().executeQuery("SELECT DISTINCT year_issued FROM Model");
		%>



		<form method="POST" action="search.jsp">

			<select name="brand" id="brand" class="selectInput">
				<option value="null">(select a brand)</option>
				<%
					while (brands.next()) {
						String curBrand = brands.getString(1);
				%>
				<option value="<%=curBrand%>"><%=curBrand%></option>
				<%
					}
				%>

			</select> <select name="model" id="model" class="selectInput">
				<option value="null">(select a model)</option>
				<%
					while (models.next()) {
						String curModel = models.getString(1);
				%>
				<option value="<%=curModel%>"><%=curModel%></option>
				<%
					}
				%>


			</select> <select name="year" id="year" class="selectInput">
				<option value="null">(select a year)</option>
				<%
					while (years.next()) {
						int curYear = years.getInt(1);
				%>
				<option value="<%=curYear%>"><%=curYear%></option>
				<%
					}
				%>
			</select>
			<button id="submit" type="submit" class="btn btn-success"
				name="submit">Go</button>
		</form>
	</div>

</body>
</html>