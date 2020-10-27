<%@ page import="entities.Word" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Input</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Word successful saved</h1>
<table>
    <% Word word = (Word) request.getAttribute("savedWord"); %>
    <tr>
        <td>Content:</td>
        <td><%out.print(word.getContent());%></td>
    </tr>
    <tr>
        <td>Definition:</td>
        <td><%out.print(word.getDefinition());%></td>
    </tr>
    <tr>
        <td>Language:</td>
        <td><%out.print(word.getLanguage().getName());%></td>
    </tr>
</table>
</body>
</html>