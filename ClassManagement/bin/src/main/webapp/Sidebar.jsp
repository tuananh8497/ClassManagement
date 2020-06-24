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

	<title>menu</title>
</head>
<body>
    <!-- Sidebar  -->
    <div class="col-2">
        <nav  id="sidebar" class="border-right shadow ">
            <ul class="list-unstyled components bg-light ">
                <li class="active border-bottom">
                    <a href="<%= request.getContextPath()%>/home">Home</a>
                </li>
                <li >
                    <a href="#class" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Classes</a>
                    <ul class="collapse list-unstyled border-bottom" id="class">
                        <li>
                            <a href="<%= request.getContextPath()%>/showClass">Show classes</a>
                        </li>
                        <li>
                            <a href="<%= request.getContextPath()%>/addClass">Add class</a>
                        </li>
                        <li>
                            <a href="<%= request.getContextPath()%>/editClass">Edit class</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#student" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Students</a>
                    <ul class="collapse list-unstyled border-bottom" id="student">
                        <li>
                            <a href="<%= request.getContextPath()%>/showStudent">Show students</a>
                        </li>
                        <li>
                            <a href="<%= request.getContextPath()%>/addStudent">Add student</a>
                        </li>
                        <li>
                            <a href="<%= request.getContextPath()%>/editStudent">Edit student</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#mentor" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Mentors</a>
                    <ul class="collapse list-unstyled border-bottom" id="mentor">
                        <li>
                            <a href="<%= request.getContextPath()%>/showMentor">Show mentors</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="<%= request.getContextPath()%>/profile" class="border-bottom">Own profile</a>
                </li>
                <li>
                    <a href="<%= request.getContextPath()%>/contact">Contact</a>
                </li>
            </ul>
        </nav>
    </div>
</body>
</html>