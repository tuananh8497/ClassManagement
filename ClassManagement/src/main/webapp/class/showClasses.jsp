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

</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../Sidebar.jsp"></jsp:include>

		<!-- Page Content  -->
		<div id="content" class="container-fluid">
			<div class="box">
				<h2>Welcome to list of Classes</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>
			<div class="row text-center">
				<c:forEach items="${listClass }" var="class1">
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<div class="card-header">
								<h4 class="my-0 font-weight-normal">${class1.getClassCode() }</h4>
							</div>
							<div class="card-body">
								<ul class="list-unstyled mt-3 mb-4">
									<li>AdminClass: ${class1.getAdminAccount() }</li>
									<li>StartDate: ${class1.actualStartDate}</li>
									<li>EndDate: ${class1.actualEndDate}</li>
									<li style="color: green">Status: ${(class1.status==true)? "Active" : "Finished" }</li>
								</ul>
								<button type="button" class="btn btn-lg btn-block btn-info">
									<a href="<%= request.getContextPath()%>/profileClass?classId=<c:out value="${class1.getClassId()}"/>">Class
										profile</a>
								</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>