<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加类别</title>
</head>
<body>
<h1>添加类别</h1>


<form action="" method="post">

    类&ensp;别&ensp;id：<input type="text" name="id" value="${category.id}"><br/>
    名&emsp;称&emsp;：<input type="text" name="name" value="${category.name}"><br/>
    父&ensp;类&ensp;id：<input type="text" name="parentId" value="${category.parentId}"><br/>
    <label>类别状态：</label>
    <select name="status" value="${category.status}" >
        <option value="1" >1</option>
        <option value="2" >2</option>
    </select><br/>
    <%--创建时间：<input type="" name="create_time" value="${category.createTime}"><br/>--%>
    <%--修改时间：<input type="text" name="update_time" value="${category.updateTime}"><br/>--%>

    <input type="submit"  value="添加" ><br/>
</form>
</body>
</html>
