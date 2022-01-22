$(document).ready(function () {
    $.ajax({
        url: "MachineController",
        data: {action: "load"},
        method: "POST",
        success: function (data) {
            console.log(data);
            listerMachine(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
    $("#submitMachine").click(function () {

        if (parseInt($("#inputId").val()) === 0)
        {

            var reference = $("#inputReference").val();
            var prix = $("#inputPrix").val();
            var date = $("#inputDateAchat").val();
            var marque = $("#inputMarque").val();
            var username = $("#userId").val();

            if (reference !== "" && prix !== " " && date !== " " && marque !== " ") {

                $.ajax({
                    url: "MachineController",
                    data: {action: "add", reference: reference, prix: prix, date: date, marque: marque, username: username},
                    method: "POST",
                    success: function (data) {
                        listerMachine(data);
                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
                $("#inputReference").val("");
                $("#inputPrix").val("");
                $("#inputDateAchat").val("");
                $("#inputMarque").val("");
            }
        }
    });

    $("#search").click(function () {
        console.log("heeey");
// console.log("helloe");
        var id = $("#inputMarqueSearch").val();
        console.log(id);
        $.ajax({
            url: "MachineController",
            data: {action: "search", id: id},
            method: "POST",
            success: function (data) {
                console.log(data);
                listerMachine(data);
            },
            error: function (error) {
                console.log(error);
            }
        });
    });

    $("#searchByDate").click(function () {
        console.log("helloe");
        var date1 = $("#date1").val();
        var date2 = $("#date2").val();
        console.log(date1 + " " + date2);
        $.ajax({
            url: "MachineController",
            data: {action: "searchByDate", date1: date1, date2: date2},
            method: "POST",
            success: function (data) {
                console.log("rah dkhel");
                console.log(data);
                listerMachine(data);
            },
            error: function () {
                console.log("error");
            }
        });
    });


    $("#submitMachineUpdate").click(function () {
        if (parseInt($("#inputId").val()) !== 0)

        {

            var reference = $("#inputReference").val();
            var prix = $("#inputPrix").val();
            var id = $("#inputId").val();
            var username = $("#userId").val();
            console.log("update" + id);
            if ($("#inputReference").val() !== " " && parseInt($("#inputPrix").val()) !== " ") {

                $.ajax({
                    url: "MachineController",
                    data: {action: "update", id: id, reference: reference, prix: prix, username: username},
                    method: "POST",
                    success: function (data) {
                        console.log(data);

                        listerMachine(data);
                    },
                    error: function (data) {

                        console.log("err" + data);
                    }

                });

            }
        }
    });
    $("#contentmachine").on("click", '.badge', function () {

        if ($(this).attr("data-role") === "delete") {

            $.ajax({
                url: 'MachineController',
                data: {action: "delete", id: $(this).attr("indice")},
                method: "POST",
                success: function (data) {
                    alert("Voulez-vous vraiment supprimer cette machine ?")
                    listerMachine(data);

                },
                error: function (data) {

                    console.log(data);
                }
            });
        } else {

            $.ajax({
                url: 'MachineController',
                data: {action: "edit", id: $(this).attr("indice")},
                method: "POST",
                success: function (data) {

                    $("#inputReference").val(data.reference);
                    $("#inputPrix").val(data.prix);
                    $("#inputId").val(data.id);
                },
                error: function (data) {
                    console.log(data);
                }
            });
        }
    });
    function listerMachine(data) {
        var ligne = " ";

        data.forEach(function (e) {
            ligne += "<tr><th scope='row'>" + e.id + "</th>"
                    + "<td >" + e.reference + "</td>"
                    + "<td>" + e.dateAchat + "</td>"
                    + "<td>" + e.marque.libelle + "</td>"
                    + "<td>" + e.prix + "</td>"
                    + "<td><button indice=" + e.id + " data-role='delete' class='badge badge-warning'>Supprimer</button>&nbsp;&nbsp;&nbsp;<button indice=" + e.id + " data-role='update' class='badge badge-secondary'>Modifier</button></td></tr>";
        });
        $("#contentmachine").html(ligne);

    }
});