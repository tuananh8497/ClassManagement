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
        <div id="content" class="container">
            <div class="box shadow-sm">
                <h2>Welcome to Form
                     add class</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
            <!-- Form input class information -->
            <form class="form shadow-sm">
                <div class="form-group row">
                  <label for="class-account" class="col-sm-2 col-form-label">Class Account</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control shadow-sm" id="class-account" placeholder="Input account of class you want to add . . .">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="class-name" class="col-sm-2 col-form-label">Class Name</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control shadow-sm" id="class-name" placeholder="Input name of the class account . . .">
                  </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-1">
                      <button type="submit" class="btn btn-info shadow-sm"><a href="#">Add class</a></button>
                    </div>
                </div>
            </form>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>