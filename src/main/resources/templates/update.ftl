<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List</title>
</head>
<body>
修改页面
<form action="/user" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="id" value="${user.id}"><br><br>
    name:<input type="text" name="name" value="${user.name}"><br><br>
    age:<input type="text" name="age" value="${user.age}"><br><br>
    date:<input type="text" name="date" value="${user.date}"><br><br>
    sex:<#-- 判断sex的值 -->
        <#if user.sex== "1">
            <input type="radio" name="sex" value="1" checked>男
            <input type="radio" name="sex" value="0" >女
        <#elseif user.sex=="0">
            <input type="radio" name="sex" value="1" >男
            <input type="radio" name="sex" value="0" checked>女
        </#if><br><br>
    <input type="submit" value="提交">
</form>
</body>