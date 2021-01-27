<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int pageCount = 0;

    void addCount() {
        pageCount++;
    }
%>

<%
    addCount();
%>
<center>
    <p>Copyright © 2020 | 备案号：xxxxxxxxx | 联系我们：codemilk | 访问次数：<%=pageCount%>
    </p>
</center>

