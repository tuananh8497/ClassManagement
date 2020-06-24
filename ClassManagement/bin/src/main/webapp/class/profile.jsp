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


    <!-- Simple graph use canvas -->
    <script>
        window.onload = function () {
        
        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light1",
            title:{
                text: "Graph average of student mark"
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
                <h1 class="text-center">HN02_CPL_Java03</h1>
                <div class="line"></div>
                <div class="row my-2">
                    <div class="col-lg-12 order-lg-2">
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a href="" data-target="#list" data-toggle="tab" class="nav-link active">List</a>
                            </li>
                            <li class="nav-item">
                                <a href="" data-target="#checked" data-toggle="tab" class="nav-link ">Checked</a>
                            </li>
                        </ul>
                        <div class="tab-content py-4">
                            <div class="tab-pane active" id="list">
                                <div id="chartContainer" style="height: 370px; width: 100%;" class="graph shadow-sm"></div>
                                    <div>
                                        <h3 class="text-center">List of students</h3>
                                        <button type="button" class="btn btn-info"><a href="<%= request.getContextPath()%>/addStudent">Add Student</a></button>
                                    </div>
                                    <div class="tbl">
                                        <table class="table table-striped shadow-sm text-center">
                                            <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Account</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Date</th>
                                                <th scope="col">Class account</th>
                                                <th scope= "col">Average</th>
                                                <th scope="col">Profile</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>A1</td>
                                                <td>a1</td>
                                                <td>01.01.2020</td>
                                                <td>HN_CPL_Java03</td>
                                                <td>8.1</td>
                                                <td>
                                                  <a href="<%= request.getContextPath()%>/profileStudent"><img src="/ClassManagement/icon/alien.svg" width="40px" height="40px"></a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <p class="mt-5 mb-3 text-muted text-center">&copy; 14.06.2020</p>
                                </div>
                                <div class="tab-pane" id="checked">
                                    <div id="calendar">
                                        cho bang diem danh vao day nhe mn
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>