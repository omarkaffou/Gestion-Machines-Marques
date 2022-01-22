$(document).ready(function(){
    $.ajax({
            url: "LogsController",
            data:{action:"load"},
            method:"POST",
            success: function(data){
                listerMachine(data);
                console.log(data);
            },
            error: function(data){
                console.log(data);
            }
        });
    
    function listerMachine(data){
        var ligne=" ";
        
        data.forEach(function(e){
            ligne +="<tr><th scope='row'>"+e.id+"</th>"
              +"<td >"+e.username+"</td>"
               +"<td>"+e.operation+"</td>";
        });
        $("#contentlogs").html(ligne);
        
    }
});
