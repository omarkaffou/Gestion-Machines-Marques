$(document).ready(function(){     
$("#login").click(function () {
    var username=$("#username").val();
    var password=$("#password").val();
    alert(username + password);
        $.ajax({
            url: "UserController",
            data: { username: username, password: password},
            method: "POST",
            success: function (data) {
                console.log("!-!-!-!");
               console.log(data);
            },
            error: function () {
                console.log("------>");
            }
        });
        $("#username").val("");
        $("#password").val("");     
    });
});
    
   
  
   
    


