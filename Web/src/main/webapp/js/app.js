//Make sure jQuery has been loaded before app.js
if (typeof jQuery === "undefined") {
  throw new Error("jQuery is required");
}

/**
 * BankAccount Class
 * @param  iban
 * @param  bic
 * @returns 
 */
function BankAccount (id, iban, bic){
    this.id = id;
    this.iban = iban;
    this.bic = bic;
    this.validate  = function (){
        if(this.iban === "" || this.bic === ""){
            this.error = 'Empty IBAN/BIC';
            return false;
        }
        
        return true;        
    };
    
    this.save = function(){
        console.log('saved');
    };
    
    
    this.update = function(){
        
    };
    
    
    this.delete = function(){
        
    }
}



app = {
    
}

app.table = {


    append: function (element){
        console.log(element);
        $('#bankAccountList  tr:last').before(element);
    }  
};


app.table.record = {
    create : function(element){
        
        bankAccount = this.extract(element);
        
        if(bankAccount.validate()){
            bankAccount.save();
            app.table.append(this.clone(bankAccount));
            this.override(element, new BankAccount()); // clear data

        }else{
            alert(bankAccount.error);
        }
    },
    
    delete : function(element){
        element.remove();
    },
    
    edit : function(element){
        bankAccount = this.extract(element);
        element.addClass('editMode');
        element.removeClass('readMode');
        element.find('input').attr("readonly", false); 
        console.log(bankAccount);
    },
    
    update : function(element){
        
    },
    
    cancel : function(element){
        element.removeClass('editMode');
        element.addClass('readMode');
        element.find('input').attr("readonly", true); 
        
    },
    
    clone : function(bankAccount){
        element = $('#emptyRecord').clone(true);
        element.removeClass('hidden');
        
        element = this.override(element, bankAccount);
        
        return element;
    },
    
    extract: function(element){
        iban = element.find('.iban_record').val();
        bic = element.find('.bic_record').val();
        id = element.find('.id_record').val();
        bankAccount = new BankAccount(id, iban, bic);
        
        return bankAccount;
    },
    
    override : function(element, bankAccount){
        element.find(".iban_record").val(bankAccount.iban);
        element.find(".bic_record").val(bankAccount.bic);
        element.find(".id_record").val(bankAccount.id);
        
        return element;
    }
    
}

/**
 * 
 * Bind jqurty Events
 */
$(document).ready(function(){
    $('.createBtn').click(function (){
        var record = $(this).closest("tr");
        app.table.record.create(record);

    });
    
    $('.editBtn').click(function(){
        var record = $(this).closest("tr");
        app.table.record.edit(record);
    });
    
    $('.deleteBtn').click(function(){
        var record = $(this).closest("tr");
        if(confirm("Are you sure you want to delete this Bank Account?")){
            app.table.record.delete(record);
        }
    });
    
    $('.updateBtn').click(function(){
        var record = $(this).closest("tr");
        app.table.record.update(record);
    });
    
    $('.cancelBtn').click(function(){
        var record = $(this).closest("tr");
        app.table.record.cancel(record);
    });
});
