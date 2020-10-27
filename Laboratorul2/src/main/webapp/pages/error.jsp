<%@ page isErrorPage="true" %>
<html>
<head><title>Show Error Page</title></head>
<body>
<h1>Oops, something's gone wrong</h1>
<h3>Error type: <%out.println(exception.getClass());%></h3>
<h4>Reason: <%out.print(exception.getMessage());%></h4>
</body>
</html>
