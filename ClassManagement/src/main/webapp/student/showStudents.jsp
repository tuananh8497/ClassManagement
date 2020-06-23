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
        <div id="content" class="container-fluid">
            <div class=" order-lg-2">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a href="" data-target="#account" data-toggle="tab" class="nav-link active">Account</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#name" data-toggle="tab" class="nav-link ">Name</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#classAccount" data-toggle="tab" class="nav-link">Class account</a>
                    </li>
                </ul>
                <div class="tab-content py-4">
                    <div class="tab-pane active" id="account">
                        <label for="colFormLabel" class="col-form-label mt-2"><h5>Search by student account</h5></label>
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                            <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <table class="table table-striped my-4 shadow-sm">
                        <thead>
                            <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                            <th scope="col">Profile</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>
                                <a href="<%= request.getContextPath()%>/profileStudent"><img src="/ClassManagement/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                            
                        </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="name">
                        <label for="colFormLabel" class="col-form-label mt-2"><h5>Search by student name</h5></label>
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                            <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <table class="table table-striped my-4 shadow-sm">
                        <thead>
                            <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                            <th scope="col">Profile</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                            <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                            <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="classAccount">
                        <label for="colFormLabel" class="col-form-label mt-2"><h5>Search by class account</h5></label>
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                            <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <table class="table table-striped my-4 shadow-sm">
                        <thead>
                            <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                            <th scope="col">Profile</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                            <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                            <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>
                                <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                            </td>
                            </tr>
                        </tbody>
                        </table>
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