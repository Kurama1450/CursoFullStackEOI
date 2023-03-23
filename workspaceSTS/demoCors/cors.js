$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/clientes"
    }).then(function(data, status, jqxhr) {
       $('.nombre').append(data[0].nombre);
       $('.email').append(data[0].email);
       console.log(jqxhr);
    });
});