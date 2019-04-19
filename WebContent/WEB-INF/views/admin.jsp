<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Manage Admins</h1>
	</center>

	<table align="center" border="1">
		<tr>
			<th>Name Admin</th>
			<th>Work Position</th>
			<th>Creation Date</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${admins}" var="admin">
			<tr>
				<td><c:out value="${admin.nameAd}" /></td>
				<td><c:out value="${admin.workPositionAd}" /></td>
				<td><c:out value="${admin.creation_date}" /></td>
				<td><a href='<c:url value="admin/${admin.idAd}/update"/>'>Update
						User</a></td>
			</tr>

		</c:forEach>

	</table>
	<center>
		<h2>Register or Update User</h2>
	</center>
	<sf:form action="${pageContext.request.contextPath}/admin/save"
		method="post" modelAttribute="admin">
		<table border="1" align="center">
			<sf:input path="IdAd" type="hidden" />
			<sf:input path="creation_date" type="hidden" />

			<tr>
				<td>Name Admin:</td>
				<td><sf:input path="nameAd" type="text" /></td>
			</tr>
			<tr>
				<td>Work Position:</td>
				<td><sf:input path="workPositionAd" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Changes" /></td>
			</tr>
		</table>
		<br />
		<center>
			<c:out value="${result}" />
		</center>
	</sf:form>
</body>
</html>