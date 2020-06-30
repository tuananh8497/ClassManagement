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
                        
                        <h6>${mentor.name }</h6>
                        <div class="pt-2">
                            <a href="https://www.facebook.com/"><img src="/ClassManagement/icon/facebook.svg" class="mx-1" width="25em" height="25em"></a>
                            <a href="https://www.instagram.com/"><img src="/ClassManagement/icon/instagram-sketched.svg" class="mx-1" width="25em" height="25em"></a>
                            <a href="https://www.pinterest.com/"><img src="/ClassManagement/icon/pinterest.svg" class="mx-1" width="25em" height="25em"></a>
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
                                <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Edit info</a>
                            </li>
                        </ul>
                        <div class="tab-content py-4">
                            <div class="tab-pane active" id="profile">
                                <h5 class="mb-3">ABOUT ME</h5>
                                
                                <div class="container">
                                    <div class="row">
                                        <div class="">
                                            <table class="table table-borderless">
                                                <tbody>
                                                    <tr>
                                                        <th>Name:</th>
                                                        <td>${mentor.name }</td>
                                                    </tr>
                                                    <tr>   
                                                        <th>Account:</th>
                                                        <td>${mentor.mentorAccount }</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Email:</th>
                                                        <td>${mentor.email }</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Phone:</th>
                                                        <td>${mentor.phone }</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Address:</th>
                                                        <td>${mentor.address }</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Education:</th>
                                                        <td>${mentor.education }</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Status:</th>
                                                        <td>${(mentor.status == true )? 'Active' : 'Inactive' }</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                            </div>
                            <div class="tab-pane" id="classes">
                            	<form action="<%=request.getContextPath()%>/addClassMentor" method="post">
                                   	<div class="input-group mb-3">
									  <div class="input-group-prepend ">
									    <label class="input-group-text" for="classCode">Add class</label>
									  </div>
									  <select class="custom-select col-4" id="classCode" name="classCode">
									  	<c:forEach items="${clazz }" var="clazz">
									  		<option >${clazz.classCode }</option>
									  	</c:forEach>	
									  </select>
									  <button type="submit" class="btn btn-info">Save</button>
									  <input type="hidden" name="mentorId" value="${mentor.mentorId }">
									</div>
                                   </form>
                                <table class="table table-striped text-center">
                                    <thead>
                                      <tr>
                                        <th scope="col">Class Code</th>
                                        <th scope="col">adminAccount</th>
                                        <th scope="col">course</th>
                                        <th scope="col">Status</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${classMentor }" var="classMentor">
                                      <tr>
                                        <th >${classMentor.clazz.classCode }</th>
                                        <td>${classMentor.clazz.adminAccount }</td>
                                        <td>${classMentor.clazz.course.courseName }</td>
                                        <td>${(classMentor.clazz.status == true)? "Active" : "Inactive" }</td>
                                      </tr>
                                      </c:forEach>
                                    </tbody>
                                  </table>
                            </div>
                            <div class="tab-pane" id="edit">
                                <form action="<%=request.getContextPath()%>/editMentor" method="post">
                                	<input type="hidden" name="mentorId" value="${mentor.mentorId }">
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.mentorAccount }" name="account">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Name</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.name }" name="name">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Bank account</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.bankAccount }" name="bankAccount">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Email</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="email" value="${mentor.email }" name="email">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Phone</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.phone }" name="phone">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Citizen ID</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text"  value="${mentor.citizenId }" name="citizenId">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Address</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.address }" name="address">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label border-bottom">Birth date</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.birthDate }" name="birthDate">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label">Education</label>
					                    <div class="col-lg-9">
					                        <input class="form-control" type="text" value="${mentor.education }" name="education">
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label">Status</label>
					                    <div class="col-lg-9">
					                        <select class="custom-select" name = "status">
												<option>${mentor.status }</option>
												<option>true</option>
												<option>false</option>
											</select>
					                    </div>
					                </div>
					                <div class="form-group row">
					                    <label class="col-lg-3 col-form-label form-control-label"></label>
					                    <div class="col-lg-9">
					                        <button type="submit" class="btn btn-info">Save and changes</button>
					                        <!--  <button type="button" class="btn btn-secondary"><a href="/student/editStudent.html">Cancel</a></button> -->
					                    </div>
					                </div>
					            </form>
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