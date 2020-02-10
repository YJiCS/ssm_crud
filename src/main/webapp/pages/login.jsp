<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
    <h4>登录</h4>
    <form action="${pageContext.request.contextPath}/login" method="get">
        账号：<input type="text" name="userNo"><br>
        密码：<input type="password" name="userPwd"><br>
        <input type="submit" value="登录">
    </form>
</center>
</body>
</html>
