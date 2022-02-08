<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a new Staff</title>
    </head>
    <body>
        <h1>Create a new Staff</h1>
        
    <c:if test="${not empty requestScope.errors}">
        <p>Please fix the errors with your submission</p>
        <ol>
            <c:forEach items="${requestScope.errors}" var="error">
                <li>Problem with ${error.propertyPath}: ${error.message}</li>
            </c:forEach>
        </ol>
    </c:if>
        
        <form method = "post" action="/smuthyala-fp/staff">
            <div>
                <label for="staffId">Staff ID</label>
                <input type="text" id="staffId" name="staffId" value="${requestScope.staff.staffId}">
            </div>
            
            <div>
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" value="${requestScope.staff.firstName}">
            </div>
            
            <div>
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" value="${requestScope.staff.lastName}">
            </div>
            
            <div>
                <label for="userName">User Name</label>
                <input type="text" id="userName" name="userName" value="${requestScope.staff.userName}">
            </div>
            
            <div>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" value="${requestScope.staff.email}">
            </div>
            
            <div>
                <label for="addressId">Address ID</label>
                <input type="text" id="addressId" name="addressId" value="${requestScope.staff.addressId}">
            </div>
            
            <div>
                <label for="storeId">Store ID</label>
                
                <select id="storeId" name="storeId">
                    <option ${requestScope.staff.storeId eq 1 ? 'selected' : '' } value="1">One</option>
                    <option ${requestScope.staff.storeId eq 2 ? 'selected' : '' } value="2">Two</option>
                </select>
            </div>
            
            <div>
                <label for="active">Active</label>
                <input type="checkbox" id="active" name="active" ${requestscope.staff.active ? 'checked' : '' } >
            </div>
            
            <button type="submit">Create the Staff</button>
        </form>
    </body>
</html>
