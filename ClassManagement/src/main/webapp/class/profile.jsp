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
		<div id="content">
			<div class="container-fluid">
				<h1 class="text-center">${class1.getClassCode() }</h1>
				<div class="line"></div>
				<div class="row my-2">
					<div class="col-lg-12 order-lg-2">
						<ul class="nav nav-tabs">
							<li class="nav-item"><a href="" data-target="#list"
								data-toggle="tab" class="nav-link active">List</a></li>
							<li class="nav-item"><a href="" data-target="#checked"
								data-toggle="tab" class="nav-link ">Checked</a></li>
							<li class="nav-item"><a href="" data-target="#editClass"
								data-toggle="tab" class="nav-link ">Edit Class</a></li>
						</ul>
						<div class="tab-content py-4">
							<div class="tab-pane active" id="list">
								<div id="chartContainer" style="height: 370px; width: 100%;"
									class="graph shadow-sm"></div>
								<div>
									<h3 class="text-center">List of students</h3>
									<h3 class="text-center">AdminClass:
										${class1.getAdminAccount() }</h3>
									<button type="button" class="btn btn-info">
										<a href="<%=request.getContextPath()%>/addStudent">Add
											Student</a>
									</button>
								</div>
								<div class="tbl">
									<table class="table table-striped shadow-sm text-center">
										<thead>
											<tr>
												<th scope="col">Account</th>
												<th scope="col">Name</th>
												<th scope="col">BirthDate</th>
												<th scope="col">Address</th>
												<th scope="col">Phone</th>
												<th scope="col">Email</th>
												<th scope="col">Status</th>
												<th scope="col">Profile</th>
											</tr>
										</thead>
										<c:forEach items="${listPer }" var="listPer">
											<tbody>
												<tr>
													<td>${listPer.getAccount() }</td>
													<td>${listPer.getName() }</td>
													<td>${listPer.birthDate.getDate()}/${listPer.birthDate.getMonth() +
                                    				1}/${listPer.birthDate.getYear() + 1900}</td>
													<td>${listPer.getAddress() }</td>
													<td>${listPer.getPhone() }</td>
													<td>${listPer.getEmail() }</td>
													<td style="color: green">${(listPer.status==true)? "Active" : "Deactive" }</td>
													<td><a
														href="<%=request.getContextPath()%>/profileStudent"><img
															src="/ClassManagement/icon/alien.svg" width="40px"
															height="40px"></a></td>
												</tr>
											</tbody>
										</c:forEach>
									</table>
								</div>
								<p class="mt-5 mb-3 text-muted text-center">&copy;
									14.06.2020</p>
							</div>
							<div class="tab-pane" id="checked">
								<div id="calendar">cho bang diem danh vao day nhe mn</div>
							</div>

							<!-- ------------------Edit Class------------------------------------ -->
							<div class="tab-pane" id="editClass">
								<form class="form shadow-sm"
									action="<%=request.getContextPath()%>/editClass" method="post">
									<input type="hidden" name="idClass" value="${class1.getClassId() }">
									<div class="form-group row">
										<label for="admin-account" class="col-sm-2 col-form-label">Class
											Code</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												value="${class1.getClassCode() }" id="class-code" name="classCode"> 
										</div>
									</div>
									<div class="form-group row">
										<label for="admin-account" class="col-sm-2 col-form-label">ClassAdmin</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												value="${class1.getAdminAccount() }" id="admin-account" name="adminAccount"
												readonly>
										</div>
									</div>
									<div class="form-group row">
										<label for="admin-account" class="col-sm-2 col-form-label">Course</label>
										<div class="col-sm-10">
											<select class="custom-select" id="inputGroupSelect01" name = "courseId">
												<option>${class1.getCourse().getCourseName() }</option>
												<c:forEach items="${listCourse }" var="course1">
													<option value="${course1.courseId }">
														${course1.courseName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label for="expected-start-date"
											class="col-sm-2 col-form-label">Expected Start Date</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												id="expected-start-date" name ="expectedStartDate"
												value="${class1.getExpectedStartDate() }"
												name="expectedStartDate">
										</div>
									</div>
									<div class="form-group row">
										<label for="expected-end-date" class="col-sm-2 col-form-label">Expected
											End Date</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												id="expected-end-date" name ="expectedEndDate"
												value="${class1.getExpectedEndDate() }"
												name="expectedEndDate">
										</div>
									</div>
									<div class="form-group row">
										<label for="actual-start-date" class="col-sm-2 col-form-label">Actual
											Start Date</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												id="actual-start-date" name ="actualStartDate"
												value="${class1.actualStartDate }"
												name="actualStartDate">
										</div>
									</div>
									<div class="form-group row">
										<label for="actual-end-date" class="col-sm-2 col-form-label">Actual
											Start Date</label>
										<div class="col-sm-10">
											<input type="text" class="form-control shadow-sm"
												id="actual-end-date" name ="actualEndDate"
												value="${class1.actualEndDate}"
												name="actualEndDate">
										</div>
									</div>
									<!-------------------------------- Testing-------------------------------------- -->

									<div class="form-group row">
										<div class="col-sm-4">
											<button type="submit" class="btn btn-info shadow-sm">Save
												edit</button>
										</div>
									</div>
								</form>
							</div>
							<!-- ----------------------------------------------------------------- -->

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>