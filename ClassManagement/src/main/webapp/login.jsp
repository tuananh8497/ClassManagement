<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Class Management - Login</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Fontawesome CSS -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="/ClassManagement/css/login-style.css">
</head>

<body class="loginForm ">
	<div class="loginbox mx-auto">
		<div class="text-center pt-3 pb-0">
			<img src="./image/logo.png" alt="Logo">
		</div>

		<h1 class="text-center pt-1 pb-2">Login</h1>

		<form method="post" action="<%=request.getContextPath()%>/login">
			<p class="mb-1">Username</p>
			<div class="textbox mb-3 mt-0 pb-1">
				<i class="fas fa-user"></i> <input type="text" name="username"
					placeholder="Enter Username" required>
			</div>

			<p class="mb-1">Password</p>
			<div class="textbox mb-3 mt-0 pb-1">
				<i class="fas fa-lock"></i> <input type="password" name="password"
					placeholder="Enter Password" required>
			</div>

			<input class="mt-2" type="submit" name="btnsubmit" value="Login">
		</form>

		<div class="text-center mt-3">
			<input type="checkbox"> Stay signed in
		</div>

		<div class="text-center mt-2">
			<a href="#">Lost your password?</a><br>
		</div>
	</div>
</body>

</html>