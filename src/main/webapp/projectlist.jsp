<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div >
    <div >
<table>
    <tr>
        <c:forEach var="project" items="${projects}">
        <td><c:out value="${project.projectName}"/></td>
    </tr>
    <c:forEach var="task" items="${project.tasks}">
        <tr><td><input type="checkbox" name="completed"></td>
            <td><c:out value="${task.description}"/></td>
            <td><c:out value="${task.createdDate}"/></td>
            <td><c:out value="${task.period}"/></td>
        </tr>
    </c:forEach>

    </c:forEach>
</table>
    </div>
    <div >
        <form name="return" action="addtaskform" method='get'>
            <input type='submit' value='Create task'/>
        </form>
        <form name="return" action="addprojectform" method='get'>
            <input type='submit' value='Create project'/>
        </form>
    </div>
</div>
</body>
</html>
