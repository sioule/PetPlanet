<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <style>
            div { text-align: center; margin: 20px}
            #logo { width: 150px;  }
        </style>
    </head>
    <body>
        <title>Pet Planet</title>
        <div>
            <a href="/main/${memberId}">
            <img id="logo" src="/img/logo.png" alt="Pet Planet Logo"/></a>
        </div>
    </body>
</html>