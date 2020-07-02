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

<script>
	function myFunction(mess) {
		if (mess == 'Done') {
			alert("Done!");
		} else {
			alert("Save ngu");
		}
	}
</script>

</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../Sidebar.jsp"></jsp:include>
		<!-- Page Content  -->
		<div id="content" class="container form ml-3">
			<div class="m-4">
				<h4 class="text-center">Form add a student</h4>
				<hr>
			</div>
			<form role="form" method="post" class="ml-2"
				action="<%=request.getContextPath()%>/createStudent">
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter account . . ." name="account">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Name</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter name . . ." name="name">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Address</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter address . . ." name="address">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Date
						of birth</label>
					<div class="col-lg-9">
						<input class="form-control" type="date" name="dateOfBirth">
					</div>
				</div>

				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Email</label>
					<div class="col-lg-9">
						<input class="form-control" type="email"
							placeholder="Enter email . . ." name="email">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Phone</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter phone . . ." name="phone">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Class</label>
					<div class="col-lg-9">
						<select class="form-control" id="inputGroupSelect01"
							name="classCode">
							<c:forEach items="${listClassCode }" var="classCode">
								<option value="${classCode}">${classCode}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Status</label>
					<div class="col-lg-9">
						<select class="form-control" id="inputGroupSelect01" name="status">
							<option value="active">active</option>
							<option value="inactive">inactive</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">School</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter school . . ." name="school">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Citizen
						ID</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter citizen ID . . ." name="citizenId">
					</div>
				</div>
				<div class="form-group row">
					<label
						class="col-lg-3 col-form-label form-control-label border-bottom">Bank
						Account</label>
					<div class="col-lg-9">
						<input class="form-control" type="text"
							placeholder="Enter bank account . . ." name="bankAccount">
					</div>
				</div>




				<div class="form-group row">
					<label class="col-lg-3 col-form-label form-control-label"></label>
					<div class="col-lg-9">
						<button type="submit" class="btn btn-info mr-2">
							<i class="fas fa-save"></i> Save
						</button>
						<a class="btn btn-secondary" href="<%=request.getContextPath()%>/showStudent"> 
							<i class="fas fa-times"></i> Cancel
						</a>
					</div>
				</div>
			</form>
		</div>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>