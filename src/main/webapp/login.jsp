<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styless.css">
    <link rel="stylesheet" type="styless.css" href="<%=request.getContextPath()%>/css/styless.jsp">
    
</head>
<body>
    

        <div class="white-panel">
            <div class="login-show">
                <h2>LOGIN</h2>
                <form action="user" method="post">
                    <input type="hidden" name="action" value="login">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <button type="submit">Login</button>
                </form>
                <br>
                <a href="register.jsp">Don’t have an account? Register</a>
            </div>
        </div>
    </div>

   
</body>
</html>
