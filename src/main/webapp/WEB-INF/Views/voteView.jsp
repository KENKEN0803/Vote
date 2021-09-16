<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/index1.css">
</head>
<body>
<div class="wrap">
    <label>투표 후보</label>
    <form method="post" action="voteViewProcess" class="textForm">
        <div><input type="radio" value="c1" name="radio" checked> <label for="c1">김나은</label></div>
        <div><input type="radio" value="c2" name="radio"> <label for="c2">이재현</label></div>
        <div><input type="radio" value="c3" name="radio"> <label for="c3">김수인</label></div>
        <div><input type="radio" value="c4" name="radio"> <label for="c4">최예준</label></div>

        <div><input type="submit" value="투표하기" class="btn"></div>
    </form>
</div>
</body>
</html>