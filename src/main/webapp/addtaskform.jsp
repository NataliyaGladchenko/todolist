<%--
  Created by IntelliJ IDEA.
  User: Наташа
  Date: 26.06.2018
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Task Form</title>
</head>
<body>

<br/>
<form action="addtaskform" method="post">
    Project name: <input type="text" name="project_name"/><br/>
    Description: <input type="text" name="description"/><br/>
    Completed: <input type="checkbox" name="completed"/><br/>
    Created date: <input type="date" name="created_date"/><br/>

    Period: <input type="text" name="period"/>
    <br/>
    <input type="submit" value="Add Task"/>
</form>
<form name="return" action="projectlist" method='get'>
    <input type='submit' value='Return Project List'/>
</form>

</body>
</html>
