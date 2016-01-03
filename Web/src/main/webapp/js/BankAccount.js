//Make sure jQuery has been loaded before app.js
if (typeof jQuery === "undefined") {
    throw new Error("jQuery is required");
}

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
        this.error = 'Empty IBAN/BIC';
        return false;
    }

    return true;
};


BankAccount.prototype.save = function () {
    console.log('saved');
    me = this;

    $.ajax({
        type: 'POST',
        url: '/banks/accounts/',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(this),
        async: false,
        success: function (response) {
            console.log("success");
            me.id = response.data.id;
            alert(response.message);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error");
            console.log("textStatus: " + textStatus.value);
            console.log(jqXHR.status + " " + jqXHR.responseText);

        }
    });
};


BankAccount.prototype.update = function () {
    me = this;

    $.ajax({
        type: 'PUT',
        url: '/banks/accounts/' + me.id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(this),
        async: false,
        success: function (response) {
            console.log("success");
            alert(response.message);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error");
            console.log("textStatus: " + textStatus.value);
            console.log(jqXHR.status + " " + jqXHR.responseText);

        }
    });
};


BankAccount.prototype.delete = function () {
    me = this;

    $.ajax({
        type: 'DELETE',
        url: '/banks/accounts/' + me.id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(this),
        async: false,
        success: function (response) {
            console.log("success");
            alert(response.message);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error");
            console.log("textStatus: " + textStatus.value);
            console.log(jqXHR.status + " " + jqXHR.responseText);

        }
    });
};