<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改类别</title>
    <style>
        form {
            align-items: center;
            border:1px solid gray;
        }

    </style>
</head>
<body>
<h1>修改类别</h1>


<form action="" method="post">
    
    <input type="hidden" name="id" value="${category.id}"><br/>
    名&emsp;称&emsp;：<input type="text" name="name" value="${category.name}"><br/>
    父&ensp;类&ensp;id：<input type="text" name="parentId" value="${category.parentId}"><br/>
    <label>类别状态：</label>
        <select name="status" value="${category.status}">
            <option value="1" >1</option>
            <option value="2" >2</option>
        </select><br/>
    <%--类别状态：<input type="text" name="status" value="${category.status}"><br/>--%>
    <input type="submit"  value="修改"><br/>

</form>
</body>
</html>
