<%-- 
    Document   : home
    Created on : Jan 1, 2016, 7:32:01 PM
    Author     : abbasadel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/main.css" />" />
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div class="container">

            <table class="table table-hover" id="bankAccountList">
                <tr>
                    <th>IBAN</th>
                    <th>BIC</th>
                    <th></th>
                </tr>  
                <c:forEach items="${userAccount.bankAccounts}" var="account">
                    <tr class="readMode">
                        <td width="40%"><input type="text" class="form-control iban_record" placeholder="IBAN" value="${account.iban}" readonly="readonly"></td>
                        <td width="35%"><input type="text" class="form-control bic_record" placeholder="BIC" value="${account.bic}" readonly="readonly"></td>
                        <td>
                            <input type="hidden" class="form-control id_record" value="${account.id}">
                            <div class="btn-group" role="group" aria-label="...">
                                <button type="button" class="btn btn-default editBtn">Edit</button>
                                <button type="button" class="btn btn-default deleteBtn">Delete</button>
                            </div>
                            <div class="btn-group" role="group" aria-label="...">
                                <button type="button" class="btn btn-default cancelBtn">Cancel</button>
                                <button type="button" class="btn btn-default updateBtn">Update</button>

                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr class="readMode hidden" id="emptyRecord">
                    <td width="40%"><input type="text" class="form-control iban_record" placeholder="IBAN" value="${account.iban}" readonly="readonly"></td>
                        <td width="35%"><input type="text" class="form-control bic_record" placeholder="BIC" value="${account.bic}" readonly="readonly"></td>
                        <td>
                            <input type="hidden" class="form-control id_record" value="">
                            <div class="btn-group" role="group" aria-label="...">
                                <button type="button" class="btn btn-default editBtn">Edit</button>
                                <button type="button" class="btn btn-default deleteBtn">Delete</button>
                            </div>
                            <div class="btn-group" role="group" aria-label="...">
                                <button type="button" class="btn btn-default cancelBtn">Cancel</button>
                                <button type="button" class="btn btn-default updateBtn">Update</button>

                            </div>
                        </td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control iban_record" placeholder="IBAN"></td>
                    <td><input type="text" class="form-control bic_record" placeholder="BIC"></td>
                    <td>
                        <input type="hidden" class="form-control id_record" >
                        <!--<input type="hidden" id="sessionid" value="${sessionid}"  />-->
                        <button type="button" class="btn btn-default btn-small createBtn">Add New Account</button>
                    </td>
                </tr>
            </table>


        </div> <!-- /container -->



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity = "sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin = "anonymous" ></script>
        <script src="<c:url value="/js/app.js" />" /></script>

</body>
</html>
