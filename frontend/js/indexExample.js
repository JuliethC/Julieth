document.addEventListener("DOMContentLoaded", event => {

    const API = "http://localhost:8080";
    var params = new URLSearchParams();
    params.append("idCard", prompt("Ingrese su cédula"));
    params.append("password", prompt("Ingrese su contraseña"));
    fetch(API + "/customers/login", {
        "method": "POST", 
        "mode": "cors",
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded" 
        },
        "body": params 
    }).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).then(data => {
        alert("BIENVENID@ " + data.user.name);
    });

}, false); 