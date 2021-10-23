const api = {
    product: new Product()
};

document.forms.registerProduct.addEventListener("submit", event => {
    event.preventDefault();
    api.product.save({"id": event.target.id.value,
                        "name":event.target.name.value, 
                        "brand":event.target.brand.value,
                        "expiration": event.target.expiration.value,
                        "price": event.target.price.value,
                        "taxes": event.target.taxes.value,
                        "discount": event.target.discount.value,
                        "type":event.target.type.value}).then(data => {
        sessionStorage.setItem("product", JSON.stringify(data.product));
        location.href = "main.html";
        // console.log("ok");
    }).catch(error => {
        console.error(error);
    });
}, false);