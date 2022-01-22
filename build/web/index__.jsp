<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
        <!--  <script src="scripte/statistique.js" type="text/javascript"></script> -->
        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
    </head>
    <%

        //if (session.getAttribute("username") == null) {
           // response.sendRedirect("login.jsp");
        //}
    %>
    <body id="page-top">
        <div id="wrapper">
            <%@include file="template/header.jsp" %>
            <%@include file="template/navigation.jsp" %>


        </div>             
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/chart-bar-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>
    </body>
</html>