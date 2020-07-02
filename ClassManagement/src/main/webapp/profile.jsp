<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- Our Custom CSS -->
<!-- <link rel="stylesheet" href="/ClassManagement/css/style.css"> -->
<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.css">
<link rel="stylesheet" type="text/css"
	href="https://handsontable.com/static/css/main.css">
<script
	src="https://cdn.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Class management project</title>


</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="Sidebar.jsp"></jsp:include>
		<!-- Page Content  -->
		<div id="content">
			<div id="hot"></div>
			<div id="export-buttons" class="visible">
				<button id="export-csv"
					class="btn size-medium bg-blue text-white shadow hover-moveup"
					style="margin-right: 5px;">Export to a .csv file</button>
			</div>
		</div>
	</div>
</body>
<script src="/ClassManagement/js/test.js"></script>

</html>