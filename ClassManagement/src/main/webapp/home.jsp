<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Class management project</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/ClassManagement/css/style.css">
<link rel="stylesheet" href="css/main.css" />
<link
	href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700,900&display=swap"
	rel="stylesheet" />
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="Sidebar.jsp"></jsp:include>
		<!-- Page Content  -->
		<div id="content">
			<div class="line"></div>
			<div class="box">
				<h2>Economic Calendar (TEST)</h2>
				<iframe
					src="https://sslecal2.forexprostools.com?columns=exc_flags,exc_currency,exc_importance,exc_actual,exc_forecast,exc_previous&features=datepicker,timezone&countries=25,34,32,6,37,72,71,22,17,51,39,14,33,10,35,43,60,38,36,110,11,26,9,12,4,5&calType=week&timeZone=31&lang=70"
					width="800" height="800" frameborder="0" allowtransparency="true"
					marginwidth="0" marginheight="0"></iframe>
			</div>
			<!-- ------------------------------------TESTING--------------------------------------- -->
			<div class="line"></div>
			<div class="box">
				<div class="all-tasks">
					<h2 class="task-list-title">My lists</h2>
					<ul class="task-list" data-lists></ul>

					<form action="" data-new-list-form>
						<input type="text" class="new list" data-new-list-input
							placeholder="new list name" aria-label="new list name" />
						<button class="btn create" aria-label="create new list">+</button>
					</form>
				</div>

				<div class="todo-list" data-list-display-container>
					<div class="todo-header">
						<h2 class="list-title" data-list-title>YouTube</h2>
						<p class="task-count" data-list-count>3 tasks remaining</p>
					</div>

					<div class="todo-body">
						<div class="tasks" data-tasks></div>

						<div class="new-task-creator">
							<form action="" data-new-task-form>
								<input type="text" data-new-task-input class="new task"
									placeholder="new task name" aria-label="new task name" />
								<button class="btn create" aria-label="create new task">+</button>
							</form>
						</div>

						<div class="delete-stuff">
							<button class="btn delete" data-clear-complete-tasks-button>Clear
								completed tasks</button>
							<button class="btn delete" data-delete-list-button>Delete
								list</button>
						</div>
					</div>
				</div>
			</div>
			<div class="box">
				<div id="line"></div>
				<template id="task-template">
					<div class="task">
						<input type="checkbox" /> <label> <span
							class="custom-checkbox"></span>
						</label>
					</div>
				</template>
			</div>
		</div>
		<!-- ------------------------------------TESTING--------------------------------------- -->

		<div class="box">
			<h2>Lorem Ipsum Dolor</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
		<div class="line"></div>
		<div class="box">
			<h2>Lorem Ipsum Dolor</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
		<p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
	</div>
	<script defer src="/ClassManagement/js/script.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>