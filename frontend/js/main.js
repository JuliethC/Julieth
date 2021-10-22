document.addEventListener("DOMContentLoaded", event => {

    var customer = JSON.parse(sessionStorage.getItem("customer"));
    document.querySelector("#customerName").innerHTML = customer.name;

}, false); 