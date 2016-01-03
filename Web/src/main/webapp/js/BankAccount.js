//Make sure jQuery has been loaded before app.js
if (typeof jQuery === "undefined") {
    throw new Error("jQuery is required");
}

var baseUrl = '/banks/accounts/';

/**
 * BankAccount Class
 * @param  id
 * @param  iban
 * @param  bic
 * @returns 
 */
function BankAccount(id, iban, bic) {
    //make sure that no id with 0
    if (id > 0) {
        this.id = id;
    }
    this.iban = iban;
    this.bic = bic;
}

BankAccount.prototype.validate = function () {
    if (this.iban === "" || this.bic === "") {
        this.error = 'Empty IBAN or BIC';
        return false;
    }

    if (this.iban.length !== 22) {
        this.error = "Invalid IBAN";
        return false;
    }

    if (this.bic.length !== 11) {
        this.error = "Invalid BIC";
        return false;
    }

    return true;
};

BankAccount.prototype.save = function () {
    return this.delegateError(this.sendAjax(baseUrl, 'POST', this));

};


BankAccount.prototype.update = function () {
    return this.delegateError(this.sendAjax(baseUrl + this.id, 'PUT', this));
};


BankAccount.prototype.delete = function () {
    return this.delegateError(this.sendAjax(baseUrl + this.id, 'DELETE', this));
};

BankAccount.prototype.delegateError = function (ajaxResponse) {
    if (ajaxResponse.status !== 'OK') {
        this.error = ajaxResponse.message;
        return false;
    }
    this.message = ajaxResponse.message;
    return true;
};


 BankAccount.prototype.sendAjax = function(url, type, data) {
    var ajaxResponse;

    $.ajax({
        type: type,
        url: url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(data),
        async: false,
        success: function (response) {
            if (response.data !== null) {
                data.id = response.data.id;
            }

            ajaxResponse = response;

            //notifyUser(response.message);
        },
        error: function (response, textStatus) {
            console.log("Error");
            console.log(response.status + " " + response.error);
//            notifyUser(response.message)
            ajaxResponse = response;

        }
    });

    return ajaxResponse;

}

function notifyUser(message) {
    alert(message);
}

