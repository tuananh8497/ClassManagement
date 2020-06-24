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

cript>
</head>

<body>
       <jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">     
		<jsp:include page="../Sidebar.jsp"></jsp:include>
        <!-- Page Content  -->
        <div id="content" class="container form">
            <div class="m-4">
                <h4 class="text-center">Form edit a student</h4>
                <hr>
            </div>
            <form role="form">
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="A1">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Name</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="a1">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Date of birth</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="url" value="01.01.2020">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Email</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="email" value="email@">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">School</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="abc">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Skill</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text"  value="N/A">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Hobbies</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="N/A">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Class account</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="HN02_CPL_Java03">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Admin account</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" value="QuyLV2">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label"></label>
                    <div class="col-lg-9">
                        <button type="button" class="btn btn-info"><a href="/student/showStudents.html">Save and changes</a></button>
                        <button type="button" class="btn btn-secondary"><a href="/student/editStudent.html">Cancel</a></button>
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