<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <center>
        <p>用户名：${sessionScope.user.userName}</p>
        <form action="${pageContext.request.contextPath}/selAllUsers" method="post">
            <input type="submit" value="查询用户信息" >
        </form>
        <table border="1">
            ${requestScope.users}
            <tr>
                <td>账号</td>
                <td>姓名</td>
                <td>密码</td>
            </tr>
        </table>
    </center>
</body>
</html>
