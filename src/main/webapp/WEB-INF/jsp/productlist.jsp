
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品清单</title>

    <style>
        table {
            align-items: center;
            border:1px solid gray;
        }

    </style>
    <table>
        <thead>
        <th>商品Id</th>
        <th>商品类别Id</th>
        <th>商品名称</th>
        <th>价格</th>
        <th>库存</th>
        <th>商品状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>

        <c:forEach items="${productlist}" var="product">
            <tr>
                <th>${product.id}</th>
                <th>${product.categoryId}</th>
                <th>${product.name}</th>
                <th>${product.price}</th>
                <th>${product.stock}</th>
                <th>${product.status}</th>
                <th>${product.createTime}</th>
                <th>${product.updateTime}</th>
                <th>
                    <a href="update/${product.id}">修改</a>
                    <a href="delete/${product.id}">删除</a>
                </th>
            </tr>

        </c:forEach>
    </table>
</head>

<body>
<a href="add">添加新商品</a>
</body>
</html>
