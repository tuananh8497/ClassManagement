 <!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Class management project</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >   
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="/ClassManagement/css/style.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" ></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" ></script>

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
    <nav class="navbar navbar-expand-lg navbar-primary fixed-top shadow-sm ">
        <div class="container-fluid">
            <a class="navbar-brand" href="/home.html">Navbar</a>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-align-justify"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">...</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Log out </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar" class="border-right shadow ">
            <ul class="list-unstyled components bg-light ">
                <li class="border-bottom">
                    <a href="/home.html">Home</a>
                </li>
                <li class="active">
                    <a href="#class" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Classes</a>
                    <ul class="collapse list-unstyled border-bottom" id="class">
                        <li>
                            <a href="/class/showClasses.html">Show classes</a>
                        </li>
                        <li>
                            <a href="/class/addClass.html">Add class</a>
                        </li>
                        <li>
                            <a href="/class/editClass.html">Edit class</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#student" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Students</a>
                    <ul class="collapse list-unstyled border-bottom" id="student">
                        <li>
                            <a href="/student/showStudents.html">Show students</a>
                        </li>
                        <li>
                            <a href="/student/addStudent.html">Add student</a>
                        </li>
                        <li>
                            <a href="/student/editStudent.html">Edit student</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#mentor" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle border-bottom">Mentors</a>
                    <ul class="collapse list-unstyled border-bottom" id="mentor">
                        <li>
                            <a href="/mentor/showMentor.html">Show mentors</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/profile.html" class="border-bottom">Own profile</a>
                </li>
                <li>
                    <a href="/contact.html">Contact</a>
                </li>
            </ul>
        </nav>

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
                                        <button type="button" class="btn btn-info"><a href="/student/addStudent.html">Add student</a></button>
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
                                                    <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>A2</td>
                                                <td>a2</td>
                                                <td>02.02.2020</td>
                                                <td>HN_CPL_Java03</td>
                                                <td>8.2</td>
                                                <td>
                                                    <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>A3</td>
                                                <td>a3</td>
                                                <td>03.03.2020</td>
                                                <td>HN_CPL_Java03</td>
                                                <td>8.3</td>
                                                <td>
                                                    <a href="/student/profile.html"><img src="/icon/alien.svg" width="40px" height="40px"></a>
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