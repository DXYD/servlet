<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页(index.jsp)</title>
</head>
<body>
<%@ include file="header.jsp" %>

<center>
    <a href="/myweb/QuestionFind">查看题目数据</a>
    <p>index.jsp页面的内容~</p>
    <p>typedef 是类型定义的意思。typedef struct 是为了使用这个结构体方便。
        具体区别在于:
        若 struct node {} 这样来定义结构体的话。在申请 node 的变量时，需要这样写，struct node n;
        若用 type­def，可以这样写，type­def struct node {} NODE; 。在申请变量时就可以这样写，NODE n;
        区别就在于使用时，是否可以省去 struct 这个关键字。</p>
    <p>include指令用于在编译阶段包括一个文件。这个指令告诉容器在编译阶段将其他外部文件的内容合并到当前JSP文件中。可在JSP页面的任何位置使用 include指令进行编码。</p>
</center>

<%@ include file="footer.jsp" %>
</body>
</html>

