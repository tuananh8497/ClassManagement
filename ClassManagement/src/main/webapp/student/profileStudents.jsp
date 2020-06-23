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



    <script>
        window.onload = function () {
        
        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light2",
            title:{
                text: "Graph of student mark"
            },
            axisY:{
                includeZero: false
            },
            data: [{        
                type: "line",
                  indexLabelFontSize: 16,
                dataPoints: [
                    { y: 450 },
                    { y: 414 },
                    { y: 520 },
                    { y: 460 },
                    { y: 450 },
                    { y: 500 },
                    { y: 480 },
                    { y: 480 },
                    { y: 410 },
                    { y: 500 },
                    { y: 480 },
                    { y: 510 }
                ]
            }]
        });
        chart.render();
        
        }
    </script>
</head>

<body>
       <jsp:include page="../header.jsp"></jsp:include>
    <div class="wrapper">     
		<jsp:include page="../Sidebar.jsp"></jsp:include>

        <!-- Page Content  -->
        <div id="content">
            <div class="container-fluid">
                <div class="row my-2">
                    <div class="col-lg-8 order-lg-2">
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a href="" data-target="#profile" data-toggle="tab" class="nav-link">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a href="" data-target="#mark" data-toggle="tab" class="nav-link active">Mark</a>
                            </li>
                            <li class="nav-item">
                                <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Edit student</a>
                            </li>
                        </ul>
                        <div class="tab-content py-4">
                            <div class="tab-pane" id="profile">
                                <h5 class="mb-3">User Profile</h5>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h6>Info</h6>
                                        <p> Name: Nguyen Trong Tung<br>
                                            Gender: Male<br>
                                            Age: 23<br>
                                            Email:
                                        </p>
                                        <h6>Hobbies</h6>
                                        <p>
                                            Game.
                                        </p>
                                    </div>
                                    <div class="col-md-6">
                                        <h6>Recent badges</h6>
                                        <a href="#" class="badge badge-info">html5</a>
                                        <a href="#" class="badge badge-info">css3</a>
                                        <a href="#" class="badge badge-info">bootstrap</a><br>
                                        <a href="#" class="badge badge-info">responsive-design</a>
                                    </div>
                                    <div class="col-md-12">
                                        <h5 class="mt-2">What classes learned</h5>
                                        <table class="table table-sm table-hover table-striped">
                                            <tbody>                                    
                                                <tr>
                                                    <td>
                                                        <strong>HN_CPL_Java03</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Coming soon . . .
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        .
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!--/row-->
                            </div>
                            <div class="tab-pane active" id="mark">
                                <div id="chartContainer" style="height: 370px; width: 100%;" class="graph shadow-sm"></div>
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
                            <div class="tab-pane" id="edit">
                                <div>
                                    <h4 class="text-center">Form edit a student</h4>
                                    <hr>
                                </div>
                                <form role="form">
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" placeholder="Your account . . .">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Name</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" placeholder="Your name . . .">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Date of birth</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="url" value="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Email</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="email" placeholder="email@">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">School</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" value="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Address</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" value="" placeholder="Street">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Account</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" placeholder="Your account">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label border-bottom">Password</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="password" placeholder="Password. . .">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="password" placeholder="Password again. . .">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label"></label>
                                        <div class="col-lg-9">
                                            <input type="button" class="btn btn-info" value="Save Changes">
                                            <input type="reset" class="btn btn-secondary" value="Cancel">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 order-lg-1 text-center">
                        <img src="/icon/alien.svg" class="mx-auto img-fluid img-circle d-block" alt="avatar" width="150px" height="150px">
                        <br>
                        <h6>Nguyen Trong Tung</h6>
                    </div>
                </div>
            </div>
            <!-- <p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p> -->
        </div>
    </div>

    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>