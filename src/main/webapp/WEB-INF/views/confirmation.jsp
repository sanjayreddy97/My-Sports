
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Confirmation</title>
    </head>
    <body>
        <h1>Staff Passed Validation</h1>
        <!-- confirmation view with user input values -->
        <ul>
            <li>staff Id:   ${requestScope.staff.staffId}</li>
            <li>First Name: ${requestScope.staff.firstName}</li>
            <li>Last Name:  ${requestScope.staff.lastName}</li>
            <li>User Name:  ${requestScope.staff.userName}</li>
            <li>Email:      ${requestScope.staff.email}</li>
            <li>Active:     ${requestScope.staff.active}</li>
            <li>Address Id: ${requestScope.staff.addressId}</li>
            <li>Store Id:   ${requestScope.staff.storeId}</li>
        </ul>
    </body>
</html>
