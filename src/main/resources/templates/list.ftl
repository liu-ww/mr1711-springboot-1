<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List</title>

    <script src="../jquery-1.11.3.min.js"></script>
</head>
<body>
<form method="post" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE">
</form>
<a href="/addUser">增加</a>
<table border="1" width="100%">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>date</td>
        <td>sex</td>
        <td>操作</td>
    </tr>
<#list usersList as list>
    <tr>
        <th>${list.id}</th>
        <th>${list.name}</th>
        <th>${list.age}</th>
        <th>${list.date?string("yyyy-MM-dd")}</th>
        <th>
            <#if list.sex=="1">男
                <#elseif list.sex=="0">女
            </#if>
            <#--${list.sex}-->
        </th>
        <th>
            <#-- 转换成post方式删除 -->
            <a href="javascript:del(${list.id})">删除</a>
            <a href="toUpdate/${list.id}">修改</a>
        </th>
    </tr>
</#list>
</table>
<script>
    function del(id) {
        alert(66);
        /*
            prop("key","value"),给key属性赋值,action为提交的路径
        */
        $("#deleteForm").prop("action","user/"+id);
        $("#deleteForm").submit();
    }
</script>
</body>