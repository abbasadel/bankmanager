
app = {};

app.alert = function(msg){
    alert(msg);
}

app.table = {
    /**
     * append element to table
     * @param DOM element
     */
    append: function (element) {
        $('#bankAccountList  tr:last').before(element);
    }
};

/**
 * handle table events/actions
 */
app.table.record = {
    create: function (element) {

        bankAccount = this.extract(element);

        if (bankAccount.validate()) {
            if(bankAccount.save() === false){
                app.alert(bankAccount.error);
                return;
            }
            app.table.append(this.clone(bankAccount));
            this.override(element, new BankAccount()); // clear data

        } else {
            app.alert(bankAccount.error);
        }
    },
    delete: function (element) {
        bankAccount = this.extract(element);
        if(bankAccount.delete() === false){
            app.alert(bankAccount.error);
            return;
        }
        element.remove();
    },
    
    edit: function (element) {
        bankAccount = this.extract(element);
        app.bankAccountCopy = jQuery.extend({}, bankAccount);

        element.addClass('editMode');
        element.removeClass('readMode');
        element.find('input').attr("readonly", false);
    },
    
    update: function (element) {
        bankAccount = this.extract(element);
        if (bankAccount.validate()) {
            if (bankAccount.update() === false) {
                app.alert(bankAccount.error);
                return;
            }
            this.readMode(element);

        } else {
            app.alert(bankAccount.error);
        }
        
    },
    cancel: function (element) {
        this.override(element, app.bankAccountCopy);

    },
    
    readMode : function(element){
        element.removeClass('editMode');
        element.addClass('readMode');
        element.find('input').attr("readonly", true);
    },
    
    clone: function (bankAccount) {
        element = $('#emptyRecord').clone(true);
        element.removeClass('hidden');

        element = this.override(element, bankAccount);

        return element;
    },
    extract: function (element) {
        iban = element.find('.iban_record').val();
        bic = element.find('.bic_record').val();
        id = element.find('.id_record').val();
        bankAccount = new BankAccount(id, iban, bic);

        return bankAccount;
    },
    override: function (element, bankAccount) {
        element.find(".iban_record").val(bankAccount.iban);
        element.find(".bic_record").val(bankAccount.bic);
        element.find(".id_record").val(bankAccount.id);

        return element;
    }

};

/**
 * 
 * Bind jqurty Events
 */
$(document).ready(function () {
    $('.createBtn').click(function () {
        var record = $(this).closest("tr");
        app.table.record.create(record);

    });

    $('.editBtn').click(function () {
        var record = $(this).closest("tr");
        app.table.record.edit(record);
    });

    $('.deleteBtn').click(function () {
        var record = $(this).closest("tr");
        if (confirm("Are you sure you want to delete this Bank Account?")) {
            app.table.record.delete(record);
        }
    });

    $('.updateBtn').click(function () {
        var record = $(this).closest("tr");
        app.table.record.update(record);
    });

    $('.cancelBtn').click(function () {
        var record = $(this).closest("tr");
        app.table.record.cancel(record);
    });
});
