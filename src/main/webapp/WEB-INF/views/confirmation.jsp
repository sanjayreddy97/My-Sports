
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Confirmation</title>
    </head>
    <body>
        <h1>Staff Passed Validation</h1>
        <ul>
            <li>${requestScope.staff.staffId}</li>
            <li>${requestScope.staff.firstName}</li>
            <li>${requestScope.staff.lastName}</li>
            <li>${requestScope.staff.userName}</li>
            <li>${requestScope.staff.email}</li>
            <li>${requestScope.staff.active}</li>
            <li>${requestScope.staff.addressId}</li>
            <li>${requestScope.staff.storeId}</li>
        </ul>
    </body>
</html>
