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
<link rel="stylesheet" href="/ClassManagement/css/main.css" />

<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>
</head>

<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>

		<div class="wrapper">

			<jsp:include page="Sidebar.jsp"></jsp:include>
		</div>
		<!-- Page Content  -->
		<div id="content" style="padding-left: 380px;">

			<!-- ------------------------------------TESTING--------------------------------------- -->
			<div class="box" style="width: 864px;">
				<div class="all-tasks">
					<h2 class="task-list-title">TODO LIST</h2>
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
	<script defer src="/ClassManagement/js/script.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>