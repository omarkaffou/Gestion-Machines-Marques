$(document).ready(function () {
//alert("test");
    $.ajax({
        url: "MarqueController",
        data: {action: "charge"},
        method: "POST",
        success: function (data) {
//console.log(data);
            listerMarque(data);
        },
        error: function () {
//console.log(error);
        }
    });

    $("#submitMarque").click(function () {
        if (parseInt($("#inputId").val()) === 0) {
            var code = $("#inputCode").val();
            var libelle = $("#inputLibelle").val();
            var username = $("#userId").val();


            if ($("#inputCode").val() !== " " && $("#inputLibelle").val() !== " ")
            {



                $.ajax({
                    url: "MarqueController",
                    data: {action: "add", code: code, libelle: libelle, username: username},
                    method: "POST",
                    success: function (data) {

                        listerMarque(data);
                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
                $("#code").val("");
                $("#libelle").val("");

            }
        }
    });

    $("#submitMarqueUpdate").click(function () {
        if (parseInt($("#inputId").val()) !== 0) {
            var code = $("#inputCode").val();
            var libelle = $("#inputLibelle").val();
            var id = $("#inputId").val();
            console.log("update" + id);
            var username = $("#userId").val();
            if ($("#inputCode").val() !== " " && $("#inputLibelle").val() !== " ")
            {
                $.ajax({
                    url: "MarqueController",
                    data: {action: "update", id: id, code: code, libelle: libelle, username: username},
                    method: "POST",
                    success: function (data) {
                        console.log("her hna");
                        console.log(data);
                        listerMarque(data);
                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
                $("#inputCode").val("");
                $("#inputLibelle").val("");
                $("#inputId").val("");
            }
        }
    });


    $("#contentmarque").on('click', '.badge', function () {
// alert($(this).attr("indice"));
        var username = $("#userId").val();
        if ($(this).attr("role") === "delete") {
            $.ajax({
                url: "MarqueController",
                data: {action: "delete", id: $(this).attr("indice"), username: username},
                method: "POST",
                success: function (data) {
                    console.log(data);
                    alert("Voulez-vous vraiment supprimer cette marque ?")
                    listerMarque(data);
                },
                error: function (error) {
                    console.log(error);
                }
            });
        } else {
            $.ajax({
                url: "MarqueController",
                data: {action: "edit", id: $(this).attr("indice")},
                method: "POST",
                success: function (data) {



                    $("#inputId").val(data.id);
                    $("#inputCode").val(data.code);
                    $("#inputLibelle").val(data.libelle);


                },
                error: function () {
                    console.log(error);
                }
            });
        }
    });


    function listerMarque(data) {
        var ligne = " ";
        var option = " ";



// console.log(data);



        data.forEach(function (e) {
            ligne += "<tr><th scope='row'>" + e.id + "</th><td>"
                    + e.code + "</td><td>" + e.libelle + "</td>"
                    + "<td><button role='delete' indice="
                    + e.id + " class='badge badge-warning'>Supprimer</button>&nbsp;&nbsp;&nbsp;<button indice="
                    + e.id + " class='badge badge-secondary'>Modifier</button></td> </tr>";

            option += "<option value=" + e.id + " >" + e.libelle + "</option>";
        });
        $("#contentmarque").html(ligne);
        $("#inputMarque").html(option);
        $("#inputMarqueSearch").html(option);




    }

});