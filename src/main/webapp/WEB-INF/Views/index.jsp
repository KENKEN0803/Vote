<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #back {
        background-color: #E0E0E0;
    }

    #wrap {
        background-color: #FFF;
        width: 400px;
        height: 400px;
        border: 0px solid red;
        margin: 70 auto;
        box-shadow: 10px 5px 5px gray;
        padding: 50px 10px 10px 100px;
    }
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<head>
    <title>메인 페이지</title>
</head>
<body id='back'>
<div id='wrap'>
    <form method="post" action="login">
        <div><input type="text" name="uid" placeholder="ID" class="form-control" style='width:200px;'></div>
        <br/>
        <div><input type="password" name="pw" placeholder="PASSWORD" class="form-control" style='width:200px'></div>
        <br/>
        <div><input type="submit" value="로그인" class="btn btn-info" style='width:130px; margin-left:25px;'></div>
    </form>
    <br/>현재 득표 수
    <p>
        <%--        미투표 : ${c0}<br/>--%>
        1번 : ${c1}<br/>
        2번 : ${c2}<br/>
        3번 : ${c3}<br/>
        4번 : ${c4}<br/>
    </p>
    <div><a href="result"><input type='button' value='투표 결과보기' class="btn btn-success"
                                 style='width:130px; margin-left:25px;'/></a></div>
</div>
</body>