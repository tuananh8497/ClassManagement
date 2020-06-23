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

</head>

<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">     
		<jsp:include page="../Sidebar.jsp"></jsp:include>
		
        <!-- Page Content  -->
        <div class="container">
            <div class="container-fluid pt-4">
                <div class="row my-2">
                    <div class="col-4 text-center">
                        <img src="/ClassManagement/icon/user.svg" class="mx-auto img-fluid mb-3" alt="avatar" width="150px" height="150px">
                        
                        <h6>Lam Thi Huong</h6>
                        <div class="pt-2">
                            <a href="https://www.facebook.com/"><img src="/icon/facebook.svg" class="mx-1" width="25em" height="25em"></a>
                            <a href="https://www.instagram.com/"><img src="/icon/instagram-sketched.svg" class="mx-1" width="25em" height="25em"></a>
                            <a href="https://www.pinterest.com/"><img src="/icon/pinterest.svg" class="mx-1" width="25em" height="25em"></a>
                        </div>
                    </div>
                    <div class="col-8">
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a href="" data-target="#classes" data-toggle="tab" class="nav-link ">Classes</a>
                            </li>
                            <li class="nav-item">
                                <a href="" data-target="#contact" data-toggle="tab" class="nav-link">Contact</a>
                            </li>
                        </ul>
                        <div class="tab-content py-4">
                            <div class="tab-pane active" id="profile">
                                <h5 class="mb-3">ABOUT ME</h5>
                                
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <table class="table table-borderless">
                                                <tbody>
                                                    <tr>
                                                        <th>Name:</th>
                                                        <td>Lam Thi Huong</td>
                                                    </tr>
                                                    <tr>   
                                                        <th>Gender:</th>
                                                        <td>Female</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Age:</th>
                                                        <td>?</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Email:</th>
                                                        <td>email@ttt</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Relationship:</th>
                                                        <td>?</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="col-6">
                                            One of three columns
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                            </div>
                            <div class="tab-pane" id="classes">
                                <table class="table table-striped text-center">
                                    <thead>
                                      <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Subject</th>
                                        <th scope="col">Mark</th>
                                        <th scope="col">Notes</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                      <tr>
                                        <th scope="row">1</th>
                                        <td>Java core</td>
                                        <td>7</td>
                                        <td>Good</td>
                                      </tr>
                                      <tr>
                                        <th scope="row">2</th>
                                        <td>JDBC</td>
                                        <td>7</td>
                                        <td>Moderate</td>
                                      </tr>
                                      <tr>
                                        <th scope="row">3</th>
                                        <td>Frontend</td>
                                        <td>7</td>
                                        <td>Good</td>
                                      </tr>
                                    </tbody>
                                  </table>
                            </div>
                            <div class="tab-pane" id="contact">
                                <div>
                                    <h4 class="text-center">Contact me at ...</h4>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>