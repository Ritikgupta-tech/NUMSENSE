<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styless.css">
</head>
<body>
    

        <div class="white-panel">
            <div class="register-show">
                <h2>REGISTER</h2>
                <form action="user" method="post">
                    <input type="hidden" name="action" value="register">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
                    <button type="submit">Register</button>
                </form>
                <br>
                <a href="login.jsp">Already have an account? Login</a>
            </div>
        </div>
    </div>

    
</body>
</html>
