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
			<form class="form shadow-sm" action="<%=request.getContextPath()%>/editClass" method="post">
				<div class="form-group row">
					<label for="class-code" class="col-sm-2 col-form-label">Class
						code</label>
					<div class="col-sm-10">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<label class="input-group-text" for="inputGroupSelect01">Options</label>
							</div>
							<select class="custom-select" id="inputGroupSelect01">
								<option></option>
								<c:forEach items="${listClass }" var="class1">
									<option value="${class1.classId }">${class1.classId } - ${class1.classCode }</option>
								</c:forEach>
							</select>
							
						</div>
					</div>
				</div>
				<p>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">
						Edit this class</button>
				</p>
				<!--------------------Testing------------------->
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<div class="form-group row">
							<label for="admin-account" class="col-sm-2 col-form-label">Admin
								Account</label>
							<div class="col-sm-10">
								<input type="text" class="form-control shadow-sm"
									id="admin-account" value="${class1.adminAccount }" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="admin-account" class="col-sm-2 col-form-label">Course id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control shadow-sm"
									id="admin-account" value="${class1.courseId }">
							</div>
						</div>
						<div class="form-group row">
							<label for="expected-start-date" class="col-sm-2 col-form-label">Expected
								Start Date</label>
							<div class="col-sm-10">
								<input type="date" class="form-control shadow-sm"
									id="expected-start-date" name="expectedStartDate" value="${class1.expectedStartDate }">
							</div>
						</div>
						<div class="form-group row">
							<label for="expected-end-date" class="col-sm-2 col-form-label">Expected
								End Date</label>
							<div class="col-sm-10">
								<input type="date" class="form-control shadow-sm"
									id="expected-end-date" name="expectedEndDate" value="${class1.expectedEndDate }">
							</div>
						</div>
						<div class="form-group row">
							<label for="actual-start-date" class="col-sm-2 col-form-label">Actual
								Start Date</label>
							<div class="col-sm-10">
								<input type="date" class="form-control shadow-sm"
									id="actual-start-date" name="actualStartDate" value="${class1.actualStartDate }">
							</div>
						</div>
						<div class="form-group row">
							<label for="actual-end-date" class="col-sm-2 col-form-label">Actual
								Start Date</label>
							<div class="col-sm-10">
								<input type="date" class="form-control shadow-sm"
									id="actual-end-date" name="actualEndDate" value="${class1.actualEndDate }">
							</div>
						</div>
					</div>
				</div>
				<!-------------------------------- Testing-------------------------------------- -->

				<div class="form-group row">
					<div class="col-sm-4">
						<button type="submit" class="btn btn-info shadow-sm">Save edit class</button>
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