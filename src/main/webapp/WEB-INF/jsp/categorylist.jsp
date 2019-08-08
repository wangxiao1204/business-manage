<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>

<html>
<head>
    <title>类别清单</title>
    <style>
        table {
            align-items: center;
            border:1px solid gray;
        }

    </style>
<table>
        <thead>
            <th>类别Id</th>
            <th>类别名称</th>
            <th>所属父类</th>
            <th>类别状态</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作</th>
        </thead>

    <c:forEach items="${categorylist}" var="category">
        <tr>
            <th>${category.id}</th>
            <th>${category.name}</th>
            <th>${category.parentId}</th>
            <th>${category.status}</th>
            <th>${category.createTime}</th>
            <th>${category.updateTime}</th>
            <th>
                <a href="update/${category.id}">修改</a>
                <a href="delete/${category.id}">删除</a>
            </th>
        </tr>

    </c:forEach>
</table>
</head>
<body>
     <a href="add">添加新类别</a>
</body>
</html>
