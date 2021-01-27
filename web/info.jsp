<%@ page import="bean.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 28182
  Date: 2021/1/25
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px" align="center">
    <tr>
        <td>id编号</td>
        <td>题目</td>
        <td>选项A</td>
        <td>选项B</td>
        <td>选项C</td>
        <td>选项D</td>
        <td>答案</td>
        <td>操作</td>
    </tr>
    <%
        List<Question> list = (List) request.getAttribute("info");
        for (Question q : list) {
    %>
    <tr>
        <td><%=q.getQuestionId()%>
        </td>
        <td><%=q.getTitle()%>
        </td>
        <td><%=q.getOptionA()%>
        </td>
        <td><%=q.getOptionB()%>
        </td>
        <td><%=q.getOptionC()%>
        </td>
        <td><%=q.getOptionD()%>
        </td>
        <td><%=q.getAmswer()%>
        </td>
        <td><a href="/myweb/QuestionDelete?QuestionDeleteId=<%=q.getQuestionId()%>">删除操作</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
