const api = {
    customer: new Customer()
};

document.addEventListener("DOMContentLoaded", event => {

    document.forms.login.addEventListener("submit", event => {
        event.preventDefault();
        api.customer.login(event.target.idCard.value, event.target.password.value).then(data => {
            sessionStorage.setItem("token", data.token);
            sessionStorage.setItem("customer", JSON.stringify(data.customer));
            location.href = "main.html";
            // console.log("ok");
        }).catch(error => {
            console.error(error);
        });
    }, false); 

    document.forms.register.addEventListener("submit", event => {
        event.preventDefault();
        api.customer.save({"idCard": event.target.idCard.value,
                            "name":event.target.name.value, 
                            "gender":event.target.gender.value,
                            "birthday": event.target.birthday.value,
                            "address": event.target.address.value,
                            "payment": event.target.payment.value,
                            "points": 0,
                            "status": true,
                            "password":event.target.password.value}).then(data => {
            sessionStorage.setItem("customer", JSON.stringify(data.customer));
            location.href = "main.html";
            // console.log("ok");
        }).catch(error => {
            console.error(error);
        });
    }, false);

document.getElementById("iniciarSesion").addEventListener("click", iniciarSesion);
document.getElementById("registrarse").addEventListener("click", register);
window.addEventListener("resize", anchoPage);

//Declarando variables
var formularioLogin = document.querySelector(".formularioLogin");
var formularioRegister = document.querySelector(".formularioRegister");
var contenedorLoginRegister = document.querySelector(".contenedorLoginRegister");
var cajaTraseraLogin = document.querySelector(".cajaTraseraLogin");
var cajaTraseraRegister = document.querySelector(".cajaTraseraRegister");

//FUNCIONES

function anchoPage(){

    if (window.innerWidth > 850){
        cajaTraseraRegister.style.display = "block";
        cajaTraseraLogin.style.display = "block";
    }else{
        cajaTraseraRegister.style.display = "block";
        cajaTraseraRegister.style.opacity = "1";
        cajaTraseraLogin.style.display = "none";
        formularioLogin.style.display = "block";
        contenedorLoginRegister.style.left = "0px";
        formularioRegister.style.display = "none";   
    }
}

anchoPage();


function iniciarSesion(){
    if (window.innerWidth > 850){
        formularioLogin.style.display = "block";
        contenedorLoginRegister.style.left = "10px";
        formularioRegister.style.display = "none";
        cajaTraseraRegister.style.opacity = "1";
        cajaTraseraLogin.style.opacity = "0";
    }else{
        formularioLogin.style.display = "block";
        contenedorLoginRegister.style.left = "0px";
        formularioRegister.style.display = "none";
        cajaTraseraRegister.style.display = "block";
        cajaTraseraLogin.style.display = "none";
    }
}

function register(){
    if (window.innerWidth > 850){
        formularioRegister.style.display = "block";
        contenedorLoginRegister.style.left = "410px";
        formularioLogin.style.display = "none";
        cajaTraseraRegister.style.opacity = "0";
        cajaTraseraLogin.style.opacity = "1";
    }else{
        formularioRegister.style.display = "block";
        contenedorLoginRegister.style.left = "0px";
        formularioLogin.style.display = "none";
        cajaTraseraRegister.style.display = "none";
        cajaTraseraLogin.style.display = "block";
        cajaTraseraLogin.style.opacity = "1";
    }
}

}, false); 
