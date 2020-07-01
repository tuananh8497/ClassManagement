<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cmw.models.Person"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.lang.*"%>

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



		<div class="container-fluid ml-5">

			<!-- <div class="row w-100">
				<button id="btnDemo">Demo Ajax</button>
				<br>
				<div id="content">
					<div id="content">
						<p>hello</p>
					</div>
				</div>
			</div> -->

			<h1 class="text-center">${class1.getClassCode() }</h1>
			<div class="line"></div>
			<div class="row my-2">
				<div class="col-lg-12 order-lg-2">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a href="" data-target="#list"
							data-toggle="tab" class="nav-link active">List</a></li>
						<li class="nav-item"><a href="" data-target="#timetable"
							data-toggle="tab" class="nav-link ">Timetable</a></li>
						<li class="nav-item"><a href="" data-target="#editClass"
							data-toggle="tab" class="nav-link ">Edit Class</a></li>
						<li class="nav-item"><a href="" data-target="#addStudents"
							data-toggle="tab" class="nav-link ">Add student</a></li>
					</ul>
					<!-- -----------------------LIST----------------------------- ------------>
					<div class="tab-content py-4">
						<div class="tab-pane active" id="list">
							<!-- <div id="chartContainer" style="height: 370px; width: 100%;"
								class="graph shadow-sm"></div> -->
							<div>
								<h3 class="text-center">List of students</h3>
								<h3 class="text-center">AdminClass:
									${class1.getAdminAccount() } - Course:
									${class1.getCourse().getCourseName() }</h3>
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
												<td>${listPer.birthDate }</td>
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
							<p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
						</div>
						<!-- ------------------Timetable------------------------------------ -->
						<div class="tab-pane" id="timetable">
							<div>
								<h1>Course: ${class1.getCourse().getCourseName() } -
									Duration: ${sum }(days)</h1>
							</div>
							<div class="tbl">
								<table class="table table-striped shadow-sm text-center">
									<thead>
										<tr>
											<!-- <th scope="col">Course</th>
											<th scope="col">Course Duration</th> -->
											<th scope="col">#</th>
											<th scope="col">Subject Name</th>
											<th scope="col">Priority</th>
											<th scope="col">Duration</th>
											<th scope="col">Start Date</th>
											<th scope="col">End Date</th>
										</tr>
									</thead>
									<c:forEach items="${timetable }" var="tkb"  varStatus="loop" >
									
										<tbody>
											<tr>
												<%-- <td>${tkb.getCourse().getCourseId() } - ${tkb.getCourse().getCourseName() } </td> --%>
												<%-- <td>${tkb.getCourse().getDuration() }</td> --%>
												<td>${loop.index }</td>
												<td>${tkb.getSubject().getSubjectName()}</td>
												<td>${tkb.getPriority() }</td>
												<td>${tkb.getDuration() }</td>
												<td>${startDateMap.get(Long.valueOf(loop.index))}</td>
												<td>${endDateMap.get(Long.valueOf(loop.index))}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>

						<!-- ------------------Edit Class------------------------------------ -->
						<div class="tab-pane" id="editClass">
							<form class="form shadow-sm"
								action="<%=request.getContextPath()%>/editClass" method="post">
								<input type="hidden" name="idClass"
									value="${class1.getClassId() }">
								<div class="form-group row">
									<label for="admin-account" class="col-sm-2 col-form-label">Class
										Code</label>
									<div class="col-sm-10">
										<input type="text" class="form-control shadow-sm"
											value="${class1.getClassCode() }" id="class-code"
											name="classCode">
									</div>
								</div>
								<div class="form-group row">
									<label for="admin-account" class="col-sm-2 col-form-label">ClassAdmin</label>
									<div class="col-sm-10">
										<input type="text" class="form-control shadow-sm"
											value="${class1.getAdminAccount() }" id="admin-account"
											name="adminAccount" readonly>
									</div>
								</div>
								<div class="form-group row">
									<label for="admin-account" class="col-sm-2 col-form-label">Course</label>
									<div class="col-sm-10">
										<select class="custom-select" id="inputGroupSelect01"
											name="courseId">
											<option value="${class1.getCourse().getCourseId() }">${class1.getCourse().getCourseName() }</option>
											<c:forEach items="${listCourse }" var="course1">
												<option value="${course1.courseId }">
													${course1.courseName }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="admin-account" class="col-sm-2 col-form-label">Status</label>
									<div class="col-sm-10">
										<select class="custom-select" id="inputGroupSelect01"
											name="status">
											<option>${class1.isStatus()}</option>
											<option>true</option>
											<option>false</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="expected-start-date"
										class="col-sm-2 col-form-label">Expected Start Date</label>
									<div class="col-sm-10">
										<input type="date" class="form-control shadow-sm"
											id="expected-start-date" name="expectedStartDate"
											value="${class1.getExpectedStartDate() }">
									</div>
								</div>
								<div class="form-group row">
									<label for="expected-end-date" class="col-sm-2 col-form-label">Expected
										End Date</label>
									<div class="col-sm-10">
										<input type="date" class="form-control shadow-sm"
											id="expected-end-date" name="expectedEndDate"
											value="${class1.getExpectedEndDate() }"
											name="expectedEndDate">
									</div>
								</div>
								<div class="form-group row">
									<label for="actual-start-date" class="col-sm-2 col-form-label">Actual
										Start Date</label>
									<div class="col-sm-10">
										<input type="date" class="form-control shadow-sm"
											id="actual-start-date" name="actualStartDate"
											value="${class1.actualStartDate }" name="actualStartDate">
									</div>
								</div>
								<div class="form-group row">
									<label for="actual-end-date" class="col-sm-2 col-form-label">Actual
										Start Date</label>
									<div class="col-sm-10">
										<input type="date" class="form-control shadow-sm"
											id="actual-end-date" name="actualEndDate"
											value="${class1.actualEndDate}" name="actualEndDate">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4">
										<button type="submit" class="btn btn-info shadow-sm">Save
											edit</button>
									</div>
								</div>
							</form>
						</div>
						<!-- ------------------Add Students---------------------------------- -->
						<div class="tab-pane" id="addStudents">
							<div class="row mt-5">
								<div class="col-10 no-padding">
									<form method="get"
										action="<%=request.getContextPath()%>/addStudent">
										<div class="form-row">
											<div class="form-group input-group col-3">
												<div class="input-group-prepend">
													<label class="input-group-text" for="inputGroupSelect01">Search
														by</label>
												</div>
												<select class="form-control" id="inputGroupSelect01"
													name="searchBy">
													<option value="1">Account</option>
													<option value="2">Name</option>
													<option value="3">Class</option>
												</select>
											</div>

											<div class="col-4">
												<input type="text" class="form-control"
													placeholder="Input something..." name="searchString">
											</div>

											<div class="col-auto">
												<button class="form-control btn btn-info my-2 my-sm-0"
													type="submit">
													<i class="fas fa-search"></i> Search
												</button>
											</div>

											<div class="col-auto">
												<a class="form-control btn btn-danger my-2 my-sm-0"
													href="<%= request.getContextPath()%>/profileClass?classId=<c:out value="${class1.getClassId()}"/>">
													<i class="fas fa-sync-alt"></i> Reset
												</a>
											</div>
										</div>
									</form>
								</div>

								<%-- <div class="col-2">
										<a href="<%=request.getContextPath()%>/createStudent"
											id="addNewContact" class="btn btn-success float-right"> <i
											class="fas fa-user-plus"></i> New Student
										</a>
									</div> --%>
							</div>
							<form method="post"
								action="<%=request.getContextPath()%>/addStudent">
								<button type="submit" class="btn btn-info">Save changes</button>
								<table class="table table-striped table-bordered mt-3 shadow-sm">

									<thead class="thead-dark">
										<tr class="text-center">
											<th scope="col">#</th>
											<th scope="col">Account</th>
											<th scope="col">Name</th>
											<th scope="col">Date of birth</th>
											<th scope="col">Email</th>
											<th scope="col">Class</th>
											<th scope="col">Status</th>
											<th scope="col">Action</th>
										</tr>
									</thead>
									<tbody>
										<%
										  int i = 1;
										/* List<Person> listStudent = new ArrayList(); */
										%>
										<c:forEach items="${listStudent }" var="student">
											<%-- 	<input type="hidden" name="studentId"
												value="${student.personId }"> --%>
											<input type="hidden" name="classCode"
												value="${class1.getClassCode()}">
											<tr>
												<td class="text-right"><%=i++%></td>
												<td>${student.account }</td>
												<td>${student.name }</td>
												<td class="text-right">${student.birthDate }</td>
												<td>${student.email }</td>
												<td>${student.clazz.classCode }</td>
												<td class="text-center" style="color: green">${(student.status==true)? "active" : "inactive" }</td>
												<td class="text-center">
													<%-- <a class="mr-sm-3 text-primary"
													href="<%= request.getContextPath()%>/profileStudent?id=<c:out value='${student.personId}' />">
														<i class="fas fa-id-card"></i>
												</a>  --%> <%-- <a href="<%= request.getContextPath() %>/deleteStudent?id=<c:out value='${student.personId}' />"
													class="text-danger"><i class="fa fa-trash"></i></a>  --%> <input
													type="checkbox" class="form-check-input" name="checkBox">
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

	<script>
		$(document).ready(function() {
			$("#btnDemo").click(function() {

				$.ajax({
					url : "/ClassManagement/demoajax",
					type : "POST",
					data : {
						"data1" : "demo ajax"
					},
					success : function(result) {
						$("#content").html(result);
					}
				});

			});
		});
	</script>
</body>

</html>