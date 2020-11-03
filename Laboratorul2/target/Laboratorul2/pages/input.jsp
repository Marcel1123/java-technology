<%@ page import="java.util.List" %>
<%@ page import="entities.Language" %>
<%@ page import="repositories.LanguageRepository" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.UUID" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Input</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <h1>Add word form</h1>
    <form action="../input" method="post">
        <table style="width: 50%">
            <tr>
                <td>Language: </td>
                <td>
                    <select name="language">
                        <%
                            Cookie[] cookies = request.getCookies();
                            LanguageRepository languageRepository = new LanguageRepository();
                            List<Language> languages = languageRepository.getAll();
                            String languageS = "";

                            if(cookies != null){
                                for(Cookie cookie : cookies){
                                    if(cookie.getName().equals("language")){
                                        languageS = cookie.getValue();
                                        break;
                                    }
                                }
                            }
                            if(languageS.isEmpty()){
                                languageS = UUID.randomUUID().toString();
                            }
                            for (Language language : languages){
                                if(language.getId().equals(UUID.fromString(languageS))){
                                    out.println("<option value=" + language.getId() + "\" selected >" + language.getName() + "</option>");
                                } else {
                                    out.println("<option value=" + language.getId() + ">" + language.getName() + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Word: </td>
                <td><input type="text" name="word"/></td>
            </tr>
            <tr>
                <td>Definition: </td>
                <td><input type="text" name="definition"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>