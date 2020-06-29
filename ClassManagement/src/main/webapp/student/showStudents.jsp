<%@ page import="cmw.utils.DateUtils"%>
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
		<div id="content" class="container-fluid ml-3 mr-0">
			<div class=" order-lg-2">
				<h2 class="text-center">List of student</h2>

				<div class="row mt-5">
					<div class="col-10 no-padding">
						<form method="get"
							action="<%=request.getContextPath()%>/search-student">
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
										href="<%=request.getContextPath()%>/showStudent"> <i
										class="fas fa-sync-alt"></i> Reset
									</a>
								</div>

							</div>
						</form>
					</div>

					<div class="col-2">
						<a href="<%=request.getContextPath()%>/createStudent"
							id="addNewContact" class="btn btn-success float-right"> 
							<i class="fas fa-user-plus"></i>
							New Student
						</a>
					</div>
				</div>



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
						%>
						<c:forEach items="${listStudent }" var="student">
							<tr>
								<td class="text-right"><%=i++%></td>
								<td>${student.account }</td>
								<td>${student.name }</td>
								<td class="text-right">
									${DateUtils.date2String(student.birthDate)}</td>
								<td>${student.email }</td>
								<td>${student.clazz.classCode }</td>
								<td class="text-center" style="color: green">${(student.status==true)? "active" : "inactive" }</td>
								<td class="text-center"><a class="mr-sm-3 text-primary"
									href="<%= request.getContextPath()%>/profileStudent?id=<c:out value='${student.personId}' />">
										<i class="fas fa-id-card"></i>
								</a> <a
									href="<%= request.getContextPath() %>/deleteStudent?id=<c:out value='${student.personId}' />"
									class="text-danger"><i class="fa fa-trash"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>