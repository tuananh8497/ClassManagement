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

<title>Add mentor</title>

</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../Sidebar.jsp"></jsp:include>

		<!-- Page Content  -->
		<div id="content" class="container ml-3">
			
			<form action="<%=request.getContextPath()%>/addMentor" method="post">
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="account">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Name</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="name">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Bank account</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="bankAccount">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Email</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="email" name="email">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Phone</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="phone">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Citizen ID</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="citizenId">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Address</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="address">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Birth date</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="date" name="birthDate">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label">Education</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" name="education">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label">Status</label>
					                    <div class="col-lg-9">
					                        <select class="custom-select" name = "status">
					                        	<option></option>
												<option>true</option>
												<option>false</option>
											</select>
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label"></label>
					                    <div class="col-lg-9">
					                        <button type="submit" class="btn btn-info">Save and changes</button>
					                        <!--  <button type="button" class="btn btn-secondary"><a href="/student/editStudent.html">Cancel</a></button> -->
					                    </div>
					                </div>
					            </form>
			
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