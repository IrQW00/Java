<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Employee INFO</h2>
<br>
<%--@elvariable id="employee" type=""--%>
<form:form action="" modelAttribute="employee">

    <form:hidden path="id"/>
    
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">
    
    
    
</form:form>
<br><br>

</body>

</html>