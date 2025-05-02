<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
    <script>
        // Redirect after 30 seconds
        setTimeout(function() {
            window.location.href = "voterLogin.jsp";
        }, 30000); // 30000 milliseconds = 30 seconds
    </script>
</head>
<body>

<%
    // Invalidate session
    session.invalidate();
%>

<p>You have been logged out. You will be redirected to the login page in 30 seconds. <a href="voterLogin.jsp">Login again</a></p>

</body>
</html>
