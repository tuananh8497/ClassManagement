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
<link rel="stylesheet" href="/ClassManagement/css/style.css">
<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
<title>Class management project</title>


<!-- Simple graph use canvas -->

</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../Sidebar.jsp"></jsp:include>


		<!-- Page Content  -->
		<div id="content" class="container">
			<div class="box shadow-sm">
				<h2>Welcome to Form edit class informations.</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>
			<!-- Form input class information -->
			<form class="form shadow-sm">
				<div class="form-group row">
					<label for="class-account" class="col-sm-2 col-form-label">Class
						Account</label>
					<div class="col-sm-10">
						<input type="text" class="form-control shadow-sm"
							id="class-account"
							placeholder="Input account of class you want to edit . . .">
					</div>
				</div>
				<div>
					<label for="class-account" class="col-sm-2 col-form-label">Class
						Code</label>
					<div class="col-sm-10">
						<c:forEach items="${listClass }" var="class1">
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="${class1.classCode }">Action</a>
								<h4 class="my-0 font-weight-normal">${class1.classCode }</h4>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="row text-center">
					<c:forEach items="${listClass }" var="class1">
						<div class="row text-center">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<div class="card-header">
										<h4 class="my-0 font-weight-normal">${class1.classCode }</h4>
									</div>
									<div class="card-body">
										<ul class="list-unstyled mt-3 mb-4">
											<li>${class1.adminAccount }</li>
											<li>${class1.actualStartDate }</li>
											<li>${class1.actualEndDate }</li>
											<li>${class1.status }</li>
										</ul>
										<button type="button" class="btn btn-lg btn-block btn-info">
											<a href="<%=request.getContextPath()%>/profileClass">Class
												profile</a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!------------------------------------------------->
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Dropdown
						button</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div>
				</div>
				<!-------------------------------------------------->
				<div class="form-group row">
					<label for="class-name" class="col-sm-2 col-form-label">Class
						Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control shadow-sm" id="class-name"
							placeholder="Input name of the class account you want to change . . .">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-1">
						<button type="submit" class="btn btn-info shadow-sm">
							<a href="#">Save edit class</a>
						</button>
					</div>
				</div>
			</form>
			<p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
		</div>

	</div>
	<footer>
		<p></p>
	</footer>

	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>