<%@ page import="java.util.List" %>
<%@ page import="bean.Students" %><%--
  Created by IntelliJ IDEA.
  User: 28182
  Date: 2021/1/23
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>user_show</title>
</head>

<body>
    <%  List<Students> stuList = (List) request.getAttribute("key");%>
    <table border="2" align="center">
        <tr>
            <th>学生的名字</th>
            <th>学生的性别</th>
        </tr>
        <% for (Students stu : stuList
        ) {
        %>
        <tr>
            <td><%=stu.getName()%>
            </td>
            <td>
                <% if (stu.isSet()) {%>
                男
                <%} else { %>
                女
                <%}%>
            </td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
