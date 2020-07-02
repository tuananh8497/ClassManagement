<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<link rel="stylesheet" href="/ClassManagement/css/style.css">

<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>

<title>menu</title>
</head>
<body>
	<!-- Sidebar  -->
	<div class="col-2">
		<nav id="sidebar" class="border-right shadow ">
			<ul class="list-unstyled components bg-light ">
				<li class="active border-bottom"><a
					href="<%=request.getContextPath()%>/home">Home</a></li>
				<li><a href="#class" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle border-bottom">Classes</a>
					<ul class="collapse list-unstyled border-bottom" id="class">
						<li><a href="<%=request.getContextPath()%>/showClass">Show
								classes</a></li>
						<li><a href="<%=request.getContextPath()%>/addClass">Create
								Class</a></li>
					</ul></li>
				<li><a href="#student" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle border-bottom">Students</a>
					<ul class="collapse list-unstyled border-bottom" id="student">
						<li><a href="<%=request.getContextPath()%>/showStudent">Show
								students</a></li>
						<li><a href="<%=request.getContextPath()%>/createStudent">Create
								student</a></li>
					</ul></li>
				<li><a href="#tkb" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle border-bottom">Timetable</a>
					<ul class="collapse list-unstyled border-bottom" id="tkb">
						<li><a href="<%=request.getContextPath()%>/showTimetable">Show Timetable</a></li>
						<li><a href="<%=request.getContextPath()%>/createTimetable">Create Timetable</a></li>
						<li><a href="<%=request.getContextPath()%>/createCourseSubject">Create Course/Timetable</a></li>
					</ul></li>
				<li><a href="#mentor" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle border-bottom">Mentors</a>
					<ul class="collapse list-unstyled border-bottom" id="mentor">
						<li><a href="<%=request.getContextPath()%>/showMentor">Show
								mentors</a></li>
					</ul></li>
				<li><a href="<%=request.getContextPath()%>/profile"
					class="border-bottom">Own profile</a></li>
				<li><a href="<%=request.getContextPath()%>/contact">Contact</a>
				</li>
			</ul>
		</nav>
	</div>
</body>
</html>