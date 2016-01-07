<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring+SpringMVC+MyBatis+Mysql增删改查</title>
<c:if test="${empty pageBean }">
	<c:redirect url="/emp/findByPage.action?page=1"></c:redirect>
</c:if>
<script type="text/javascript">
	function add(){
		document.getElementById("empSub").value="添加新用户";
		document.getElementById("empForm").action="${pageContext.request.contextPath}/emp/addEmp.action";
		document.getElementById("empId").value=0;
		document.getElementById("empName").value="";
		document.getElementById("empSal").value="";
		document.getElementById("empSex").value="";
	}
	
	function update(id,name,sal,sex){
		//alert(id+':::'+name+':::'+sal+":::"+sex);
		document.getElementById("empSub").value="修改用户";
		document.getElementById("empForm").action="${pageContext.request.contextPath}/emp/updateEmp.action";
		document.getElementById("empId").value=id;
		document.getElementById("empName").value=name;
		document.getElementById("empSal").value=sal;
		if(sex=='男'){
			document.getElementById("empSex").checked=true;
		}else{
			document.getElementById("empSex").checked=true;
		}
		
	}
	
	function del(mid){
		if(window.confirm("你确定删除吗？")){
			location.href="${pageContext.request.contextPath}/emp/deleteEmp.action?empId="+mid;
		}
	}
</script>
</head>
<body>
<center>
<h1>Spring+SpringMVC+MyBatis+Mysql增删改查</h1>
<form action="${pageContext.request.contextPath}/emp/findByName.action" method="post">
	<input type="text" name="empName"/>
	<input type="submit" value="搜索一下">
	<a href="javascript:add()">添加新用户</a>
</form>


<hr>
<table border="1" cellpadding="1" cellspacing="0" width="50%" >
	<tr align="center">
	<td>员工编号</td><td>员工姓名</td><td>员工薪资</td><td>员工性别</td><td>操作</td>
	</tr>
	<c:forEach var="page" items="${pageBean.list }">
		<tr align="center">
			<td>${page.empId }</td>
			<td>${page.empName }</td>
			<td>${page.empSal }</td>
			<td>${page.empSex }</td>
			<td>
				<a href="javascript:update(${page.empId },'${page.empName }','${page.empSal }','${page.empSex }')">修改</a>
				<a href="javascript:del(${page.empId })">删除</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
			第${pageBean.page }/${pageBean.totalPage }页	
			<a href="${pageContext.request.contextPath}/emp/findByPage.action?page=1">首页</a>
			<a href="${pageContext.request.contextPath}/emp/findByPage.action?page=${pageBean.page-1}">上一页</a>
			<a href="${pageContext.request.contextPath}/emp/findByPage.action?page=${pageBean.page+1}">下一页</a>
			<a href="${pageContext.request.contextPath}/emp/findByPage.action?page=${pageBean.totalPage}">末页</a>
		</td>
	</tr>
</table>
<hr>
<form action="${pageContext.request.contextPath}/emp/updateEmp.action" method="post" id="empForm">
	<input type="hidden" id="empId" name="empId"/>
	<table border="1" cellpadding="1" cellspacing="0" width="30%">
		<tr align="center">
			<td>姓名:</td>
			<td><input type="text" name="empName" id="empName"/></td>
		</tr>
		<tr align="center">
			<td>薪资:</td>
			<td><input type="text" name="empSal" id="empSal"/></td>
		</tr>
		<tr align="center">
			<td>性别:</td>
			<td>
			<input type="radio" name="empSex" value="男" checked id="empSex1"/>男
			<input type="radio" name="empSex" value="女" id="empSex2"/>女
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
			<input type="submit" id="empSub" value="修改用户"/>
			</td>
		</tr>
	</table>
</form>
</center>
</body>
</html>