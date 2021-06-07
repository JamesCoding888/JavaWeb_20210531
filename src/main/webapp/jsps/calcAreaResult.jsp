<%-- 
    Document   : calcAreaResult
    Created on : Jun 7, 2021, 8:25:50 PM
    Author     : jamesliao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>計算面積結果</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>計算面積結果</legend>
                <%=request.getAttribute("result") %>
            </fieldset>
        </form>
    </body>
</html>
