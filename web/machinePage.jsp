FF<%

//if(session.getAttribute("username") == null){
//response.sendRedirect("login.jsp");
//}
%>
<!DOCTYPE html>
<html lang="en">



    <head>



        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">



        <title>SB Admin 2 - Tables</title>



        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
        <script src="scripte/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="scripte/machine.js" type="text/javascript"></script>
        <script src="scripte/marque.js" type="text/javascript"></script>
        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">



        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">



    </head>



    <body id="page-top">



        <!-- Page Wrapper -->
        <div id="wrapper">




            <%@include file="template/header.jsp" %>

            <div id="content-wrapper" class="d-flex flex-column">



                <!-- Main Content -->
                <div id="content">




                    <!-- End of Topbar -->



                    <!-- Begin Page Content -->

                    <div class="container-fluid">



                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                        <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                            For more information about DataTables, please visit the <a target="_blank"
                                                                                       href="https://datatables.net">official DataTables documentation</a>.</p>





                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">

                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Gestion des machines</h6>
                            </div>

                            <div class="card-body">

                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="inputId" value="0">
                                    <input type="hidden" class="form-control" id="userId" value=${username}>
                                    <label for="reference">reference</label>
                                    <input type="text" class="form-control" id="inputReference" placeholder="reference">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="reference">date Achat</label>
                                    <input type="date" class="form-control" id="inputDateAchat" placeholder="date achat">
                                </div>
                                <div class="form-group ">
                                    <label for="prix">prix</label>
                                    <input type="text" class="form-control" id="inputPrix" placeholder="prix">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="inputMarque">marques</label>
                                    <select id="inputMarque" class="form-control">
                                        <option >choisir ...</option>

                                    </select>
                                </div>
                                <div class="form-check">

                                </div>

                                <button class="btn btn-success btn-icon-split" id="submitMachine">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-check"></i>
                                    </span>
                                    <span class="text">ajouter</span>
                                </button>
                                <button class="btn btn-warning btn-icon-split" id="submitMachineUpdate">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-exclamation-triangle"></i>
                                    </span>
                                    <span class="text">update</span>
                                </button>

                                <hr/>
                                <br> <hr>


                                <div class="form-inline my-6 my-lg-0">
                                    <label for="inputMarqueSearch">chercher par marques :</label>
                                    <select class="form-control mr-sm-6" id="inputMarqueSearch">

                                    </select>



                                    <button type="submit" class="btn btn-primary" id="search">chercher</button>
                                </div>
                                <br/>
                                <div class="form-inline my-6 my-lg-0">
                                    <label for="searchByDate">chercher par date :</label>



                                    <input class="form-control mr-sm-2" type="date" placeholder="Search" aria-label="Search" id="date1" >
                                    <input class="form-control mr-sm-2" type="date" placeholder="Search" aria-label="Search" id="date2">
                                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="searchByDate">Search</button>
                                </div>

                                <hr/>
                                <br> <hr>
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>reference</th>
                                                <th>date d'Achat</th>
                                                <th>marque</th>
                                                <th>prix</th>
                                                <th>action</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>id</th>
                                                <th>reference</th>
                                                <th>date d'Achat</th>
                                                <th>marque</th>
                                                <th>prix</th>
                                                <th>action</th>
                                            </tr>
                                        </tfoot>
                                        <tbody id="contentmachine" >




                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>



                    </div>
                    <!-- /.container-fluid -->



                </div>
                <!-- End of Main Content -->




                <!-- End of Footer -->



            </div>
            <!-- End of Content Wrapper -->



        </div>
        <!-- End of Page Wrapper -->



        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>



        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>



        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>



        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>



        <!-- Page level custom scripts -->



    </body>



</html>