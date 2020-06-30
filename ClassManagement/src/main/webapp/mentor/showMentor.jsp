<%@ page language="java"
 contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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

    <title>Mentor management project</title>
	<script>
		window.setTimeout(function() {
			$(".alert").alert('close')
		}, 2000);
	</script>
</head>

<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">     
		<jsp:include page="../Sidebar.jsp"></jsp:include>
		
        <!-- Page Content  -->
        <div id="content" class="ml-4">
            <div class="box">
                <h2>Welcome to list of Mentors</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            	<button type="button" class="btn btn-info">
					<a href="<%=request.getContextPath()%>/addMentor">Add Mentor</a>
					
				</button>
            </div>
            <div class="alert alert-info" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  Welcome.. ${message }
			</div>
			<form action="<%=request.getContextPath()%>/addClassMentor" method="post">
                      <div class="input-group mb-3">
						<div class="input-group-prepend ">
						  <label class="input-group-text" for="classCode">Add class</label>
						</div>
						<select class="custom-select col-2" id="classCode" name="classCode">
							<option>1</option>	
							<option>2</option>	
						 </select>
						 <input type="text" class="form-control col-3" placeholder="" aria-label="" aria-describedby="basic-addon1">
						 <button type="submit" class="btn btn-info">Search</button>
						</div>
                     </form>
            <div class="row text-center">
            	<c:forEach items="${listMentor }" var="mentor">
                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 shadow">
                      <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">Mentor</strong>
                        <h4 class="mb-0">
                          ${mentor.name }
                        </h4>
                        <div class="mb-1 text-muted">${mentor.mentorAccount }</div>
                        <p class="card-text mb-auto">Contact: + ${mentor.email }</p>
                        <div class="form-inline">
	                        <a href="<%= request.getContextPath()%>/profile-mentor?id=<c:out value='${mentor.mentorId }' />" class="btn btn-info mt-1 mr-2">Go to profile</a>
                        	<a href="<%= request.getContextPath()%>/deleteMentor?id=<c:out value='${mentor.mentorId }' />" class="btn btn-secondary mt-1">Delete</a>
	                    </div>
                      </div>
                      <img src="/ClassManagement/icon/user.svg" width="100px" class="mr-3">
                    </div>
                </div>
                </c:forEach>  
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>