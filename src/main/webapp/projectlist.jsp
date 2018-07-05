<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <div>
        <table>
            <tr>
                <c:forEach var="project" items="${projects}">
                <td><c:out value="${project.projectName}"/></td>
            </tr>

         <c:forEach var="task" items="${project.tasks}">
                <tr>
                    <td>
                        <c:if test="${task.completed}">
                           <input type="checkbox" name="completed" id="${task.id}" checked="checked">
                      </c:if>
                      <c:if test="${task.completed==false}">
                          <input type="checkbox" name="completed" id="${task.id}">
                      </c:if>
                  </td>
                    <td><c:out value="${task.description}"/></td>
                    <td><c:out value="${task.createdDate}"/></td>
                    <td><c:out value="${task.period}"/></td>
                </tr>
            </c:forEach>
            </c:forEach>
        </table>
    </div>
    <div>
        <form name="return" action="addtaskform" method='get'>
            <input type='submit' value='Create task'/>
        </form>
        <form name="return" action="addprojectform" method='get'>
            <input type='submit' value='Create project'/>
        </form>
    </div>

</body>
</html>
