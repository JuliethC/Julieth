class Customer extends Entity {

    constructor() {
        super("/customers");
    }

    login(idCard, password) {
        let params = new URLSearchParams();
        params.append("idCard", idCard);
        params.append("password", password);
        return new Promise((fullfill, reject) => {
            fetch(this.api + this.endpoint + "/login", {
                "method": "POST", 
                "mode": "cors",
                "headers": {
                    "Content-Type": "application/x-www-form-urlencoded" 
                },
                "body": params 
            }).then(response => {
                if (response.ok) {
                    return response.json().then(fullfill, reject);
                } else {
                    reject(response);
                }
            }, reject);
        });
    }

}